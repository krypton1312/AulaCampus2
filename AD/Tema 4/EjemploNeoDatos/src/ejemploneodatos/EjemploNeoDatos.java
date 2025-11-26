package ejemploneodatos;

import java.util.ArrayList;
import java.util.List;
import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.Objects;
import org.neodatis.odb.core.query.criteria.ICriterion;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;

public class EjemploNeoDatos {

    public static void main(String[] args) {
        ODB odb = ODBFactory.open("jugadores.neo");

        /*
        odb.store(new Jugador("Jusus","Baloncesto", "Valencia", 50));
        odb.store(new Jugador("Jose","Futbol", "Valencia", 30));
        odb.store(new Jugador("Hugo","Futbol", "Valencia", 18));
         */
        listar(odb);
        System.out.println("=====================");
        
        /*System.out.println(consulta(odb, "Jusus"));
        
        actualiza(odb, new Jugador("Jusus", "Balonmano", "Madrid", 17));
        
        System.out.println(consulta(odb, "Jusus"));*/
        
        eliminar(odb, "Jusus");

        odb.close();
    }

    public static void listar(ODB odb) {
        Objects<Jugador> objects = odb.getObjects(Jugador.class);

        while (objects.hasNext()) {
            System.out.println(objects.next());
        }
    }

    public static List<Jugador> consulta(ODB odb, String nombre) {
        ICriterion condicion = Where.equal("nombre", nombre);
        CriteriaQuery consulta = new CriteriaQuery(Jugador.class, condicion);

        Objects<Jugador> obj = odb.getObjects(consulta);

        List<Jugador> jugadores = new ArrayList<>();

        while (obj.hasNext()) {
            Jugador j = obj.next();
            jugadores.add(j);
        }

        return jugadores;
    }
    
    public static void actualiza(ODB odb, Jugador miJugador){
        Jugador jugador = consulta(odb, miJugador.getNombre()).get(0);
        
        jugador.setCiudad(miJugador.getCiudad());
        jugador.setDeporte(miJugador.getDeporte());
        jugador.setEdad(miJugador.getEdad());
        
        odb.store(jugador);
        
    }
    
    public static void eliminar(ODB odb, String nombre){
        Jugador jugador = consulta(odb, nombre).get(0);
        
        System.out.println("Eliminar: " + jugador);
        odb.delete(jugador);
    }
}
