import { Injectable, signal } from '@angular/core';
import Keycloak from 'keycloak-js';
import { APP_CONFIG } from '../config';

export interface UsuarioSesion {
  nombre: string;
  email: string;
  roles: string[];
  idPersona: number | null;
}

@Injectable({ providedIn: 'root' })
export class KeycloakService {
  readonly keycloak = new Keycloak({
    url: APP_CONFIG.keycloak.url,
    realm: APP_CONFIG.keycloak.realm,
    clientId: APP_CONFIG.keycloak.clientId,
  });

  readonly autenticado = signal(false);
  readonly usuario = signal<UsuarioSesion | null>(null);

  async init(): Promise<void> {
    const ok = await this.keycloak.init({
      onLoad: 'login-required',
      pkceMethod: 'S256',
      checkLoginIframe: false,
    });
    this.autenticado.set(ok);
    if (ok) {
      this.cargarUsuario();
      // Refresca el token 30s antes de expirar.
      setInterval(() => this.keycloak.updateToken(30).catch(() => this.logout()), 15000);
    }
  }

  private cargarUsuario(): void {
    const token = this.keycloak.tokenParsed as Record<string, unknown> | undefined;
    if (!token) return;
    this.usuario.set({
      nombre: (token['name'] as string) ?? (token['preferred_username'] as string) ?? 'Usuario',
      email: (token['email'] as string) ?? '',
      roles: (this.keycloak.realmAccess?.roles ?? []) as string[],
      idPersona: (token['idPersona'] as number) ?? null,
    });
  }

  get token(): string | undefined {
    return this.keycloak.token;
  }

  tieneRol(rol: string): boolean {
    return this.keycloak.hasRealmRole(rol);
  }

  logout(): void {
    this.keycloak.logout({ redirectUri: window.location.origin });
  }
}
