import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-comparison',
  standalone: true,
  imports: [CommonModule],
  template: `
    <section class="py-20 bg-slate-50">
      <div class="container">
        <div class="grid md:grid-cols-2 gap-8 items-stretch">
          <!-- The Old Way -->
          <div class="bg-white p-8 md:p-12 rounded-[2rem] border border-slate-100 shadow-sm relative overflow-hidden group">
            <div class="absolute top-0 right-0 p-4 opacity-5 group-hover:opacity-10 transition-opacity">
               <svg xmlns="http://www.w3.org/2000/svg" width="120" height="120" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="text-slate-900"><circle cx="12" cy="12" r="10"/><line x1="15" y1="9" x2="9" y2="15"/><line x1="9" y1="9" x2="15" y2="15"/></svg>
            </div>
            <h3 class="text-2xl font-bold text-slate-400 mb-8 uppercase tracking-widest">The Old Way</h3>
            <ul class="space-y-6">
              <li class="flex gap-4 text-slate-500">
                <span class="flex-shrink-0 w-6 h-6 rounded-full bg-red-50 flex items-center justify-center text-red-400 font-bold text-xs">✕</span>
                <p>Handwritten tickets get lost or missed in the kitchen chaos.</p>
              </li>
              <li class="flex gap-4 text-slate-500">
                <span class="flex-shrink-0 w-6 h-6 rounded-full bg-red-50 flex items-center justify-center text-red-400 font-bold text-xs">✕</span>
                <p>Inventory errors lead to 86'd items during peak hours.</p>
              </li>
              <li class="flex gap-4 text-slate-500">
                <span class="flex-shrink-0 w-6 h-6 rounded-full bg-red-50 flex items-center justify-center text-red-400 font-bold text-xs">✕</span>
                <p>Split payments take forever, frustrating waiting guests.</p>
              </li>
            </ul>
            <div class="mt-12 h-12 w-full bg-slate-50 rounded-lg animate-pulse"></div>
          </div>

          <!-- The Orderly Way -->
          <div class="bg-brand/5 p-8 md:p-12 rounded-[2rem] border border-brand/20 shadow-xl relative overflow-hidden group">
            <div class="absolute top-0 right-0 p-4 opacity-10 group-hover:opacity-20 transition-opacity">
               <svg xmlns="http://www.w3.org/2000/svg" width="120" height="120" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="text-brand"><path d="M22 11.08V12a10 10 0 1 1-5.93-9.14"/><polyline points="22 4 12 14.01 9 11.01"/></svg>
            </div>
            <h3 class="text-2xl font-bold text-brand mb-8 uppercase tracking-widest">The Orderly Way</h3>
            <ul class="space-y-6">
              <li class="flex gap-4 text-slate-900 font-medium">
                <span class="flex-shrink-0 w-6 h-6 rounded-full bg-brand flex items-center justify-center text-white">✓</span>
                <p>Digital KDS ensures 100% order accuracy instantly.</p>
              </li>
              <li class="flex gap-4 text-slate-900 font-medium">
                <span class="flex-shrink-0 w-6 h-6 rounded-full bg-brand flex items-center justify-center text-white">✓</span>
                <p>Real-time inventory sync prevents awkward "sold out" moments.</p>
              </li>
              <li class="flex gap-4 text-slate-900 font-medium">
                <span class="flex-shrink-0 w-6 h-6 rounded-full bg-brand flex items-center justify-center text-white">✓</span>
                <p>One-tap split bills and pay-at-table functionality.</p>
              </li>
            </ul>
            <div class="mt-12 p-4 bg-white rounded-xl shadow-sm border border-brand/10 flex items-center gap-4">
               <div class="w-10 h-10 rounded-full bg-brand/20 flex items-center justify-center text-brand font-bold text-xs">AI</div>
               <div>
                  <p class="text-xs font-bold text-brand uppercase">AI Prediction</p>
                  <p class="text-sm font-semibold text-slate-900">Tomorrow's Prep List Generated</p>
               </div>
            </div>
          </div>
        </div>
      </div>
    </section>
  `
})
export class ComparisonComponent {}
