package act7t5;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import static com.mongodb.client.model.Filters.lt;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bson.Document;
import org.bson.conversions.Bson;

public class Act7T5 {
    public static void main(String[] args) {
        Logger.getLogger("org.mongodb.driver").setLevel(Level.SEVERE);
        
        MongoClient con = MongoClients.create("mongodb://localhost:27017");
        
        String baseDatos = "concesionario";
        String coleccion = "vehiculos";

        Document v1 = new Document("matricula", "1234ABC")
                .append("marca", "Toyota")
                .append("modelo", "Corolla")
                .append("precio", 15000.0);

        Document v2 = new Document("matricula", "5678DEF")
                .append("marca", "BMW")
                .append("modelo", "X5")
                .append("precio", 42000.0);

        Document v3 = new Document("matricula", "9999ZZZ")
                .append("marca", "Seat")
                .append("modelo", "Ibiza")
                .append("precio", 11000.0);

        insertarVehiculo(con, baseDatos, coleccion, v1);
        insertarVehiculo(con, baseDatos, coleccion, v2);
        insertarVehiculo(con, baseDatos, coleccion, v3);

        System.out.println("\n===== LISTADO COMPLETO =====");
        listarVehiculos(con, baseDatos, coleccion);

        System.out.println("\n===== VEHÍCULOS CON PRECIO > 12000 =====");
        Bson condicionPrecio = Filters.gt("precio", 12000);
        consultarVehiculos(con, baseDatos, coleccion, condicionPrecio);

        System.out.println("\n===== VEHÍCULOS MARCA TOYOTA =====");
        Bson condicionMarca = Filters.eq("marca", "Toyota");
        consultarVehiculos(con, baseDatos, coleccion, condicionMarca);
        
        System.out.println("\n===== ACTUALIZAR PRECIO TOYOTA 1234ABC =====");
        Bson condicionMatricula = Filters.eq("matricula", "1234ABC");

        Document nuevoValor = new Document("precio", 16000.0);
        actualizarVehiculos(con, baseDatos, coleccion, condicionMatricula, nuevoValor);
        
        System.out.println("\n===== DESPUÉS DE ACTUALIZAR =====");
        consultarVehiculos(con, baseDatos, coleccion, condicionMatricula);

        Bson condicionEliminar = lt("precio", 12000);
        eliminarVehiculo(con, baseDatos, coleccion, condicionEliminar);

        System.out.println("\n===== LISTADO FINAL =====");
        listarVehiculos(con, baseDatos, coleccion);

        con.close();
    }
    
    public static void insertarVehiculo(MongoClient con, String baseDatos, String nombreColeccion, Document vehiculo){
        MongoDatabase base = con.getDatabase(baseDatos);
        MongoCollection<Document> coleccion = base.getCollection(nombreColeccion);
        coleccion.insertOne(vehiculo);
        System.out.println("Vehiculo insertado.");
    }
    
    public static void listarVehiculos(MongoClient conexion, String baseDatos, String nombreColeccion){
        MongoDatabase base = conexion.getDatabase(baseDatos);
        MongoCollection<Document> coleccion = base.getCollection(nombreColeccion);
        
        MongoCursor<Document> listado = coleccion.find().iterator();
        
        bucleListar(listado);
    }
    
    public static void consultarVehiculos(MongoClient conexion, String baseDatos, String nombreColeccion, Bson condicion){
        MongoDatabase base = conexion.getDatabase(baseDatos);
        MongoCollection<Document> coleccion = base.getCollection(nombreColeccion);
        
        MongoCursor<Document> listado = coleccion.find(condicion).iterator();
        
        bucleListar(listado);
    }
    
    public static void eliminarVehiculo(MongoClient conexion, String baseDatos, String nombreColeccion, Bson condicion){
        MongoDatabase base = conexion.getDatabase(baseDatos);
        MongoCollection<Document> coleccion = base.getCollection(nombreColeccion);
        
        coleccion.deleteMany(condicion);
    }
    
    public static void actualizarVehiculos(MongoClient conexion, String baseDatos, String nombreColeccion, Bson condicion, Document nuevoValor){
        MongoDatabase base = conexion.getDatabase(baseDatos);
        MongoCollection<Document> coleccion = base.getCollection(nombreColeccion);
        
        Document cambio = new Document("$set", nuevoValor);
        
        coleccion.updateOne(condicion, cambio);
    }
    
    public static void bucleListar(MongoCursor<Document> listado){
        
        Document vehiculo;
        
        while(listado.hasNext()){
            vehiculo = listado.next();
            System.out.println("Matricula: " + vehiculo.getString("matricula"));
            System.out.println("Marca: " + vehiculo.getString("marca"));
            System.out.println("Modelo: " + vehiculo.getString("modelo"));
            System.out.println("Precio: " + vehiculo.getDouble("precio"));
            System.out.println("=====================================================================================");
        }
    }
}
