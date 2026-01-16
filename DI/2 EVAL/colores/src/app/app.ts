import { Component } from '@angular/core';
import {NgForOf} from '@angular/common';

type Theme = 'oriente' | 'occidente';

@Component({
  selector: 'app-root',
  templateUrl: './app.html',
  styleUrl: './app.css',
  imports: [
    NgForOf
  ]
})
export class App {
  theme: Theme = 'oriente';

  menu = ['Inicio', 'Productos', 'Seguridad', 'Opiniones', 'Contacto'];

  features = [
    {
      icon: '⚡',
      title: 'Potencia controlada',
      text: 'Diseñado para el máximo impacto visual con control total. Calibrado para espectáculos seguros.',
    },
    {
      icon: '⏱️',
      title: 'Encendido rápido',
      text: 'Mecha de alta visibilidad y reacción precisa para un uso fiable y consistente.',
    },
    {
      icon: '🛡️',
      title: 'Certificación y seguridad',
      text: 'Cumple normativa CE y controles de calidad. Materiales ignífugos y empaquetado reforzado.',
    },
  ];

  product = {
    badge: 'Edición Limitada',
    name: 'Petardo Trueno Dragón XL',
    reviews: '(128 opiniones)',
    desc: 'La joya de la corona para tus celebraciones. Un estallido que resuena con la fuerza de la tradición.',
    priceOld: '19.99€',
    price: '14.99€',
    bullets: [
      { icon: '⏳', label: 'Duración extendida', value: 'Mecha retardada de 8 segundos.' },
      { icon: '💥', label: 'Alta intensidad', value: 'Sonido seco y contundente.' },
      { icon: '✨', label: 'Tipo de chispa', value: 'Destello dorado previo a la detonación.' },
      { icon: '🔊', label: 'Nivel de ruido', value: 'Categoría F3 (Solo adultos).' },
    ],
  };

  safety = [
    'Nunca encender sujetando el petardo con la mano. Apóyalo en el suelo.',
    'Mantener una distancia de seguridad mínima de 15 metros tras el encendido.',
    'No encender cerca de materiales inflamables, bosques o vehículos.',
    'Si falla el encendido, no tocar ni intentar reencender. Esperar 30 min y mojar.',
    'Respetar siempre la edad mínima de uso indicada en el envase del producto.',
  ];

  reviews = [
    { name: 'Carlos M.', city: 'Alicante', stars: 5, text: 'Increíble calidad. Los usé para San Juan y fueron el centro de atención. El sonido es muy limpio.' },
    { name: 'Laura G.', city: 'Valencia', stars: 5, text: 'El envío fue rapidísimo y todo llegó muy bien embalado. Me da seguridad que cumplan la normativa.' },
    { name: 'Javier R.', city: 'Castellón', stars: 4, text: 'Muy buena relación calidad-precio. El pack “Dragón XL” es espectacular. Repetiré seguro.' },
  ];

  constructor() {
    document.body.setAttribute('data-theme', this.theme);
  }

  setTheme(t: Theme) {
    this.theme = t;
    document.body.setAttribute('data-theme', this.theme);
  }

  get heroImage(): string {
    return this.theme === 'occidente'
      ? 'occidente1.png'
      : 'oriente1.png';
  }

  get productImage(): string {
    return this.theme === 'occidente'
      ? 'occidente2.png'
      : 'oriente2.png';
  }


  trackByIndex = (i: number) => i;
}
