-- Lote F2b: Calendario y planes (items 13-14 del documento MATRICULAS Y FINANZAS)

CREATE TABLE IF NOT EXISTS cronogramas_vencimiento (
    id BIGSERIAL PRIMARY KEY,
    periodo VARCHAR(20) NOT NULL,
    descripcion VARCHAR(150) NOT NULL,
    fecha_vencimiento DATE NOT NULL
);

CREATE TABLE IF NOT EXISTS plantillas_plan_pago (
    id BIGSERIAL PRIMARY KEY,
    nombre VARCHAR(150) NOT NULL,
    tipo VARCHAR(20) NOT NULL,
    numero_cuotas INT NOT NULL
);
