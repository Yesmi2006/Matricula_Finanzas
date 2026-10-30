-- Lote Cobros (items 17, 18, 20, 21 del documento MATRICULAS Y FINANZAS).

-- Item 17, Nucleo. Referencia local real a cuentas_estudiante (item 64, ya implementado),
-- aunque el documento etiqueta este campo como "JALA ID 15" que a su vez remite al 64.
CREATE TABLE estados_cobro (
    id BIGSERIAL PRIMARY KEY,
    id_cuenta_estudiante BIGINT NOT NULL,
    estado VARCHAR(20) NOT NULL,
    fecha DATE NOT NULL,
    CONSTRAINT fk_estados_cobro_cuenta_estudiante FOREIGN KEY (id_cuenta_estudiante) REFERENCES cuentas_estudiante (id)
);

-- Item 18. CRUD opcional: depende de la universidad.
CREATE TABLE detalles_cobro (
    id BIGSERIAL PRIMARY KEY,
    id_estado_cobro BIGINT NOT NULL,
    concepto VARCHAR(150) NOT NULL,
    monto DECIMAL(10,2) NOT NULL,
    CONSTRAINT fk_detalles_cobro_estado_cobro FOREIGN KEY (id_estado_cobro) REFERENCES estados_cobro (id)
);

-- Item 20, Nucleo.
CREATE TABLE historiales_estado_cobro (
    id BIGSERIAL PRIMARY KEY,
    id_estado_cobro BIGINT NOT NULL,
    estado VARCHAR(20) NOT NULL,
    fecha DATE NOT NULL,
    CONSTRAINT fk_historiales_estado_cobro_estado_cobro FOREIGN KEY (id_estado_cobro) REFERENCES estados_cobro (id)
);

-- Item 21, Nucleo.
CREATE TABLE montos_pago (
    id BIGSERIAL PRIMARY KEY,
    id_estado_cobro BIGINT NOT NULL,
    monto DECIMAL(10,2) NOT NULL,
    fecha DATE NOT NULL,
    CONSTRAINT fk_montos_pago_estado_cobro FOREIGN KEY (id_estado_cobro) REFERENCES estados_cobro (id)
);
