import { Component, signal } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import {Coche} from './models/Coche';
import {ListaCoches} from './components/lista-coches/lista-coches';
import {Header} from './components/header/header';
import {Filtro} from './components/filtro/filtro';
import {DetalleCoche} from './components/detalle-coche/detalle-coche';
import {FormsModule} from '@angular/forms';

@Component({
  selector: 'app-root',
  imports: [RouterOutlet, ListaCoches, Header, Filtro, DetalleCoche, FormsModule],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected readonly title = signal('Coches');

  titulo = 'Catálogo de Coches';

  textoBusqueda = '';
  tipoSeleccionado: string = 'Todos';
  soloConStock = false;

  orden = 'destacados';
  pagina = 1;
  porPagina = 9;

  seleccionado: Coche | null = null;

  private cochesRaw = [
    {
      marca: 'Toyota', modelo: 'Corolla', tipo: 'Sedán', imagen: 'corrola.png',
      precio: 21900, stock: 3, km: 0, anio: 2025, destacado: true,
      descripcion: 'Sedán fiable y eficiente para ciudad y carretera.',
      extras: ['Climatizador', 'Cámara trasera', 'Bluetooth'],
      combustible: 'Gasolina', transmision: 'Automática', potenciaCV: 140, rating: 4.6
    },
    {
      marca: 'Tesla', modelo: 'Model 3', tipo: 'Eléctrico', imagen: 'teslamodel3.jpg',
      precio: 39990, stock: 0, km: 12000, anio: 2023, destacado: true,
      descripcion: 'Eléctrico con gran aceleración y tecnología.',
      extras: ['Autopilot', 'Pantalla 15"', 'Carga rápida'],
      combustible: 'Eléctrico', transmision: 'Automática', potenciaCV: 283, rating: 4.7
    },
    {
      marca: 'SEAT', modelo: 'Ateca', tipo: 'SUV', imagen: 'seatotaca.jpg',
      precio: 28900, stock: 5, km: 4500, anio: 2024, destacado: false,
      descripcion: 'SUV compacto muy cómodo y práctico.',
      extras: ['Sensores parking', 'Apple CarPlay', 'Control crucero'],
      combustible: 'Diésel', transmision: 'Manual', potenciaCV: 150, rating: 4.3
    },
    {
      marca: 'BMW', modelo: 'M4', tipo: 'Deportivo', imagen: 'bmw4.jpg',
      precio: 88900, stock: 1, km: 8000, anio: 2022, destacado: false,
      descripcion: 'Deportivo premium con altas prestaciones.',
      extras: ['Asientos sport', 'Modo track', 'Suspensión adaptativa'],
      combustible: 'Gasolina', transmision: 'Automática', potenciaCV: 510, rating: 4.8
    },
    {
      marca: 'Hyundai', modelo: 'Tucson', tipo: 'Híbrido',
      precio: 33400, stock: 6, km: 0, anio: 2025, destacado: false,
      descripcion: 'Híbrido equilibrado con buen consumo.',
      extras: ['Asistente carril', 'Cámara 360', 'Keyless'],
      combustible: 'Híbrido', transmision: 'Automática', potenciaCV: 230, rating: 4.4
    },
    {
      marca: 'Volkswagen', modelo: 'Golf', tipo: 'Sedán',
      precio: 25900, stock: 4, km: 2000, anio: 2024, destacado: false,
      descripcion: 'Compacto versátil con buen equilibrio general.',
      extras: ['Android Auto', 'Freno automático', 'Faros LED'],
      combustible: 'Gasolina', transmision: 'Manual', potenciaCV: 150, rating: 4.4
    },
    {
      marca: 'Audi', modelo: 'A3', tipo: 'Sedán',
      precio: 32900, stock: 2, km: 6000, anio: 2023, destacado: true,
      descripcion: 'Premium compacto con interior moderno.',
      extras: ['Virtual cockpit', 'Sensores parking', 'Cargador inalámbrico'],
      combustible: 'Gasolina', transmision: 'Automática', potenciaCV: 150, rating: 4.6
    },
    {
      marca: 'Mercedes-Benz', modelo: 'Clase A', tipo: 'Sedán',
      precio: 34900, stock: 1, km: 9000, anio: 2023, destacado: false,
      descripcion: 'Compacto premium con buen confort y tecnología.',
      extras: ['MBUX', 'Cámara trasera', 'Control crucero'],
      combustible: 'Gasolina', transmision: 'Automática', potenciaCV: 163, rating: 4.5
    },
    {
      marca: 'Skoda', modelo: 'Octavia', tipo: 'Sedán',
      precio: 27900, stock: 6, km: 3500, anio: 2024, destacado: false,
      descripcion: 'Gran maletero y espacio interior excelente.',
      extras: ['Asistente carril', 'Apple CarPlay', 'Climatizador'],
      combustible: 'Diésel', transmision: 'Manual', potenciaCV: 150, rating: 4.4
    },
    {
      marca: 'Kia', modelo: 'Sportage', tipo: 'SUV',
      precio: 31900, stock: 5, km: 0, anio: 2025, destacado: true,
      descripcion: 'SUV moderno con buena garantía y equipamiento.',
      extras: ['Cámara 360', 'Keyless', 'Faros LED'],
      combustible: 'Híbrido', transmision: 'Automática', potenciaCV: 230, rating: 4.6
    },
    {
      marca: 'Nissan', modelo: 'Qashqai', tipo: 'SUV',
      precio: 29900, stock: 3, km: 5000, anio: 2024, destacado: false,
      descripcion: 'SUV compacto ideal para uso diario.',
      extras: ['Control crucero', 'Sensores parking', 'Android Auto'],
      combustible: 'Gasolina', transmision: 'Manual', potenciaCV: 140, rating: 4.3
    },
    {
      marca: 'Peugeot', modelo: '3008', tipo: 'SUV',
      precio: 33900, stock: 2, km: 12000, anio: 2023, destacado: false,
      descripcion: 'Diseño atractivo y buena calidad interior.',
      extras: ['i-Cockpit', 'Cámara trasera', 'Faros LED'],
      combustible: 'Diésel', transmision: 'Automática', potenciaCV: 130, rating: 4.4
    },
    {
      marca: 'Renault', modelo: 'Austral', tipo: 'SUV',
      precio: 32900, stock: 4, km: 3000, anio: 2024, destacado: false,
      descripcion: 'SUV eficiente con enfoque en confort.',
      extras: ['Cámara 360', 'Asistente carril', 'Keyless'],
      combustible: 'Híbrido', transmision: 'Automática', potenciaCV: 200, rating: 4.3
    },
    {
      marca: 'Ford', modelo: 'Kuga', tipo: 'SUV',
      precio: 31500, stock: 3, km: 7000, anio: 2024, destacado: false,
      descripcion: 'SUV equilibrado con buen comportamiento.',
      extras: ['CarPlay', 'Control crucero', 'Cámara trasera'],
      combustible: 'Híbrido', transmision: 'Automática', potenciaCV: 190, rating: 4.3
    },
    {
      marca: 'Mazda', modelo: 'CX-5', tipo: 'SUV',
      precio: 34900, stock: 2, km: 9000, anio: 2023, destacado: false,
      descripcion: 'Conducción agradable y acabados muy cuidados.',
      extras: ['Head-up display', 'Faros LED', 'Cámara trasera'],
      combustible: 'Gasolina', transmision: 'Automática', potenciaCV: 165, rating: 4.5
    },
    {
      marca: 'Honda', modelo: 'Civic', tipo: 'Híbrido',
      precio: 30900, stock: 5, km: 1500, anio: 2025, destacado: true,
      descripcion: 'Híbrido eficiente con gran fiabilidad.',
      extras: ['Asistente carril', 'CarPlay', 'Cargador inalámbrico'],
      combustible: 'Híbrido', transmision: 'Automática', potenciaCV: 184, rating: 4.6
    },
    {
      marca: 'Opel', modelo: 'Astra', tipo: 'Sedán',
      precio: 24900, stock: 4, km: 4000, anio: 2024, destacado: false,
      descripcion: 'Compacto práctico con buen equipamiento.',
      extras: ['Sensores parking', 'Climatizador', 'Android Auto'],
      combustible: 'Gasolina', transmision: 'Manual', potenciaCV: 130, rating: 4.2
    },
    {
      marca: 'Citroën', modelo: 'C5 Aircross', tipo: 'SUV',
      precio: 32900, stock: 2, km: 11000, anio: 2023, destacado: false,
      descripcion: 'SUV muy cómodo con suspensión pensada para confort.',
      extras: ['Asientos confort', 'Cámara trasera', 'Control crucero'],
      combustible: 'Diésel', transmision: 'Automática', potenciaCV: 130, rating: 4.3
    },
    {
      marca: 'Volvo', modelo: 'XC40', tipo: 'SUV',
      precio: 40900, stock: 1, km: 8000, anio: 2023, destacado: true,
      descripcion: 'SUV premium con alta seguridad.',
      extras: ['Pilot Assist', 'Cámara 360', 'Faros LED'],
      combustible: 'Híbrido', transmision: 'Automática', potenciaCV: 197, rating: 4.7
    },
    {
      marca: 'Polestar', modelo: '2', tipo: 'Eléctrico',
      precio: 45900, stock: 2, km: 5000, anio: 2024, destacado: false,
      descripcion: 'Eléctrico con enfoque premium y diseño nórdico.',
      extras: ['Google built-in', 'Carga rápida', 'Cámara trasera'],
      combustible: 'Eléctrico', transmision: 'Automática', potenciaCV: 231, rating: 4.5
    },
    {
      marca: 'Cupra', modelo: 'Formentor', tipo: 'Deportivo',
      precio: 38900, stock: 3, km: 6000, anio: 2024, destacado: true,
      descripcion: 'Crossover deportivo con carácter y diseño.',
      extras: ['Modo Sport', 'Asientos bucket', 'CarPlay'],
      combustible: 'Gasolina', transmision: 'Automática', potenciaCV: 245, rating: 4.6
    },
    {
      marca: 'Porsche', modelo: '911 Carrera', tipo: 'Deportivo',
      precio: 139900, stock: 1, km: 4000, anio: 2023, destacado: true,
      descripcion: 'Icono deportivo con prestaciones sobresalientes.',
      extras: ['Launch Control', 'Asientos sport', 'Suspensión adaptativa'],
      combustible: 'Gasolina', transmision: 'Automática', potenciaCV: 385, rating: 4.9
    },
    {
      marca: 'Ferrari', modelo: 'Roma', tipo: 'Deportivo',
      precio: 219900, stock: 0, km: 3000, anio: 2022, destacado: true,
      descripcion: 'Gran turismo con lujo y potencia.',
      extras: ['Modo Race', 'Asientos cuero', 'Suspensión adaptativa'],
      combustible: 'Gasolina', transmision: 'Automática', potenciaCV: 620, rating: 4.9
    },
    {
      marca: 'Lamborghini', modelo: 'Huracán', tipo: 'Deportivo',
      precio: 259900, stock: 1, km: 2500, anio: 2022, destacado: true,
      descripcion: 'Superdeportivo con sonido y rendimiento extremo.',
      extras: ['Modo Corsa', 'Frenos cerámicos', 'Aerodinámica activa'],
      combustible: 'Gasolina', transmision: 'Automática', potenciaCV: 640, rating: 4.9
    },
    {
      marca: 'Dacia', modelo: 'Duster', tipo: 'SUV',
      precio: 19900, stock: 7, km: 0, anio: 2025, destacado: false,
      descripcion: 'SUV económico y práctico.',
      extras: ['CarPlay', 'Aire acondicionado', 'Sensores parking'],
      combustible: 'Gasolina', transmision: 'Manual', potenciaCV: 130, rating: 4.1
    },
    {
      marca: 'Fiat', modelo: '500e', tipo: 'Eléctrico',
      precio: 27900, stock: 4, km: 1000, anio: 2024, destacado: false,
      descripcion: 'Eléctrico urbano ideal para ciudad.',
      extras: ['Carga rápida', 'Cámara trasera', 'Keyless'],
      combustible: 'Eléctrico', transmision: 'Automática', potenciaCV: 118, rating: 4.2
    },
    {
      marca: 'Mini', modelo: 'Cooper', tipo: 'Deportivo',
      precio: 29900, stock: 2, km: 7000, anio: 2023, destacado: false,
      descripcion: 'Compacto con estilo y conducción divertida.',
      extras: ['Faros LED', 'Modo Sport', 'CarPlay'],
      combustible: 'Gasolina', transmision: 'Automática', potenciaCV: 136, rating: 4.4
    },
    {
      marca: 'Jaguar', modelo: 'I-PACE', tipo: 'Eléctrico',
      precio: 69900, stock: 1, km: 9000, anio: 2023, destacado: false,
      descripcion: 'SUV eléctrico premium con gran potencia.',
      extras: ['Carga rápida', 'Cámara 360', 'Asistente carril'],
      combustible: 'Eléctrico', transmision: 'Automática', potenciaCV: 400, rating: 4.6
    },
    {
      marca: 'Land Rover', modelo: 'Range Rover Evoque', tipo: 'SUV',
      precio: 54900, stock: 1, km: 12000, anio: 2023, destacado: false,
      descripcion: 'SUV premium con diseño icónico.',
      extras: ['Cámara 360', 'Asientos cuero', 'Faros LED'],
      combustible: 'Diésel', transmision: 'Automática', potenciaCV: 200, rating: 4.5
    },
    {
      marca: 'Subaru', modelo: 'Forester', tipo: 'SUV',
      precio: 36900, stock: 2, km: 6000, anio: 2024, destacado: false,
      descripcion: 'Tracción total y enfoque en seguridad.',
      extras: ['EyeSight', 'Control crucero', 'CarPlay'],
      combustible: 'Híbrido', transmision: 'Automática', potenciaCV: 150, rating: 4.4
    },
    {
      marca: 'Mitsubishi', modelo: 'Outlander', tipo: 'Híbrido',
      precio: 41900, stock: 3, km: 4000, anio: 2024, destacado: false,
      descripcion: 'Híbrido enchufable con gran versatilidad.',
      extras: ['Cámara 360', 'Keyless', 'Asistente carril'],
      combustible: 'Híbrido', transmision: 'Automática', potenciaCV: 224, rating: 4.4
    },
    {
      marca: 'BYD', modelo: 'Atto 3', tipo: 'Eléctrico',
      precio: 36900, stock: 5, km: 1500, anio: 2025, destacado: true,
      descripcion: 'Eléctrico competitivo con gran equipamiento.',
      extras: ['Carga rápida', 'Pantalla rotatoria', 'Cámara trasera'],
      combustible: 'Eléctrico', transmision: 'Automática', potenciaCV: 204, rating: 4.5
    },
    {
      marca: 'MG', modelo: 'ZS EV', tipo: 'Eléctrico',
      precio: 31900, stock: 6, km: 2000, anio: 2024, destacado: false,
      descripcion: 'SUV eléctrico asequible para uso diario.',
      extras: ['Carga rápida', 'CarPlay', 'Control crucero'],
      combustible: 'Eléctrico', transmision: 'Automática', potenciaCV: 177, rating: 4.2
    },
    {
      marca: 'Alfa Romeo', modelo: 'Giulia', tipo: 'Sedán',
      precio: 45900, stock: 2, km: 9000, anio: 2023, destacado: false,
      descripcion: 'Sedán deportivo con diseño italiano.',
      extras: ['Modo Dynamic', 'Asientos sport', 'Faros LED'],
      combustible: 'Gasolina', transmision: 'Automática', potenciaCV: 280, rating: 4.6
    },
  ];


  coches: Coche[] = this.cocherizar(this.cochesRaw);
  private cocherizar(list: any[]): Coche[] {
    return list.map((c, idx) => ({
      id: idx + 1,
      imagen: `https://picsum.photos/seed/coche-${idx + 1}/900/600`,
      ...c,
    })) as Coche[];
  }

  seleccionarCoche(c: Coche) { this.seleccionado = c; }
  limpiarSeleccion() { this.seleccionado = null; }

  marcaSeleccionada = 'Todas';
  precioMinSel = 10000;
  precioMaxSel = 85000;

  aplicarFiltros(payload: {
    texto: string; tipo: string; soloStock: boolean; orden: string;
    marca: string; precioMin: number; precioMax: number;
  }) {
    this.textoBusqueda = payload.texto;
    this.tipoSeleccionado = payload.tipo;
    this.soloConStock = payload.soloStock;
    this.orden = payload.orden;

    this.marcaSeleccionada = payload.marca;
    this.precioMinSel = payload.precioMin;
    this.precioMaxSel = payload.precioMax;

    this.pagina = 1;
  }


  get cochesFiltrados(): Coche[] {
    const filtrados = this.coches.filter(c => {
      const coincideTexto =
        (c.marca + ' ' + c.modelo).toLowerCase().includes(this.textoBusqueda.toLowerCase());

      const coincideTipo = this.tipoSeleccionado === 'Todos' || c.tipo === this.tipoSeleccionado;
      const coincideStock = !this.soloConStock || c.stock > 0;
      const coincideMarca = this.marcaSeleccionada === 'Todas' || c.marca === this.marcaSeleccionada;
      const coincidePrecio = c.precio >= this.precioMinSel && c.precio <= this.precioMaxSel;

      return coincideTexto && coincideTipo && coincideStock && coincideMarca && coincidePrecio;
    });

    const ordenados = [...filtrados].sort((a, b) => {
      switch (this.orden) {
        case 'precioAsc': return a.precio - b.precio;
        case 'precioDesc': return b.precio - a.precio;
        case 'anioDesc': return b.anio - a.anio;
        case 'kmAsc': return a.km - b.km;
        default:
          return (b.destacado ? 1 : 0) - (a.destacado ? 1 : 0) || (b.rating - a.rating);
      }
    });

    return ordenados;
  }

  get totalPaginas(): number {
    return Math.max(1, Math.ceil(this.cochesFiltrados.length / this.porPagina));
  }

  get cochesPagina(): Coche[] {
    const start = (this.pagina - 1) * this.porPagina;
    return this.cochesFiltrados.slice(start, start + this.porPagina);
  }

  prevPage(){ this.pagina = Math.max(1, this.pagina - 1); }
  nextPage(){ this.pagina = Math.min(this.totalPaginas, this.pagina + 1); }
}
