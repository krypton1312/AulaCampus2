package transaccionesejemplo;

import java.sql.*;

public class TransaccionesEjemplo {

    public static void main(String[] args) throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bancos", "root", "");
        
        transaccion(con, 2,1,1000);
        
        con.close();
    }

    public static void transaccion(Connection conexion, int cuentaOrigen, int cuentaDestino,double cantidad) throws SQLException {
        // Creamos instancia del tipo Statement
        // para la consulta
        Statement consulta = null;
        // Creamos variables para la cantidad de 
        // registros afectados por los updates y
        // el saldo
        int registrosOrigen;
        int registrosDestino;
        double saldoOrigen = 0;
        // Almacenar los registros de la consulta
        ResultSet resultado;
        // Creamos las sentencias SQL: 
        // 2 update y 1 select
        String sentenciaActOrigen
                = "UPDATE cuentas SET saldo = saldo - "
                + cantidad + " WHERE numcuenta = "
                + cuentaOrigen;
        String sentenciaActDestino
                = "UPDATE cuentas SET saldo = saldo + "
                + cantidad + " WHERE numcuenta = "
                + cuentaDestino;
        String sentenciaConsultaSaldo
                = "SELECT saldo FROM cuentas WHERE numcuenta="
                + cuentaOrigen;
        // COMIENZA LA TRANSACCION
        conexion.setAutoCommit(false);
        // Ejecutamos las actualizaciones de saldo
        consulta = conexion.createStatement();
        registrosOrigen
                = consulta.executeUpdate(sentenciaActOrigen);
        registrosDestino
                = consulta.executeUpdate(sentenciaActDestino);
        // Obtenemos saldo cuenta de Origen
        resultado
                = consulta.executeQuery(sentenciaConsultaSaldo);
        while (resultado.next()) {
            saldoOrigen = resultado.getDouble("SALDO");
        }
        // Comprobamos si la transaccion no es correcta
        if (registrosOrigen == 0 || registrosDestino == 0
                || saldoOrigen < 0) {
            // Deshacemos la transaccion
            conexion.rollback();
            System.out.println("Transaccion anulada");
        } else {
            // Confirmar la transaccion
            conexion.commit();
            System.out.println("Transaccion confirmada");
        }
        // Activamos el autocommit
        conexion.setAutoCommit(true);
    }
}
