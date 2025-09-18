package jsonobjecto;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class JSONObjecto {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        String jsonT = "{\n"
                + "	\"titulo\": \"123\",\n"
                + "	\"numPaginas\":123\n"
                + "}";

        FileReader reader = new FileReader("libro.json");

        Gson miGson = new Gson();
        Libro miLibro = miGson.fromJson(reader, Libro.class);
        reader.close();
        System.out.println(miLibro);

        String jsonTnew = miGson.toJson(new Libro("titulo", 12093));
        System.out.println(jsonTnew);

        ArrayList<Libro> libros = new ArrayList<>();

        libros.add(new Libro("Libro1", 123));
        libros.add(new Libro("Libro3", 312));
        libros.add(new Libro("Libro2", 231));

        Type tipoListado = new TypeToken<ArrayList<Libro>>() {
        }.getType();
        String json = miGson.toJson(libros, tipoListado);
        System.out.println(json);
        
        String jsonArray = "[{\"titulo\":\"Libro1\",\"numPaginas\":123},{\"titulo\":\"Libro1\",\"numPaginas\":123},{\"titulo\":\"Libro1\",\"numPaginas\":123}]";
        ArrayList<Libro> arrayLibro = miGson.fromJson(jsonArray, new TypeToken<ArrayList<Libro>>(){}.getType());
        if(arrayLibro!=null){
            for(Libro object : arrayLibro){
                System.out.println(object);
            }
        }
    }   
    
}
