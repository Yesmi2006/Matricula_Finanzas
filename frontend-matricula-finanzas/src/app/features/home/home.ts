import { Component, computed, inject } from '@angular/core';
import { RouterLink } from '@angular/router';
import { KeycloakService } from '../../core/auth/keycloak.service';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [RouterLink],
  templateUrl: './home.html',
  styleUrl: './home.scss',
})
export class Home {
  private readonly keycloak = inject(KeycloakService);
  readonly usuario = this.keycloak.usuario;

  readonly inicial = computed(() => (this.usuario()?.nombre?.trim()?.[0] ?? 'U').toUpperCase());

  readonly avatarIniciales = computed(() => {
    const nombre = this.usuario()?.nombre?.trim();
    if (!nombre) return 'U';
    const partes = nombre.split(/\s+/);
    return ((partes[0]?.[0] ?? '') + (partes[1]?.[0] ?? '')).toUpperCase();
  });

  logout(): void {
    this.keycloak.logout();
  }
}
