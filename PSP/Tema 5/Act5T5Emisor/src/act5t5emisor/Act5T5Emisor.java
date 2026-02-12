package act5t5emisor;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.Key;
import java.security.KeyFactory;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.Scanner;
import javax.crypto.Cipher;

public class Act5T5Emisor {

    private static final Path RUTA_FICHERO = Path.of("C:\\Users\\YEHORBURLACHENKO\\AulaCampus2\\PSP\\Tema 5\\datos.txt");
    private static final Path RUTA_CLAVE_PUBLICA = Path.of("C:\\Users\\YEHORBURLACHENKO\\AulaCampus2\\PSP\\Tema 5\\public.key");

    public static void main(String[] args) throws Exception {

        if (!Files.exists(RUTA_CLAVE_PUBLICA)) {
            System.out.println("No existe public.key");
            return;
        }

        String clavePublicaB64 = Files.readString(RUTA_CLAVE_PUBLICA).trim();
        Key clavePublica = stringToKey(clavePublicaB64);

        Scanner sc = new Scanner(System.in);
        System.out.print("Texto a encriptar: ");
        String mensaje = sc.nextLine();

        String cifradoB64 = cifrar(mensaje, clavePublica);

        Files.writeString(RUTA_FICHERO, cifradoB64, StandardCharsets.UTF_8);

        System.out.println("Mensaje cifrado guardado en datos.txt");
    }

    public static Key stringToKey(String clave) throws Exception {
        byte[] claveBytes = Base64.getDecoder().decode(clave);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        return kf.generatePublic(new X509EncodedKeySpec(claveBytes));
    }

    public static String cifrar(String texto, Key clavePublica) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.ENCRYPT_MODE, clavePublica);
        byte[] cifrado = cipher.doFinal(texto.getBytes(StandardCharsets.UTF_8));
        return Base64.getEncoder().encodeToString(cifrado);
    }
}
