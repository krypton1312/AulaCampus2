import java.io.*;
import java.util.Scanner;

public class LlamaMayusculas {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        ProcessBuilder pb = new ProcessBuilder("java", "Mayusculas");
        pb.redirectOutput(ProcessBuilder.Redirect.INHERIT);
        Process p = pb.start();
        
        OutputStream salida = p.getOutputStream();
        salida.write("hola\n".getBytes());
        
        salida.flush();
        salida.close();
        
        p.waitFor();
    }
}