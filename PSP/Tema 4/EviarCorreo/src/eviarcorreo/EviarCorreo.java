package eviarcorreo;

import java.io.IOException;
import java.io.Writer;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import org.apache.commons.net.smtp.AuthenticatingSMTPClient;
import org.apache.commons.net.smtp.SimpleSMTPHeader;

public class EviarCorreo {

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidKeySpecException {
        String servidor = "smtp.ionos.es";
        int puerto = 465;
        String login = "alumno@formaval.com";
        String password = "Pass.2025";
        String origen = "alumno@formaval.com";
        String destino = "josibla@campusaula.com";
        String asunto = "Saludos";
        String mensaje = "Mensaje de bienvenida";

        AuthenticatingSMTPClient cliente = new AuthenticatingSMTPClient("TLS", true);

        cliente.connect(servidor, puerto);

        cliente.ehlo(servidor);

        cliente.auth(AuthenticatingSMTPClient.AUTH_METHOD.LOGIN, login, password);

        SimpleSMTPHeader cabecera = new SimpleSMTPHeader(origen, destino, asunto);

        cliente.setSender(origen);

        cliente.addRecipient(destino);

        Writer envio = cliente.sendMessageData();

        envio.write(cabecera.toString());

        envio.write(mensaje);

        envio.close();
        cliente.logout();
        cliente.disconnect();
    }
}
