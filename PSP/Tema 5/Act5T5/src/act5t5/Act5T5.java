package act5t5;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.util.Base64;
import javax.crypto.Cipher;

public class Act5T5 {

    private static final Path RUTA_FICHERO = Path.of("C:\\Users\\YEHORBURLACHENKO\\AulaCampus2\\PSP\\Tema 5\\datos.txt");
    private static final Path RUTA_CLAVE_PUBLICA = Path.of("C:\\Users\\YEHORBURLACHENKO\\AulaCampus2\\PSP\\Tema 5\\public.key");

    public static void main(String[] args) throws Exception {

        KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
        kpg.initialize(2048);
        KeyPair kp = kpg.generateKeyPair();

        String clavePublicaB64 = Base64.getEncoder()
                .encodeToString(kp.getPublic().getEncoded());

        Files.writeString(RUTA_CLAVE_PUBLICA, clavePublicaB64, StandardCharsets.UTF_8);

        System.out.println("Clave publica generada y guardada en public.key");
        System.out.println("Esperando mensaje en datos.txt...");

        while (!Files.exists(RUTA_FICHERO)) {
            Thread.sleep(1000);
        }

        String mensajeCifradoB64 = Files.readString(RUTA_FICHERO).trim();

        String mensajeDescifrado = descifrar(mensajeCifradoB64, kp.getPrivate());

        System.out.println("Mensaje descifrado: " + mensajeDescifrado);
    }

    public static String descifrar(String cifradoB64, Key clavePrivada) throws Exception {
        byte[] cifrado = Base64.getDecoder().decode(cifradoB64);
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.DECRYPT_MODE, clavePrivada);
        byte[] plano = cipher.doFinal(cifrado);
        return new String(plano, StandardCharsets.UTF_8);
    }
}
