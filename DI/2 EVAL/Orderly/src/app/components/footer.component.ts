import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-footer',
  standalone: true,
  imports: [CommonModule],
  template: `
    <footer class="py-12 border-t border-slate-100">
      <div class="container">
        <div class="flex flex-col md:flex-row justify-between items-center gap-8">
          <!-- Logo -->
          <div class="flex items-center gap-2">
            <div class="w-6 h-6 bg-brand rounded-full flex items-center justify-center text-white font-bold text-xs">
              <svg xmlns="http://www.w3.org/2000/svg" width="14" height="14" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="3" stroke-linecap="round" stroke-linejoin="round"><circle cx="12" cy="12" r="8"/></svg>
            </div>
            <span class="text-lg font-bold text-slate-900">Orderly</span>
          </div>

          <!-- Links -->
          <div class="flex flex-wrap justify-center gap-8">
            <a href="#" class="text-sm text-slate-500 hover:text-brand transition-colors">Privacy Policy</a>
            <a href="#" class="text-sm text-slate-500 hover:text-brand transition-colors">Terms of Service</a>
            <a href="#" class="text-sm text-slate-500 hover:text-brand transition-colors">Contact</a>
          </div>

          <!-- Copyright -->
          <p class="text-sm text-slate-400">
            &copy; 2026 Orderly. All rights reserved.
          </p>
        </div>
      </div>
    </footer>
  `
})
export class FooterComponent {}
