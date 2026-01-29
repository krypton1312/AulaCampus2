package unavia;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class UnaVia {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        MessageDigest algoritmo = MessageDigest.getInstance("SHA-256");
        
        String mensaje = "Aula Campus";
        
        byte[] mensajeBytes = mensaje.getBytes();
        
        algoritmo.update(mensajeBytes);
        
        byte[] mensajeEncriptado = algoritmo.digest();
        
        //String mensajeEcriptadoHex = HexFormat.of().formatHex(mensajeEncriptado);
        //System.out.println(mensajeEcriptadoHex);
        
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Clave Accesso: ");
        String clave = sc.nextLine();
         
        byte[] claveBytes = clave.getBytes();
        algoritmo.update(claveBytes);
        byte[] claveEncriptada = algoritmo.digest();
        
        if(MessageDigest.isEqual(mensajeEncriptado, claveEncriptada)){
            System.out.println("login");
        }else{
            System.out.println("not login");
        }
        
    }
}
