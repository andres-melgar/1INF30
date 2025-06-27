package pe.edu.pucp.clase.notas_v03;


public class NotasParcial implements Runnable {
    
    private Thread hilo;
    
    public NotasParcial(){
        this.hilo = new Thread(this);
        this.hilo.start();
    }

    @Override
    public void run() {
        this.mostrarParcial();
    }
    
     public void mostrarParcial() {
        for (int i = 0; i < 1000; i++) {
            System.out.print("24, ");
        }
        System.out.println("");
    }
    
}
