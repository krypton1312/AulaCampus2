import { Component } from '@angular/core';
import {NgForOf} from '@angular/common';

interface Skill {
  name: string;
  level: number; // %
  category: string;
}

@Component({
  selector: 'app-skills-component',
  imports: [
    NgForOf
  ],
  templateUrl: './skills-component.html',
  styleUrl: './skills-component.css',
})
export class SkillsComponent {
  skills: Skill[] = [
    // Языки программирования
    { name: 'C++', level: 50, category: 'Lenguajes de programación' },
    { name: 'C#', level: 60, category: 'Lenguajes de programación' },
    { name: 'Java', level: 90, category: 'Lenguajes de programación' },
    { name: 'Kotlin', level: 70, category: 'Lenguajes de programación' },
    { name: 'Python', level: 55, category: 'Lenguajes de programación' },

    // Фреймворки
    { name: 'Angular', level: 60, category: 'Frameworks' },
    { name: 'Spring Boot', level: 85, category: 'Frameworks' },
    { name: 'Hibernate', level: 80, category: 'Frameworks' },

    // Базы данных
    { name: 'SQL / MySQL', level: 90, category: 'Bases de datos' },
    { name: 'PostgreSQL', level: 90, category: 'Bases de datos' },
    { name: 'MongoDB', level: 70, category: 'Bases de datos' },

    // Инструменты
    { name: 'Git / GitHub', level: 90, category: 'Herramientas' },
    { name: 'Microsoft 365', level: 80, category: 'Herramientas' },

    // Soft skills
    { name: 'Resolución de problemas', level: 90, category: 'Soft skills' },
    { name: 'Trabajo en equipo ágil', level: 80, category: 'Soft skills' },
    { name: 'Responsable', level: 90, category: 'Soft skills' },
    { name: 'Resistente al estrés', level: 100, category: 'Soft skills' },
  ];
}
