package act8;

public class Mueble {
    private String codigo;
    private String material;
    private double precio;

    public Mueble(String codigo, String material, double precio) {
        this.codigo = codigo;
        this.material = material;
        this.precio = precio;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Mueble{" + "codigo=" + codigo + ", material=" + material + ", precio=" + precio + '}';
    }
    
    public double calculaIVA(){
        return this.precio*0.21;
    }
    
    public double calculaIVA(double iva){
        return this.precio*iva;
    }
}
