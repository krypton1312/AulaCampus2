package act29t1;

public class Empleado {
    private int idEmpleado;
    private String nombre;
    private String apellidos;
    private String dni;
    private String departamiento;
    private double sueldo;

    public Empleado() {
    }

    public Empleado(int idEmpleado, String nombre, String apellidos, String dni, String departamiento, double sueldo) {
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.departamiento = departamiento;
        this.sueldo = sueldo;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getDepartamiento() {
        return departamiento;
    }

    public void setDepartamiento(String departamiento) {
        this.departamiento = departamiento;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }
    
    
    @Override
    public String toString() {
        return "Empleado{" + "idEmpleado=" + idEmpleado + ", nombre=" + nombre + ", apellidos=" + apellidos + ", dni=" + dni + ", departamiento=" + departamiento + ", sueldo=" + sueldo + '}';
    }
    
    
}
