package actividad4t4psp;

import java.awt.event.*;
import java.io.Writer;
import javax.swing.*;
import org.apache.commons.net.smtp.AuthenticatingSMTPClient;
import org.apache.commons.net.smtp.SimpleSMTPHeader;

public class Formulario extends JFrame implements ActionListener {

    JPanel miPanel;
    JLabel destinatarioT, asuntoT, mensajeT, confirmacionT;
    JTextField destinatarioTF, asuntoTF;
    JTextArea mensajeTA;
    JButton enviarB, limpiarB, salirB;

    public Formulario() {
        this.setTitle("Correo Saliente");
        this.setSize(600, 400);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        miPanel = new JPanel();
        miPanel.setLayout(null);

        destinatarioT = new JLabel("Destinatario:");
        destinatarioT.setBounds(10, 20, 150, 30);
        miPanel.add(destinatarioT);

        asuntoT = new JLabel("Asunto:");
        asuntoT.setBounds(35, 50, 150, 30);
        miPanel.add(asuntoT);

        mensajeT = new JLabel("Mensaje:");
        mensajeT.setBounds(27, 75, 150, 30);
        miPanel.add(mensajeT);

        confirmacionT = new JLabel();
        confirmacionT.setBounds(350, 250, 200, 30);
        miPanel.add(confirmacionT);

        destinatarioTF = new JTextField();
        destinatarioTF.setBounds(100, 20, 200, 30);
        miPanel.add(destinatarioTF);

        asuntoTF = new JTextField();
        asuntoTF.setBounds(100, 50, 200, 30);
        miPanel.add(asuntoTF);

        mensajeTA = new JTextArea();
        mensajeTA.setBounds(15, 110, 300, 200);
        miPanel.add(mensajeTA);

        enviarB = new JButton("Enviar");
        enviarB.setBounds(400, 110, 100, 30);
        miPanel.add(enviarB);
        enviarB.addActionListener(this);

        limpiarB = new JButton("Limpiar");
        limpiarB.setBounds(400, 150, 100, 30);
        miPanel.add(limpiarB);
        limpiarB.addActionListener(this);

        salirB = new JButton("Salir");
        salirB.setBounds(400, 190, 100, 30);
        miPanel.add(salirB);
        salirB.addActionListener(this);

        this.add(miPanel);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == salirB) {
            System.exit(0);
        } else if (e.getSource() == enviarB) {
            enviarCorreo();
        } else if (e.getSource() == limpiarB) {
            limpiarCampos();
        }
    }

    private void enviarCorreo() {
        try {
            String servidor = "smtp.ionos.es";
            int puerto = 465;
            String login = "alumno@formaval.com";
            String password = "Pass.2025";
            String origen = "alumno@formaval.com";

            AuthenticatingSMTPClient cliente = new AuthenticatingSMTPClient("TLS", true);

            cliente.connect(servidor, puerto);

            cliente.ehlo(servidor);

            cliente.auth(AuthenticatingSMTPClient.AUTH_METHOD.LOGIN, login, password);

            SimpleSMTPHeader cabecera = new SimpleSMTPHeader(origen, destinatarioTF.getText(), asuntoTF.getText());

            cliente.setSender(origen);

            cliente.addRecipient(destinatarioTF.getText());

            Writer envio = cliente.sendMessageData();

            envio.write(cabecera.toString());

            envio.write(mensajeTA.getText());

            envio.close();
            cliente.logout();
            cliente.disconnect();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    private void limpiarCampos() {
        destinatarioTF.setText("");
        mensajeTA.setText("");
        asuntoTF.setText("");
    }
}
