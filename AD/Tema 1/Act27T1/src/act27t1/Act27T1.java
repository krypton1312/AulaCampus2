package act27t1;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class Act27T1 {
    public static void main(String[] args) throws JAXBException {
        //unmarsh();
        
        marsh();
        
    }
    public static void marsh() throws JAXBException{
        Empleado emp = new Empleado(1, "jose", "asd", "01923", "depart", 234.13);
        
        JAXBContext context = JAXBContext.newInstance(Empleado.class);
        
        Marshaller marshaller = context.createMarshaller();
        
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        
        marshaller.marshal(emp, new File("emp.xml"));
        
    }
    public static void unmarsh() throws JAXBException{
        JAXBContext context = JAXBContext.newInstance(Empleado.class);
        
        Unmarshaller unmarshaller = context.createUnmarshaller();
        
        Empleado emp = (Empleado)unmarshaller.unmarshal(new File("empleado.xml"));
        System.out.println(emp);
    }
}


