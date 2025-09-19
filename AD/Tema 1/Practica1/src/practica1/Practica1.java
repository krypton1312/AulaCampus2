package practica1;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class Practica1 {
    public static void main(String[] args) throws IOException, JAXBException {
        Scanner sc = new Scanner(System.in);
        
        Pais pais = null;
        
        int opcion;

        do {
            System.out.println("Práctica AD Tema 1.");
            System.out.println("------------------------------------");
            System.out.println("1.- Pedir datos del país y crear fichero.");
            System.out.println("2.- Leer fichero y volcar datos a objeto miPais.");
            System.out.println("3.- Crear fichero XML a partir del objeto miPais.");
            System.out.println("4.- Crear fichero Json a partir del objeto miPais.");
            System.out.println("5.- Salir de la aplicación.");
            System.out.print("Elige una opción: ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    pedirDatos(sc);
                    break;
                case 2:
                    pais = leerDatos();
                    System.out.println("Datos del fichero han sido guardado en el objeto.");
                    break;
                case 3:
                    convertirXML(pais);
                    System.out.println("Objeto ha sido convertido a XML.");
                    break;
                case 4:
                    convertirJSON(pais);
                    System.out.println("Objeto ha sido convertido a JSON.");
                    break;
                case 5:
                    System.out.println("Saliendo de la aplicación...");
                    break;
                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }

            System.out.println();

        } while (opcion != 5);
        
    }
    
    public static void pedirDatos(Scanner sc) throws IOException{
        File file = new File("datospais.txt");
        if(file.exists() && file.length() > 0){
            file.delete();
            file.createNewFile();
        }
        FileWriter fw = new FileWriter(file, true);
        
        System.out.print("Datos del pais\nNombre:");
        fw.write(sc.nextLine() + ";");
        
        System.out.print("Capital: ");
        fw.write(sc.nextLine() + ";");
        
        System.out.print("Habitantes: ");
        fw.write(sc.nextLine() + ";");
        
        System.out.print("Costero?(si/no):");
        fw.write(sc.nextLine() + ";");
        fw.flush();
        fw.close();
    }
    
    private static Pais leerDatos() throws FileNotFoundException, IOException{
        BufferedReader br = new BufferedReader(new FileReader("datospais.txt"));
        String linea;
        String[] datos = null;
        while((linea = br.readLine()) != null){
            datos = linea.split(";");
        }
        
        Pais pais = new Pais(datos[0],datos[1],Integer.parseInt(datos[2]),datos[3].equals("si") ? true : false);
        return pais;
    }
    
    private static void convertirXML(Pais pais) throws JAXBException{
        JAXBContext contexto = JAXBContext.newInstance(pais.getClass());
        Marshaller marsh = contexto.createMarshaller();
        
        marsh.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        
        marsh.marshal(pais, new File("datospais.xml"));
    }
    
    private static void convertirJSON(Pais pais) throws IOException{
        Gson gson = new Gson();
        
        FileWriter fw = new FileWriter("datospais.json");
        fw.write(gson.toJson(pais));
        fw.flush();
        fw.close();
    }
}
