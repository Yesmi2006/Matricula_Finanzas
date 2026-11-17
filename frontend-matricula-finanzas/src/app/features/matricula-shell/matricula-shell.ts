import { Component } from '@angular/core';
import { AppShell } from '../../shared/components/app-shell/app-shell';
import { MATRICULA_GROUPS } from '../../config/resources.matricula';

@Component({
  selector: 'app-matricula-shell',
  standalone: true,
  imports: [AppShell],
  template: `<app-shell domainKey="matricula" domainLabel="Matrícula" [groups]="groups"></app-shell>`,
})
export class MatriculaShell {
  readonly groups = MATRICULA_GROUPS;
}
