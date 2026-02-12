package actaddictt6;


import java.math.BigDecimal;


public class Peliculas {
    private static final long serialVersionUID = 1L;
    private Integer codpelicula;
    private String titulo;
    private String tema;
    private Integer duracion;
    private BigDecimal precio;

    public Peliculas(Integer codpelicula, String titulo, String tema, Integer duracion, BigDecimal precio) {
        this.codpelicula = codpelicula;
        this.titulo = titulo;
        this.tema = tema;
        this.duracion = duracion;
        this.precio = precio;
    }

    public Peliculas() {
    }

    public Integer getCodpelicula() {
        return codpelicula;
    }

    public void setCodpelicula(Integer codpelicula) {
        this.codpelicula = codpelicula;
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

    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Peliculas{" + "codpelicula=" + codpelicula + ", titulo=" + titulo + ", tema=" + tema + ", duracion=" + duracion + ", precio=" + precio + '}';
    }
    
    
}
