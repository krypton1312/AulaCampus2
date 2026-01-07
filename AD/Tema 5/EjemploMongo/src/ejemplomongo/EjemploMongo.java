package ejemplomongo;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import java.util.logging.*;
import org.bson.Document;

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
        
        listarPeliculas(conexion, "videoclub", "peliculas");
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
}
