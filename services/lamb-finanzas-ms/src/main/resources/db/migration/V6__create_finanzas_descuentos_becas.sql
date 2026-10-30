-- Lote F3 - Descuentos y becas (items 30-35 del documento MATRICULAS Y FINANZAS).

CREATE TABLE tipos_descuento (
    id BIGSERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    porcentaje DECIMAL(5,2) NOT NULL,
    descripcion VARCHAR(255)
);

-- Tabla de union de la relacion muchos a muchos real (item 30): un pago puede llevar
-- varios tipos de descuento, y un tipo de descuento puede aplicarse a varios pagos.
CREATE TABLE pago_descuento (
    id_pago BIGINT NOT NULL,
    id_tipo_descuento BIGINT NOT NULL,
    PRIMARY KEY (id_pago, id_tipo_descuento),
    CONSTRAINT fk_pago_descuento_pago FOREIGN KEY (id_pago) REFERENCES pagos (id),
    CONSTRAINT fk_pago_descuento_tipo_descuento FOREIGN KEY (id_tipo_descuento) REFERENCES tipos_descuento (id)
);

CREATE TABLE tipos_beca (
    id BIGSERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion VARCHAR(255)
);

CREATE TABLE becas_aplicadas (
    id BIGSERIAL PRIMARY KEY,
    id_persona BIGINT NOT NULL,
    id_tipo_beca BIGINT NOT NULL,
    porcentaje DECIMAL(5,2) NOT NULL,
    fecha_inicio DATE NOT NULL,
    CONSTRAINT fk_becas_aplicadas_tipo_beca FOREIGN KEY (id_tipo_beca) REFERENCES tipos_beca (id)
);

CREATE TABLE renovaciones_suspensiones_beca (
    id BIGSERIAL PRIMARY KEY,
    id_beca_aplicada BIGINT NOT NULL,
    tipo VARCHAR(20) NOT NULL,
    fecha DATE NOT NULL,
    motivo VARCHAR(255),
    CONSTRAINT fk_renovaciones_suspensiones_beca_aplicada FOREIGN KEY (id_beca_aplicada) REFERENCES becas_aplicadas (id)
);

-- CRUD marcado con (*) en el documento: "Exoneracion de pago" (item 34).
CREATE TABLE exoneraciones_pago (
    id BIGSERIAL PRIMARY KEY,
    id_pago BIGINT NOT NULL,
    motivo VARCHAR(255) NOT NULL,
    fecha DATE NOT NULL,
    CONSTRAINT fk_exoneraciones_pago_pago FOREIGN KEY (id_pago) REFERENCES pagos (id)
);

-- CRUD opcional: depende de la universidad (item 35).
CREATE TABLE convenios_institucionales_descuento (
    id BIGSERIAL PRIMARY KEY,
    nombre_institucion VARCHAR(150) NOT NULL,
    porcentaje_descuento DECIMAL(5,2) NOT NULL
);
