package act7;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Act7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        
        System.out.print("Introduce fecha inicial: ");
        LocalDate fechaInicial = LocalDate.parse(sc.nextLine(), formatter);
        
        System.out.print("Introduce fecha inicial: ");
        LocalDate fechaFinal = LocalDate.parse(sc.nextLine(), formatter);
        
        System.out.println("Dia de la semana de la fecha inicial: " + fechaInicial.getDayOfWeek());
        System.out.println("Dia de la semana de la fecha final: " + fechaFinal.getDayOfWeek());
        System.out.println("Dias transcurridos entre " + fechaInicial.toString() + " y " + fechaFinal.toString() + ": " + ChronoUnit.DAYS.between(fechaInicial, fechaFinal));
    }
}
