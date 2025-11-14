package practice3cliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Practice3Cliente {

    public static void main(String[] args) throws IOException {
        Socket cliente = new Socket("localhost", 6000);

        DataInputStream entrada = new DataInputStream(cliente.getInputStream());
        DataOutputStream salida = new DataOutputStream(cliente.getOutputStream());

        Scanner sc = new Scanner(System.in);

        String mensaje;
        System.out.println("Adivina un numero, tienes 5 intentos: ");

        do {
            System.out.print("Numero: ");
            salida.writeInt(sc.nextInt());
            sc.nextLine();

            mensaje = entrada.readUTF();
            System.out.println(mensaje);

            if (mensaje.startsWith("Has") || mensaje.startsWith("Lo siento")) {
                System.out.println(entrada.readUTF());
                break;
            }

        } while (!mensaje.equals("Has acertado el numero, congratulations!")
                && !mensaje.equals("Lo siento, no lo has podido acertar."));

        entrada.close();
        salida.close();
        cliente.close();
    }
}
