-- Lote F1: Saldo del Estudiante (items 64-69 del documento MATRICULAS Y FINANZAS)

CREATE TABLE IF NOT EXISTS cuentas_estudiante (
    id BIGSERIAL PRIMARY KEY,
    id_persona BIGINT NOT NULL,
    saldo_actual DECIMAL(10,2) NOT NULL,
    fecha_apertura TIMESTAMP NOT NULL,
    CONSTRAINT uq_cuentas_estudiante_id_persona UNIQUE (id_persona)
);

CREATE TABLE IF NOT EXISTS movimientos_cuenta (
    id BIGSERIAL PRIMARY KEY,
    id_cuenta BIGINT NOT NULL,
    tipo VARCHAR(10) NOT NULL,
    monto DECIMAL(10,2) NOT NULL,
    concepto VARCHAR(150) NOT NULL,
    fecha TIMESTAMP NOT NULL,
    CONSTRAINT fk_movimientos_cuenta_cuenta FOREIGN KEY (id_cuenta) REFERENCES cuentas_estudiante(id)
);

CREATE TABLE IF NOT EXISTS saldos_periodo (
    id BIGSERIAL PRIMARY KEY,
    id_cuenta BIGINT NOT NULL,
    periodo VARCHAR(20) NOT NULL,
    saldo_calculado DECIMAL(10,2) NOT NULL,
    fecha_calculo TIMESTAMP NOT NULL
);

-- CRUD marcado con (*) en el documento: ajuste manual requiere autorizacion.
CREATE TABLE IF NOT EXISTS ajustes_manuales_saldo (
    id BIGSERIAL PRIMARY KEY,
    id_cuenta BIGINT NOT NULL,
    monto DECIMAL(10,2) NOT NULL,
    motivo VARCHAR(255) NOT NULL,
    autorizado_por VARCHAR(150) NOT NULL,
    fecha TIMESTAMP NOT NULL
);

-- CRUD opcional: depende de la universidad.
CREATE TABLE IF NOT EXISTS reservas_saldo_devolucion (
    id BIGSERIAL PRIMARY KEY,
    id_cuenta BIGINT NOT NULL,
    monto DECIMAL(10,2) NOT NULL,
    motivo VARCHAR(255) NOT NULL,
    fecha TIMESTAMP NOT NULL
);
