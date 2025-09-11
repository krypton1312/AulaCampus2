package ejemplo4t1;

import java.io.File;
import java.io.IOException;

public class Ejemplo4T1 {
    public static void main(String[] args) throws IOException {
        ProcessBuilder pb = new ProcessBuilder("CMD");
        File fBat = new File("fichero.bat");
        File fOut = new File("salida.txt");
        File fErr = new File("error.txt");
        
        pb.redirectInput(fBat);
        pb.redirectOutput(fOut);
        pb.redirectError(fErr);
        
        pb.start();
    }
}
