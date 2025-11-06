package clienteudp;

import java.io.IOException;
import java.net.*;


public class ClienteUDP {
    public static void main(String[] args) throws SocketException, UnknownHostException, IOException {
        DatagramSocket socketUDP = new DatagramSocket();
        
        byte[] buffer = new byte[1000];
        
        String mensaje = "Hola Mundo!!!";
        
        byte[] mensajeBytes = mensaje.getBytes();
        
        InetAddress host = InetAddress.getLocalHost();
        
        DatagramPacket paqueteEnviado = new DatagramPacket(mensajeBytes, mensajeBytes.length, host, 6789);
        
        socketUDP.send(paqueteEnviado);
        
        DatagramPacket paqRecibido = new DatagramPacket(buffer, buffer.length);
        
        socketUDP.receive(paqRecibido);
        
        String rec = new String(paqRecibido.getData()).trim();
        
        System.out.println(rec.length());
        
        socketUDP.close();
    }
}
