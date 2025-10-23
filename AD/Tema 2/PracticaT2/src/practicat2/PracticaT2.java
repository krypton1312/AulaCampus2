package practicat2;

import java.sql.*;

public class PracticaT2 {

    public static void main(String[] args) throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eventos", "root", "");

        venderEntradas(con, 1, 5);
    }

    public static void venderEntradas(Connection con, int idEvento, int numEntradas) throws SQLException {
        PreparedStatement select = null;
        PreparedStatement updateVendidas = null;
        PreparedStatement updateRecaudacion = null;
        ResultSet rs = null;

        con.setAutoCommit(false);

        select = con.prepareStatement(
                "SELECT entradasVendidas, aforoEvento, precioEvento, recaudacionEvento "
                + "FROM eventos WHERE IdEvento = ?");
        select.setInt(1, idEvento);
        rs = select.executeQuery();

        if (!rs.next()) {
            System.out.println("Evento no encontrado");
            con.rollback();
            return;
        }

        int vendidas = rs.getInt("entradasVendidas");
        int aforo = rs.getInt("aforoEvento");
        double precio = rs.getDouble("precioEvento");
        double recaudacion = rs.getDouble("recaudacionEvento");

        int quedan = aforo - vendidas;

        if (quedan >= numEntradas) {

            updateVendidas = con.prepareStatement(
                    "UPDATE eventos SET entradasVendidas = ? WHERE IdEvento = ?");
            updateVendidas.setInt(1, vendidas + numEntradas);
            updateVendidas.setInt(2, idEvento);
            updateVendidas.executeUpdate();

            updateRecaudacion = con.prepareStatement(
                    "UPDATE eventos SET recaudacionEvento = ? WHERE IdEvento = ?");
            updateRecaudacion.setDouble(1, recaudacion + (numEntradas * precio));
            updateRecaudacion.setInt(2, idEvento);
            updateRecaudacion.executeUpdate();

            con.commit();
            System.out.println("Venta realizada correctamente. Transacción confirmada.");

        } else {
            con.rollback();
            System.out.println("No hay suficientes entradas disponibles. Transacción cancelada.");
        }
    }
}
