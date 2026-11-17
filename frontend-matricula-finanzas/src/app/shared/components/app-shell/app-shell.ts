import { Component, Input, inject } from '@angular/core';
import { RouterLink, RouterLinkActive, RouterOutlet } from '@angular/router';
import { ControllerGroup } from '../../models/resource.model';
import { KeycloakService } from '../../../core/auth/keycloak.service';

@Component({
  selector: 'app-shell',
  standalone: true,
  imports: [RouterLink, RouterLinkActive, RouterOutlet],
  templateUrl: './app-shell.html',
  styleUrl: './app-shell.scss',
})
export class AppShell {
  private readonly keycloak = inject(KeycloakService);

  @Input({ required: true }) domainLabel!: string;
  @Input({ required: true }) domainKey!: string;
  @Input({ required: true }) groups: ControllerGroup[] = [];

  readonly usuario = this.keycloak.usuario;

  logout(): void {
    this.keycloak.logout();
  }
}
