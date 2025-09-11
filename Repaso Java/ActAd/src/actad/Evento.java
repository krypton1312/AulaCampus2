package actad;

import java.time.LocalDate;
import java.time.LocalTime;

public class Evento {
    private String codigo;
    private String descripcion;
    private int aforo;
    private String lugar;
    private LocalDate fecha;
    private LocalTime hora;
    private double precio;

    public Evento(String codigo, String descripcion, int aforo, String lugar, LocalDate fecha, LocalTime hora, double precio) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.aforo = aforo;
        this.lugar = lugar;
        this.fecha = fecha;
        this.hora = hora;
        this.precio = precio;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getAforo() {
        return aforo;
    }

    public void setAforo(int aforo) {
        this.aforo = aforo;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Evento{" + "codigo=" + codigo + ", descripcion=" + descripcion + ", aforo=" + aforo + ", lugar=" + lugar + ", fecha=" + fecha + ", hora=" + hora + ", precio=" + calculaPrecio() + '}';
    }
    
    public double calculaRecaudacion(){
        return aforo*precio;
    }
    
    public double calculaPrecio(){
        return precio*0.21;
    }
}
