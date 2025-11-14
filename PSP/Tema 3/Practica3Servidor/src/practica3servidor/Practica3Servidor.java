package practica3servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class Practica3Servidor {
    public static void main(String[] args) throws IOException {
        ServerSocket servidor = new ServerSocket(6000);
        
        System.out.println("Servidor iniciado..");
        
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
    private DataInputStream entrada;
    private DataOutputStream salida;
    private boolean isNumeroAcertado = false;
    private LocalTime inicio;
    private LocalTime fin;
    private int intentos = 0;
    
    public Servidor(Socket s) throws IOException{
        this.s = s;
        this.entrada = new DataInputStream(s.getInputStream());
        this.salida = new DataOutputStream(s.getOutputStream());
    }
    
    @Override
    public void run(){
        int numero = (int)(Math.random()*10)+1; 
        inicio = LocalTime.now();
        
        for(int i = 0; i < 5; i++){
            try {
                int intento = entrada.readInt();
                intentos++;
                
                if (intento == numero) {
                    salida.writeUTF("Has acertado el numero, congratulations!");
                    isNumeroAcertado = true;
                    fin = LocalTime.now();
                    salida.writeUTF("Has hecho " + intentos + " intentos y has tardado " +
                        ChronoUnit.SECONDS.between(inicio, fin) + " segundos.");
                    return;
                } else {
                    if (i < 4) {
                        salida.writeUTF("No.");
                    }
                }
            } catch (IOException ex) {}
        }
        
        if (!isNumeroAcertado){
            try {
                fin = LocalTime.now();
                salida.writeUTF("Lo siento, no lo has podido acertar.");
                salida.writeUTF("Has hecho " + intentos + " intentos y has tardado " +
                        ChronoUnit.SECONDS.between(inicio, fin) + " segundos.");
            } catch (IOException ex) {}
        }
        
        try {
            entrada.close();
            salida.close();
            s.close();
        } catch (IOException ex) {}
    }
}
