export type FieldType = 'text' | 'textarea' | 'number' | 'decimal' | 'date' | 'datetime' | 'boolean';

export interface ResourceField {
  key: string;
  label: string;
  type: FieldType;
  required?: boolean;
  /** No se muestra en el formulario, solo en la tabla (ej. id autogenerado). */
  readOnly?: boolean;
  /** Se oculta del formulario de creacion/edicion (ej. id). */
  hiddenInForm?: boolean;
}

export interface ResourceAction {
  key: string;
  label: string;
  /** Subruta relativa al recurso: POST {base}{path}/{id}/{endpoint} */
  endpoint: string;
  /** Pide confirmacion antes de ejecutar. */
  confirm?: string;
  cssClass?: 'primary' | 'danger' | 'ghost';
  /** Si esta presente, pide un valor por prompt y lo manda como { [promptKey]: valor }. */
  promptLabel?: string;
  promptKey?: string;
}

export interface ResourceConfig {
  key: string;
  label: string;
  /** Ruta relativa a la base del controlador, ej: /tipos-matricula */
  path: string;
  description?: string;
  fields: ResourceField[];
  rowActions?: ResourceAction[];
}

export interface ControllerGroup {
  key: string;
  label: string;
  /** Ruta base del controlador expuesta por el Gateway, ej: /calendario-periodos */
  basePath: string;
  resources: ResourceConfig[];
}
