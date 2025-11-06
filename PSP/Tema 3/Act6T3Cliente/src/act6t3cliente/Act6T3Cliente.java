package act6t3cliente;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class Act6T3Cliente {
    public static void main(String[] args) throws SocketException, IOException {
        DatagramSocket socket = new DatagramSocket();
        File file = new File("sinopsis.txt");
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        byte[] buffer = new byte[1000];
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Titulo: ");
        String titulo = sc.nextLine();
        
        DatagramPacket paqEnviado = new DatagramPacket(titulo.getBytes(), titulo.getBytes().length , InetAddress.getLocalHost(), 6480);
        
        socket.send(paqEnviado);
        
        DatagramPacket paqRecibido = new DatagramPacket(buffer, buffer.length);
        
        socket.receive(paqRecibido);
        
        String mensaje = new String(paqRecibido.getData()).trim();
        System.out.println(mensaje);
        if(mensaje.equals("Pelicula con este titulo no ha sido encontrada")){
            System.out.println("Pelicula con este titulo no ha sido encontrada");
        }else{
            bw.write(mensaje);
            bw.flush();
        }
        bw.close();
        socket.close();
    }
}
