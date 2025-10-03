package act2t2;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Act2T2 {

    public static void main(String[] args) throws InterruptedException {
        Jugador jug1 = new Jugador("Mario");
        Jugador jug2 = new Jugador("JM");
        Jugador jug3 = new Jugador("Alejandro");
        Jugador jug4 = new Jugador("Marcos");

        jug1.start();
        jug2.start();
        jug3.start();
        jug4.start();

        jug1.join();
        jug2.join();
        jug3.join();
        jug4.join();
        System.out.println("\nPartida ha terminado.");
    }
}

class Jugador extends Thread {

    private List<Integer> dados = new ArrayList<>();
    private List<Integer> seis = Arrays.asList(6, 6, 6, 6, 6, 6);
    private int tiradas = 0;
    private LocalTime hInicio;
    private LocalTime hFin;

    public Jugador(String name) {
        super(name);
    }

    public void run() {
        hInicio = LocalTime.now();
        while (true) {
            tiradas++;
            dados.clear();
            for (int i = 0; i < 6; i++) {
                dados.add((int) (Math.random() * 6) + 1);
            }
            if (dados.equals(seis)) {
                hFin = LocalTime.now();
                System.out.println(super.getName() + " ha ganado, ha hecho " + tiradas + " tiradas.\nLe ha costado: " + ChronoUnit.MILLIS.between(hInicio, hFin) + "mills");
                break;
            }
        }

    }
}
