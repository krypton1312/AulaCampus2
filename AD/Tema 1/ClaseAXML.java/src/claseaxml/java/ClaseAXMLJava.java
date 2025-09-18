package claseaxml.java;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class ClaseAXMLJava {
    public static void main(String[] args) throws JAXBException {
        Libro libro = new Libro("Libro1", 333);
        
        JAXBContext contexto = JAXBContext.newInstance(libro.getClass());
        
        Marshaller marshaller = contexto.createMarshaller();
        
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);
        
        marshaller.marshal(libro, new File("libro.xml"));
        marshaller.marshal(libro, System.out);
    }
}
