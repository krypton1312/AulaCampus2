package act4t5encriptar;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashMap;
import java.util.Scanner;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

public class Act4T5Encriptar {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        HashMap<String, String> datosCliente = getClientData(sc);

        File file = new File(datosCliente.get("fileName"));

        FileWriter fw = new FileWriter(file);
        fw.write(encriptar(datosCliente.get("text"), datosCliente.get("secretKey")));
        fw.close();

    }

    private static HashMap<String, String> getClientData(Scanner sc) {
        HashMap<String, String> data = new HashMap<String, String>();
        System.out.println("Introduce el nombre del fichero: ");
        data.put("fileName", sc.nextLine());
        System.out.println("Introduce la clave secreta: ");
        data.put("secretKey", sc.nextLine());
        System.out.println("Intoduce el texto: ");
        data.put("text", sc.nextLine());
        return data;
    }

    private static String encriptar(String texto, String claveSecreta) throws UnsupportedEncodingException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        SecretKeySpec secretKey = crearClave(claveSecreta);
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] datosEncriptar = texto.getBytes("UTF-8");
        byte[] bytesEncriptados = cipher.doFinal(datosEncriptar);
        String encriptado = Base64.getEncoder().encodeToString(bytesEncriptados);
        return encriptado;

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

}
