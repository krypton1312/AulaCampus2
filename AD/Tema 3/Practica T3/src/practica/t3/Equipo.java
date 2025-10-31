package practica.t3;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="equipos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Equipo {
    @Id
    private int IdEquipo;
    private String marca;
    private String modelo;
    private String descripcion;
    private int pulgadasPantalla;
    private int capacidadDisco;
    private int gbMemoria;
    private double precio;
}
