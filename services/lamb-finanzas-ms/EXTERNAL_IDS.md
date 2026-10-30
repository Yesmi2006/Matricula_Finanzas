# Identificadores externos (JALA ID) — lamb-finanzas-ms

Este documento lista los campos de `lamb-finanzas-ms` que almacenan un identificador
(`Long`) perteneciente a otro microservicio, sin relacion JPA (`@ManyToOne`/FK) local,
siguiendo la regla "jalar IDs" del documento MATRICULAS Y FINANZAS: cuando un dato es
propiedad de otro microservicio, no se duplica su CRUD aqui, solo se referencia su ID.

Esta lista es para que el equipo pueda fusionar el codigo y, en el momento de la
integracion, decidir si se agrega una validacion remota (ej. llamada REST/Feign) contra
el microservicio propietario de cada ID.

## Usuarios / Personas

- `BecaAplicada.idPersona` (entity `BecaAplicada`, dto `BecaAplicadaRequest.idPersona`)
  — la persona/estudiante beneficiario de la beca es dato propio del microservicio de
  Usuarios/Personas.
- `DescuentoAplicado.idPersona` (entity `DescuentoAplicado`, dto
  `DescuentoAplicadoRequest.idPersona`) — la persona/estudiante beneficiario del
  descuento es dato propio del microservicio de Usuarios/Personas.
- `RecaudacionVentanilla.idCajero` (entity `RecaudacionVentanilla`)
  — el cajero que atendio la recaudacion en ventanilla es dato propio del microservicio
  de Usuarios/Personas.

## Curriculo

- `TarifarioEscuelaCiclo.idEscuela` (entity `TarifarioEscuelaCiclo`, dto
  `TarifarioEscuelaCicloRequest.idEscuela`) — la escuela cuyo tarifario se define es dato
  propio del microservicio de Curriculo.

## Matricula

- `CancelacionCargoMatricula.idMatricula` (entity `CancelacionCargoMatricula`, dto
  `CancelacionCargoMatriculaRequest.idMatricula`) — la matricula anulada que origina la
  cancelacion del cargo se gestiona en `lamb-matricula-ms`.

## Notas sobre referencias resueltas localmente (no son JALA ID)

Los siguientes items del documento estan anotados en el documento como "JALA ID" hacia
otro item, pero ese item de origen ya esta implementado como entidad local en
`lamb-finanzas-ms`, por lo que se modelaron como relaciones JPA reales (`@ManyToOne` con
FK), no como campos externos sin FK:

- `EstadoCobro.cuentaEstudiante` — el documento marca este item (17) como "JALA ID 15"
  (Saldo de Estudiante), y el item 15 a su vez es "JALA ID 64" (Catalogo y tarifas), que
  ya esta implementado localmente como `CuentaEstudiante`.
- `ConstanciaNoAdeudo.estadoCobro` — el documento marca este item (59) como
  "JALA ID 17 - COBROS", y el item 17 ya esta implementado localmente como `EstadoCobro`.
- `ReembolsoPago.cuentaEstudiante` — el documento marca este item (53) como
  "RETORNA AL ID 69 - SALDO DE ESTUDIANTE", que ya esta implementado localmente como
  `CuentaEstudiante`.
- `EstadoCuentaEstudiante.cuentaEstudiante` — el documento marca este item (58) como
  "RETORNA AL ID 64 - CATALOGO Y TARIFAS", ya implementado localmente como
  `CuentaEstudiante`.
- `DetalleCobro.descuentoAplicado` — el documento marca este item (16, bajo "Cobros")
  como "JALA ID DE 30 - DESCUENTOS Y BECAS", y el item 30 ya esta implementado
  localmente en este mismo microservicio como `DescuentoAplicado`. Relacion `@ManyToOne`
  nullable (no todo cargo tiene un descuento aplicado).
