package act16.pkg26t2;

import java.sql.*;
import java.util.Scanner;

public class Act1626T2 {

    public static void main(String[] args) throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/inmobilaria", "root", "");
    }

    public static void insertar(Connection con, Alquiler alquiler) throws SQLException {
        PreparedStatement stat = con.prepareStatement("INSERT INTO ALQUILERES VALUES(?,?,?,?,?,?,?)");
        stat.setInt(1, alquiler.getIdAlquiler());
        stat.setString(2, alquiler.getDireccion());
        stat.setString(3, alquiler.getPoblacion());
        stat.setString(4, alquiler.getCodPostal());
        stat.setDouble(5, alquiler.getPrecioAlquiler());
        stat.setString(6, alquiler.getIdContacto());
        stat.setString(7, alquiler.getTelefono());

        consultarPorId(con, alquiler.getIdAlquiler());
        stat.execute();
    }

    public static void consultarPorId(Connection con, int idAlquiler) throws SQLException {
        Statement stat = con.createStatement();
        ResultSet result = stat.executeQuery("SELECT * FROM ALQUILERES WHERE idAlquiler=" + idAlquiler);

        while (result.next()) {
            System.out.print(result.getInt("idAlquiler") + "    ");
            System.out.print(result.getString("direccion") + "    ");
            System.out.print(result.getString("poblacion") + "    ");
            System.out.print(result.getString("codPostal") + "    ");
            System.out.println((double) result.getDouble("precioAlquiler") + "    ");
            System.out.print(result.getString("idContacto") + "    ");
            System.out.print(result.getString("telefono") + "    ");
            System.out.println("============================================================");
        }
    }

    public static void eliminar(Connection con, int idAlquiler) throws SQLException {
        consultarPorId(con, idAlquiler);
        Statement stat = con.createStatement();
        int result = stat.executeUpdate("DELETE FROM ALQUILERES WHERE idAlquiler=" + idAlquiler);
        if (result > 0) {
            System.out.println("done");
        } else {
            System.out.println("not done");
        }
    }

    public static void updateAlquiler(Connection con, Alquiler alquiler) throws SQLException {
        consultarPorId(con, alquiler.getIdAlquiler());

        PreparedStatement stat = con.prepareStatement("UPDATE ALQUILERES SET direccion = ?, poblacion = ?, codPostal = ?, precioAlquiler = ?, idContacto = ?, telefono = ? WHERE idAlquiler = ?");

        stat.setString(1, alquiler.getDireccion());
        stat.setString(2, alquiler.getPoblacion());
        stat.setString(3, alquiler.getCodPostal());
        stat.setDouble(4, alquiler.getPrecioAlquiler());
        stat.setString(5, alquiler.getIdContacto());
        stat.setString(6, alquiler.getTelefono());
        stat.setInt(7, alquiler.getIdAlquiler());

        int result = stat.executeUpdate();

        if (result > 0) {
            System.out.println("Alquiler actualizado correctamente.");
        } else {
            System.out.println("No se encontró el alquiler con ID " + alquiler.getIdAlquiler());
        }
        consultarPorId(con, alquiler.getIdAlquiler());
    }

    public static void consultarTodos(Connection con) throws SQLException {
        Statement stat = con.createStatement();
        ResultSet result = stat.executeQuery("SELECT * FROM ALQUILERES");

        while (result.next()) {
            System.out.print(result.getInt("idAlquiler") + "    ");
            System.out.print(result.getString("direccion") + "    ");
            System.out.print(result.getString("poblacion") + "    ");
            System.out.print(result.getString("codPostal") + "    ");
            System.out.println((double) result.getDouble("precioAlquiler") + "    ");
            System.out.print(result.getString("idContacto") + "    ");
            System.out.print(result.getString("telefono") + "    ");
            System.out.println("============================================================");
        }
    }

    public static void consultarPorPrecio(Connection con) throws SQLException {
        Scanner sc = new Scanner(System.in);

        System.out.print("Importe: ");
        double importe = sc.nextDouble();
        sc.nextLine();

        Statement stat = con.createStatement();
        ResultSet result = stat.executeQuery("SELECT * FROM ALQUILERES WHERE precioAlquiler <=" + importe);

        while (result.next()) {
            System.out.print(result.getInt("idAlquiler") + "    ");
            System.out.print(result.getString("direccion") + "    ");
            System.out.print(result.getString("poblacion") + "    ");
            System.out.print(result.getString("codPostal") + "    ");
            System.out.println((double) result.getDouble("precioAlquiler") + "    ");
            System.out.print(result.getString("idContacto") + "    ");
            System.out.print(result.getString("telefono") + "    ");
            System.out.println("============================================================");
        }
    }
    
    public static void consultarPorCodPostal(Connection con) throws SQLException {
        Scanner sc = new Scanner(System.in);

        System.out.print("CodPostal: ");
        String codPostal = sc.nextLine();

        PreparedStatement stat = con.prepareStatement(
                "SELECT * FROM ALQUILERES WHERE codPostal LIKE ?"
        );
        stat.setString(1, "%" + codPostal + "%");

        ResultSet result = stat.executeQuery();
        
        while (result.next()) {
            System.out.print(result.getInt("idAlquiler") + "    ");
            System.out.print(result.getString("direccion") + "    ");
            System.out.print(result.getString("poblacion") + "    ");
            System.out.print(result.getString("codPostal") + "    ");
            System.out.println((double) result.getDouble("precioAlquiler") + "    ");
            System.out.print(result.getString("idContacto") + "    ");
            System.out.print(result.getString("telefono") + "    ");
            System.out.println("============================================================");
        }
    }
    public static void consultarPorDirrecion(Connection con) throws SQLException {
        Scanner sc = new Scanner(System.in);

        System.out.print("Importe: ");
        String direccion = sc.nextLine();

        PreparedStatement stat = con.prepareStatement(
                "SELECT * FROM ALQUILERES WHERE direccion LIKE ?"
        );
        stat.setString(1, "%" + direccion + "%");

        ResultSet result = stat.executeQuery();
        
        while (result.next()) {
            System.out.print(result.getInt("idAlquiler") + "    ");
            System.out.print(result.getString("direccion") + "    ");
            System.out.print(result.getString("poblacion") + "    ");
            System.out.print(result.getString("codPostal") + "    ");
            System.out.println((double) result.getDouble("precioAlquiler") + "    ");
            System.out.print(result.getString("idContacto") + "    ");
            System.out.print(result.getString("telefono") + "    ");
            System.out.println("============================================================");
        }
    }
    
    public static void consultarPorContacto(Connection con) throws SQLException {
        Scanner sc = new Scanner(System.in);

        System.out.print("Contacto: ");
        String idContacto = sc.nextLine();

        PreparedStatement stat = con.prepareStatement(
                "SELECT * FROM ALQUILERES WHERE idContacto LIKE ?"
        );
        stat.setString(1, idContacto);

        ResultSet result = stat.executeQuery();
        
        while (result.next()) {
            System.out.print(result.getInt("idAlquiler") + "    ");
            System.out.print(result.getString("direccion") + "    ");
            System.out.print(result.getString("poblacion") + "    ");
            System.out.print(result.getString("codPostal") + "    ");
            System.out.println((double) result.getDouble("precioAlquiler") + "    ");
            System.out.print(result.getString("idContacto") + "    ");
            System.out.print(result.getString("telefono") + "    ");
            System.out.println("============================================================");
        }
    }
    
    public static void consultarPorPoblacion(Connection con) throws SQLException {
        Scanner sc = new Scanner(System.in);

        System.out.print("Telefono: ");
        String poblacion = sc.nextLine();

        PreparedStatement stat = con.prepareStatement(
                "SELECT * FROM ALQUILERES WHERE poblacion LIKE ?"
        );
        stat.setString(1, poblacion);

        ResultSet result = stat.executeQuery();
        
        while (result.next()) {
            System.out.print(result.getInt("idAlquiler") + "    ");
            System.out.print(result.getString("direccion") + "    ");
            System.out.print(result.getString("poblacion") + "    ");
            System.out.print(result.getString("codPostal") + "    ");
            System.out.println((double) result.getDouble("precioAlquiler") + "    ");
            System.out.print(result.getString("idContacto") + "    ");
            System.out.print(result.getString("telefono") + "    ");
            System.out.println("============================================================");
        }
    }
}
