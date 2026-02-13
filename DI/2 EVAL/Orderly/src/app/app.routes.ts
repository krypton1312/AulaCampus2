import { Routes } from '@angular/router';
import { LandingComponent } from './components/landing.component';

export const routes: Routes = [
  { path: '', component: LandingComponent },
  { path: '**', redirectTo: '' }
];
