package act4t5desincriptar;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Scanner;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class Act4T5Desincriptar {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        File file = new File("C:\\Users\\YEHORBURLACHENKO\\AulaCampus2\\PSP\\Tema 5\\Act4T5Encriptar\\datos.txt");
        String datos = leerDatosDelFichero(file);
        System.out.println("Datos encriptados: " + datos);
        System.out.println("Introduce la clave: ");
        String clave = sc.nextLine();
        System.out.println("Datos desincriptados: ");
        System.out.println(desencriptar(datos, clave));
        
    }
    private static String leerDatosDelFichero(File file) throws FileNotFoundException, IOException{
        BufferedReader br = new BufferedReader(new FileReader(file));
        
        String linea = "";
        String datos = "";
        while ((linea = br.readLine()) != null) {
                datos += linea;
        }
        return datos;
    }
    private static SecretKeySpec crearClave(String clave) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        byte[] claveBytes = clave.getBytes("UTF-8");
        MessageDigest algSHA = MessageDigest.getInstance("SHA-1");
        algSHA.update(claveBytes);
        byte[] claveEncriptacion = algSHA.digest();
        claveEncriptacion = Arrays.copyOf(claveEncriptacion, 16);
        SecretKeySpec clavePrivada = new SecretKeySpec(claveEncriptacion, "AES");
        return clavePrivada;
    }
    
    private static String desencriptar(String datosEncriptados, String claveSecreta)
            throws UnsupportedEncodingException, NoSuchAlgorithmException,
            InvalidKeyException, NoSuchPaddingException,
            IllegalBlockSizeException, BadPaddingException {
        // Genera la clave secreta encriptada
        SecretKeySpec secretKey = crearClave(claveSecreta);
        // Crea la instancia Cipher para cifrar mensaje con algoritmo AES
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
        // Inicializa el descifrado con la clave secreta
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        // Decodifica el mensaje de Base64
        byte[] bytesEncriptados = Base64.getDecoder().decode(datosEncriptados);
        // Mediante el método doFinal cifra el mensaje obteniendo el
        // mensaje descifrado en bytes
        byte[] datosDesencriptados = cipher.doFinal(bytesEncriptados);
        // Convertimos bytes de mensaje descifrado a String
        String datos = new String(datosDesencriptados);
        // Retornamos el mensaje descifrado como una cadena de texto
        return datos;
    }
    
}
