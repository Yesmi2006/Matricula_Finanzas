import { Component, inject, signal } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ApiService } from '../../core/api/api.service';
import { DataTable } from '../../shared/components/data-table/data-table';
import { ResourceForm } from '../../shared/components/resource-form/resource-form';
import { ControllerGroup, ResourceConfig } from '../../shared/models/resource.model';
import { MATRICULA_GROUPS } from '../../config/resources.matricula';
import { FINANZAS_GROUPS } from '../../config/resources.finanzas';

const GROUPS_BY_DOMAIN: Record<string, ControllerGroup[]> = {
  matricula: MATRICULA_GROUPS,
  finanzas: FINANZAS_GROUPS,
};

@Component({
  selector: 'app-resource-view',
  standalone: true,
  imports: [DataTable, ResourceForm],
  templateUrl: './resource-view.html',
  styleUrl: './resource-view.scss',
})
export class ResourceView {
  private readonly route = inject(ActivatedRoute);
  private readonly api = inject(ApiService);

  config!: ResourceConfig;
  fullPath = '';

  readonly rows = signal<Record<string, unknown>[]>([]);
  readonly editing = signal<Record<string, unknown> | null>(null);
  readonly showForm = signal(false);
  readonly loading = signal(false);
  readonly error = signal<string | null>(null);

  constructor() {
    this.route.params.subscribe((params) => {
      const domain = this.route.snapshot.parent?.url[0]?.path ?? '';
      const groups = GROUPS_BY_DOMAIN[domain] ?? [];
      const group = groups.find((g) => g.key === params['groupKey']);
      const resource = group?.resources.find((r) => r.key === params['resourceKey']);
      if (!group || !resource) return;
      this.config = resource;
      this.fullPath = `${group.basePath}${resource.path}`;
      this.showForm.set(false);
      this.editing.set(null);
      this.loadRows();
    });
  }

  loadRows(): void {
    this.loading.set(true);
    this.error.set(null);
    this.api.list<Record<string, unknown>>(this.fullPath).subscribe({
      next: (data) => {
        this.rows.set(data);
        this.loading.set(false);
      },
      error: () => {
        this.error.set('No se pudo cargar la información. Verifique que el backend y el gateway estén activos.');
        this.loading.set(false);
      },
    });
  }

  onCreateNew(): void {
    this.editing.set(null);
    this.showForm.set(true);
  }

  onEdit(row: Record<string, unknown>): void {
    this.editing.set(row);
    this.showForm.set(true);
  }

  onCancel(): void {
    this.showForm.set(false);
    this.editing.set(null);
  }

  onSave(value: Record<string, unknown>): void {
    const current = this.editing();
    const req = current
      ? this.api.update(this.fullPath, current['id'] as number, value)
      : this.api.create(this.fullPath, value);
    req.subscribe({
      next: () => {
        this.showForm.set(false);
        this.editing.set(null);
        this.loadRows();
      },
      error: () => this.error.set('No se pudo guardar el registro.'),
    });
  }

  onRemove(row: Record<string, unknown>): void {
    if (!confirm('¿Eliminar este registro?')) return;
    this.api.remove(this.fullPath, row['id'] as number).subscribe({
      next: () => this.loadRows(),
      error: () => this.error.set('No se pudo eliminar el registro.'),
    });
  }

  onRowAction(evt: { action: string; row: Record<string, unknown> }): void {
    const def = this.config.rowActions?.find((a) => a.key === evt.action);
    if (!def) return;
    if (def.confirm && !confirm(def.confirm)) return;

    let body: unknown = undefined;
    if (def.promptLabel && def.promptKey) {
      const value = window.prompt(def.promptLabel);
      if (value === null) return;
      body = { [def.promptKey]: value };
    }

    this.api.action(this.fullPath, evt.row['id'] as number, def.endpoint, body).subscribe({
      next: () => this.loadRows(),
      error: () => this.error.set('No se pudo ejecutar la acción.'),
    });
  }
}
