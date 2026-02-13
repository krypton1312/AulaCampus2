import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-navbar',
  standalone: true,
  imports: [CommonModule, RouterLink],
  template: `
    <nav class="sticky top-0 z-50 bg-white/80 backdrop-blur-md border-b border-slate-100">
      <div class="container h-16 flex items-center justify-between">
        <!-- Logo -->
        <a routerLink="/" class="flex items-center gap-2 group">
          <div class="w-8 h-8 bg-brand rounded-full flex items-center justify-center text-white font-bold group-hover:bg-brand-light transition-colors">
            <svg xmlns="http://www.w3.org/2000/svg" width="18" height="18" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="3" stroke-linecap="round" stroke-linejoin="round"><circle cx="12" cy="12" r="8"/></svg>
          </div>
          <span class="text-xl font-bold tracking-tight text-slate-900">Orderly</span>
        </a>

        <!-- Center Links -->
        <div class="hidden md:flex items-center gap-8">
          <a href="#features" class="text-sm font-medium text-slate-600 hover:text-brand transition-colors">Features</a>
          <a href="#features" class="text-sm font-medium text-slate-600 hover:text-brand transition-colors">Features</a>
          <a href="#benefits" class="text-sm font-medium text-slate-600 hover:text-brand transition-colors">Benefits</a>
          <a href="#vision" class="text-sm font-medium text-slate-600 hover:text-brand transition-colors">Vision</a>
        </div>

        <!-- Right Buttons -->
        <div class="flex items-center gap-6">
          <a href="#" class="text-sm font-semibold text-slate-700 hover:text-brand transition-colors">Log in</a>
          <button class="btn btn-primary !py-2 !px-5 text-sm">Request Demo</button>
        </div>
      </div>
    </nav>
  `
})
export class NavbarComponent {}
