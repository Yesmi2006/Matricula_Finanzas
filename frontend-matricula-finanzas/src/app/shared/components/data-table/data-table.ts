import { Component, EventEmitter, Input, Output } from '@angular/core';
import { ResourceConfig } from '../../models/resource.model';

@Component({
  selector: 'app-data-table',
  standalone: true,
  templateUrl: './data-table.html',
  styleUrl: './data-table.scss',
})
export class DataTable {
  @Input({ required: true }) config!: ResourceConfig;
  @Input() rows: Record<string, unknown>[] = [];

  @Output() edit = new EventEmitter<Record<string, unknown>>();
  @Output() remove = new EventEmitter<Record<string, unknown>>();
  @Output() rowAction = new EventEmitter<{ action: string; row: Record<string, unknown> }>();
  @Output() createNew = new EventEmitter<void>();

  columns(): string[] {
    return this.config.fields.map((f) => f.key);
  }

  value(row: Record<string, unknown>, key: string): unknown {
    const v = row[key];
    if (typeof v === 'boolean') return v ? 'Sí' : 'No';
    return v ?? '—';
  }
}
