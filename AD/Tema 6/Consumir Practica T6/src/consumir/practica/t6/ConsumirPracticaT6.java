package consumir.practica.t6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

public class ConsumirPracticaT6 {
    public static void main(String[] args) throws Exception{
        String direccion = "http://localhost:8080/Practica_T6/libroApi/libros";
        //System.out.println(listado(direccion));
        crear(direccion, "{\"autor\":\"Yehor\",\"codLibro\":1001,\"editorial\":\"Editorial1\",\"isbn\":\"3454235\",\"tema\":\"Informática\",\"titulo\":\"tutorial SpringBoot\"}");
        System.out.println(consulta(direccion, 1001));
        actualizar(direccion,"{\"autor\":\"Yehor\",\"codLibro\":1001,\"editorial\":\"Editorial2\",\"isbn\":\"3454235\",\"tema\":\"Informática\",\"titulo\":\"tutorial SpringBoot\"}", 1);
        System.out.println(consulta(direccion, 1001));
        eliminar(direccion, 1001);
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
        int codLibro) throws MalformedURLException, IOException{
        // Creamos conexion
        URI uri = URI.create(direccion+"/"+codLibro);
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
    
    public static void actualizar(String direccion, String json,
            int codLibro) throws MalformedURLException, IOException{
        // Creamos conexion
        URI uri = URI.create(direccion+"/"+codLibro);
        URL url = uri.toURL();
        HttpURLConnection conexion = 
            (HttpURLConnection)url.openConnection(); 
        // Establecemos que se envia json con los datos de pelicula
        conexion.setDoOutput(true);
        conexion.setRequestMethod("PUT"); 
        conexion.setRequestProperty("Content-Type", "application/json");
        // Escribimos la información de la pelicula en json
        // en un flujo de salida sobre la conexion
        OutputStream os = conexion.getOutputStream();
        os.write(json.getBytes());
        os.flush();
        // Obtenemos el codigo de respuesta
        int codigoRespuesta  = 
             conexion.getResponseCode();
        System.out.println("Respuesta: " + 
            codigoRespuesta);
        // Cerramos la conexion
        conexion.disconnect();   
    }
    
    public static void crear(String direccion, String json) throws MalformedURLException, IOException{
        // Creamos conexion
        URI uri = URI.create(direccion);
        URL url = uri.toURL();
        HttpURLConnection conexion = 
            (HttpURLConnection)url.openConnection(); 
        // Establecemos que se envia json con los datos de pelicula
        conexion.setDoOutput(true);
        conexion.setRequestMethod("POST"); 
        conexion.setRequestProperty("Content-Type", "application/json");
        // Escribimos la información de la pelicula en json
        // en un flujo de salida sobre la conexion
        OutputStream os = conexion.getOutputStream();
        os.write(json.getBytes());
        os.flush();
        // Obtenemos el codigo de respuesta
        int codigoRespuesta  = 
             conexion.getResponseCode();
        System.out.println("Respuesta: " + 
            codigoRespuesta);
        // Cerramos la conexion
        conexion.disconnect();   
    }
    
    public static void eliminar(String direccion, int codLibro) throws MalformedURLException, IOException{
        // Creamos conexion
        URI uri = URI.create(direccion+"/"+codLibro);
        URL url = uri.toURL();
        HttpURLConnection conexion = 
            (HttpURLConnection)url.openConnection();
        // Establecemos el m?todo HTTP y el tipo de 
        // datos que ser? json
        conexion.setRequestMethod("DELETE"); 
        conexion.setRequestProperty("Accept", "application/json");
        // Obtenemos el codigo de respuesta
        int codigoRespuesta  = 
             conexion.getResponseCode();
        System.out.println("Respuesta: " + 
            codigoRespuesta);
        // Cerramos la conexion
        conexion.disconnect();
    }
}
