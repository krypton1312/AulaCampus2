package practica1;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder={"nombre", "capital", "habitantes", "costero"})
public class Pais {
    private String nombre;
    private String capital;
    private int habitantes;
    private boolean costero;

    public Pais(String nombre, String capital, int habitantes, boolean costero) {
        this.nombre = nombre;
        this.capital = capital;
        this.habitantes = habitantes;
        this.costero = costero;
    }

    public Pais() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public int getHabitantes() {
        return habitantes;
    }

    public void setHabitantes(int habitantes) {
        this.habitantes = habitantes;
    }

    public boolean isCostero() {
        return costero;
    }

    public void setCostero(boolean costero) {
        this.costero = costero;
    }

    @Override
    public String toString() {
        return "Pais{" + "nombre=" + nombre + ", capital=" + capital + ", habitantes=" + habitantes + ", costero=" + costero + '}';
    }
}
