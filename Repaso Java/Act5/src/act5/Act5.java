package act5;

import java.util.Scanner;

public class Act5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double factura;
        double lowest_factura = Double.MAX_VALUE;
        int i = 1;
        do{
            System.out.print("Factura "+ i +":");
            factura = sc.nextDouble();
            if(factura == 0){
                break;
            }
            if(lowest_factura > factura){
                lowest_factura = factura;
            }
            
            i++;
        }while(factura!=0);
        
        System.out.println("El menor importe de las facturas introducido es " + lowest_factura + " euros");
    }
}
