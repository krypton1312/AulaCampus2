package act10;

import java.util.ArrayList;
import java.util.Scanner;

public class Act10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Alumno> cola = new ArrayList<>();
        
        insertar(sc, cola);
        insertar(sc, cola);
        System.out.println("==================================");
        listar(cola);
        System.out.println("==================================");
        eliminarAtendido(cola);
        listar(cola);
    }
    
    public static void insertar(Scanner sc, ArrayList<Alumno> cola){
        System.out.println("DNI: ");
        String dni = sc.nextLine();
        System.out.println("Nombre: ");
        String nombre = sc.nextLine();
        System.out.println("Apellidos: ");
        String apellidos = sc.nextLine();
        System.out.println("Curso: ");
        String curso = sc.nextLine();
        cola.add(new Alumno(dni, nombre, apellidos, curso));
    }
    
    public static void listar(ArrayList<Alumno> cola){
        for (Alumno alumno : cola) {
            System.out.println(alumno);
        }
    }
    
    public static void eliminarAtendido(ArrayList<Alumno> cola){
        cola.remove(0);
    }
}
