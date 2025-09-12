package ejemplo1;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;




public class Ejemplo1 {
    public static void main(String[] args) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Libro.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        
        Libro libro = (Libro)unmarshaller.unmarshal(new File("libro.xml"));
        System.out.println(libro);
    }
}
