package act9;

public class Silla extends Mueble{
    private int numPatas;
    private String materialTapizado;
    private boolean respaldo;

    public Silla(int numPatas, String materialTapizado, boolean respaldo, String codigo, String material, double precio) {
        super(codigo, material, precio);
        this.numPatas = numPatas;
        this.materialTapizado = materialTapizado;
        this.respaldo = respaldo;
    }

    public int getNumPatas() {
        return numPatas;
    }

    public void setNumPatas(int numPatas) {
        this.numPatas = numPatas;
    }

    public String getMaterialTapizado() {
        return materialTapizado;
    }

    public void setMaterialTapizado(String materialTapizado) {
        this.materialTapizado = materialTapizado;
    }

    public boolean isRespaldo() {
        return respaldo;
    }

    public void setRespaldo(boolean respaldo) {
        this.respaldo = respaldo;
    }

    @Override
    public String toString() {
        return super.toString() + "\nSilla{" + "numPatas=" + numPatas + ", materialTapizado=" + materialTapizado + ", respaldo=" + respaldo + '}';
    }
}
