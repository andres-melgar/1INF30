package pe.edu.pucp.clase.notas_v03;


public class NotasFinal implements Runnable{

    private Thread hilo;
    
    public NotasFinal(){
        this.hilo = new Thread(this);
        this.hilo.start();
    }
    
    @Override
    public void run() {
        this.mostrarFinal();
    }
    
    public void mostrarFinal() {
        for (int i = 0; i < 1000; i++) {
            System.out.print("20, ");
        }
        System.out.println("");
    }
}
