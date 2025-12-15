import { Component, EventEmitter, Output } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-filtro',
  standalone: true,
  imports: [CommonModule, FormsModule], // ← ВАЖНО
  templateUrl: './filtro.html',
  styleUrls: ['./filtro.css'],
})
export class Filtro {
  @Output() cambioFiltros = new EventEmitter<{
    texto: string;
    tipo: string;
    soloStock: boolean;
    orden: string;
    marca: string;
    precioMin: number;
    precioMax: number;
  }>();

  texto = '';
  tipo: string = 'Todos';
  soloStock = false;

  orden = 'destacados';
  ordenes = [
    { value: 'destacados', label: 'Relevancia' },
    { value: 'precioAsc', label: 'Precio bajo' },
    { value: 'precioDesc', label: 'Precio alto' },
    { value: 'anioDesc', label: 'Nuevo' },
    { value: 'kmAsc', label: 'Menor km' },
  ];

  marca = 'Todas';
  marcas = [
    'Todas','Toyota','Tesla','SEAT','BMW','Hyundai','Volkswagen','Audi','Mercedes-Benz','Skoda','Kia','Nissan',
    'Peugeot','Renault','Ford','Mazda','Honda','Opel','Citroën','Volvo','Polestar','Cupra','Porsche','Ferrari',
    'Lamborghini','Dacia','Fiat','Mini','Jaguar','Land Rover','Subaru','Mitsubishi','BYD','MG','Alfa Romeo'
  ];

  // ===== PRICE SLIDER =====
  sliderMin = 5000;
  sliderMax = 120000;

  precioMin = 10000;
  precioMax = 85000;

  // проценты для “заливки” на треке
  get minPct(): number {
    return ((this.precioMin - this.sliderMin) / (this.sliderMax - this.sliderMin)) * 100;
  }
  get maxPct(): number {
    return ((this.precioMax - this.sliderMin) / (this.sliderMax - this.sliderMin)) * 100;
  }

  onMinRange(v: number) {
    this.precioMin = Math.min(v, this.precioMax - 500); // минимум зазор 500
    this.emitir();
  }

  onMaxRange(v: number) {
    this.precioMax = Math.max(v, this.precioMin + 500);
    this.emitir();
  }

  resetAll() {
    this.texto = '';
    this.tipo = 'Todos';
    this.soloStock = false;
    this.orden = 'destacados';
    this.marca = 'Todas';
    this.precioMin = 10000;
    this.precioMax = 85000;
    this.emitir();
  }

  emitir() {
    this.cambioFiltros.emit({
      texto: this.texto,
      tipo: this.tipo,
      soloStock: this.soloStock,
      orden: this.orden,
      marca: this.marca,
      precioMin: this.precioMin,
      precioMax: this.precioMax,
    });
  }
}
