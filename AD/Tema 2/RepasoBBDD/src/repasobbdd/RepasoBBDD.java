package repasobbdd;

import java.sql.*;

public class RepasoBBDD {

    public static void main(String[] args) throws SQLException {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/vc", "root", "");

        createPeli(con, new Pelicula(1, "new", "new", 0, 0.0));
    }
    
    public static void listarPeliculas(Connection con) throws SQLException {
        Statement stat = con.createStatement();
        ResultSet result = stat.executeQuery("SELECT * FROM PELICULAS");

        while (result.next()) {
            System.out.print(result.getString("codpelicula") + "    ");
            System.out.print(result.getString("titulo") + "    ");
            System.out.print(result.getString("tema") + "    ");
            System.out.print(result.getInt("duracion") + "    ");
            System.out.println((double) result.getDouble("precio") + "    ");
            System.out.println("============================================================");
        }
    }

    public static void consultarPeliPorCodigo(Connection con, int codpelicula) throws SQLException {
        Statement stat = con.createStatement();
        ResultSet result = stat.executeQuery("SELECT * FROM PELICULAS WHERE codpelicula=" + codpelicula);

        while (result.next()) {
            System.out.print(result.getString("codpelicula") + "    ");
            System.out.print(result.getString("titulo") + "    ");
            System.out.print(result.getString("tema") + "    ");
            System.out.print(result.getInt("duracion") + "    ");
            System.out.println((double) result.getDouble("precio") + "    ");
            System.out.println("============================================================");
        }
    }
    public static void borrar(Connection con, int codpelicula) throws SQLException {
        consultarPeliPorCodigo(con, codpelicula);
        Statement stat = con.createStatement();
        stat.executeUpdate("DELETE FROM PELICULAS WHERE codpelicula=" + codpelicula);
        System.out.println("ha sido borrado :)");
    }
    
    public static void cantidadPelis(Connection con) throws SQLException {
        Statement stat = con.createStatement();
        ResultSet res = stat.executeQuery("SELECT COUNT(*) AS count FROM PELICULAS");
        while(res.next()){
            System.out.println(res.getInt("count"));
        }
    }
    
    public static void updatePeli(Connection con, Pelicula pelicula) throws SQLException{
        consultarPeliPorCodigo(con, pelicula.getCodelicula());
        
        PreparedStatement stat = con.prepareStatement("UPDATE PELICULAS SET titulo = ?, tema = ?, duracion = ?, precio = ? WHERE codpelicula = ?");
        
        stat.setString(1, pelicula.getTitulo());
        stat.setString(2, pelicula.getTema());
        stat.setInt(3, pelicula.getDuracion());
        stat.setDouble(4, pelicula.getPrecio());
        stat.setInt(5, pelicula.getCodelicula());
        
        stat.execute();
        
        consultarPeliPorCodigo(con, pelicula.getCodelicula());
    }
    
    public static void createPeli(Connection con, Pelicula pelicula) throws SQLException{
        PreparedStatement stat = con.prepareStatement("INSERT INTO PELICULAS VALUES (?,?,?,?,?)");
        
        stat.setInt(1, pelicula.getCodelicula());
        stat.setString(2, pelicula.getTitulo());
        stat.setString(3, pelicula.getTema());
        stat.setInt(4, pelicula.getDuracion());
        stat.setDouble(5, pelicula.getPrecio());
        
        stat.execute();
        
        consultarPeliPorCodigo(con, pelicula.getCodelicula());
    }
}
