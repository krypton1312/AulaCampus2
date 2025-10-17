package functionejemplo;

import java.sql.*;

public class FunctionEjemplo {
    public static void main(String[] args) throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bancos", "root", "");
        
        String sentencia = "{? = CALL consultaSaldo(?)}";
        
        CallableStatement fun = con.prepareCall(sentencia);
        
        fun.registerOutParameter(1, Types.DECIMAL);
        fun.setInt(2, 1);
        
        fun.executeUpdate();
        
        System.out.println(fun.getDouble(1));
        
        con.close();
    }
}
