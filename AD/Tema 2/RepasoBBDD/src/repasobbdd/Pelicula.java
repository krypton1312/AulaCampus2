package repasobbdd;

public class Pelicula {
    private int codelicula;
    private String titulo;
    private String tema;
    private int duracion;
    private double precio;

    public Pelicula(int codelicula, String titulo, String tema, int duracion, double precio) {
        this.codelicula = codelicula;
        this.titulo = titulo;
        this.tema = tema;
        this.duracion = duracion;
        this.precio = precio;
    }

    public Pelicula() {
    }

    public int getCodelicula() {
        return codelicula;
    }

    public void setCodelicula(int codelicula) {
        this.codelicula = codelicula;
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
        return "Pelicula{" + "codelicula=" + codelicula + ", titulo=" + titulo + ", tema=" + tema + ", duracion=" + duracion + ", precio=" + precio + '}';
    }
}
