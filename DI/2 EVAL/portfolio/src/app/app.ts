import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {AboutMeComponent} from './components/about-me-component/about-me-component';
import {SkillsComponent} from './components/skills-component/skills-component';
import {ProjectsComponent} from './components/projects-component/projects-component';
import {ContactsComponent} from './components/contacts-component/contacts-component';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, AboutMeComponent, SkillsComponent, ProjectsComponent, ContactsComponent],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('portfolio');
}
