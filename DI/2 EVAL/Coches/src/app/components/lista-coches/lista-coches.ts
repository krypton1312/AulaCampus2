import { Component, Input, Output, EventEmitter } from '@angular/core';
import { CommonModule } from '@angular/common';
import {Coche} from '../../models/Coche';

@Component({
  selector: 'app-lista-coches',
  standalone: true,
  imports: [CommonModule],   // ← ОБЯЗАТЕЛЬНО
  templateUrl: './lista-coches.html',
  styleUrls: ['./lista-coches.css'],
})
export class ListaCoches {
  @Input() coches: Coche[] = [];
  @Input() seleccionado: Coche | null = null;
  @Output() seleccionar = new EventEmitter<Coche>();

  elegir(c: Coche) {
    this.seleccionar.emit(c);
  }

  esSeleccionado(c: Coche) {
    return this.seleccionado?.id === c.id;
  }
}
