import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-hero',
  standalone: true,
  imports: [CommonModule],
  template: `
    <section class="pt-16 pb-24 md:pt-24 md:pb-32 overflow-hidden gradient-hero">
      <div class="container relative">
        <!-- Badge -->
        <div class="flex justify-center mb-6">
          <span class="inline-flex items-center gap-2 px-3 py-1 rounded-full bg-brand/10 text-brand text-xs font-bold tracking-wide uppercase">
            <span class="relative flex h-2 w-2">
              <span class="animate-ping absolute inline-flex h-full w-full rounded-full bg-brand opacity-75"></span>
              <span class="relative inline-flex rounded-full h-2 w-2 bg-brand"></span>
            </span>
            V2.0 now available
          </span>
        </div>

        <!-- Headline -->
        <div class="text-center max-w-4xl mx-auto mb-10">
          <h1 class="text-5xl md:text-7xl font-extrabold tracking-tight text-slate-900 leading-[1.1] mb-6">
            Smart Hospitality <br>
            <span class="text-brand">Management Made Simple</span>
          </h1>
          <p class="text-lg md:text-xl text-muted leading-relaxed max-w-2xl mx-auto">
            The all-in-one operating system for hospitality restaurants. Streamline orders, payments, and kitchen workflows on one beautiful interface.
          </p>
        </div>

        <!-- Buttons -->
        <div class="flex flex-col sm:flex-row items-center justify-center gap-4 mb-16">
          <button class="btn btn-primary w-full sm:w-auto px-8 py-4 text-lg">Start Free Trial</button>
          <button class="btn btn-outline w-full sm:w-auto px-8 py-4 text-lg flex items-center justify-center gap-2">
            <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"><polygon points="5 3 19 12 5 21 5 3"/></svg>
            View live Demo
          </button>
        </div>

        <!-- Hero Visual -->
        <div class="relative max-w-5xl mx-auto">
          <!-- Main Device Mockup -->
          <div class="aspect-[16/10] rounded-2xl md:rounded-[2rem] bg-slate-900 shadow-2xl overflow-hidden border-8 border-slate-900 relative">
            <!-- Tablet Interface Simulation -->
            <div class="absolute inset-0 bg-slate-100 m-0.5 rounded-lg md:rounded-[1.8rem] overflow-hidden border border-slate-700/50">
               <div class="w-full h-full bg-[url('https://images.unsplash.com/photo-1556742049-0cfed4f6a45d?auto=format&fit=crop&q=80')] bg-cover bg-center opacity-40"></div>
               <div class="absolute inset-0 bg-gradient-to-t from-white via-transparent to-transparent"></div>

               <!-- UI Elements Placeholder -->
               <div class="absolute top-8 left-8 right-8 bottom-8 flex flex-col gap-4">
                 <div class="w-1/3 h-8 bg-white/80 rounded shadow-sm"></div>
                 <div class="flex gap-4 h-full">
                    <div class="w-2/3 bg-white/60 rounded shadow-sm"></div>
                    <div class="w-1/3 flex flex-col gap-4">
                       <div class="h-1/2 bg-white/60 rounded shadow-sm"></div>
                       <div class="h-1/2 bg-white/60 rounded shadow-sm"></div>
                    </div>
                 </div>
               </div>
            </div>
          </div>

          <!-- Floating Cards -->
          <div class="absolute -top-6 -left-4 md:-left-12 p-4 bg-white rounded-xl shadow-xl border border-slate-100 hidden sm:block animate-bounce-subtle">
             <div class="flex items-center gap-3">
                <div class="w-10 h-10 rounded-full bg-green-100 flex items-center justify-center text-green-600">
                   <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"><path d="M22 11.08V12a10 10 0 1 1-5.93-9.14"/><polyline points="22 4 12 14.01 9 11.01"/></svg>
                </div>
                <div>
                   <p class="text-xs font-bold text-slate-500 uppercase tracking-wider">Payment Received</p>
                   <p class="text-lg font-bold text-slate-900">$134.50</p>
                </div>
             </div>
          </div>

          <div class="absolute top-12 -right-4 md:-right-8 p-4 bg-white rounded-xl shadow-xl border border-slate-100 hidden sm:block delay-700 animate-bounce-subtle-slow">
             <div class="flex items-center gap-3">
                <div class="w-10 h-10 rounded-full bg-brand/10 flex items-center justify-center text-brand">
                   <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round"><path d="M6 2 3 6v14a2 2 0 0 0 2 2h14a2 2 0 0 0 2-2V6l-3-4Z"/><path d="M3 6h18"/><path d="M16 10a4 4 0 0 1-8 0"/></svg>
                </div>
                <div>
                   <p class="text-xs font-bold text-slate-500 uppercase tracking-wider">New Order</p>
                   <p class="text-sm font-bold text-slate-900">Table 4 • 3 Items</p>
                </div>
             </div>
          </div>
        </div>
      </div>
    </section>
  `,
  styles: [`
    @keyframes bounce-subtle {
      0%, 100% { transform: translateY(0); }
      50% { transform: translateY(-10px); }
    }
    .animate-bounce-subtle {
      animation: bounce-subtle 4s ease-in-out infinite;
    }
    .animate-bounce-subtle-slow {
      animation: bounce-subtle 5s ease-in-out infinite;
    }
  `]
})
export class HeroComponent {}
