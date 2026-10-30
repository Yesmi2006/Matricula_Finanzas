-- Lote F2: Catalogos y tarifas (items 1-3 del documento MATRICULAS Y FINANZAS)

-- CRUD marcado con (*) en el documento: "Categoria de concepto (OTRO CRUD)".
CREATE TABLE IF NOT EXISTS categorias_concepto (
    id BIGSERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS conceptos_pago (
    id BIGSERIAL PRIMARY KEY,
    id_categoria BIGINT NOT NULL,
    nombre VARCHAR(150) NOT NULL,
    monto DECIMAL(10,2) NOT NULL,
    vigencia_desde DATE NOT NULL,
    vigencia_hasta DATE,
    CONSTRAINT fk_conceptos_pago_categoria FOREIGN KEY (id_categoria) REFERENCES categorias_concepto(id)
);

CREATE TABLE IF NOT EXISTS tarifarios_escuela_ciclo (
    id BIGSERIAL PRIMARY KEY,
    id_concepto_pago BIGINT NOT NULL,
    id_escuela BIGINT NOT NULL,
    ciclo VARCHAR(20) NOT NULL,
    monto DECIMAL(10,2) NOT NULL,
    CONSTRAINT fk_tarifarios_concepto_pago FOREIGN KEY (id_concepto_pago) REFERENCES conceptos_pago(id)
);
