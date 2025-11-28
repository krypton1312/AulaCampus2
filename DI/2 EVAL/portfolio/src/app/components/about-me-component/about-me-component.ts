import { Component } from '@angular/core';
import {NgForOf, NgIf} from '@angular/common';

@Component({
  selector: 'app-about-me-component',
  imports: [
    NgIf,
    NgForOf,
  ],
  templateUrl: './about-me-component.html',
  styleUrls: ['./about-me-component.css'],
})
export class AboutMeComponent {
  name = 'Yehor Burlachenko';
  role = 'Programador · Estudiante de desarrollo de software';
  location = 'Catarroja, Valencia · nacido en Odesa, Ucrania';

  summary = `Soy un joven entusiasta y activo. Disfruto de trabajar tanto en equipo
como de manera independiente. Me apasiona estudiar, adquirir nuevos conocimientos
y combinar la formación en ingeniería de software, economía y gestión empresarial.`;

  // можно потом вынести в отдельный интерфейс, если захочешь
  highlights = [
    'Grado Superior DAM (Aula Campus, Valencia)',
    'Grado universitario de Economía y Gestión Empresarial (Humanitas, Sosnowiec)',
    'Grado medio + superior de Ingeniería de Software (Universidad KROK, Kyiv)',
    'Experiencia como camarero / barista y prácticas en AHORA Soluciones',
  ];

  tags = [
    'C++',
    'C#',
    'Java',
    'Kotlin',
    'Python',
    'Angular',
    'Spring Boot',
    'SQL / PostgreSQL',
  ];
  languages = [
    'Ruso — nativo',
    'Ucraniano — nativo',
    'Español — intermedio-avanzado',
    'Inglés — intermedio',
  ];

}
