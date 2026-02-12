package actaddictt6;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ActAddictT6 {
    public static void main(String[] args) throws IOException {
        Gson gson = new Gson();
        String direccion=
            "http://localhost:8080/ApiVideoclub/ApiVC/peliculas";
        System.out.println(convertir(consulta(direccion, 100), gson));
        int codpelicula = 100;
        System.out.println(convertirArray(listado(direccion), gson));
    }
    
     public static String listado(String direccion) throws MalformedURLException, IOException{
        // Creamos conexion
        URI uri = URI.create(direccion);
        URL url = uri.toURL();
        HttpURLConnection conexion = 
            (HttpURLConnection)url.openConnection();
        // Establecemos el m?todo HTTP y el tipo de 
        // datos que ser? json
        conexion.setRequestMethod("GET");
        conexion.setRequestProperty("Accept", 
               "application/json");
        // Obtenemos el c?digo de respuesta
        int codigoRespuesta  = 
             conexion.getResponseCode();
        System.out.println("Respuesta: " + 
            codigoRespuesta);
        
        // Creamos un buffer de datos sobre conexion
        InputStreamReader isr = 
            new InputStreamReader(
                conexion.getInputStream());
        BufferedReader br = new BufferedReader(isr);
        String json="";
        String linea="";
        // Leemos la salida de la api linea a linea
        while((linea=br.readLine())!=null){
            json+=linea;
        }
        // Cerramos buffer
        br.close();
        // Cerramos la conexion
        conexion.disconnect();
        // devolvemos json
        return json;
    }    

    public static String consulta(String direccion,
        int codpelicula) throws MalformedURLException, IOException{
        // Creamos conexion
        URI uri = URI.create(direccion+"/"+codpelicula);
        URL url = uri.toURL();
        HttpURLConnection conexion = 
            (HttpURLConnection)url.openConnection();
        // Establecemos el m?todo HTTP y el tipo de 
        // datos que ser? json
        conexion.setRequestMethod("GET");
        conexion.setRequestProperty("Accept", 
               "application/json");
        // Obtenemos el c?digo de respuesta
        int codigoRespuesta  = 
             conexion.getResponseCode();
        System.out.println("Respuesta: " + 
            codigoRespuesta);
        
        // Creamos un buffer de datos sobre conexion
        InputStreamReader isr = 
            new InputStreamReader(
                conexion.getInputStream());
        BufferedReader br = new BufferedReader(isr);
        String json="";
        String linea="";
        // Leemos la salida de la api linea a linea
        while((linea=br.readLine())!=null){
            json+=linea;
        }
        // Cerramos buffer
        br.close();
        // Cerramos la conexion
        conexion.disconnect();
        // devolvemos json
        return json;
    }
    private static Peliculas convertir(String json, Gson gson){
        return gson.fromJson(json, Peliculas.class);
    }
    
    private static List<Peliculas> convertirArray(String json, Gson gson){
        return gson.fromJson(json, new TypeToken<ArrayList<Peliculas>>(){}.getType());
    }
}
