package act8.pkg14;

public class Libro {
    private String ISBN;
    private String titulo;
    private String autor;
    private String editorial;
    private String categoria;
    private String sinopsis;
    private int paginas;
    private String idioma;
    private int anyoPublicacion;
    private double precio;
    private boolean novedad;

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Libro(String ISBN, String titulo, String autor, String editorial, String categoria, String sinopsis, int paginas, String idioma, int anyoPublicacion, double precio, boolean novedad) {
        this.ISBN = ISBN;
        this.titulo = titulo;
        this.autor = autor;
        this.editorial = editorial;
        this.categoria = categoria;
        this.sinopsis = sinopsis;
        this.paginas = paginas;
        this.idioma = idioma;
        this.anyoPublicacion = anyoPublicacion;
        this.precio = precio;
        this.novedad = novedad;
    }

    public Libro() {
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEditoria() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public int getAnyoPublicacion() {
        return anyoPublicacion;
    }

    public void setAnyoPublicacion(int anyoPublicacion) {
        this.anyoPublicacion = anyoPublicacion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean isNovedad() {
        return novedad;
    }

    public void setNovedad(boolean novedad) {
        this.novedad = novedad;
    }

    @Override
    public String toString() {
        return "Libro{" + "ISBN=" + ISBN + ", titulo=" + titulo + ", editoria=" + editorial + ", categoria=" + categoria + ", sinopsis=" + sinopsis + ", paginas=" + paginas + ", idioma=" + idioma + ", anyoPublicacion=" + anyoPublicacion + ", precio=" + precio + ", novedad=" + novedad + '}';
    }
}
