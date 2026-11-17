import { Routes } from '@angular/router';
import { authGuard } from './core/auth/auth.guard';
import { Home } from './features/home/home';
import { MatriculaShell } from './features/matricula-shell/matricula-shell';
import { FinanzasShell } from './features/finanzas-shell/finanzas-shell';
import { ResourceView } from './features/resource-view/resource-view';

export const routes: Routes = [
  {
    path: '',
    canActivate: [authGuard],
    children: [
      { path: '', component: Home, pathMatch: 'full' },
      {
        path: 'matricula',
        component: MatriculaShell,
        children: [{ path: ':groupKey/:resourceKey', component: ResourceView }],
      },
      {
        path: 'finanzas',
        component: FinanzasShell,
        children: [{ path: ':groupKey/:resourceKey', component: ResourceView }],
      },
    ],
  },
];
