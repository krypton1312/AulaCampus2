package procedureejemplo;
import java.sql.*;

public class ProcedureEjemplo {
    public static void main(String[] args) throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bancos", "root", "");
        
        String sentencia = "{CALL ingreso(?,?)}";
       
        CallableStatement proc = con.prepareCall(sentencia);
        
        proc.setInt(1, 2);
        proc.setDouble(2, 350);
        
        proc.executeUpdate();
        
        con.close();
    }
}
