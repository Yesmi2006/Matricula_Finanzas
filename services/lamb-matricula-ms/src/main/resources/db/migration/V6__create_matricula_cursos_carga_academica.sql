CREATE TABLE IF NOT EXISTS intentos_curso (
    id BIGSERIAL PRIMARY KEY,
    id_persona BIGINT NOT NULL,
    id_curso BIGINT NOT NULL,
    numero_intento INTEGER NOT NULL,
    periodo VARCHAR(20) NOT NULL,
    fecha_registro TIMESTAMP NOT NULL
);

CREATE TABLE IF NOT EXISTS cargas_academicas_periodo (
    id BIGSERIAL PRIMARY KEY,
    id_persona BIGINT NOT NULL,
    periodo VARCHAR(20) NOT NULL,
    total_creditos INTEGER NOT NULL,
    total_cursos INTEGER NOT NULL,
    fecha_calculo TIMESTAMP NOT NULL
);

CREATE TABLE IF NOT EXISTS elecciones_curso_electivo (
    id BIGSERIAL PRIMARY KEY,
    id_persona BIGINT NOT NULL,
    id_curso BIGINT NOT NULL,
    periodo VARCHAR(20) NOT NULL,
    fecha_eleccion TIMESTAMP NOT NULL
);

CREATE TABLE IF NOT EXISTS cruces_horario_autorizados (
    id BIGSERIAL PRIMARY KEY,
    id_matricula BIGINT NOT NULL,
    id_seccion_1 BIGINT NOT NULL,
    id_seccion_2 BIGINT NOT NULL,
    motivo VARCHAR(255) NOT NULL,
    fecha_autorizacion TIMESTAMP NOT NULL
);

-- (*) CRUD marcado en el documento: excepcion administrativa poco frecuente.
CREATE TABLE IF NOT EXISTS liberaciones_excepcionales_prerrequisito (
    id BIGSERIAL PRIMARY KEY,
    id_persona BIGINT NOT NULL,
    id_curso BIGINT NOT NULL,
    id_prerrequisito BIGINT NOT NULL,
    motivo VARCHAR(255) NOT NULL,
    fecha_autorizacion TIMESTAMP NOT NULL
);

-- (*) CRUD marcado en el documento: autorizacion excepcional de sobrecarga de creditos.
CREATE TABLE IF NOT EXISTS sobrecargas_creditos_autorizadas (
    id BIGSERIAL PRIMARY KEY,
    id_matricula BIGINT NOT NULL,
    creditos_autorizados INTEGER NOT NULL,
    motivo VARCHAR(255) NOT NULL,
    fecha_autorizacion TIMESTAMP NOT NULL
);

-- (*) CRUD marcado en el documento: autorizacion excepcional de carga minima.
CREATE TABLE IF NOT EXISTS cargas_minimas_autorizadas (
    id BIGSERIAL PRIMARY KEY,
    id_matricula BIGINT NOT NULL,
    creditos_minimos INTEGER NOT NULL,
    motivo VARCHAR(255) NOT NULL,
    fecha_autorizacion TIMESTAMP NOT NULL
);
