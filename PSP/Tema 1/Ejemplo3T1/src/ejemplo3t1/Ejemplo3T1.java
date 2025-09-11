package ejemplo3t1;

import java.io.File;
import java.io.IOException;

public class Ejemplo3T1 {
    public static void main(String[] args) throws IOException {
        ProcessBuilder pb = new ProcessBuilder("CMD", "/C", "DIRr");
        File fOut = new File("salida.txt");
        File fErr = new File("error.txt");
        
        pb.redirectOutput(fOut);
        pb.redirectError(fErr);
        
        pb.start();
    }
}
