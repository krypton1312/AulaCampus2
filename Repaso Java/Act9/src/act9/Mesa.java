package act9;

public class Mesa extends Mueble{
    private String ancho;
    private String Largo;

    public Mesa(String ancho, String Largo, String codigo, String material, double precio) {
        super(codigo, material, precio);
        this.ancho = ancho;
        this.Largo = Largo;
    }

    public String getAncho() {
        return ancho;
    }

    public void setAncho(String ancho) {
        this.ancho = ancho;
    }

    public String getLargo() {
        return Largo;
    }

    public void setLargo(String Largo) {
        this.Largo = Largo;
    }

    @Override
    public String toString() {
        return super.toString()+"\nMesa{" + "ancho=" + ancho + ", Largo=" + Largo + '}';
    } 

}
