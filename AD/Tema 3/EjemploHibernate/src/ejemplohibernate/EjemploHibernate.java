package ejemplohibernate;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;



public class EjemploHibernate {

    public static void main(String[] args) {
        Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);
        Configuration configuracion = new Configuration();
        configuracion.addAnnotatedClass(Pelicula.class);
        configuracion.configure();

        SessionFactory conexion = configuracion.buildSessionFactory();

        Pelicula miPelicula;
        
        List<Pelicula> lista = listarPelicula(conexion);
        for(Pelicula pelicula: lista){
            System.out.println(pelicula);
        }
        conexion.close();
    }

    public static Pelicula consultaPelicula(SessionFactory conexion, int codPelicula) {
        Pelicula miPelicula;
        
        Session sesion = conexion.openSession();
        Transaction tx = sesion.beginTransaction();
        miPelicula = (Pelicula) sesion.find(Pelicula.class, codPelicula);
        tx.commit();
        sesion.close();
        return miPelicula;
    }
    
    public static List<Pelicula> listarPelicula(SessionFactory conexion){
        Session sesion = conexion.openSession();
        
        Transaction tx = sesion.beginTransaction();
        
        List<Pelicula> lista = sesion.createQuery("from Pelicula", Pelicula.class).getResultList();
        
        tx.commit();
        
        sesion.close();
        
        return lista;
    }
}
