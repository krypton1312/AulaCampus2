package act3t2;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class Act3T2 {

    public static void main(String[] args) throws InterruptedException {
        int[] vector = new int[50000000];
        LocalTime hInicio;
        LocalTime hFinal;

        for (int i = 0; i < vector.length; i++) {
            vector[i] = (int) (Math.random() * 101);
        }

        // sin hilos
        int cantidad = 0;

        hInicio = LocalTime.now();
        for (int i = 0; i < vector.length; i++) {
            if (vector[i] < 66 && vector[i] > 17) {
                cantidad++;
            }
        }

        hFinal = LocalTime.now();

        System.out.println("Recuento de los españoles en edad laboral: " + cantidad);
        System.out.println("Sin hilos ha tardado: " + ChronoUnit.MILLIS.between(hInicio, hFinal) + "mills");

        // con hilos
        int octavo = vector.length / 8;

        Hilo hilo1 = new Hilo(0, octavo - 1, vector);
        Hilo hilo2 = new Hilo(octavo, octavo * 2 - 1, vector);
        Hilo hilo3 = new Hilo(octavo * 2, octavo * 3 - 1, vector);
        Hilo hilo4 = new Hilo(octavo * 3, octavo * 4 - 1, vector);
        Hilo hilo5 = new Hilo(octavo * 4, octavo * 5 - 1, vector);
        Hilo hilo6 = new Hilo(octavo * 5, octavo * 6 - 1, vector);
        Hilo hilo7 = new Hilo(octavo * 6, octavo * 7 - 1, vector);
        Hilo hilo8 = new Hilo(octavo * 7, vector.length - 1, vector);

        hInicio = LocalTime.now();
        
        hilo1.start();
        hilo2.start();
        hilo3.start();
        hilo4.start();
        hilo5.start();
        hilo6.start();
        hilo7.start();
        hilo8.start();

        hilo1.join();
        hilo2.join();
        hilo3.join();
        hilo4.join();
        hilo5.join();
        hilo6.join();
        hilo7.join();
        hilo8.join();
        
        
        cantidad = hilo1.getCantidad() + hilo2.getCantidad() + hilo3.getCantidad() + hilo4.getCantidad() + hilo5.getCantidad() +hilo6.getCantidad() + hilo7.getCantidad() + hilo8.getCantidad();
        
        hFinal = LocalTime.now();
        
        System.out.println("Recuento de los españoles en edad laboral: " + cantidad);
        System.out.println("Con hilos ha tardado: " + ChronoUnit.MILLIS.between(hInicio, hFinal) + "mills");
    }
}

class Hilo extends Thread {

    private int inicio;
    private int fin;
    private int[] vector;
    private int cantidad;

    public Hilo(int inicio, int fin, int[] vector) {
        this.inicio = inicio;
        this.fin = fin;
        this.vector = vector;
    }

    public int getCantidad() {
        return cantidad;
    }

    @Override
    public void run() {
        int total = 0;
        for (int i = inicio; i <= fin; i++) {
            if (vector[i] < 66 && vector[i] > 17) {
                total++;
            }
        }
        this.cantidad = total;
    }
}
