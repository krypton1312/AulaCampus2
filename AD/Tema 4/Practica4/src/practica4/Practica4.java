package practica4;

import java.util.Scanner;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

public class Practica4 {

    public static void main(String[] args) {
        ODB odb = null;
        Scanner sc = new Scanner(System.in);

        try {
            odb = ODBFactory.open("vehiculos.neo");

            int opcion;
            do {
                System.out.println("\n===== MENU GESTION DE VEHICULOS =====");
                System.out.println("1. Alta (insertar vehiculo)");
                System.out.println("2. Baja (eliminar vehiculo)");
                System.out.println("3. Modificar vehiculo");
                System.out.println("4. Consultar por matricula");
                System.out.println("5. Listar todos los vehiculos");
                System.out.println("0. Salir");
                System.out.print("Elige una opcion: ");

                while (!sc.hasNextInt()) {
                    System.out.print("Introduce un numero valido: ");
                    sc.next();
                }
                opcion = sc.nextInt();
                sc.nextLine();

                switch (opcion) {
                    case 1 -> insertar(odb, sc);
                    case 2 -> eliminar(odb, sc);
                    case 3 -> actualizar(odb, sc);
                    case 4 -> {
                        System.out.print("Introduce matricula a consultar: ");
                        String mat = sc.nextLine();
                        Vehiculo v = consultarPorMatricula(odb, mat);
                        if (v != null) {
                            System.out.println("Vehiculo encontrado:");
                            System.out.println(v);
                        } else {
                            System.out.println("No existe ningún vehiculo con esa matricula.");
                        }
                    }
                    case 5 -> listar(odb);
                    case 0 -> System.out.println("Cerrando la aplicacion...");
                    default -> System.out.println("Opcion no valida.");
                }

            } while (opcion != 0);

        } finally {
            if (odb != null) {
                odb.close();
            }
            sc.close();
        }
    }

    private static void listar(ODB odb) {
        Objects<Vehiculo> obj = odb.getObjects(Vehiculo.class);

        System.out.println("\n--- LISTADO DE VEHICULOS ---");
        while (obj.hasNext()) {
            System.out.println(obj.next());
        }
    }

    public static Vehiculo consultarPorMatricula(ODB odb, String matricula) {
        CriteriaQuery consulta
                = new CriteriaQuery(Vehiculo.class, Where.equal("matricula", matricula));

        Objects<Vehiculo> obj = odb.getObjects(consulta);

        if (!obj.isEmpty()) {
            return obj.getFirst();
        }
        return null;
    }

    public static void actualizar(ODB odb, Scanner sc) {
        System.out.print("Introduce matricula del vehiculo para actualizar: ");
        String matricula = sc.nextLine();

        Vehiculo veh = consultarPorMatricula(odb, matricula);

        if (veh == null) {
            System.out.println("No existe ningun vehículo con esa matricula.");
            return;
        }

        System.out.println("Datos actuales:\n" + veh);

        Vehiculo nuevosDatos = pedirDatos(sc, true);

        veh.setMarca(nuevosDatos.getMarca());
        veh.setModelo(nuevosDatos.getModelo());
        veh.setPrecio(nuevosDatos.getPrecio());

        odb.store(veh);
        System.out.println("Datos actualizados:\n" + veh);
    }

    public static void insertar(ODB odb, Scanner sc) {
        System.out.println("Introduce los datos del vehiculo:");
        Vehiculo v = pedirDatos(sc, false);
        odb.store(v);
        System.out.println("Vehiculo insertado correctamente.");
    }

    public static Vehiculo pedirDatos(Scanner sc, boolean modoActualizar) {
        String matricula = null;

        if (!modoActualizar) {
            System.out.print("Matricula: ");
            matricula = sc.nextLine();
        }

        System.out.print("Marca: ");
        String marca = sc.nextLine();

        System.out.print("Modelo: ");
        String modelo = sc.nextLine();

        System.out.print("Precio: ");
        double precio = sc.nextDouble();
        sc.nextLine();

        return new Vehiculo(matricula, marca, modelo, precio);
    }

    public static void eliminar(ODB odb, Scanner sc) {
        System.out.print("Introduce matricula para eliminar vehiculo: ");
        String mat = sc.nextLine();

        Vehiculo veh = consultarPorMatricula(odb, mat);

        if (veh == null) {
            System.out.println("No existe ningun vehículo con esa matricula.");
            return;
        }

        odb.delete(veh);
        System.out.println("Vehiculo eliminado correctamente.");
    }
}
