import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-workflow',
  standalone: true,
  imports: [CommonModule],
  template: `
    <section class="py-24 bg-white overflow-hidden">
      <div class="container">
        <div class="text-center mb-16">
          <h2 class="section-title">A flawless flow from seat to receipt</h2>
          <p class="section-subtitle">Streamlined operations that connect every part of your restaurant in real-time.</p>
        </div>

        <!-- Timeline -->
        <div class="relative max-w-5xl mx-auto px-4">
          <!-- Connector Line -->
          <div class="absolute top-[2rem] left-0 w-full h-0.5 bg-brand/20 -translate-y-1/2 hidden md:block"></div>

          <div class="grid md:grid-cols-4 gap-12 relative">
            <div *ngFor="let step of steps; let i = index" class="relative flex flex-col items-center group">
              <!-- Icon Circle -->
              <div class="w-16 h-16 rounded-full bg-white border-2 border-brand/20 flex items-center justify-center text-brand z-10 shadow-sm transition-all duration-300">
                 <span [innerHTML]="step.icon"></span>
              </div>

              <!-- Content -->
              <div class="mt-6 text-center">
                <p class="text-brand font-bold text-sm mb-1 uppercase tracking-wider">{{ i + 1 }}. {{ step.title }}</p>
                <p class="text-slate-500 text-sm leading-relaxed">{{ step.description }}</p>
              </div>
            </div>
          </div>
        </div>

        <!-- Technology Badges -->
        <div class="mt-24 text-center">
           <p class="text-xs font-bold text-slate-400 uppercase tracking-[0.2em] mb-8">Powering the best kitchens with reliable tech</p>
           <div class="flex flex-wrap justify-center gap-4">
              <span *ngFor="let tech of technologies" class="px-4 py-2 rounded-full border border-slate-100 bg-slate-50 text-slate-600 text-sm font-medium flex items-center gap-2">
                 <div class="w-1.5 h-1.5 rounded-full" [style.background]="tech.color"></div>
                 {{ tech.name }}
              </span>
           </div>
        </div>
      </div>
    </section>
  `
})
export class WorkflowComponent {
  steps = [
    {
      title: 'Order',
      description: 'Waiters take orders on handheld devices, instantly appearing on KDS.',
      icon: '<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"><path d="m16 12 2 2 4-4"/><rect width="20" height="14" x="2" y="6" rx="2"/></svg>'
    },
    {
      title: 'Prep',
      description: 'Kitchen receives organized tickets with accurate modifiers and timing.',
      icon: '<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"><path d="M6 13.87A4 4 0 0 1 7.41 6a5.11 5.11 0 0 1 1.05-1.54 5 5 0 0 1 7.08 0A5.11 5.11 0 0 1 16.59 6 4 4 0 0 1 18 13.87V21H6Z"/><line x1="6" y1="17" x2="18" y2="17"/></svg>'
    },
    {
      title: 'Payment',
      description: 'Quick check-outs with integrated cards, digital wallets, or cash split.',
      icon: '<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"><rect width="20" height="14" x="2" y="5" rx="2"/><line x1="2" x2="22" y1="10" y2="10"/></svg>'
    },
    {
      title: 'Insight',
      description: 'Manager reviews performance reports and inventory levels in real-time.',
      icon: '<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"><path d="M21.21 15.89A10 10 0 1 1 8 2.83"/><path d="M22 12A10 10 0 0 0 12 2v10z"/></svg>'
    }
  ];

  technologies = [
    { name: 'Spring Boot', color: '#6db33f' },
    { name: 'PostgreSQL', color: '#336791' },
    { name: 'Android Enterprise', color: '#3ddc84' },
    { name: 'AWS Cloud', color: '#ff9900' }
  ];
}
