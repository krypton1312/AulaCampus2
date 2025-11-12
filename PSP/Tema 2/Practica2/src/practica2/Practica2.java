package practica2;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Practica2 {

    public static void main(String[] args) throws InterruptedException {
        Equipo eq1 = new Equipo("Lakers");
        Equipo eq2 = new Equipo("Celtics");
        Equipo eq3 = new Equipo("Golden State Warriors");

        eq1.start();
        eq2.start();
        eq3.start();

        eq1.join();
        eq2.join();
        eq3.join();
        
        System.out.println("=======================================================");
        System.out.println(eq1.getName() + ":\nTotal puntos: " + eq1.getTotalPuntos());
        System.out.println("Canastras falladas: " + eq1.getPuntos().get(0));
        System.out.println("Tiros libres encestados: " + eq1.getPuntos().get(1));
        System.out.println("Tiros de dos encestados: " + eq1.getPuntos().get(2));
        System.out.println("Tiros de tres encestados: " + eq1.getPuntos().get(3));
        
        System.out.println("=======================================================");
        System.out.println(eq2.getName() + ":\nTotal puntos: " + eq2.getTotalPuntos());
        System.out.println("Canastras falladas: " + eq2.getPuntos().get(0));
        System.out.println("Tiros libres encestados: " + eq2.getPuntos().get(1));
        System.out.println("Tiros de dos encestados: " + eq2.getPuntos().get(2));
        System.out.println("Tiros de tres encestados: " + eq2.getPuntos().get(3));
        
        System.out.println("=======================================================");
        System.out.println(eq3.getName() + ":\nTotal puntos: " + eq3.getTotalPuntos());
        System.out.println("Canastras falladas: " + eq3.getPuntos().get(0));
        System.out.println("Tiros libres encestados: " + eq3.getPuntos().get(1));
        System.out.println("Tiros de dos encestados: " + eq3.getPuntos().get(2));
        System.out.println("Tiros de tres encestados: " + eq3.getPuntos().get(3));
    }
}

class Equipo extends Thread {

    private List<Integer> puntos = new ArrayList<>();

    public Equipo(String name) {
        super(name);
        for (int i = 0; i < 4; i++) {
            puntos.add(0);
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < 151; i++) {
            int random = (int) ((Math.random()) * 100);
            if (random <= 30) {
                System.out.println("Equipo " + super.getName() + " ha fallado el tiro.");
                puntos.set(0, puntos.get(0) + 1);
            } else if (random > 30 && random <= 50) {
                System.out.println("Equipo " + super.getName() + " ha sacado un punto del tiro.");
                puntos.set(1, puntos.get(1) + 1);
            } else if (random > 50 && random <= 90) {
                System.out.println("Equipo " + super.getName() + " ha sacado dos puntos del tiro.");
                puntos.set(2, puntos.get(2) + 1);
            } else if (random > 90 && random <= 100) {
                System.out.println("Equipo " + super.getName() + " ha sacado tres puntos del tiro.");
                puntos.set(3, puntos.get(3) + 1);
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(Equipo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public List<Integer> getPuntos() {
        return puntos;
    }

    public int getTotalPuntos() {
        return puntos.get(1) * 1 + puntos.get(2) * 2 + puntos.get(3) * 3;
    }
}
