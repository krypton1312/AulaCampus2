package act1t3;



import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Act1T3 {
    public static void main(String[] args) {
        Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);
        Configuration configuracion = new Configuration();
        configuracion.addAnnotatedClass(Socio.class);
        configuracion.configure();
        
        SessionFactory con = configuracion.buildSessionFactory();
        
        //altaActualizacionSocio(con, new Socio(1, "Kevin", "Smoke", "Calle Cami Real 57", "4585855", "Catarroja"));
        eliminarSocio(con, 1);
        List<Socio> lista = listar(con);
        for(Socio s: lista){
            System.out.println(s);
        }
        
        System.out.println(consultaSocio(con, 1274));
        con.close();
    }
    
    public static void altaActualizacionSocio(SessionFactory con, Socio socio){
        Session sesion = con.openSession();
        
        Transaction tx = sesion.beginTransaction();
        
        sesion.merge(socio);
        
        tx.commit();
        
        sesion.close();
    }
    
    public static List<Socio> listar(SessionFactory con){
        Session sesion = con.openSession();
        
        Transaction tx = sesion.beginTransaction();
        
        List<Socio> socios = sesion.createQuery("from Socio", Socio.class).getResultList();
        
        tx.commit();
        
        sesion.close();
        
        return socios;
    }
    
    public static void eliminarSocio(SessionFactory con, int codsocio){
        Session sesion = con.openSession();
        
        Transaction tx = sesion.beginTransaction();
        
        Socio socio = new Socio();
        socio.setCodsocio(codsocio);
        sesion.remove(socio);
        
        tx.commit();
        
        sesion.close();
    }
    
    public static Socio consultaSocio(SessionFactory conexion, int codSocio) {
        Session sesion = conexion.openSession();
        Transaction tx = sesion.beginTransaction();
        Socio socio = (Socio) sesion.find(Socio.class, codSocio);
        tx.commit();
        sesion.close();
        return socio;
    }
}
