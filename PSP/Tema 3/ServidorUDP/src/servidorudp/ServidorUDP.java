package servidorudp;

import java.io.IOException;
import java.net.*;
import java.net.SocketException;

public class ServidorUDP {

    public static void main(String[] args) throws SocketException, IOException {
        DatagramSocket socketUDP = new DatagramSocket(6789);

        byte[] buffer = new byte[1000];

        System.out.println("esperando paquetes./.././././");
        while (true) {
            DatagramPacket paqueteRecibido = new DatagramPacket(buffer, buffer.length);
            socketUDP.receive(paqueteRecibido);
            System.out.println(paqueteRecibido.getAddress() + ":" + paqueteRecibido.getPort());

            String mensajeRespuesta = "Recibido";
            
            DatagramPacket paqueteEnviado = new DatagramPacket(mensajeRespuesta.getBytes(), mensajeRespuesta.getBytes().length, paqueteRecibido.getAddress(), paqueteRecibido.getPort());
            socketUDP.send(paqueteEnviado);            
        }
        
        //socketUDP.close();
    }
}
