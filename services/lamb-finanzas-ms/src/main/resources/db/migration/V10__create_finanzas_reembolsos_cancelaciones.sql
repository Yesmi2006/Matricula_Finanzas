-- Lote "Reembolsos y cancelaciones" (items 52-55 del documento MATRICULAS Y FINANZAS).

CREATE TABLE solicitudes_devolucion (
    id BIGSERIAL PRIMARY KEY,
    id_pago BIGINT NOT NULL,
    motivo VARCHAR(255) NOT NULL,
    monto_solicitado DECIMAL(10,2) NOT NULL,
    estado VARCHAR(20) NOT NULL,
    fecha TIMESTAMP NOT NULL,
    CONSTRAINT fk_solicitud_devolucion_pago FOREIGN KEY (id_pago) REFERENCES pagos (id)
);

CREATE TABLE reembolsos_pago (
    id BIGSERIAL PRIMARY KEY,
    id_solicitud_devolucion BIGINT NOT NULL,
    id_cuenta_estudiante BIGINT NOT NULL,
    monto_reembolsado DECIMAL(10,2) NOT NULL,
    fecha TIMESTAMP NOT NULL,
    CONSTRAINT fk_reembolso_pago_solicitud FOREIGN KEY (id_solicitud_devolucion) REFERENCES solicitudes_devolucion (id),
    CONSTRAINT fk_reembolso_pago_cuenta FOREIGN KEY (id_cuenta_estudiante) REFERENCES cuentas_estudiante (id)
);

-- id_matricula no lleva FK local: la matricula pertenece a lamb-matricula-ms (JALA ID).
CREATE TABLE cancelaciones_cargo_matricula (
    id BIGSERIAL PRIMARY KEY,
    id_pago BIGINT NOT NULL,
    id_matricula BIGINT NOT NULL,
    motivo VARCHAR(255) NOT NULL,
    fecha TIMESTAMP NOT NULL,
    CONSTRAINT fk_cancelacion_cargo_pago FOREIGN KEY (id_pago) REFERENCES pagos (id)
);

CREATE TABLE transferencias_pago (
    id BIGSERIAL PRIMARY KEY,
    id_pago BIGINT NOT NULL,
    id_concepto_origen BIGINT NOT NULL,
    id_concepto_destino BIGINT NOT NULL,
    monto DECIMAL(10,2) NOT NULL,
    fecha TIMESTAMP NOT NULL,
    CONSTRAINT fk_transferencia_pago_pago FOREIGN KEY (id_pago) REFERENCES pagos (id),
    CONSTRAINT fk_transferencia_pago_concepto_origen FOREIGN KEY (id_concepto_origen) REFERENCES conceptos_pago (id),
    CONSTRAINT fk_transferencia_pago_concepto_destino FOREIGN KEY (id_concepto_destino) REFERENCES conceptos_pago (id)
);
