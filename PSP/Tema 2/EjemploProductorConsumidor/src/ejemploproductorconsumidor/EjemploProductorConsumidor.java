package ejemploproductorconsumidor;

import static java.lang.Thread.sleep;

public class EjemploProductorConsumidor {
    public static void main(String[] args) throws InterruptedException {
        Contenedor contenedor = new Contenedor();
        Productor prod = new Productor(contenedor);
        Consumidor cons = new Consumidor(contenedor);
        
        prod.start();
        cons.start();
    }
}
class Consumidor extends Thread{
    private Contenedor contenedor;

    public Consumidor(Contenedor contenedor) {
        this.contenedor = contenedor;
    }
    
    @Override
    public void run(){
        for(int i = 1; i <= 10; i++){
            try {
                contenedor.get();
            } catch (InterruptedException ex){}
        }
    }
}
class Productor extends Thread{
    private Contenedor contenedor;

    public Productor(Contenedor contenedor) {
        this.contenedor = contenedor;
    }
    
    @Override
    public void run(){
        for(int i = 1; i <= 10; i++){
            try {
                contenedor.put(i);
            } catch (InterruptedException ex){}
        }
    }
}

class Contenedor{
    private int dato;
    private boolean hayDato = false;
    
    public synchronized int get() throws InterruptedException{
        if(!hayDato){
            wait();
        }
        sleep((int) (Math.random() * 2000));
        
        hayDato = false;
        System.out.println("Consumido dato: " + this.dato);
        notifyAll();
        return dato;
    }
    
    public synchronized void put(int valor) throws InterruptedException{
        if(hayDato){
            wait();
        }
        sleep((int) (Math.random() * 2000));
        
        hayDato = true;
        this.dato = valor;
        
        System.out.println("Producido dato: " + this.dato);
        notifyAll();
    }
}
