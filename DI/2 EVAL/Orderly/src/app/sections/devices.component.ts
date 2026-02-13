import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-devices',
  standalone: true,
  imports: [CommonModule],
  template: `
    <section class="py-24 bg-slate-50 overflow-hidden">
      <div class="container">
        <div class="flex flex-col lg:flex-row items-center gap-16">
          <!-- Text Content -->
          <div class="lg:w-1/2">
            <h2 class="text-4xl md:text-5xl font-extrabold text-slate-900 mb-6 leading-tight">
              One system.<br>
              <span class="text-brand">Every device.</span>
            </h2>
            <p class="text-lg text-slate-600 mb-10 leading-relaxed">
              Whether it's a fixed terminal at the counter, a handheld for the patio, or a tablet in the kitchen, Orderly keeps everyone in sync.
            </p>

            <ul class="space-y-6">
              <li class="flex items-start gap-4">
                <div class="w-6 h-6 rounded-md bg-brand/10 flex items-center justify-center text-brand mt-1">
                   <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="3" stroke-linecap="round" stroke-linejoin="round"><polyline points="20 6 9 17 4 12"/></svg>
                </div>
                <div>
                   <p class="font-bold text-slate-900">POS Terminal</p>
                   <p class="text-slate-500">Robust fixed stations for peak efficiency.</p>
                </div>
              </li>
              <li class="flex items-start gap-4">
                <div class="w-6 h-6 rounded-md bg-brand/10 flex items-center justify-center text-brand mt-1">
                   <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="3" stroke-linecap="round" stroke-linejoin="round"><polyline points="20 6 9 17 4 12"/></svg>
                </div>
                <div>
                   <p class="font-bold text-slate-900">Tablets & iPads</p>
                   <p class="text-slate-500">Mobile ordering and interactive menus.</p>
                </div>
              </li>
              <li class="flex items-start gap-4">
                <div class="w-6 h-6 rounded-md bg-brand/10 flex items-center justify-center text-brand mt-1">
                   <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="3" stroke-linecap="round" stroke-linejoin="round"><polyline points="20 6 9 17 4 12"/></svg>
                </div>
                <div>
                   <p class="font-bold text-slate-900">Mobile Waiter App</p>
                   <p class="text-slate-500">Order at table on any smartphone.</p>
                </div>
              </li>
            </ul>
          </div>

          <!-- Mockup Visual -->
          <div class="lg:w-1/2 relative">
             <div class="relative z-10 p-8 bg-brand/10 rounded-[3rem]">
                <!-- Laptop Mockup -->
                <div class="relative bg-slate-900 rounded-xl border-4 border-slate-800 shadow-2xl overflow-hidden aspect-video">
                   <div class="absolute inset-0 bg-white m-1 rounded-sm flex flex-col">
                      <div class="h-6 bg-slate-100 flex items-center px-2 gap-1">
                         <div class="w-1.5 h-1.5 rounded-full bg-red-400"></div>
                         <div class="w-1.5 h-1.5 rounded-full bg-yellow-400"></div>
                         <div class="w-1.5 h-1.5 rounded-full bg-green-400"></div>
                      </div>
                      <div class="flex-1 p-4">
                         <div class="grid grid-cols-3 gap-3">
                            <div class="h-4 bg-slate-100 rounded"></div>
                            <div class="h-4 bg-slate-100 rounded"></div>
                            <div class="h-4 bg-slate-100 rounded"></div>
                         </div>
                         <div class="mt-4 flex gap-4">
                            <div class="w-1/4 h-32 bg-slate-50 rounded"></div>
                            <div class="w-3/4 h-32 bg-slate-50 rounded"></div>
                         </div>
                      </div>
                   </div>
                </div>

                <!-- Phone Mockup -->
                <div class="absolute -bottom-6 -right-4 w-32 h-64 bg-slate-900 rounded-[2rem] border-4 border-slate-800 shadow-2xl overflow-hidden hidden sm:block">
                   <div class="absolute top-0 left-1/2 -translate-x-1/2 w-12 h-4 bg-slate-800 rounded-b-xl z-20"></div>
                   <div class="absolute inset-0 bg-white m-1 rounded-[1.8rem] overflow-hidden p-3 flex flex-col gap-2">
                      <div class="h-4 bg-brand/20 rounded"></div>
                      <div class="h-10 bg-slate-50 rounded"></div>
                      <div class="h-10 bg-slate-50 rounded"></div>
                      <div class="h-10 bg-slate-50 rounded"></div>
                   </div>
                </div>
             </div>

             <!-- Decorative elements -->
             <div class="absolute -top-10 -right-10 w-40 h-40 bg-brand/20 rounded-full blur-3xl"></div>
             <div class="absolute -bottom-10 -left-10 w-40 h-40 bg-brand/10 rounded-full blur-3xl"></div>
          </div>
        </div>
      </div>
    </section>
  `
})
export class DevicesComponent {}
