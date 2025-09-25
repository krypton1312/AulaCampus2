package ejemplo1;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import java.util.Scanner;

public class Ejemplo1 {

    public static void main(String[] args) {
        ObjectContainer con = Db4oEmbedded.openFile("empleados.db4o");
        Scanner sc = new Scanner(System.in);
        
        listar(con);
        System.out.println("");
        System.out.println("");
        listarPorId(55, con);
        
        con.close();
    }

    public static void insertar(Scanner sc, ObjectContainer con) {
        System.out.print("Id: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Apellidos: ");
        String apellidos = sc.nextLine();

        System.out.print("Sueldo: ");
        double sueldo = sc.nextDouble();
        sc.nextLine();

        con.store(new Empleado(id, nombre, apellidos, sueldo));
    }

    public static void listar(ObjectContainer con) {
        ObjectSet<Empleado> result = con.queryByExample(new Empleado(0, null, null, 0));

        while (result.hasNext()) {
            Empleado e = result.next();
            System.out.println(e);
        }
    }
    
    public static void listarPorId(int id, ObjectContainer con){
       ObjectSet<Empleado> result = con.queryByExample(new Empleado(id, null, null, 0));
       if(result.hasNext()){
           System.out.println(result.next());
       }else{
           System.out.println("no hay empleado con este id");
       }
    }
    
    public static void eliminar(int id, ObjectContainer con){
       ObjectSet<Empleado> result = con.queryByExample(new Empleado(id, null, null, 0));
       if(result.hasNext()){
           con.delete(result.next());
       }else{
           System.out.println("no hay empleado con este id");
       }
    }
   
}
