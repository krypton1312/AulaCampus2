package act16.pkg26t2;

public class Alquiler {
    private int idAlquiler;
    private String direccion;
    private String poblacion;
    private String codPostal;
    private double precioAlquiler;
    private String idContacto;
    private String telefono;

    public Alquiler(int idAlquiler, String direccion, String poblacion, String codPostal, double precioAlquiler, String idContacto, String telefono) {
        this.idAlquiler = idAlquiler;
        this.direccion = direccion;
        this.poblacion = poblacion;
        this.codPostal = codPostal;
        this.precioAlquiler = precioAlquiler;
        this.idContacto = idContacto;
        this.telefono = telefono;
    }

    public Alquiler() {
    }

    public int getIdAlquiler() {
        return idAlquiler;
    }

    public void setIdAlquiler(int idAlquiler) {
        this.idAlquiler = idAlquiler;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public String getCodPostal() {
        return codPostal;
    }

    public void setCodPostal(String codPostal) {
        this.codPostal = codPostal;
    }

    public double getPrecioAlquiler() {
        return precioAlquiler;
    }

    public void setPrecioAlquiler(double precioAlquiler) {
        this.precioAlquiler = precioAlquiler;
    }

    public String getIdContacto() {
        return idContacto;
    }

    public void setIdContacto(String idContacto) {
        this.idContacto = idContacto;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Alquiler{" + "idAlquiler=" + idAlquiler + ", direccion=" + direccion + ", poblacion=" + poblacion + ", codPostal=" + codPostal + ", precioAlquiler=" + precioAlquiler + ", idContacto=" + idContacto + ", telefono=" + telefono + '}';
    }
}
