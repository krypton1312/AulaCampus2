package act29t1;

import com.google.gson.Gson;
import java.io.FileReader;

public class Act29T1 {

    public static void main(String[] args) {
        String jsonT = "{\n"
                + "    \"idEmpleado\": \"12345\",\n"
                + "    \"nombre\": \"John Doe\",\n"
                + "    \"apellidos\": \"Smith\",\n"
                + "    \"dni\": \"98765432A\",\n"
                + "    \"departamento\": \"IT\",\n"
                + "    \"sueldo\": 55000\n"
                + "}";

        Gson miGson = new Gson();
        Empleado emp = miGson.fromJson(jsonT, Empleado.class);
        System.out.println(emp);

        String jsonTnew = miGson.toJson(new Empleado(213,"nombre", "ronaldo", "12323213B", "Cleaning", 5050));
        System.out.println(jsonTnew);
    }
}
