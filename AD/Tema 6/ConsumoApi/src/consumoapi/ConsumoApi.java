package consumoapi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;

public class ConsumoApi {
    public static void main(String[] args) throws IOException {
        String direccion = "http://api.openweathermap.org/data/2.5/weather?q=valencia&units=metric&APPID=a77a241542b9ed8ac5b8e533f10c2f0a";
        String json = listado(direccion);
        //System.out.println(json);
        JSONObject datosJson = new JSONObject(json);
        String lugar = datosJson.getString("name");
        System.out.println(lugar);
        double temp = datosJson.getJSONObject("main").getDouble("temp");
        System.out.println(temp);
        double windSpeed = datosJson.getJSONObject("wind").getDouble("speed");
        System.out.println(windSpeed);
        
        JSONObject descripNubes = (JSONObject) datosJson.getJSONArray("weather").get(0);
        String descrip = descripNubes.getString("description");
        System.out.println(descrip);
        
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

    
}
