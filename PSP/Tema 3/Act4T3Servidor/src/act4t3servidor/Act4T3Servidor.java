package act4t3servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Act4T3Servidor {
    public static void main(String[] args) throws IOException {
        List<Participante> list = new ArrayList<>();
        list.add(new Participante("Juan", "Ros"));
        list.add(new Participante("Jose", "Molino"));
        list.add(new Participante("Kevin", "Smoke"));
        
        ServerSocket server = new ServerSocket(6000);
        System.out.println("Waiting for a client.....");
        
        Socket client = server.accept();
        System.out.println("Connected.");
        
        DataOutputStream output = new DataOutputStream(client.getOutputStream());
        DataInputStream input = new DataInputStream(client.getInputStream());
        
        int index = input.readInt();
        
        output.writeUTF("Posicion " + index + ": " + list.get(index-1).nombre() + " " + list.get(index-1).apellidos());
        output.flush(); 
        output.close();
        
        client.close();
        server.close();
        System.out.println("Disconnected.");
    }
}

record Participante(String nombre, String apellidos){};
