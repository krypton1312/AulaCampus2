package act27t1;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class Act27T1 {
    public static void main(String[] args) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Empleado.class);
        
        Unmarshaller unmarshaller = context.createUnmarshaller();
        
        Empleado emp = (Empleado)unmarshaller.unmarshal(new File("empleado.xml"));
        System.out.println(emp);
    }
}


