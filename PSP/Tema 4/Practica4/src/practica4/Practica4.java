package practica4;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;

public class Practica4 {

    public static void main(String[] args) {
        FTPClient con = new FTPClient();
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Host (ej: localhost): ");
            String host = sc.nextLine().trim();
            if (host.isEmpty()) host = "localhost";

            System.out.print("Usuario: ");
            String user = sc.nextLine().trim();

            System.out.print("Password: ");
            String pass = sc.nextLine().trim();

            con.connect(host);
            int reply = con.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                System.out.println("Servidor rechazó la conexión. Reply=" + reply);
                con.disconnect();
                return;
            }

            con.enterLocalPassiveMode();
            if (!con.login(user, pass)) {
                System.out.println("Login incorrecto.");
                con.disconnect();
                return;
            }

            con.setFileType(FTP.BINARY_FILE_TYPE);

            System.out.println("\nConectado. Directorio actual: " + con.printWorkingDirectory());

            boolean running = true;
            while (running) {
                System.out.println("\n========= MENU FTP =========");
                System.out.println("1) Cambiar directorio (CWD)");
                System.out.println("2) Listar contenido (LS)");
                System.out.println("3) Renombrar fichero (RNFR/RNTO)");
                System.out.println("4) Eliminar fichero (DELE)");
                System.out.println("5) Descargar fichero (RETR)");
                System.out.println("6) Subir fichero (STOR)");
                System.out.println("0) Salir (logout/disconnect)");
                System.out.print("Opción: ");

                String op = sc.nextLine().trim();

                switch (op) {
                    case "1" -> cmdCwd(con, sc);
                    case "2" -> cmdLs(con);
                    case "3" -> cmdRename(con, sc);
                    case "4" -> cmdDelete(con, sc);
                    case "5" -> cmdDownload(con, sc);
                    case "6" -> cmdUpload(con, sc);
                    case "0" -> running = false;
                    default -> System.out.println("Opción inválida.");
                }
            }
            con.logout();
            con.disconnect();
            System.out.println("Desconectado. Fin.");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            try {
                if (con.isConnected()) {
                    con.logout();
                    con.disconnect();
                }
            } catch (IOException ignored) {}
        } finally {
            sc.close();
        }
    }

    // ---------------- COMMANDS ----------------

    private static void cmdCwd(FTPClient con, Scanner sc) throws IOException {
        System.out.print("Nuevo directorio (ej: / o /carpeta): ");
        String dir = sc.nextLine().trim();
        if (dir.isEmpty()) dir = "/";

        if (con.changeWorkingDirectory(dir)) {
            System.out.println("OK. Directorio actual: " + con.printWorkingDirectory());
        } else {
            System.out.println("No se pudo cambiar al directorio: " + dir);
        }
    }

    private static void cmdLs(FTPClient con) throws IOException {
        FTPFile[] files = con.listFiles();
        System.out.println("\n--- LISTADO: " + con.printWorkingDirectory() + " ---");
        System.out.printf("%-35s %-12s %-12s%n", "NOMBRE", "TAMAÑO", "TIPO");
        System.out.println("---------------------------------------------------------------");

        for (FTPFile f : files) {
            String name = f.getName();
            long size = f.getSize();
            String type = f.isDirectory() ? "DIR" : (f.isFile() ? "FILE" : "OTHER");
            System.out.printf("%-35s %-12d %-12s%n", name, size, type);
        }
    }

    private static void cmdRename(FTPClient con, Scanner sc) throws IOException {
        System.out.print("Nombre actual (ej: a.txt): ");
        String oldName = sc.nextLine().trim();

        System.out.print("Nuevo nombre (ej: b.txt): ");
        String newName = sc.nextLine().trim();

        if (oldName.isEmpty() || newName.isEmpty()) {
            System.out.println("Nombres inválidos.");
            return;
        }

        if (con.rename(oldName, newName)) {
            System.out.println("Renombrado: " + oldName + " -> " + newName);
        } else {
            System.out.println("No se pudo renombrar (¿existe? ¿permisos?).");
        }
    }

    private static void cmdDelete(FTPClient con, Scanner sc) throws IOException {
        System.out.print("Fichero a eliminar (ej: a.txt): ");
        String name = sc.nextLine().trim();

        if (name.isEmpty()) {
            System.out.println("Nombre inválido.");
            return;
        }

        if (con.deleteFile(name)) {
            System.out.println("Eliminado: " + name);
        } else {
            System.out.println("No se pudo eliminar (¿es directorio? ¿permisos?).");
        }
    }

    private static void cmdDownload(FTPClient con, Scanner sc) throws IOException {
        System.out.print("Fichero remoto a descargar (ej: receipt.pdf): ");
        String remoteName = sc.nextLine().trim();

        System.out.print("Ruta local destino (ej: C:/Users/.../receipt1.pdf): ");
        String localPath = sc.nextLine().trim();

        if (remoteName.isEmpty() || localPath.isEmpty()) {
            System.out.println("Datos inválidos.");
            return;
        }

        File outFile = new File(localPath);
        File parent = outFile.getParentFile();
        if (parent != null && !parent.exists()) parent.mkdirs();

        try (BufferedOutputStream salida = new BufferedOutputStream(new FileOutputStream(outFile))) {
            if (con.retrieveFile(remoteName, salida)) {
                System.out.println("Descarga lista: " + localPath);
            } else {
                System.out.println("Descarga fallida.");
            }
            salida.flush();
        }
    }

    private static void cmdUpload(FTPClient con, Scanner sc) throws IOException {
        System.out.print("Ruta local del fichero (ej: C:/Users/.../file.pdf): ");
        String localPath = sc.nextLine().trim();

        System.out.print("Nombre remoto destino (enter = mismo nombre): ");
        String remoteName = sc.nextLine().trim();

        if (localPath.isEmpty()) {
            System.out.println("Ruta inválida.");
            return;
        }

        File inFile = new File(localPath);
        if (!inFile.exists() || !inFile.isFile()) {
            System.out.println("No existe el archivo local.");
            return;
        }

        if (remoteName.isEmpty()) {
            remoteName = inFile.getName();
        }

        try (BufferedInputStream entrada = new BufferedInputStream(new FileInputStream(inFile))) {
            if (con.storeFile(remoteName, entrada)) {
                System.out.println("Subida lista: " + remoteName);
            } else {
                System.out.println("Subida fallida.");
            }
        }
    }
}
