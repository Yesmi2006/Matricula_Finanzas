# Contexto de sesión — Proyecto Lamb (continuar si se corta)

Fecha: 2026-10-23. Este archivo resume todo lo decidido hasta ahora para retomar en otra sesión sin perder contexto.

## 1. Repos involucrados

- **D:\CICLO V\MICROSERVICIOS\Modulo-02-Admision-a-Trayectoria** — repo personal del estudiante. 10 microservicios completos con S01-S10 implementado y verificado. **Se usa solo como referencia/fuente para copiar y portar código** — no se modifica más, solo lectura.
- **F:\SISTEMAS\Lamb_UPeU_v2.0** — repo de trabajo real (remote `AyniSyst/Lamb_UPeU_v2.0`, commits "Examen 01 Unidad"). **Acá se hace todo el trabajo de ahora en adelante.**

## 2. Alcance confirmado del proyecto en F:

- El proyecto en F: **no es solo "Admisión a Trayectoria"**, es **todo el sistema Lamb completo**.
- Se definieron **22 dominios** según `docs/proyecto-sello/acad.md` del repo `262dist/pagatu` (guía oficial del docente para dominio académico/universitario):
  1. Institucional, 2. Personas, 3. Admisión, 4. Currículo, 5. Planificación y Oferta Académica, 6. Matrícula, 7. Evaluación y Cierre Académico, 8. Trayectoria Académica, 9. Finanzas del Estudiante, 10. Egreso/Grados/Títulos, 11. Ingresos/Cobranza/Pagos, 12. Extensión/Educación Continua, 13. LMS, 14. Servicios al Estudiante, 15. Investigación, 16. Prácticas/Internado/Vinculación, 17. Movilidad e Internacionalización, 18. Egresados y Seguimiento, 19. Convenios y Relaciones Institucionales, 20. Biblioteca, 21. Analítica/Indicadores/BI, 22. Plataforma Transversal (seguridad/SSO).
- `acad.md` describe el **sistema legado actual** (monolitos modulares + solo 3 microservicios reales + integraciones externas tipo CRM/ERP/pasarela). **El docente pidió migrar lo máximo posible a microservicios** — por eso se decidió NO seguir la topología reducida de acad.md.
- **Decisión de topología confirmada**: TODOS los 22 dominios se construyen como **microservicios propios**, incluyendo los que acad.md marcaba como "externos" (Admisión, ERP Administrativo, Pasarela de pago) — el usuario quiere dejar de depender de servicios externos.
- **Aclaración importante dada al usuario**: una pasarela de pago real no se puede "reemplazar" de verdad (requiere banco/procesador real, PCI). Lo que se construye es un **simulador propio** de pasarela, no un procesador de pagos real.
- **Profundidad esperada**: TODOS los 22 microservicios con profundidad completa — mismo patrón que los 10 actuales (entity/repository/dto/mapper/service/controller/exception + Flyway + S01-S10: config centralizada, Eureka, Gateway, resiliencia, seguridad, mensajería, consistencia/sagas, observabilidad donde aplique).
- **Estimado de tiempo honesto dado al usuario**: 10-15 horas de trabajo efectivo repartidas en varias sesiones, NO en 1 hora (el usuario pidió "menos de 1 hora" para los 22, se le aclaró que no es realista y aceptó seguir por fases).
- **S11 (frontend Angular)**: queda para después, fuera del alcance inmediato — primero se termina backend al máximo.

## 3. Estado de F: antes de empezar a trabajar (línea base)

- 7 microservicios ya creados: `lamb-admision-ms`, `lamb-evaluacion-ms`, `lamb-finanzas-ms`, `lamb-institucional-ms`, `lamb-matricula-ms`, `lamb-personas-ms`, `lamb-planificacion-ms`.
- Esos 7 **solo tenían patrón S01-S04** (estructura base, Eureka, Config, Gateway). Las dependencias de Feign/Resilience4j/Kafka/Prometheus estaban en `pom.xml` pero **sin código real que las usara** (nada de S06-S10 implementado).
- Faltaban completos: `lamb-curriculo-ms`, `lamb-trayectoria-ms`.
- No existía `lamb-auth-ms` ni Keycloak — sin seguridad implementada.
- `infra/` (config, eureka, gateway) y `obs/` ya existían, similares a D:.
- Faltaba `kafka/` y `scripts/`.

## 4. Decisiones técnicas clave

