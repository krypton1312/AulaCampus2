package act13t1;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Act13T1 {

    public static void main(String[] args) {
        GranCaballo[] caballos = {
            new GranCaballo(), new GranCaballo(), new GranCaballo(),
            new GranCaballo(), new GranCaballo(), new GranCaballo(),
            new GranCaballo(), new GranCaballo(), new GranCaballo(),
            new GranCaballo()
        };
        
        caballos[1].setName("alejandro");
        caballos[2].setName("mario");

        for (GranCaballo c : caballos) {
            c.start();
        }

    }
}

class GranCaballo extends Thread {

    @Override
    public void run() {
        int i = 0;
        while (i <= 100) {
            //System.out.println("Caballo " + Thread.currentThread().getName() + " " + i);
            i += (int) (Math.random() * 10) + 1;
        }
        System.out.println(Thread.currentThread().getName() + " HA LLEGADO!");
    }
}
