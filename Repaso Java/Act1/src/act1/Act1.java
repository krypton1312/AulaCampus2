package act1;

import java.util.Scanner;

public class Act1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nombre: ");
        String nombre = sc.nextLine();
        
        System.out.print("Sueldo: ");
        double sueldo = sc.nextDouble();
        sc.nextLine();
        
        System.out.print("Categoria laboral(1-4): ");
        int catlab = sc.nextInt();
        sc.nextLine();
        
        System.out.print("Poblacion: ");
        String poblacion = sc.nextLine();
        
        if(poblacion.equals("Valencia")){
            sueldo = sueldo + sueldo*0.2;
        }
        
        System.out.println("El empleado " + nombre + 
                " con categoria laboral " + catlab + " de " + poblacion + " cobra " + sueldo + " euros");
    }
}
