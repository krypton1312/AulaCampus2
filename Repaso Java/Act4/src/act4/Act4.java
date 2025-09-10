package act4;

import java.util.Scanner;

public class Act4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double factura_total = 0;
        for (int i = 1; i<=10; i++) {
            System.out.print("Factura "+ i +":");
            factura_total+=sc.nextDouble();
        }
        System.out.println("El total del las facturas es " + factura_total + " euros");
    }
}
