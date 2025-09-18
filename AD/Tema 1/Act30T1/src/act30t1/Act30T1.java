package act30t1;

import com.google.gson.Gson;
import java.util.ArrayList;

public class Act30T1 {
    public static void main(String[] args) {
      
        ArrayList<Coche> listado = new ArrayList<>();
        listado.add(new Coche("1234ABC", "Toyota", "Corolla", 18000, "Gasolina"));
        listado.add(new Coche("5678DEF", "Honda", "Civic", 20000, "Diesel"));
        listado.add(new Coche("9012GHI", "Tesla", "Model 3", 40000, "Eléctrico"));
        listado.add(new Coche("3456JKL", "Ford", "Focus", 17000, "Gasolina"));
        listado.add(new Coche("7890MNO", "BMW", "Serie 3", 35000, "Híbrido"));
        
        Gson gson = new Gson();
        
        String json = gson.toJson(listado);
        System.out.println(json);
        
    }
}
