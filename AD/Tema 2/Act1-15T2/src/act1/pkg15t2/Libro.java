package act1.pkg15t2;

public class Libro {
    private String isbn;
    private String titulo;
    private String autor;
    private String editorial;
    private String categoria;
    private String sinopsis;
    private int paginas;
    private String idioma;
    private int anyoPublicacion;
    private double precio;
    private Boolean novedad;

    public Libro() {
    }

    public Libro(String isbn, String titulo, String autor, String editorial, String categoria, String sinopsis, int paginas, String idioma, int anyoPublicacion, double precio, Boolean novedad) {
        this.isbn = isbn;
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

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditorial() {
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

    public int getAnyopublicacion() {
        return anyoPublicacion;
    }

    public void setAnyopublicacion(int anyoPublicacion) {
        this.anyoPublicacion = anyoPublicacion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Boolean isNovedad() {
        return novedad;
    }

    public void setNovedad(Boolean novedad) {
        this.novedad = novedad;
    }

    @Override
    public String toString() {
        return "Libro{" + "isbn=" + isbn + ", titulo=" + titulo + ", autor=" + autor + ", editorial=" + editorial + ", categoria=" + categoria + ", sinopsis=" + sinopsis + ", paginas=" + paginas + ", idioma=" + idioma + ", anyopublicacion=" + anyoPublicacion + ", precio=" + precio + ", novedad=" + novedad + '}';
    }
}
