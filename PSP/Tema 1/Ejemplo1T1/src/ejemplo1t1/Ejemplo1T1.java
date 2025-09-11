package ejemplo1t1;

import java.io.IOException;

public class Ejemplo1T1 {
    public static void main(String[] args) throws IOException {
        ProcessBuilder pb = new ProcessBuilder("NOTEPAD");
        Process p = pb.start();
    }
}
