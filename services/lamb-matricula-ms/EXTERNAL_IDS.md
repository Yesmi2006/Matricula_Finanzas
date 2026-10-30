# Identificadores externos (JALA ID) — lamb-matricula-ms

Este documento lista los campos de `lamb-matricula-ms` que almacenan un identificador
(`Long`) perteneciente a otro microservicio, sin relacion JPA (`@ManyToOne`/FK) local,
siguiendo la regla "jalar IDs" del documento MATRICULAS Y FINANZAS: cuando un dato es
propiedad de otro microservicio, no se duplica su CRUD aqui, solo se referencia su ID.

Esta lista es para que el equipo pueda fusionar el codigo y, en el momento de la
integracion, decidir si se agrega una validacion remota (ej. llamada REST/Feign) contra
el microservicio propietario de cada ID.

## Planificacion

- `AmpliacionCupo.idSeccion` (dto `AmpliacionCupoRequest.idSeccion`) — la seccion/grupo
  cuyo cupo se ampliase se define en `lamb-planificacion-ms`.
- `CruceHorarioAutorizado.idSeccion1` / `idSeccion2` — ambas secciones en conflicto
  horario se definen en `lamb-planificacion-ms`.
- `ListaEsperaSeccion.idSeccion` (dto `ListaEsperaSeccionRequest.idSeccion`) — la seccion
  la define y mantiene `lamb-planificacion-ms`.
- `ReservaVacante.idSeccion` (dto `ReservaVacanteRequest.idSeccion`) — la seccion/grupo
  (cupo, apertura y cierre) la define `lamb-planificacion-ms`.

## Curriculo

- `EleccionCursoElectivo.idCurso` — el catalogo de cursos electivos lo gestiona
  `lamb-curriculo-ms`.
- `LiberacionExcepcionalPrerrequisito.idCurso` / `idPrerrequisito` — ambos cursos
  (curso y su prerrequisito) se definen en `lamb-curriculo-ms`.
- `IntentoCurso.idCurso` — identificador de curso gestionado por `lamb-curriculo-ms`.
- `RequisitoPorTipoMatricula.idRequisito` (dto
  `RequisitoPorTipoMatriculaRequest.idRequisito`) — el requisito en si (ej.
  Prerrequisito) lo define y mantiene `lamb-curriculo-ms`.
