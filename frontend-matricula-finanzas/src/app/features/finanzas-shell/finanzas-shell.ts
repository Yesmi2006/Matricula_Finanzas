import { Component } from '@angular/core';
import { AppShell } from '../../shared/components/app-shell/app-shell';
import { FINANZAS_GROUPS } from '../../config/resources.finanzas';

@Component({
  selector: 'app-finanzas-shell',
  standalone: true,
  imports: [AppShell],
  template: `<app-shell domainKey="finanzas" domainLabel="Finanzas" [groups]="groups"></app-shell>`,
})
export class FinanzasShell {
  readonly groups = FINANZAS_GROUPS;
}
