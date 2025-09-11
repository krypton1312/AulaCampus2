package actad;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class ActAd {
    public static void main(String[] args) {
        ArrayList<Evento> eventos = new ArrayList<>();
        
        eventos.add(new Evento("E001", "Concierto de Rock", 100, "Auditorio Central", LocalDate.of(2025, 10, 20), LocalTime.of(20, 0), 50.0));
        eventos.add(new Evento("E002", "Obra de Teatro", 80, "Teatro Principal", LocalDate.of(2025, 11, 5), LocalTime.of(19, 30), 30.0));
        eventos.add(new Evento("E003", "Conferencia Tecnología", 150, "Centro de Convenciones", LocalDate.of(2025, 12, 1), LocalTime.of(10, 0), 20.0));
        eventos.add(new Evento("E004", "Exposición de Arte", 200, "Museo Local", LocalDate.of(2025, 9, 15), LocalTime.of(16, 0), 15.0));
        eventos.add(new Evento("E005", "Festival de Cine", 120, "Cine Plaza", LocalDate.of(2025, 10, 30), LocalTime.of(18, 30), 25.0));
        eventos.add(new Concierto(
            "The Unknown Band", 5, null, "C001", "Concierto misterioso", 150, 
            "Auditorio Central", LocalDate.of(2025, 10, 25), LocalTime.of(21, 0), 40.0
        ));
        
        ((Concierto) eventos.get(5)).setEstilo("ROOOCK");
        
        listarEventos(eventos);
        System.out.println("======");
        listarConciertos(eventos);
        System.out.println("======");
        listaEventosLugar("Auditorio Central", eventos);
        System.out.println("======");
        listaEventosPrecio(5.25, eventos);
    }
    
    public static void listarEventos(ArrayList<Evento> eventos){
        for(Evento evento: eventos){
            System.out.println(evento);
        }
    }
    
    public static void listarConciertos(ArrayList<Evento> eventos){
        for(Evento evento: eventos){
            if(evento instanceof Concierto){
                System.out.println(evento);   
            }
        }
    }
    
    public static void listaEventosFecha(LocalDate fecha, ArrayList<Evento> eventos){
        for(Evento evento: eventos){
            if(fecha.isBefore(fecha)){
                System.out.println(evento);
            };
        }
    }
    
    public static void listaEventosLugar(String lugar, ArrayList<Evento> eventos){
        for(Evento evento: eventos){
            if(evento.getLugar().equals(lugar)){
                System.out.println(evento);
            };
        }
    }
    
    public static void listaEventosPrecio(double precio, ArrayList<Evento> eventos){
        for(Evento evento: eventos){
            if(evento.getPrecio() <= precio){
                System.out.println(evento);
            };
        }
    }
}
