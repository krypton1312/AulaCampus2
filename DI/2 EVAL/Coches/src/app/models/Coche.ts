export interface Coche {
  id: number;
  marca: string;
  modelo: string;
  tipo: 'SUV' | 'Sedán' | 'Deportivo' | 'Eléctrico' | 'Híbrido';
  precio: number;
  stock: number;
  km: number;
  anio: number;
  destacado: boolean;
  descripcion: string;
  extras: string[];
  imagen: string;
  combustible: 'Gasolina' | 'Diésel' | 'Eléctrico' | 'Híbrido';
  transmision: 'Manual' | 'Automática';
  potenciaCV: number;
  rating: number; // 1..5
}