- **Seguridad**: NO se copia `lamb-auth-ms` (JWT propio) de D:. Se construye **Keycloak desde cero** en F:, siguiendo la guía `S07b_Seguridad_Distribuida_Keycloak.md`.
- **`idPersona`**: en D: es la **PK real** (`Long`, `IDENTITY`) de la entidad `Persona` en `lamb-personas-ms`, usada en 6 servicios (admision, auth, evaluacion, finanzas, matricula, trayectoria). Al migrar a Keycloak, **`idPersona` debe quedar como *user attribute*/claim separado (Long)**, **NUNCA reemplazado por `sub` como String** — si se sigue la Parte C de S07b literal (que asume que el claim es un campo de negocio secundario, no la PK), se rompería la PK en cascada en 6 servicios. Esta es una divergencia intencional y ya confirmada.
- **Método de trabajo confirmado con el usuario**: se copia primero lo que sirve de D: (para ir rápido / ahorrar tiempo), pero **la fuente de verdad son las guías oficiales `.md` de sesión** (S01 a S11, descargadas de `262dist/pagatu`) — todo lo copiado de D: se revisa después contra esas guías y se corrige lo que no coincida. D: es punto de partida, no la referencia final.
- **Guías de sesión descargadas localmente** en:
  `C:\Users\iosef\AppData\Local\Temp\claude\D--CICLO-V-MICROSERVICIOS-Modulo-02-Admision-a-Trayectoria\a5215492-f902-45b6-953c-98adbb4d12be\scratchpad\sesiones\`
  (S01 a S11 + S12 + acad.md) — si se pierde esta carpeta temporal, volver a bajarlas con `gh api repos/262dist/pagatu/contents/docs/sesiones/<archivo>.md`.
- **Mapper faltante**: `lamb-trayectoria-ms` (y verificar los demás) necesitaba carpeta `mapper/` — pendiente de confirmar si ya se agregó.

## 5. Plan de trabajo (por bloques)

### Bloque 1 — COMPLETADO (compilación estática OK, falta verificación runtime)

Resultado real:
- Copiado tal cual de D: (ya cumplían guía): `kafka/`, `scripts/`, `lamb-curriculo-ms`, `lamb-trayectoria-ms` completos. `obs/` ya estaba sincronizado con D:.
- Portado S06-S09 (eventos, mensajería, Feign+CircuitBreaker, SecurityConfig, Flyway V2/V3) a los 3 servicios que estaban atrasados: `lamb-admision-ms`, `lamb-evaluacion-ms`, `lamb-planificacion-ms`. `lamb-finanzas-ms`, `lamb-institucional-ms`, `lamb-matricula-ms`, `lamb-personas-ms` ya estaban idénticos a D: — no se tocaron.
- Keycloak construido desde cero: `keycloak/compose-dev.yml` + `keycloak/import/lamb-realm.json` (realm `lamb`, roles ADMIN/COORDINADOR/DOCENTE/ESTUDIANTE, cliente `lamb-frontend` con PKCE S256, redirect `localhost:4200`, protocol mapper `idPersona` como user attribute Long — NO `sub`). 3 usuarios semilla con `idPersona` placeholder (1/2/3).
- Config-repo: `jwk-set-uri` → `issuer-uri` en gateway/admision/curriculo/evaluacion/planificacion/trayectoria. Gateway con rutas nuevas (curriculo, trayectoria, actas), ruta `lamb-auth-login` retirada.
- Mapper faltante en `lamb-trayectoria-ms` agregado (`TrayectoriaMapper` + DTOs) — de paso corrigió que el endpoint exponía entidades JPA crudas.
- Compilación verificada (`mvnw -DskipTests compile`): trayectoria, curriculo, admision, evaluacion, planificacion — todos OK. finanzas/institucional/matricula/personas no se tocaron ni recompilaron (no hacía falta).

**Pendiente de este bloque (decisión/trabajo del usuario):**
1. `idPersona` semilla en Keycloak (1,2,3) son placeholders — calzar con IDs reales de `lamb-personas-ms` antes de probar en serio.
2. No se corrió `docker compose up` end-to-end — solo compilación estática. Falta verificar runtime real: token real, rutas protegidas, eventos Kafka funcionando.
3. Monto de matrícula en finanzas es placeholder fijo (S$350) — falta consultar costo real a Core académico.
4. Sin commit de git todavía.

### Segunda pasada — COMPLETADA (ver más abajo)

El usuario pidió explícitamente completar S01-S10 en TODO lo que hay en F:, no solo lo que coincidía con D: (D: tampoco tenía seguridad individual por microservicio, solo Gateway — eso no cumple el requisito real de S07/S12: "cada microservicio debe validar el token, no solo el Gateway"). Se lanzó un segundo fork que hizo:

- **Seguridad (S07) agregada a los 4 que habían quedado sin tocar**: `lamb-finanzas-ms`, `lamb-institucional-ms`, `lamb-matricula-ms`, `lamb-personas-ms` — `SecurityConfig.java` + dependencia OAuth2 + `issuer-uri` en config-repo.
- **Hallazgo crítico corregido**: el Gateway NO tenía seguridad real — el `issuer-uri` estaba en YAML pero faltaba la dependencia OAuth2 en el pom, así que no validaba nada. Se agregó `SecurityConfig.java` completo con reglas `hasAnyRole` para TODAS las rutas (antes solo cubría las académicas).
- **S06 nuevo**: `lamb-matricula-ms` → `lamb-planificacion-ms` vía Feign+CircuitBreaker (valida sección ABIERTA, fallback no bloqueante si planificación cae).
- **S08/S09 nuevo**: Matrícula publica evento `matricula.confirmada` (Kafka) → Finanzas lo consume y genera `Pago` PENDIENTE de forma idempotente (constraint única `matricula_id`, no duplica si se reentrega el evento). Migración Flyway `V2__add_matricula_id_a_pagos.sql`. Idempotencia también en `confirmar()`/`anular()` de matrícula.
- Compilación verificada OK: matricula, finanzas, institucional, personas, gateway.

### Tercera pasada — COMPLETADA (re-auditoría de los 5 del primer fork)

Se re-auditó línea por línea S06-S10 en admision, curriculo, evaluacion, planificacion, trayectoria contra las guías oficiales (no contra D:, por la duda que dejó el hueco del Gateway). Resultado: **todo correcto, no hizo falta corregir nada** — dependencia OAuth2 real en los 5 poms, SecurityConfig con patrón "segunda línea" literal a S07, Feign+Resilience4j con config real en planificación, Kafka bootstrap-servers configurado en config-repo (no solo clases sueltas), constraints únicas + idempotencia + compensación de saga verificadas, Prometheus + CorrelationIdFilter en los 5, rutas de Gateway coinciden. Compilación OK en los 5.

## BLOQUE 1: COMPLETO Y VERIFICADO (9 microservicios académicos + Gateway + Keycloak, S01-S10 cumplido de verdad)

### Cuarta pasada — VERIFICACIÓN RUNTIME COMPLETADA

Se levantó el stack completo de verdad (no solo `mvnw compile`): 9 Postgres + Kafka + Keycloak + Config/Eureka/Gateway + 9 microservicios, todos registrados en Eureka.

**Bugs reales encontrados y corregidos:**
1. Eureka arrancaba en puerto 8080 (default) en vez de 18761 si se lanzaba antes que Config Server respondiera (`optional:configserver:...` degrada en silencio) — es un problema de **orden de arranque**, no de código: Config Server tiene que estar arriba y respondiendo ANTES de lanzar Eureka.
2. Keycloak 26: usuarios semilla en `lamb-realm.json` sin `firstName`/`lastName` + contraseñas en texto plano no se hashean en `--import-realm` → login fallaba ("Account is not fully set up"). Corregido: agregado firstName/lastName a los 3 usuarios, y creado `keycloak/import/seed-passwords.sh` (nuevo, idempotente, usa Admin REST API para fijar passwords post-boot).
3. Limitación de la máquina: levantar los 9 servicios en paralelo vía `mvnw` (Git-Bash/Cygwin) agota el subsistema `fork()` de Cygwin (no es RAM real). Solución: para varios a la vez, usar `mvnw.cmd` con `Start-Process` de PowerShell (proceso nativo) en vez de Git-Bash.

**Pruebas de seguridad con tokens reales** (vía Gateway): sin token→401, ADMIN→`/personas`→200, ESTUDIANTE→su matrícula→200, ESTUDIANTE→POST personas (solo ADMIN)→403, DOCENTE→`/pagos`→200. `idPersona` confirmado como claim separado del `sub` en el token real.

**Saga completa probada end-to-end**: plan de estudio→curso→sección (evento `seccion.abierta`)→evaluación auto-abre acta (`acta.abierta`)→sección ABIERTA (S06+S08+S09 real) → matrícula confirmada→evento `matricula.confirmada`→Finanzas crea Pago PENDIENTE automático (S/350, matriculaId=1) → repetido `confirmar` una 2da vez → **no duplicó el pago** (idempotencia real en ejecución).

**Datos de prueba creados** (quedan en las bases, sirven de demo): 3 personas (ids 1/2/3 calzadas con idPersona de Keycloak), 1 plan de estudio, 1 curso, 1 sección ABIERTA, 1 acta ABIERTA, 1 matrícula CONFIRMADA, 1 pago PENDIENTE.

**Estado actual: TODO EL STACK QUEDÓ CORRIENDO** (no se bajó, reiniciar cuesta ~15 min por Cygwin/orden de arranque). 4.4GB RAM libre de 16GB con todo arriba. Para bajarlo: `docker compose down` en cada carpeta (`keycloak/`, `kafka/`, cada `services/*/`) + matar procesos java (`Get-Process java | Stop-Process` en PowerShell).

## BLOQUE 1: COMPLETO, VERIFICADO EN CÓDIGO Y EN RUNTIME REAL

### Quinta pasada — obs/ construido desde cero + admision→trayectoria probado

**obs/ no existía en modo DEV** (ni en D: ni en F: — faltaba `compose-dev.yml`, solo había `prometheus-dev.yml` suelto sin nada que lo usara). Construido completo siguiendo S03/S04/S10:
- `obs/compose-dev.yml` (nuevo, puertos DEV: Prometheus 19090, Loki 13100, Grafana 13000 — distintos de PROD 29090/23100/23000)
- `obs/promtail/promtail-config-dev.yml` (nuevo) y fix de `promtail-config.yml` (le faltaban curriculo/trayectoria/gateway/keycloak)
- Prometheus (dev y prod): agregado target de Keycloak

**3 bugs reales corregidos:**
1. Gateway sin `logback-spring.xml` → creado.
2. Gateway exponía `prometheus` en config pero sin la dependencia Micrometer → 404 real en `/actuator/prometheus` → agregada, ahora 200.
3. Grafana en crash loop por 2 datasources duplicados marcados `isDefault: true` → corregido (borrado el duplicado).

**Resultado**: Prometheus 10/10 targets UP (9 microservicios+Gateway+Keycloak), Loki recibiendo logs reales, Grafana con 2 dashboards cargando. URLs reales (DEV, no las de PROD): Prometheus `localhost:19090`, Loki `localhost:13100`, Grafana `localhost:13000` (admin/admin).

**Flujo admision→trayectoria probado end-to-end**: facultad→programa→postulación(idPersona=3)→evaluar(18.0)→admitir→evento Kafka→trayectoria creada automática ACTIVO. Reintento de `admitir` misma postulación → 409 Conflict (máquina de estados bloquea antes de repetir el evento — idempotencia válida pero distinta a la de matrícula→finanzas, que sí probó reentrega real de Kafka).

**Estado actual: 17 contenedores + 12 procesos Java corriendo.**

## BLOQUE 1: 100% COMPLETO Y VERIFICADO (código + runtime + observabilidad + las 2 sagas principales probadas)

**Pendiente real:**
1. **Sin commit de git** — hay bastantes archivos modificados sin commitear de las 5 pasadas (correr `git status` en F: antes de commitear para ver la lista completa).
2. Monto de matrícula en finanzas sigue siendo placeholder fijo (S$350) — falta consultar costo real a Core académico.
3. Idempotencia de reentrega real de Kafka (no solo bloqueo de máquina de estados) solo se verificó en matricula→finanzas, no en admision→trayectoria.

### Bloque 2 — PENDIENTE (no empezado)
Construir los **12 dominios nuevos** sin código existente, completos (mismo nivel que los 10 anteriores):
- Extensión/Educación Continua (12), LMS (13), Servicios al Estudiante (14), Investigación (15), Prácticas/Internado/Vinculación (16), Movilidad e Internacionalización (17), Egresados y Seguimiento (18), Convenios y Relaciones Institucionales (19), Biblioteca (20), Analítica/BI (21), Ingresos-Cobranza-Pagos más allá de Finanzas (11, acotado a "Pagos en línea" — simulador propio, no pasarela real), ERP Administrativo (parte de "Administrativo — externo" en acad.md, pero el usuario quiere construirlo propio también).
- `acad.md` solo da 1 línea de descripción por dominio — hay que **diseñar el modelo de datos de cada uno** antes de construir (no hay spec detallada como sí la hay para los 10 académicos).
- No arrancar este bloque hasta terminar y verificar el Bloque 1.

### Bloque 3 — PENDIENTE
S11: integración frontend Angular + Keycloak. Explícitamente pospuesto hasta terminar backend.

## 6. Cómo retomar esta sesión

1. Leer este archivo completo primero.
2. Revisar el estado real de `F:\SISTEMAS\Lamb_UPeU_v2.0` (qué se alcanzó a hacer del Bloque 1) comparando contra la sección 5 de arriba.
3. Si el Bloque 1 quedó incompleto, continuar desde donde se cortó — no repetir desde cero lo que ya esté hecho y compilando.
4. Si el Bloque 1 ya está completo y validado, seguir con el Bloque 2, dominio por dominio (no los 12 de una vez).
5. Mantener la misma regla: las guías `.md` de sesión mandan sobre lo que ya exista copiado de D:.

## 7. Nota — Unificación de controladores matrícula/finanzas (según MATRICULAS_Y_FINANZAS.docx)

Refactor de controllers en `lamb-matricula-ms` y `lamb-finanzas-ms` para que cada dominio (Título 2 del doc) tenga 1 solo controller raíz con subrutas, en vez de 1 controller por atributo.

- **Corrección 2026-10-29**: el conteo original de esta nota (34→7 / 35→9) era aritméticamente incorrecto. Conteo verificado contra el `rm -f` real ejecutado en sesión: **37→7** (matrícula) y **37→9** (finanzas), total **74→16**.
- **lamb-matricula-ms**: 37 controllers → 7 (`CalendarioPeriodosController`, `ReglasRequisitosController`, `OfertaCuposController`, `MatriculaController`, `SituacionEstudianteController`, `CursosCargaAcademicaController`, `RectificacionRetiroReactivacionController`). Rutas saga `/api/v1/matriculas/**` intactas (`confirmar`, `anular`, `agregarCondicion`, `quitarCondicion` verificados presentes en `MatriculaController`).
- **lamb-finanzas-ms**: 37 controllers → 9 (`SaldoEstudianteController`, `CatalogosTarifasController`, `CalendarioPlanesController`, `DescuentosBecasController`, `CobrosController`, `PagoController`, `ComprobantesController`, `ReembolsosCancelacionesController`, `ControlCierreController`). Rutas saga `/api/v1/pagos/**` intactas (`reembolsar` verificado presente en `PagoController`).
- Services/mappers/DTOs/entities/repositories sin tocar — solo se fusionaron controllers.
- Swagger: verificado por grep que los 16 raíces (7+9) tienen `@Tag` — `grep -l "@Tag" *.java | wc -l` = 7 y 9 respectivamente. `@Operation` por endpoint.
- Gateway: rutas nuevas agregadas en `infra/lamb-config/config-repo/lamb-gateway-dev.yml` y `lamb-gateway-prod.yml` (6 matrícula + 8 finanzas, además de las ya existentes `lamb-matricula`/`lamb-finanzas`).
- Seguridad: `infra/lamb-gateway/.../SecurityConfig.java` — arrays `MATRICULA_DOMINIOS` y `FINANZAS_DOMINIOS` con reglas GET-autenticado / escritura por rol (mismo patrón que matriculas/pagos).
- `EXTERNAL_IDS.md` de ambos servicios revisado — sin cambios, documentan a nivel de campo/entidad, no de controller.
- Verificado en 2026-10-29: cada uno de los 37+37 subresources originales conserva su trío listar(GET)/obtener(GET)/crear(POST) en el raíz correspondiente (confirmado vía grep sobre el código actual, no solo por diseño). No se encontró ningún endpoint PUT/PATCH huérfano; los únicos endpoints no-CRUD (`confirmar`, `anular`, `agregarCondicion`, `quitarCondicion`, `reembolsar`) pertenecen a los 2 raíces que nunca se borraron (`MatriculaController`, `PagoController`) y están confirmados presentes.
- Los 7+9 = 16 directorios de controllers no contienen ningún archivo residual de los 74 originales (confirmado por `ls`: exactamente 7 y 9 archivos).
- Los 3 módulos compilan limpio en esta verificación (2026-10-29): `lamb-matricula-ms`, `lamb-finanzas-ms`, `infra/lamb-gateway` (`./mvnw -DskipTests compile`, exit 0 los tres).
- Pendiente: verificar visualmente en Swagger UI (localhost:8085 y 8087) que aparecen los 16 grupos — no se levantaron los servicios en esta sesión.
