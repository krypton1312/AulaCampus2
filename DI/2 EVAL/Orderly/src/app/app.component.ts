import { Component } from '@angular/core';
import { NavbarComponent } from './components/navbar/navbar.component';
import { HeroComponent } from './components/hero/hero.component';
import { ProblemSolutionComponent } from './components/problem-solution/problem-solution.component';
import { FeaturesComponent } from './components/features/features.component';
import { TestimonialComponent } from './components/testimonial/testimonial.component';
import { PricingComponent } from './components/pricing/pricing.component';
import { FinalCtaComponent } from './components/final-cta/final-cta.component';
import { FooterComponent } from './components/footer/footer.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    NavbarComponent,
    HeroComponent,
    ProblemSolutionComponent,
    FeaturesComponent,
    TestimonialComponent,
    PricingComponent,
    FinalCtaComponent,
    FooterComponent
  ],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'orderly';
}