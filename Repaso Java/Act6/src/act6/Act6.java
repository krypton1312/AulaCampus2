package act6;

import java.util.Scanner;

public class Act6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        double top_factura = 0;
        double factura = -1;
        int i = 1;
        
        while(factura!=0){
            System.out.print("Factura "+ i +": ");
            factura = sc.nextDouble();
            if(factura == 0){
                break;
            }
            if(top_factura < factura){
                top_factura = factura;
            }
            i++;
        }
        
        System.out.println("El mayor importe de las facturas introducido es: " + top_factura);
    }
}
