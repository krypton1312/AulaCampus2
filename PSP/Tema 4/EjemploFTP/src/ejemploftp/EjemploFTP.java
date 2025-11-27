package ejemploftp;

import java.io.IOException;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

public class EjemploFTP {
    public static void main(String[] args) throws IOException {
        FTPClient con = new FTPClient();
        
        con.connect("localhost");
        con.enterLocalPassiveMode();
        con.login("admin", "1111");
        
        
        System.out.println(con.getReplyString());
        System.out.println("Codigo respuesta: " + con.getReplyCode());
        
        
        FTPFile[] files = con.listFiles();
        for(FTPFile f: files){
            System.out.println(f.getName());
        }
        
        con.logout();
        System.out.println("Desconectado.");
        con.disconnect();
    }
}
