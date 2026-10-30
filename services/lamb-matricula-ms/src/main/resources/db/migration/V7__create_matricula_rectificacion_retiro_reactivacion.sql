-- Lote 6: Rectificacion, retiro y reactivacion (items 73-78 del documento MATRICULAS Y FINANZAS)

CREATE TABLE IF NOT EXISTS solicitudes_rectificacion (
    id BIGSERIAL PRIMARY KEY,
    id_matricula BIGINT NOT NULL,
    motivo VARCHAR(255) NOT NULL,
    estado VARCHAR(30) NOT NULL,
    fecha_solicitud TIMESTAMP NOT NULL
);

CREATE TABLE IF NOT EXISTS retiros_oficio (
    id BIGSERIAL PRIMARY KEY,
    id_matricula BIGINT NOT NULL,
    motivo VARCHAR(255) NOT NULL,
    fecha_retiro TIMESTAMP NOT NULL
);

-- CRUD opcional: depende de la universidad.
CREATE TABLE IF NOT EXISTS retiros_inasistencia (
    id BIGSERIAL PRIMARY KEY,
    id_matricula BIGINT NOT NULL,
    numero_inasistencias INT NOT NULL,
    fecha_retiro TIMESTAMP NOT NULL
);

CREATE TABLE IF NOT EXISTS reactivaciones_matricula_anulada (
    id BIGSERIAL PRIMARY KEY,
    id_matricula BIGINT NOT NULL,
    motivo VARCHAR(255) NOT NULL,
    fecha_reactivacion TIMESTAMP NOT NULL
);

CREATE TABLE IF NOT EXISTS anulaciones_masivas_impago (
    id BIGSERIAL PRIMARY KEY,
    periodo VARCHAR(20) NOT NULL,
    total_matriculas_anuladas INT NOT NULL,
    motivo VARCHAR(255) NOT NULL,
    fecha_ejecucion TIMESTAMP NOT NULL
);

-- CRUD opcional: depende de la universidad.
CREATE TABLE IF NOT EXISTS rehabilitaciones_matricula (
    id BIGSERIAL PRIMARY KEY,
    id_matricula BIGINT NOT NULL,
    motivo VARCHAR(255) NOT NULL,
    fecha_rehabilitacion TIMESTAMP NOT NULL
);
