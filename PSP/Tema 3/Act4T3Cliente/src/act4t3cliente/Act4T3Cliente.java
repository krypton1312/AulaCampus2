package act4t3cliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Act4T3Cliente {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        Socket client = new Socket("localhost", 6000);

        DataOutputStream output = new DataOutputStream(client.getOutputStream());
        DataInputStream input = new DataInputStream(client.getInputStream());
        
        System.out.print("Intoduce posicion: ");
        int index = sc.nextInt();
        sc.nextLine();
        
        output.writeInt(index);
        
        System.out.println(input.readUTF());

        input.close();
        client.close();
    }
}
