import { Component } from '@angular/core';

import { Header } from './components/header/header';
import { Menu } from './components/menu/menu';
import { Content } from './components/content/content';
import { Footer } from './components/footer/footer';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [
    Header,
    Menu,
    Content,
    Footer
  ],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {}
