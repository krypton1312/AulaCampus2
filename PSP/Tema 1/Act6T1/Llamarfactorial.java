import java.io.IOException;
import java.io.OutputStream;
import java.lang.ProcessBuilder.Redirect;
import java.util.Scanner;

public class Llamarfactorial {
    public static void main(String[] args) throws IOException, InterruptedException {
        new Scanner(System.in);
        ProcessBuilder pb = new ProcessBuilder("java", "Factorial");
        pb.redirectOutput(Redirect.INHERIT);
        Process p = pb.start();
        OutputStream os = p.getOutputStream();
        os.write("5\n".getBytes());
        os.flush();
        os.close();
        p.waitFor();
    }
}
