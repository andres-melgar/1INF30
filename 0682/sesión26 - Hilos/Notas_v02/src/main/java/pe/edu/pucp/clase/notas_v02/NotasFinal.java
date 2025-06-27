package pe.edu.pucp.clase.notas_v02;

public class NotasFinal extends Thread {

    @Override
    public void run(){
        this.mostrarFinal();
    }
    
    public void mostrarFinal() {
        for (int i = 0; i < 1000; i++) {
            System.out.print("20, ");
        }
        System.out.println("");
    }
}
