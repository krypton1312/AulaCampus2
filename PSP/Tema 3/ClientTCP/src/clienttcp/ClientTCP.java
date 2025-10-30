package clienttcp;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientTCP {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("localhost", 6000);
        
        DataInputStream input = new DataInputStream(client.getInputStream());
        
        System.out.println(input.readUTF());
        
        input.close();
        client.close();
    }
}
