package practica4;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vehiculo {
    private String matricula;
    private String marca;
    private String modelo;
    private double precio;
}
