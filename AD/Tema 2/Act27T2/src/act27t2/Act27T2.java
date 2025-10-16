package act27t2;

import java.sql.*;

public class Act27T2 {
    public static void main(String[] args) throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/inmobilaria", "root", "");
        
        //actividad27(con);
        
        //actividad28(con);
        
        //actividad29(con);
        
        //actividad30(con);
        
        con.close();
        
    }
    
    private static void actividad27(Connection con) throws SQLException{
        String sentencia = "{CALL eliminaAlquiler(?)}";
        
        CallableStatement stat = con.prepareCall(sentencia);
        
        stat.setInt(1, 1);
        
        stat.executeUpdate();
        
        System.out.println("Eliminado.");
    }
    
    private static void actividad28(Connection con) throws SQLException{
        String sencencia = "{CALL actualizaAlquiler(?,?)}";
        
        CallableStatement stat = con.prepareCall(sencencia);
        
        stat.setInt(1, 2);
        stat.setDouble(2, 100);
        
        stat.executeUpdate();
        
        System.out.println("Actualizado.");
    }
    
    private static void actividad29(Connection con) throws SQLException{
        CallableStatement stat = con.prepareCall("{? = CALL devuelveImporte(?)}");
        
        stat.registerOutParameter(1, Types.DECIMAL);
        stat.setInt(2,2);
        
        stat.executeUpdate();
        System.out.println("Precio del alquiler id 2:" + stat.getDouble(1));
    }
    
    private static void actividad30(Connection con) throws SQLException{
        CallableStatement stat = con.prepareCall("{? = CALL devuelveImporteAnnual(?)}");
        
        stat.registerOutParameter(1, Types.DECIMAL);
        stat.setInt(2,2);
        
        stat.executeUpdate();
        System.out.println("Precio annual con IVA del alquiler id 2:" + stat.getDouble(1));
    }
}
