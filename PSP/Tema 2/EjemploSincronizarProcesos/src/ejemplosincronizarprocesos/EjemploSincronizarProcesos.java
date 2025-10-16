package ejemplosincronizarprocesos;

public class EjemploSincronizarProcesos {
    public static void main(String[] args) {
        Cuenta miCuenta = new Cuenta(500);
        
        Cliente juan = new Cliente(miCuenta, "JUAN");
        Cliente ana = new Cliente(miCuenta, "ANA");
        
        ana.start();
        juan.start();
        
        
        
    }
}

class Cliente extends Thread {
    private Cuenta miCuenta;
    private String nombre;

    public Cliente(Cuenta miCuenta, String nombre) {
        this.miCuenta = miCuenta;
        this.nombre = nombre;
    }
    
    @Override
    public void run(){
        for(int i = 1; i<=5; i++){
            miCuenta.retirarDinero(100, this.nombre);
            try{
                Thread.sleep(100);
            }catch(InterruptedException ex){}
        }
    }
}

class Cuenta{
    private double saldo;

    public Cuenta(double saldo) {
        this.saldo = saldo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    public void restar(double cantidad){
        this.saldo = this.saldo-cantidad;
    }
    
    public synchronized void retirarDinero(double cantidad, String nombre){
        if(this.getSaldo()>=cantidad){
            System.out.println(nombre + ": SE VA A RETIRAR SALDO (ACTUAL ES: " + this.getSaldo() + ")");
            this.restar(cantidad);
            System.out.println("\t" + nombre + " retira  => " + cantidad + " SALDO  ACTUAL: " + this.getSaldo());
        }else{
            System.out.println(nombre + ". No se puede retirar dinero, NO HAY SALDO: " + this.getSaldo());
        }
        if(this.getSaldo() < 0){
            System.out.println("SALDO NEGATIVO: " + this.getSaldo());
        }
    }
}

