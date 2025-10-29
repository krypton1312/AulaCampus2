package actaddt2;

import static java.lang.Thread.sleep;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class ActAddT2 {
    public static void main(String[] args) throws InterruptedException {
        Paquete paq = new Paquete();
        Destinario des = new Destinario(paq);
        Repartidor rep = new Repartidor(paq);
        
        LocalTime antes = LocalTime.now();
        des.start();
        rep.start();
        
        des.join();
        rep.join();
        
        LocalTime despues = LocalTime.now();
        
        System.out.println("Tiempo: " + ChronoUnit.SECONDS.between(antes, despues) + "segundos");
    }
}

class Repartidor extends Thread{
    private Paquete paq;

    public Repartidor(Paquete paq) {
        this.paq = paq;
    }
    
    @Override
    public void run(){
        for(int i = 1; i <= 60; i++){
            try{
                paq.entregar(i);
            } catch(InterruptedException ex){}
        }
    }
}
class Destinario extends Thread{
    private Paquete paq;

    public Destinario(Paquete paq) {
        this.paq = paq;
    }
    
    @Override
    public void run(){
        for(int i = 1; i <= 60; i++){
            try{
                paq.recoger();
            } catch(InterruptedException ex){}
        }
    }
}


class Paquete{
    private int paquete;
    private boolean hayPaquete = false;
    
    public synchronized int recoger() throws InterruptedException{
        if(!hayPaquete){
            wait();
        }
        
        sleep((int)(Math.random()*400)+200);
        hayPaquete = false;
        System.out.println("Paquete recogido: " + this.paquete);
        notifyAll();
        return paquete;
    }
    
    public synchronized void entregar(int valor) throws InterruptedException{
        if(hayPaquete){
            wait();
        }
        
        sleep((int)(Math.random()*2000)+1000);
        hayPaquete = true;
        this.paquete = valor;
        
        System.out.println("Entregado paquete: " + this.paquete);
        notifyAll();
    }
}