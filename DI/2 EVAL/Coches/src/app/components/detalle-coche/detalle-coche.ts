import { Component, Input, Output, EventEmitter } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Coche } from '../../models/Coche';

@Component({
  selector: 'app-detalle-coche',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './detalle-coche.html',
  styleUrls: ['./detalle-coche.css'],
})
export class DetalleCoche {
  @Input() coche: Coche | null = null;
  @Output() cerrar = new EventEmitter<void>();

  cerrarPanel() {
    this.cerrar.emit();
  }
}
