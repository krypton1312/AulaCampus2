package act1t3;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="socios")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Socio {
    @Id
    private int codsocio;
    private String nombre;
    private String apellidos;
    private String direccion;
    private String telefono;
    private String poblacion;
}
