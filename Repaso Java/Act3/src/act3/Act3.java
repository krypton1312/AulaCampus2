package act3;

import java.util.Scanner;

public class Act3 {
    public static void main(String[] args) {
        double bonus = 0;
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
            bonus+=sueldo*0.2;
        }else{
            bonus+=sueldo*0.1;
        }
        
        switch (catlab) {
            case 1:
                bonus+=sueldo*0.1;
                break;
            case 2:
                bonus+=sueldo*0.2;
                break;
            case 3:
                bonus+=sueldo*0.3;
                break;
            case 4:
                bonus+=sueldo*0.4;
                break;
            default:
                break;
        }
        
        System.out.println("El empleado " + nombre + 
                " con categoria laboral " + catlab + " de " + poblacion + " cobra " + (sueldo+bonus) + " euros");
    }
}
