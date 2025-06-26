package pe.edu.pucp.clase.notas_v02;


public class NotasParcial extends Thread{

    @Override
    public void run(){
      this.mostrarParcial();
    }
    
    public void mostrarParcial() {
        for (int i = 0; i < 1000; i++) {
            if (i != 0) {
                System.out.print(", ");
            }
            System.out.print("24");
        }
        System.out.println();
    }
}
