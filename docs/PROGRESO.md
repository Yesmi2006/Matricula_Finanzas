# Progreso

1. Parte 1 (endpoints sobrantes removidos): hecho.
2. Parte 2 (saga pago-antes-de-confirmar): hecho y verificado, servicios arrancan OK.
3. Parte 3 (Keycloak: coordinador1, estudiante2, claim id_persona): hecho y verificado. id_persona declarado en user profile (view/edit solo admin), persiste en los 5 usuarios (admin=1, docente1=2, estudiante1=3, coordinador1=4, estudiante2=5). Confirmado: estudiante1 NO puede modificar su id_persona (403 vía admin API sin rol, direct grants deshabilitado en account-console).
4. Reimport de Keycloak: SIEMPRE por borrar-realm (DELETE /admin/realms/lamb) + reiniciar el contenedor (start-dev --import-realm). NUNCA usar `kc.sh import --override` sobre una base en uso (causó pérdida total del realm una vez).
5. Parte 4 orden: login+guards > asistente matrícula+pago > Mis contratos/Mi estado financiero > validación pagos coordinador/admin > panel admin.
6. Pendiente sin tocar: flyway repair V13 (bloqueado, esperar decisión usuario).
7. Pendiente: quitar ignore-migration-patterns de lamb-finanzas-ms-dev.yml tras resolver V13.
8. Frontend: Angular 22 standalone, signals.
9. Referencia UI: docs/referencia-ui, ver 0_LEEME.md.
10. Sin commits, sin cambios fuera de alcance. Última etapa completada: Parte 3 (Keycloak).
