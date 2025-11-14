package clientehilos;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ClienteHilos {
    public static void main(String[] args) throws IOException {
        String host = "localhost";
        int puerto = 6000;
        
        Socket cliente = new Socket(host, puerto);
        
        DataInputStream entrada = new DataInputStream(cliente.getInputStream());
        DataOutputStream salida = new DataOutputStream(cliente.getOutputStream());
        
        Scanner sc = new Scanner(System.in);
        String mensaje = "";
        do{
        System.out.println("Introduce texto:" );
        
        mensaje = sc.nextLine();
        salida.writeUTF(mensaje);
        
        System.out.println("Recibido: " + entrada.readUTF());
        }while(!mensaje.trim().equals("*"));
        
        entrada.close();
        salida.close();
        cliente.close();
        
    }
}
