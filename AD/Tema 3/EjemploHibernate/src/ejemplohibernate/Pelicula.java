package ejemplohibernate;

import jakarta.persistence.*;

@Entity
@Table(name = "peliculas")
public class Pelicula {

    @Id
    private int codPelicula;
    private String titulo;
    private String tema;
    private int duracion;
    private double precio;

    public Pelicula() {
    }

    public Pelicula(int codPelicula, String titulo, String tema, int duracion, double precio) {
        this.codPelicula = codPelicula;
        this.titulo = titulo;
        this.tema = tema;
        this.duracion = duracion;
        this.precio = precio;
    }

    public int getCodPelicula() {
        return codPelicula;
    }

    public void setCodPelicula(int codPelicula) {
        this.codPelicula = codPelicula;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Pelicula{" + "codPelicula=" + codPelicula + ", titulo=" + titulo + ", tema=" + tema + ", duracion=" + duracion + ", precio=" + precio + '}';
    }

}
