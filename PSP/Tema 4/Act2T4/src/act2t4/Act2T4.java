package act2t4;

import java.io.IOException;
import java.util.Scanner;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;

public class Act2T4 {

    public static void main(String[] args) throws IOException {
        FTPClient con = new FTPClient();
        Scanner sc = new Scanner(System.in);

        try {
            con.connect("localhost");
            System.out.println("Conectado a localhost.");
        } catch (Exception e) {
            System.out.println("No se ha podido conectar al servidor FTP.");
            return;
        }

        int opcion = -1;

        while (opcion != 0) {
            System.out.println("\nMENU:");
            System.out.println("1.- Conectarse al servidor mediante usuario y contraseña introducidos por teclado.");
            System.out.println("2.- Mostrar el directorio actual.");
            System.out.println("3.- Mostrar los ficheros del directorio actual.");
            System.out.println("4.- Mostrar las Carpetas del directorio actual.");
            System.out.println("5.- Mostrar los Enlaces Simbólicos del directorio actual.");
            System.out.println("6.- Cambiar el directorio actual al directorio introducido por teclado.");
            System.out.println("7.- Mostrar los ficheros de más de un determinado tamaño introducido por teclado.");
            System.out.println("8.- Mostrar los ficheros de una determinada extensión introducida por teclado.");
            System.out.println("9.- Mostrar los ficheros que en el nombre contienen un determinado texto.");
            System.out.println("0.- Desconectar del Servidor.");
            System.out.print("Elige una opcion: ");

            if (!sc.hasNextInt()) {
                System.out.println("Debes introducir un número.");
                sc.nextLine();
                continue;
            }

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    login(con, sc);
                    break;
                case 2:
                    getCurrentDirectory(con);
                    break;
                case 3:
                    getAllFiles(con);
                    break;
                case 4:
                    getAllDirectories(con);
                    break;
                case 5:
                    getAllLinks(con);
                    break;
                case 6:
                    changeWorkingDirectory(con, sc);
                    break;
                case 7:
                    getFilesMoreThen(con, sc);
                    break;
                case 8:
                    getFilesByExtention(con, sc);
                    break;
                case 9:
                    getFilesNameContains(con, sc);
                    break;
                case 0:
                    con.logout();
                    System.out.println("Desconectado del servidor.");
                    break;
                default:
                    System.out.println("Opción incorrecta.");
            }
        }

        con.disconnect();
        sc.close();
    }

    public static void login(FTPClient con, Scanner sc) throws IOException {
        System.out.print("Login: ");
        String login = sc.nextLine();

        System.out.print("Password: ");
        String password = sc.nextLine();

        if (con.login(login, password)) {
            System.out.println("Login correcto.");
            con.enterLocalPassiveMode();
        } else {
            System.out.println("Login incorrecto.");
        }
    }

    public static void getCurrentDirectory(FTPClient con) throws IOException {
        System.out.println("Directorio actual: " + con.printWorkingDirectory());
    }

    public static void getAllFiles(FTPClient con) throws IOException {
        FTPFile[] files = con.listFiles();
        System.out.println("Ficheros en el directorio actual:");
        for (FTPFile f : files) {
            if (f.isFile()) {
                System.out.println(f.getName());
            }
        }
    }

    public static void getAllDirectories(FTPClient con) throws IOException {
        FTPFile[] dirs = con.listDirectories();
        System.out.println("Directorios en el directorio actual:");
        for (FTPFile d : dirs) {
            System.out.println(d.getName());
        }
    }

    public static void getAllLinks(FTPClient con) throws IOException {
        FTPFile[] files = con.listFiles();
        System.out.println("Enlaces simbólicos en el directorio actual:");
        for (FTPFile file : files) {
            if (file.getType() == FTPFile.SYMBOLIC_LINK_TYPE) {
                System.out.println("Nombre: " + file.getName());
                System.out.println("Enlaza a: " + file.getLink());
            }
        }
    }

    public static void changeWorkingDirectory(FTPClient con, Scanner sc) throws IOException {
        System.out.print("Introduce el directorio al que quieres cambiar: ");
        String newDir = sc.nextLine();

        boolean changed = con.changeWorkingDirectory(newDir);

        if (changed) {
            System.out.println("Directorio cambiado correctamente.");
            System.out.println("Directorio actual: " + con.printWorkingDirectory());
        } else {
            System.out.println("No se pudo cambiar al directorio: " + newDir);
            System.out.println("Permisos insuficientes o el directorio no existe.");
        }
    }

    public static void getFilesMoreThen(FTPClient con, Scanner sc) throws IOException {
        System.out.print("Introduce tamaño en bytes: ");
        long bytes = sc.nextLong();
        sc.nextLine();

        FTPFile[] files = con.listFiles();
        System.out.println("Ficheros con tamaño mayor a " + bytes + " bytes:");
        boolean found = false;

        for (FTPFile f : files) {
            if (f.isFile() && f.getSize() > bytes) {
                System.out.println(f.getName() + " (" + f.getSize() + " bytes)");
                found = true;
            }
        }

        if (!found) {
            System.out.println("No se encontraron ficheros mayores a ese tamaño.");
        }
    }

    public static void getFilesByExtention(FTPClient con, Scanner sc) throws IOException {
        System.out.print("Introduce la extensión (por ejemplo: .txt, .jpg): ");
        String extension = sc.nextLine().trim().toLowerCase();

        FTPFile[] files = con.listFiles();

        System.out.println("\nFicheros con extensión " + extension + ":");
        boolean found = false;

        for (FTPFile file : files) {
            if (file.isFile() && file.getName().toLowerCase().endsWith(extension)) {
                System.out.println(" - " + file.getName());
                found = true;
            }
        }

        if (!found) {
            System.out.println("No se encontraron archivos con esa extensión.");
        }
    }

    public static void getFilesNameContains(FTPClient con, Scanner sc) throws IOException {
        System.out.print("Introduce texto a buscar en el nombre: ");
        String name = sc.nextLine();

        boolean found = false;

        FTPFile[] files = con.listFiles();
        System.out.println("Ficheros que contienen \"" + name + "\" en el nombre:");
        for (FTPFile f : files) {
            if (f.isFile() && f.getName().contains(name)) {
                System.out.println(f.getName());
                found = true;
            }
        }

        if (!found) {
            System.out.println("No se encontraron ficheros que contengan ese texto.");
        }
    }
}
