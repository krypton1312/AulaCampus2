package act5;

import java.util.Scanner;

public class Act5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double factura;
        double factura_total = 0;
        int i = 1;
        do{
            System.out.print("Factura "+ i +":");
            factura = sc.nextDouble();
            factura_total+=factura;
            i++;
        }while(factura!=0);
        
        System.out.println("El total del las facturas es " + factura_total + " euros");
    }
}
