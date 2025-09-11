package practica1;

import java.io.IOException;
import java.util.Scanner;

public class Practica1 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String[] comando = {"C:\\Program Files\\ImageMagick-7.0.8-Q16\\magick.exe", "convert", "foto.jpg", "-resize", "25%", "-flip", "foto.png"};
        

        System.out.println("Nombre de la imagen original: ");
        comando[2] = sc.nextLine();
        System.out.println("Nuevo nombre de la imagen: ");
        comando[6] = sc.nextLine();
        System.out.println("Porcentaje de redicemsion: ");
        comando[4] = sc.nextLine() + "%";
        System.out.println("La volteamos?");
        comando[5] = sc.nextLine().equals("si") ? "-flip" : "-noop";

        ProcessBuilder pb = new ProcessBuilder(comando);
        
        for (int i = 0; i < 7; i++) {
            System.out.println(comando[i]);
        }

        pb.redirectErrorStream(true);
        Process proceso = pb.start();

        try (var reader = new java.io.BufferedReader(
                new java.io.InputStreamReader(proceso.getInputStream()))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                System.out.println(linea);
            }
        }

    }
}
