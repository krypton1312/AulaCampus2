package mscservidor;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class MSCServidor {
    public static void main(String[] args) throws UnknownHostException, IOException {
        Scanner sc = new Scanner(System.in);
        
        MulticastSocket ms = new MulticastSocket();
        
        int puerto = 12345;
        
        InetAddress grupo = InetAddress.getByName("225.0.0.3");
        
        String cadena = "";
        
        while(!cadena.trim().equals("*")){
            System.out.println("Mensaje: ");
            cadena = sc.nextLine();
            
            DatagramPacket dp = new DatagramPacket(cadena.getBytes(), cadena.length(), grupo, puerto);
            
            ms.send(dp);
        }
        
        ms.close();
        System.out.println("Cerrado..");
    }
}
