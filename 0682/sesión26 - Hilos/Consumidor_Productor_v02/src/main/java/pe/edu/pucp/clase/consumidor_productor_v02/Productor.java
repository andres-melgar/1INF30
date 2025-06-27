package pe.edu.pucp.clase.consumidor_productor_v02;

import java.util.logging.Level;
import java.util.logging.Logger;

/*Objetivo: produce datos y los coloca en el recurso compartido*/
public class Productor extends Thread{

    private Contenedor contenedor;
    
    public Productor(Contenedor contenedor){
        this.contenedor = contenedor;
    }
    
    @Override
    public void run(){
        for(int i=0; i<10; i++){
            this.contenedor.colocar(i);
            System.out.println("Productor - colocado: " + i);
            try {
                sleep((int)(Math.random()*1000));
            } catch (InterruptedException ex) {
                Logger.getLogger(Productor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
