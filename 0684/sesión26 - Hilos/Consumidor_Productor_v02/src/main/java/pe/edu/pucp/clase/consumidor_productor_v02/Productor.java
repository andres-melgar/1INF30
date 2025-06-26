package pe.edu.pucp.clase.consumidor_productor_v02;

import java.util.logging.Level;
import java.util.logging.Logger;

/* Objetivo: producir valores y colocarlos en el recurso compartido.
    Ejemplos:
        Ventas de una empresa.
        Salida de almacén.
        Reserva de un libro.
        Registro de un mantenimiento.
*/
public class Productor extends Thread{

    private Contenedor contenedor;
    
    public Productor(Contenedor contenedor){
        this.contenedor = contenedor;
    }
    
    @Override
    public void run(){
        for(int i=0; i<10; i++){
            try {
                this.contenedor.colocar(i);
                System.out.println("Productor - colocando: " + i);
                sleep((int)(Math.random()*1000));
            } catch (InterruptedException ex) {
                Logger.getLogger(Productor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
