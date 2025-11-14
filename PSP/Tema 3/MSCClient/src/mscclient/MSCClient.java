package mscclient;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MSCClient {
    public static void main(String[] args) throws IOException {
        int puerto = 12345;
        
        MulticastSocket ms = new MulticastSocket(puerto);
        
        InetAddress grupo = InetAddress.getByName("225.0.0.3");
        
        ms.joinGroup(grupo);
        String mensaje = "";
        while(!mensaje.trim().equals("*")){
            byte[] buffer = new byte[1000];
            
            DatagramPacket dp = new DatagramPacket(buffer, buffer.length);
            
            ms.receive(dp);
            
            mensaje = new String(dp.getData());
            
            System.out.println("Recibo: " + mensaje.trim());
        }
        
        ms.leaveGroup(grupo);
        
        ms.close();
        
        System.out.println("socket cerrado..");
    }
}
