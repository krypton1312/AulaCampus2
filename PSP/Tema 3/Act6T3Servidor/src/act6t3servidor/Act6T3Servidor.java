package act6t3servidor;

import java.io.IOException;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

public class Act6T3Servidor {
    public static void main(String[] args) throws SocketException, IOException {
        List<Libro> libros = new ArrayList<>();
        libros.add(new Libro("El principito ? Antoine de Saint-Exupery","Un piloto perdido en el desierto se encuentra con un pequeño príncipe que viene de otro planeta. A través de sus conversaciones, el principito enseña valiosas lecciones sobre la amistad, el amor y la verdadera esencia de las cosas, que solo se ve con el corazón."));
        libros.add(new Libro("Harry Potter y la piedra filosofal ? J.K. Rowling", "Harry, un niño huérfano que vive con sus crueles tíos, descubre que es un mago. Al ingresar al colegio Hogwarts de magia y hechicería, encuentra amigos, enemigos y un misterioso secreto sobre su pasado y el poder oscuro que amenaza su mundo."));
        libros.add(new Libro("Cien años de soledad ? Gabriel García Marquez", "La novela narra la historia de la familia Buendía a lo largo de varias generaciones en el mítico pueblo de Macondo. Es una obra que mezcla la realidad con la fantasía, explorando el amor, la soledad y el destino inevitable de sus personajes."));
        
        DatagramSocket socket = new DatagramSocket(6480);
        
        byte[] buffer = new byte[1000];
        
        System.out.println("Esperando paquetes...");
        while(true){
            DatagramPacket paqRecibido = new DatagramPacket(buffer, buffer.length);
            socket.receive(paqRecibido);
            
            String titulo = new String(paqRecibido.getData()).trim();
            
            System.out.println("Titulo recibido: " + titulo);
            
            DatagramPacket paqueteEnviado;
            for(Libro l: libros){
                if(l.titulo().contains(titulo)){
                    paqueteEnviado = new DatagramPacket(l.sinopsis().getBytes(), l.sinopsis().getBytes().length, paqRecibido.getAddress(), paqRecibido.getPort());
                    socket.send(paqueteEnviado);
                }else{
                    byte[] mensaje = "Pelicula con este titulo no ha sido encontrada".getBytes();
                    paqueteEnviado = new DatagramPacket(mensaje, mensaje.length, paqRecibido.getAddress(), paqRecibido.getPort());
                    socket.send(paqueteEnviado);
                }
            }
        }
    }
}


record Libro(String titulo, String sinopsis){};
