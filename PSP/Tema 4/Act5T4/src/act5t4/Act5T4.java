package act5t4;

import correopop.ShowMessage;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;
import org.apache.commons.net.pop3.POP3Client;
import org.apache.commons.net.pop3.POP3MessageInfo;
import org.apache.commons.net.pop3.POP3SClient;

public class Act5T4 {
    public static void main(String[] args) throws IOException, Exception {
        String servidor = "pop.ionos.es";
        String usuario = "alumno@formaval.com";
        String password = "Pass.2025";
        int puerto = 995;
        
        POP3Client cliente = new POP3SClient("TLS", true);
        
        cliente.connect(servidor);
        
        if(!cliente.login(usuario, password)){
            System.out.println("error brother");
            cliente.disconnect();
            System.exit(0);
        }
        
        POP3MessageInfo[] mensajes = cliente.listMessages();
        
        for(POP3MessageInfo mensaje: mensajes){
            BufferedReader buffer = (BufferedReader) cliente.retrieveMessage(mensaje.number);
            String[] datos;
            
            ShowMessage miCorreoPOP = new ShowMessage();
            datos = miCorreoPOP.obtenerDatosMensaje(buffer, mensaje.number);
            System.out.println("Mensaje: " + datos[0]);
            System.out.println("Remitente: " + datos[1]);
            System.out.println("Asunto: " + datos[2]);
            System.out.println("Fecha: " + datos[3]);
            System.out.println("=========================================");
        }
        
        System.out.println("Elige mensaje para leer su contenido: ");
        Scanner sc = new Scanner(System.in);
        
        int messageId = sc.nextInt();
        sc.nextLine();
        BufferedReader buffer = (BufferedReader) cliente.retrieveMessage(messageId);
        ShowMessage showM = new ShowMessage();
        String[] datos = showM.obtenerDatosMensaje(buffer, messageId);
        System.out.println("Contenido de mensaje:\n" + datos[4]);
    }
}
