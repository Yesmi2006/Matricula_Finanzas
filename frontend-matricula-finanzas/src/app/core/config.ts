// Configuracion central del frontend. Ajustar estos valores segun el entorno real.
export const APP_CONFIG = {
  // Gateway (lamb-gateway) expuesto en infra/lamb-config/config-repo/lamb-gateway-dev.yml
  apiBaseUrl: 'http://localhost:18080/api/v1',
  keycloak: {
    url: 'http://localhost:18180',
    realm: 'lamb',
    clientId: 'lamb-frontend',
  },
};
