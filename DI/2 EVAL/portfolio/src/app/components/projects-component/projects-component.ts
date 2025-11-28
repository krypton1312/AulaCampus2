import { Component } from '@angular/core';
import {NgForOf, NgIf} from '@angular/common';

interface Project {
  title: string;
  description: string;
  tech: string[];
  link?: string;
  status: 'Proyecto académico' | 'Pet project' | 'En desarrollo';
}

@Component({
  selector: 'app-projects-component',
  imports: [
    NgForOf,
    NgIf
  ],
  templateUrl: './projects-component.html',
  styleUrl: './projects-component.css',
})
export class ProjectsComponent {
  projects: Project[] = [
    {
      title: 'Orderly',
      description:
        'Sistema TPV para hostelería desarrollado con JavaFX, Spring Boot y PostgreSQL, diseñado para automatizar pedidos y mejorar la eficiencia operativa.',
      tech: ['Java','JavaFX' , 'Kotlin' ,'Spring Boot', 'PostgreSQL'],
      status: 'Proyecto académico',
    },
    {
      title: 'Portfolio en Angular',
      description:
        'Aplicación de una sola página con varios componentes (about, skills, proyectos y contacto) diseñada como carta de presentación profesional.',
      tech: ['Angular', 'TypeScript', 'HTML/CSS'],
      status: 'Pet project',
    },
  ];
}
