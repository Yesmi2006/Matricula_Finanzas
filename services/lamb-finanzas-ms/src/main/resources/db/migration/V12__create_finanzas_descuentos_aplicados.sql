-- Descuentos y becas (item 30): Descuento aplicado.
CREATE TABLE descuentos_aplicados (
    id BIGSERIAL PRIMARY KEY,
    id_persona BIGINT NOT NULL,
    id_tipo_descuento BIGINT NOT NULL,
    porcentaje DECIMAL(5,2) NOT NULL,
    fecha_inicio DATE NOT NULL,
    CONSTRAINT fk_descuentos_aplicados_tipo_descuento FOREIGN KEY (id_tipo_descuento) REFERENCES tipos_descuento (id)
);

-- Cobros (item 16): el detalle de cobro puede referenciar un descuento aplicado (nullable).
ALTER TABLE detalles_cobro ADD COLUMN id_descuento_aplicado BIGINT;
ALTER TABLE detalles_cobro ADD CONSTRAINT fk_detalles_cobro_descuento_aplicado
    FOREIGN KEY (id_descuento_aplicado) REFERENCES descuentos_aplicados (id);

-- Pago.descuentos fue retirado de la entidad Pago.
DROP TABLE IF EXISTS pago_descuento;