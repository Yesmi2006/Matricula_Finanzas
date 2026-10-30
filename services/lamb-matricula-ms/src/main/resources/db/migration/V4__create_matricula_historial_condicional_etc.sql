CREATE TABLE IF NOT EXISTS historial_estados_matricula (
    id BIGSERIAL PRIMARY KEY,
    id_matricula BIGINT NOT NULL,
    estado_anterior VARCHAR(20),
    estado_nuevo VARCHAR(20) NOT NULL,
    fecha_cambio TIMESTAMP NOT NULL,
    observacion VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS matriculas_condicionales (
    id BIGSERIAL PRIMARY KEY,
    id_matricula BIGINT NOT NULL,
    motivo VARCHAR(255) NOT NULL,
    fecha_condicion DATE NOT NULL,
    levantada BOOLEAN NOT NULL
);

CREATE TABLE IF NOT EXISTS anulaciones_matricula (
    id BIGSERIAL PRIMARY KEY,
    id_matricula BIGINT NOT NULL,
    motivo VARCHAR(255) NOT NULL,
    fecha_anulacion TIMESTAMP NOT NULL,
    autorizado_por VARCHAR(80)
);

CREATE TABLE IF NOT EXISTS observaciones_matricula (
    id BIGSERIAL PRIMARY KEY,
    id_matricula BIGINT NOT NULL,
    observacion VARCHAR(500) NOT NULL,
    fecha_observacion TIMESTAMP NOT NULL,
    usuario_registro VARCHAR(80)
);

CREATE TABLE IF NOT EXISTS notificaciones_matricula (
    id BIGSERIAL PRIMARY KEY,
    id_matricula BIGINT NOT NULL,
    tipo VARCHAR(40) NOT NULL,
    canal VARCHAR(20) NOT NULL,
    fecha_envio TIMESTAMP NOT NULL,
    estado_envio VARCHAR(20)
);

CREATE TABLE IF NOT EXISTS constancias_matricula (
    id BIGSERIAL PRIMARY KEY,
    id_matricula BIGINT NOT NULL,
    fecha_emision TIMESTAMP NOT NULL,
    codigo_verificacion VARCHAR(40) NOT NULL,
    url_documento VARCHAR(255)
);
