package act9;

public class Act9 {
    public static void main(String[] args) {
        Mueble mueble = new Mueble("COD1", "latex", 1500);
        Mesa mesa = new Mesa("50cm", "150cm", "COD2", "wood", 100);
        Silla silla = new Silla(4, "tela", true, "COD3", "metal", 200);
                
        System.out.println(mueble);
        System.out.println();
        System.out.println(mesa);
        System.out.println();
        System.out.println(silla);
        System.out.println();
        
    }
}
