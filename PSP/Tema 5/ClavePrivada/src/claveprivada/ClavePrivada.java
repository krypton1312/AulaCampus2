package claveprivada;

import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class ClavePrivada {
    public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        // Creamos mensaje y clave
        String mensaje = "Aula Campus Instituto de FP";
        String clave = "mario";
    
        System.out.println("Mensaje Original: " + mensaje);
        
        // Encriptamos mensaje con clave privada
        String mensajeEncriptado = 
             encriptar(mensaje, clave);
        // Mostramos mensaje encriptado AES y en Base64
        System.out.println("Mensaje Encriptado AES: " +
            mensajeEncriptado);
        
        // Desencriptar el mensaje Encriptado con la clave
        String mensajeDesencriptado = 
                desencriptar(mensajeEncriptado, clave);
        // Mostramos el mensaje desencriptado y vemos que
        // coincide con el mensaje original
        System.out.println("Mensaje Desencriptado AES: " + 
                mensajeDesencriptado);    
    }
    
    
    // Metodo crearClave que genera clave para encriptar 
    // y desencriptar mensajes.
    // La clave se pasa como un String y 
    // se encripta con el algoritmo SHA-1
    // para devolver una instancia de la 
    // clase SecretKeySpec que utilizaremos para
    // encriptar/desencriptar el mensaje
    public static SecretKeySpec crearClave(String clave) throws NoSuchAlgorithmException{
        // Necesitamos Algoritmo de una sola via SHA
        // para crear la clave AES
        // Convertimos la clave en array de bytes
        byte[] claveBytes = clave.getBytes();
        // Creamos instancia de algoritmo 
        // para encriptar la clave
        MessageDigest algSHA = 
             MessageDigest.getInstance("SHA-256");
        // Le pasamos al algoritmo la clave para encriptar
        algSHA.update(claveBytes);
        // Obtenemos la clave encriptada como un array de 
        // bytes
        byte[] claveEncriptada = algSHA.digest();
        // La clave AES deben tener un tamaño de 16 bytes por lo que extraemos 
        // los primeros 16 bytes de la clave encriptada
        claveEncriptada = Arrays.copyOf(claveEncriptada,16);
        // Creamos la clave simetrica del tipo SecretKeySpec
        // para utilizar en el proceso de 
        // encriptado/desencriptado del 
        // mensaje con algoritmo AES      
        SecretKeySpec clavePrivada = 
            new SecretKeySpec(claveEncriptada, "AES");
        return clavePrivada;
    }
    
    public static String encriptar(String datos, String clave) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException{
        // Genera la clave privada AES a partir del String
        SecretKeySpec claveAES = crearClave(clave);
        // (1) Creamos instancia de algritmo AES
        Cipher cifrado = 
            Cipher.getInstance("AES/ECB/PKCS5Padding");
        // (2)inicializamos el algoritmo indicando si
        // vamos a encriptar o desencriptar y la clave encriptada
        cifrado.init(Cipher.ENCRYPT_MODE, claveAES);
        // (3) Convertimos los datos a array de bytes
        byte[] datosEncriptar = datos.getBytes();
        // (4)Encriptamos los datos en bytes con el método
        // .doFinal()
        byte[] bytesEncriptados = 
             cifrado.doFinal(datosEncriptar);
        // Convertirmnos los bytes encriptados a un String
        // en base 64 y lo retornamos
        String encriptado = Base64.getEncoder().
              encodeToString(bytesEncriptados);
        return encriptado;
    }
    
    public static String desencriptar(String datosEncriptados,
        String clave) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException{
        // Genera la clave privada AES a partir del String
        SecretKeySpec claveAES = crearClave(clave);
        // (1) Creamos instancia de algritmo AES
        Cipher cifrado = 
            Cipher.getInstance("AES/ECB/PKCS5Padding");        
        // (2)inicializamos el algoritmo indicando si
        // vamos a encriptar o desencriptar y la clave encriptada
        cifrado.init(Cipher.DECRYPT_MODE, claveAES);
        // Decodifica el mensaje de Base64
        byte[] bytesEncriptado =
            Base64.getDecoder().decode(datosEncriptados);
        // Mediante el método .doFinal() desencriptamos 
        // el mensaje
        byte[] bytesDesencriptado = 
             cifrado.doFinal(bytesEncriptado);
        // Convertimos a String el mensaje desecriptado en bytes
        // y lo retornamos
        String datos = new String(bytesDesencriptado);
        return datos;
    }
}
