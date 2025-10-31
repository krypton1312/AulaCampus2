package practica.t3;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class PracticaT3 {

    public static void main(String[] args) {
        Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);
        Configuration configuracion = new Configuration();
        configuracion.addAnnotatedClass(Equipo.class);
        configuracion.configure();

        SessionFactory con = configuracion.buildSessionFactory();

        insertar(con, new Equipo(
                1,
                "HP",
                "HP Pavilion 15",
                "Portátil HP con procesador Intel i5, 8GB RAM y disco SSD de 512GB. Ideal para estudiantes.",
                15,
                512,
                8,
                899.99
        ));

        insertar(con, new Equipo(
                2,
                "Lenovo",
                "Lenovo IdeaPad Slim 14",
                "Ultrabook ligero con pantalla de 14 pulgadas, 16GB RAM y SSD de 1TB.",
                14,
                1000,
                16,
                1199.50
        ));

        insertar(con, new Equipo(
                3,
                "Asus",
                "Asus VivoBook 13",
                "Equipo compacto de 13 pulgadas con 4GB de RAM y 256GB SSD.",
                13,
                256,
                4,
                699.00
        ));

        insertar(con, new Equipo(
                4,
                "Dell",
                "Dell Inspiron 16",
                "Portátil de alto rendimiento con 32GB de memoria, 1TB de disco duro y pantalla de 16 pulgadas.",
                16,
                1000,
                32,
                1350.00
        ));

        List<Equipo> result;
        
        result = consultaHQL(con, "from Equipo e where e.marca like 'HP'");
        for(Equipo e: result){
            System.out.println(e);
        }
        
        System.out.println("=======");
        
        result = consultaHQL(con, "from Equipo e where e.pulgadasPantalla < 15");
        for(Equipo e: result){
            System.out.println(e);
        }
        
        System.out.println("=======");
        
        result = consultaHQL(con, "from Equipo e where e.gbMemoria > 4 AND e.capacidadDisco > 500 ");
        for(Equipo e: result){
            System.out.println(e);
        }
        
        System.out.println("=======");
        
        result = consultaHQL(con, "from Equipo e where e.precio < 1000 OR e.gbMemoria = 8 ");
        for(Equipo e: result){
            System.out.println(e);
        }
        
        System.out.println("=======");
        
        result = consultaHQL(con, "from Equipo e where e.descripcion like '%ultrabook%'");
        for(Equipo e: result){
            System.out.println(e);
        }
        
        con.close();
    }

    private static void insertar(SessionFactory con, Equipo eq) {
        Session session = con.openSession();

        Transaction tx = session.beginTransaction();

        session.persist(eq);
        System.out.println("Datos insertados.");

        tx.commit();

        session.close();

    }

    public static List<Equipo> consultaHQL(SessionFactory con, String consulta) {
        List<Equipo> lista;

        Session session = con.openSession();

        Transaction tx = session.beginTransaction();

        lista = session.createQuery(consulta, Equipo.class).getResultList();

        tx.commit();

        session.close();

        return lista;
    }
}
