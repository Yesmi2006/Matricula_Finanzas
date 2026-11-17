import { Component, EventEmitter, Input, OnChanges, Output, SimpleChanges, inject } from '@angular/core';
import { FormBuilder, ReactiveFormsModule, Validators } from '@angular/forms';
import { ResourceConfig } from '../../models/resource.model';

@Component({
  selector: 'app-resource-form',
  standalone: true,
  imports: [ReactiveFormsModule],
  templateUrl: './resource-form.html',
  styleUrl: './resource-form.scss',
})
export class ResourceForm implements OnChanges {
  @Input({ required: true }) config!: ResourceConfig;
  @Input() value: Record<string, unknown> | null = null;

  @Output() save = new EventEmitter<Record<string, unknown>>();
  @Output() cancel = new EventEmitter<void>();

  private readonly fb = inject(FormBuilder);

  form = this.fb.group({});

  ngOnChanges(changes: SimpleChanges): void {
    if (changes['config'] || changes['value']) {
      this.buildForm();
    }
  }

  private buildForm(): void {
    const group: Record<string, unknown> = {};
    for (const field of this.config.fields) {
      if (field.hiddenInForm) continue;
      const initial = this.value?.[field.key] ?? (field.type === 'boolean' ? false : '');
      const validators = field.required ? [Validators.required] : [];
      group[field.key] = [initial, validators];
    }
    this.form = this.fb.group(group);
  }

  visibleFields() {
    return this.config.fields.filter((f) => !f.hiddenInForm);
  }

  onSubmit(): void {
    if (this.form.invalid) {
      this.form.markAllAsTouched();
      return;
    }
    this.save.emit(this.form.value as Record<string, unknown>);
  }
}
