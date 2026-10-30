-- Lote "Control y cierre" (items 57-59 del documento MATRICULAS Y FINANZAS).

CREATE TABLE reclamos_pago (
    id BIGSERIAL PRIMARY KEY,
    id_pago BIGINT NOT NULL,
    descripcion VARCHAR(500) NOT NULL,
    resuelto BOOLEAN NOT NULL,
    fecha TIMESTAMP NOT NULL,
    CONSTRAINT fk_reclamo_pago_pago FOREIGN KEY (id_pago) REFERENCES pagos (id)
);

CREATE TABLE estados_cuenta_estudiante (
    id BIGSERIAL PRIMARY KEY,
    id_cuenta_estudiante BIGINT NOT NULL,
    monto_total_deuda DECIMAL(10,2) NOT NULL,
    monto_pagado DECIMAL(10,2) NOT NULL,
    saldo_pendiente DECIMAL(10,2) NOT NULL,
    fecha TIMESTAMP NOT NULL,
    CONSTRAINT fk_estado_cuenta_estudiante_cuenta FOREIGN KEY (id_cuenta_estudiante) REFERENCES cuentas_estudiante (id)
);

CREATE TABLE constancias_no_adeudo (
    id BIGSERIAL PRIMARY KEY,
    id_estado_cobro BIGINT NOT NULL,
    codigo_constancia VARCHAR(50) NOT NULL UNIQUE,
    fecha_emision TIMESTAMP NOT NULL,
    CONSTRAINT fk_constancia_no_adeudo_estado_cobro FOREIGN KEY (id_estado_cobro) REFERENCES estados_cobro (id)
);
