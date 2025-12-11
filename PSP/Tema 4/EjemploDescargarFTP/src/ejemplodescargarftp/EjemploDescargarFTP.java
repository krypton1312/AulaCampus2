package ejemplodescargarftp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

public class EjemploDescargarFTP {
    public static void main(String[] args) throws IOException {
        FTPClient con = new FTPClient();
        
        con.connect("localhost");
        con.enterLocalPassiveMode();
        con.login("admin", "1111");
        
        con.setFileType(FTP.BINARY_FILE_TYPE);
        
        /*
        String fichero = "C:/Users/YEHORBURLACHENKO/Downloads/receipt-order-56-1765282107898.pdf";
        // C:\Users\YEHORBURLACHENKO\Desktop\login and password.txt
        
        BufferedInputStream entrada = new BufferedInputStream(new FileInputStream(fichero));
        
        if(con.storeFile("receipt.pdf", entrada)){
            System.out.println("listo");
        }else{
            System.out.println("no listo");
        }
        */
        BufferedOutputStream salida = new BufferedOutputStream(new FileOutputStream("C:/Users/YEHORBURLACHENKO/Desktop/receipt1.pdf"));
        
        if(con.retrieveFile("receipt.pdf", salida)){
            System.out.println("listo");
        }else{
            System.out.println("no listo");
        }
        salida.flush();
        salida.close();
        con.logout();
        con.disconnect();
    }
}
