package servidorhilos;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServidorHilos {
    public static void main(String[] args) throws IOException {
        ServerSocket servidor = new ServerSocket(6000);
        System.out.println("Servidor Iniciado....");
        
        while(true){
            Socket cliente = new Socket();
            cliente = servidor.accept();
            Servidor hiloCliente = new Servidor(cliente);
            hiloCliente.start();
        }
    }
}

class Servidor extends Thread{
    private Socket s;
    DataInputStream entrada;
    DataOutputStream salida;

    public Servidor(Socket s) throws IOException {
        this.s = s;
        this.entrada = new DataInputStream(s.getInputStream());
        this.salida = new DataOutputStream(s.getOutputStream());
    }
    
    @Override
    public void run(){
        String cadena = "";
        while(!cadena.trim().equals("*")){
            try {
                cadena = entrada.readUTF();
                salida.writeUTF(cadena.toUpperCase());
            } catch (IOException ex) {
                Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        try {
            entrada.close();
            salida.close();
            s.close();
        } catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
