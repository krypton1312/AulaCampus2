import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HeroComponent } from '../sections/hero.component';
import { ComparisonComponent } from '../sections/comparison.component';
import { FeaturesComponent } from '../sections/features.component';
import { DevicesComponent } from '../sections/devices.component';
import { WorkflowComponent } from '../sections/workflow.component';
import { CTAComponent } from '../sections/cta.component';

@Component({
  selector: 'app-landing',
  standalone: true,
  imports: [
    CommonModule,
    HeroComponent,
    ComparisonComponent,
    FeaturesComponent,
    DevicesComponent,
    WorkflowComponent,
    CTAComponent
  ],
  template: `
    <main>
      <app-hero></app-hero>
      <app-comparison></app-comparison>
      <app-features></app-features>
      <app-devices></app-devices>
      <app-workflow></app-workflow>
      <app-cta></app-cta>
    </main>
  `
})
export class LandingComponent {}
