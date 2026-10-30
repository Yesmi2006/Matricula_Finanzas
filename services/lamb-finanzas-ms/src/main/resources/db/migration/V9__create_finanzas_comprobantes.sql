-- Lote Comprobantes (items 37 a 42 del documento MATRICULAS Y FINANZAS).

-- Item 37, Nucleo. Referencia local real a pagos (ya implementado).
CREATE TABLE documentos_pago (
    id BIGSERIAL PRIMARY KEY,
    id_pago BIGINT NOT NULL,
    tipo VARCHAR(20) NOT NULL,
    serie VARCHAR(10) NOT NULL,
    correlativo VARCHAR(20) NOT NULL,
    monto DECIMAL(10,2) NOT NULL,
    fecha_emision TIMESTAMP NOT NULL,
    CONSTRAINT fk_documentos_pago_pago FOREIGN KEY (id_pago) REFERENCES pagos (id)
);

-- Item 38, Nucleo. Catalogo de series y correlativos por tipo de documento, sin FK.
CREATE TABLE series_correlativos_comprobante (
    id BIGSERIAL PRIMARY KEY,
    tipo_documento VARCHAR(20) NOT NULL,
    serie VARCHAR(10) NOT NULL,
    ultimo_correlativo BIGINT NOT NULL
);

-- Item 39, Operacion real.
CREATE TABLE datos_facturacion_cliente (
    id BIGSERIAL PRIMARY KEY,
    id_documento_pago BIGINT NOT NULL,
    dni VARCHAR(15),
    ruc VARCHAR(15),
    razon_social VARCHAR(150),
    CONSTRAINT fk_datos_facturacion_cliente_documento_pago FOREIGN KEY (id_documento_pago) REFERENCES documentos_pago (id)
);

-- Item 40, Operacion real.
CREATE TABLE anulaciones_comprobante (
    id BIGSERIAL PRIMARY KEY,
    id_documento_pago BIGINT NOT NULL,
    motivo VARCHAR(255) NOT NULL,
    fecha TIMESTAMP NOT NULL,
    CONSTRAINT fk_anulaciones_comprobante_documento_pago FOREIGN KEY (id_documento_pago) REFERENCES documentos_pago (id)
);

-- Item 41, marcado con (*) en el documento. Opcional.
CREATE TABLE notas_credito (
    id BIGSERIAL PRIMARY KEY,
    id_documento_pago BIGINT NOT NULL,
    motivo VARCHAR(255) NOT NULL,
    monto DECIMAL(10,2) NOT NULL,
    fecha TIMESTAMP NOT NULL,
    CONSTRAINT fk_notas_credito_documento_pago FOREIGN KEY (id_documento_pago) REFERENCES documentos_pago (id)
);

-- Item 42, marcado con (*) en el documento. Opcional.
CREATE TABLE notas_debito (
    id BIGSERIAL PRIMARY KEY,
    id_documento_pago BIGINT NOT NULL,
    motivo VARCHAR(255) NOT NULL,
    monto DECIMAL(10,2) NOT NULL,
    fecha TIMESTAMP NOT NULL,
    CONSTRAINT fk_notas_debito_documento_pago FOREIGN KEY (id_documento_pago) REFERENCES documentos_pago (id)
);
