package ejemplo5t1;

public class Ejemplo5T1 {
    public static void main(String[] args) throws InterruptedException {
        Hilo hilo = new Hilo();
        Hilo hilo2 = new Hilo();
        Hilo hilo3 = new Hilo();
        hilo.start();
        hilo2.start();
        hilo3.start();
        //1: (total time: 1 minute 17 seconds) - 5000000 
        //2: (total time: 1 minute 21 seconds)
        //3: 1m 22s

        for(int i=1; i<=1250000; i++){
            System.out.println("Main: " + i);
            //Thread.sleep((int)(Math.random()*1000)+1000);
        }
        
    }
}

class Hilo extends Thread{
    @Override
    public void run(){
        for(int i=1; i<=1250000; i++){
            System.out.println("Hilo: " + i);
            //try {
               //Thread.sleep((int)(Math.random()*1000)+1000);
            //} catch (Exception ex) {}
        }
    }
}

