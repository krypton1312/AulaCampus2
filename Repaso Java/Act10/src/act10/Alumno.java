package act10;

public class Alumno {
    private String DNI;
    private String nombre;
    private String apellidos;
    private String curso;

    public Alumno(String DNI, String nombre, String apellidos, String curso) {
        this.DNI = DNI;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.curso = curso;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    @Override
    public String toString() {
        return "Alumno{" + "DNI=" + DNI + ", nombre=" + nombre + ", apellidos=" + apellidos + ", curso=" + curso + '}';
    }
    
    
}
