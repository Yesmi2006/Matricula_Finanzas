CREATE TABLE IF NOT EXISTS condiciones_matricula (
    id BIGSERIAL PRIMARY KEY,
    nombre VARCHAR(40) NOT NULL,
    descripcion VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS situaciones_academicas_estudiante (
    id BIGSERIAL PRIMARY KEY,
    id_persona BIGINT NOT NULL,
    periodo VARCHAR(20) NOT NULL,
    situacion VARCHAR(30) NOT NULL,
    fecha_registro TIMESTAMP NOT NULL
);

CREATE TABLE IF NOT EXISTS cambios_situacion_academica (
    id BIGSERIAL PRIMARY KEY,
    id_situacion_academica BIGINT NOT NULL,
    situacion_anterior VARCHAR(30),
    situacion_nueva VARCHAR(30) NOT NULL,
    resolucion VARCHAR(255) NOT NULL,
    fecha_cambio TIMESTAMP NOT NULL
);

CREATE TABLE IF NOT EXISTS estudiantes_observados_suspendidos (
    id BIGSERIAL PRIMARY KEY,
    id_persona BIGINT NOT NULL,
    tipo VARCHAR(20) NOT NULL,
    motivo VARCHAR(255) NOT NULL,
    fecha_inicio DATE NOT NULL,
    fecha_fin DATE
);

-- CRUD opcional: movilidad / intercambio estudiantil (no todas las instituciones lo ofrecen).
CREATE TABLE IF NOT EXISTS movilidades_estudiantiles (
    id BIGSERIAL PRIMARY KEY,
    id_persona BIGINT NOT NULL,
    institucion_destino VARCHAR(150) NOT NULL,
    tipo_movilidad VARCHAR(20) NOT NULL,
    periodo VARCHAR(20) NOT NULL,
    fecha_inicio DATE,
    fecha_fin DATE,
    estado VARCHAR(20)
);

-- Tabla de union para la relacion muchos a muchos real Matricula <-> CondicionMatricula.
CREATE TABLE IF NOT EXISTS matricula_condicion (
    id_matricula BIGINT NOT NULL REFERENCES matriculas(id),
    id_condicion BIGINT NOT NULL REFERENCES condiciones_matricula(id),
    PRIMARY KEY (id_matricula, id_condicion)
);
