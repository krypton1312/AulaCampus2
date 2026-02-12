package consumoapivc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class ConsumoApiVC {
    public static void main(String[] args) throws IOException {
        String direccion=
            "http://localhost:8080/ApiVideoclub/ApiVC/peliculas";
        System.out.println(listado(direccion));
        int codpelicula = 100;
        System.out.println(consulta(direccion, codpelicula));
    }
    
    public static String listado(String direccion) throws MalformedURLException, IOException{
        // Creamos conexion
        URI uri = URI.create(direccion);
        URL url = uri.toURL();
        HttpURLConnection conexion = 
            (HttpURLConnection)url.openConnection();
        // Establecemos el m�todo HTTP y el tipo de 
        // datos que ser� json
        conexion.setRequestMethod("GET");
        conexion.setRequestProperty("Accept", 
               "application/json");
        // Obtenemos el c�digo de respuesta
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
        // Establecemos el m�todo HTTP y el tipo de 
        // datos que ser� json
        conexion.setRequestMethod("GET");
        conexion.setRequestProperty("Accept", 
               "application/json");
        // Obtenemos el c�digo de respuesta
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

}
