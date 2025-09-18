package jsonobjecto;

public class Libro {
    private String titulo;
    private int numPaginas;

    public Libro(String titulo, int numPaginas) {
        this.titulo = titulo;
        this.numPaginas = numPaginas;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getNumPaginas() {
        return numPaginas;
    }

    public void setNumPaginas(int numPaginas) {
        this.numPaginas = numPaginas;
    }

    @Override
    public String toString() {
        return "Libro{" + "titulo=" + titulo + ", numPaginas=" + numPaginas + '}';
    }
    
    
}
