import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-cta',
  standalone: true,
  imports: [CommonModule],
  template: `
    <section class="py-24">
      <div class="container">
        <div class="relative bg-gradient-to-br from-brand to-orange-600 rounded-[3rem] p-8 md:p-20 overflow-hidden text-center shadow-2xl shadow-orange-200">
          <!-- Decorative shapes -->
          <div class="absolute top-0 right-0 w-64 h-64 bg-white/10 rounded-full -mr-20 -mt-20 blur-3xl"></div>
          <div class="absolute bottom-0 left-0 w-64 h-64 bg-black/10 rounded-full -ml-20 -mb-20 blur-3xl"></div>

          <div class="relative z-10 max-w-3xl mx-auto">
            <span class="inline-block px-4 py-1.5 rounded-full bg-white/20 text-white text-xs font-bold uppercase tracking-widest mb-6">Coming Soon in V2.0</span>
            <h2 class="text-4xl md:text-6xl font-extrabold text-white mb-8 leading-tight">
              Ready to transform your restaurant workflow?
            </h2>
            <p class="text-lg md:text-xl text-orange-50 mb-12 opacity-90">
              Join 500+ restaurants saving time and money with Orderly. Setup takes less than 24 hours.
            </p>

            <div class="flex flex-col sm:flex-row items-center justify-center gap-4">
              <button class="bg-white text-brand px-10 py-4 rounded-full font-bold text-lg hover:bg-orange-50 transition-colors shadow-xl">Get Started Now</button>
              <button class="border-2 border-white/40 text-white hover:bg-white/10 px-10 py-4 rounded-full font-bold text-lg transition-colors">Talk to Sales</button>
            </div>

            <p class="mt-8 text-sm text-orange-100/80">No credit card required for 14-day trial.</p>
          </div>
        </div>
      </div>
    </section>
  `
})
export class CTAComponent {}
