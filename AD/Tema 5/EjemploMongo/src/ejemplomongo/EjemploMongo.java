package ejemplomongo;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import static com.mongodb.client.model.Filters.and;
import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.gt;
import java.util.logging.*;
import org.bson.Document;
import org.bson.conversions.Bson;

public class EjemploMongo {
    public static void main(String[] args) {
        Logger.getLogger("org.mongodb.driver").setLevel(Level.SEVERE);
        
        MongoClient conexion = MongoClients.create("mongodb://localhost:27017");

        /*
        MongoCursor<String> bases = conexion.listDatabaseNames().iterator();
        
        while(bases.hasNext()){
            System.out.println(bases.next());
        }
        */
        /*
        Document pelicula = new Document("codpelicula", 15000)
                .append("titulo", "Superman")
                .append("tema", "Aventuras")
                .append("duracion", 150)
                .append("precio", 3.5);
        
        insertarPelicula(conexion, "videoclub", "peliculas", pelicula);
        */
        
        //listarPeliculas(conexion, "videoclub", "peliculas");
        
        /*
        Bson condicion = eq("codpelicula", 15000);
        consultarPeliculas(conexion, "videoclub", "peliculas", condicion);
        
        Bson condicion1 = and(eq("tema", "Aventuras"), gt("precio", 2));
        consultarPeliculas(conexion, "videoclub", "peliculas", condicion1);
        */
        /*
        Bson condicion = eq("codpelicula", 883);
        consultarPeliculas(conexion, "videoclub", "peliculas", condicion);
        Document nuevoValor = new Document("tema", "Aventuras");
        
        actualizarPeliculas(conexion, "videoclub", "peliculas", condicion, nuevoValor);
        
        consultarPeliculas(conexion, "videoclub", "peliculas", condicion);
        */
        
        Bson condicion = eq("codpelicula", 15000);
        consultarPeliculas(conexion, "videoclub", "peliculas", condicion);
        
        eliminarPelicula(conexion, "videoclub", "peliculas", condicion);
        
        consultarPeliculas(conexion, "videoclub", "peliculas", condicion);
        
        conexion.close();
    }
    
    public static void insertarPelicula(MongoClient conexion, String baseDatos, String nombreColeccion, Document pelicula){
        MongoDatabase base = conexion.getDatabase(baseDatos);
        MongoCollection<Document> coleccion = base.getCollection(nombreColeccion);
        coleccion.insertOne(pelicula);
        System.out.println("Pelicula instertada.");
    }
    
    public static void listarPeliculas(MongoClient conexion, String baseDatos, String nombreColeccion){
        MongoDatabase base = conexion.getDatabase(baseDatos);
        MongoCollection<Document> coleccion = base.getCollection(nombreColeccion);
        
        MongoCursor<Document> listado = coleccion.find().iterator();
        
        Document pelicula;
        
        while(listado.hasNext()){
            pelicula = listado.next();
            System.out.println("Codigo pelicula: " + pelicula.getInteger("codpelicula"));
            System.out.println("Titulo: " + pelicula.getString("titulo"));
            System.out.println("Tema: " + pelicula.getString("tema"));
            System.out.println("Duracion: " + pelicula.getInteger("duracion"));
            System.out.println("Precio: " + pelicula.getDouble("precio"));
            System.out.println("=====================================================================================");
        }
    }
    
    
    public static void consultarPeliculas(MongoClient conexion, String baseDatos, String nombreColeccion, Bson condicion){
        MongoDatabase base = conexion.getDatabase(baseDatos);
        MongoCollection<Document> coleccion = base.getCollection(nombreColeccion);
        
        MongoCursor<Document> listado = coleccion.find(condicion).iterator();
        
        Document pelicula;
        
        while(listado.hasNext()){
            pelicula = listado.next();
            System.out.println("Codigo pelicula: " + pelicula.getInteger("codpelicula"));
            System.out.println("Titulo: " + pelicula.getString("titulo"));
            System.out.println("Tema: " + pelicula.getString("tema"));
            System.out.println("Duracion: " + pelicula.getInteger("duracion"));
            System.out.println("Precio: " + pelicula.getDouble("precio"));
            System.out.println("=====================================================================================");
        }
    }
    
    public static void actualizarPeliculas(MongoClient conexion, String baseDatos, String nombreColeccion, Bson condicion, Document nuevoValor){
        MongoDatabase base = conexion.getDatabase(baseDatos);
        MongoCollection<Document> coleccion = base.getCollection(nombreColeccion);
        
        Document cambio = new Document("$set", nuevoValor);
        
        coleccion.updateOne(condicion, cambio);
    }
    
    public static void eliminarPelicula(MongoClient conexion, String baseDatos, String nombreColeccion, Bson condicion){
        MongoDatabase base = conexion.getDatabase(baseDatos);
        MongoCollection<Document> coleccion = base.getCollection(nombreColeccion);
        
        coleccion.deleteMany(condicion);
    }
}
