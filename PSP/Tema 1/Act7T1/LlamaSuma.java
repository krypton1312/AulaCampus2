import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class LlamaSuma {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        ProcessBuilder pb = new ProcessBuilder("java", "Suma");
        Process p = pb.start();
        BufferedWriter bw = new BufferedWriter(new java.io.OutputStreamWriter(p.getOutputStream()));
        bw.write(sc.nextInt() + "\n");
        bw.write(sc.nextInt() + "\n");
        bw.flush();
        bw.close();

        InputStream is = p.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String linea;
        while ((linea = br.readLine()) != null) {
            System.out.println(linea);
        }
        br.close();
        br.close();
        p.waitFor();
    }
}
