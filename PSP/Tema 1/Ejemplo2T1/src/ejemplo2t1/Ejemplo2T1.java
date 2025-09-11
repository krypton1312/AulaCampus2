package ejemplo2t1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Ejemplo2T1 {
    public static void main(String[] args) throws IOException {
        Process p = new ProcessBuilder("CMD", "/C", "DIRr").start();
        InputStream entrada = p.getInputStream();
        
        int c;
        while((c = entrada.read()) != -1){
            System.out.print((char) c);
        }
        entrada.close();
        
        int exitVal;
        try {
            exitVal = p.waitFor();
            System.out.println("Valor de Salida: " + exitVal);
        } catch (InterruptedException e) {
            e.printStackTrace();    
        }
        InputStream er = p.getErrorStream();
        
        BufferedReader brer = new BufferedReader(new InputStreamReader(er));
        
        String mensajeError = null;
        System.out.print("ERROR: ");
        while ((mensajeError = brer.readLine()) != null){
            System.out.println(mensajeError);
        }
        
        er.close();
        brer.close();
    }
}
