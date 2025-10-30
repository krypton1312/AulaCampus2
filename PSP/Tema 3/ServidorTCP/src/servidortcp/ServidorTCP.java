package servidortcp;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorTCP {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(6000);
        System.out.println("Waiting for a client.....");
        
        Socket client = server.accept();
        System.out.println("Connected.");
        
        DataOutputStream output = new DataOutputStream(client.getOutputStream());
        
        output.writeUTF("Welcome to the server!");
        output.flush();
        output.close();
        
        client.close();
        server.close();
        System.out.println("Disconnected.");
    }
}
