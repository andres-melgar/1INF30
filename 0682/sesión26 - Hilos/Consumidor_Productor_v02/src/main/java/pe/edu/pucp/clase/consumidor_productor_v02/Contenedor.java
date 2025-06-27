package pe.edu.pucp.clase.consumidor_productor_v02;

import java.util.logging.Level;
import java.util.logging.Logger;

/*Representa el recurso compartido. 
  El valor se accederá de manera concurrente por varias clases. */
public class Contenedor {

    private Integer valor;
    private Boolean hayValor = false;

    /*synchronized hace que colocar se ejecute en un único hilo
    en un instante de tiempo. Dos hilos no podrán ejecutar 
    este método al mismo tiempo.
    
    Con public void colocar
        hilo1.colocar();   hilo2.colocar();    hilo3.colocar();
    
    Con public synchronized void colocar
        hilo1.colocar();   
        hilo2.colocar();    
        hilo3.colocar();
     */
    public synchronized void colocar(Integer valor) {
        while (this.hayValor == true) {
            try {
                /*Se espera hasta que alguien consuma el valor.
                wait hace que se suspenda el hilo que invoca al
                método colocar hasta que se lance una notificación
                a través de notify o notifyAll
                */            
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Contenedor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.valor = valor;
        this.hayValor = true;
        notifyAll();
    }

    /*synchronized hace que recuperar se ejecute en un único hilo
    en un instante de tiempo. Dos hilos no podrán ejecutar 
    este método al mismo tiempo
    
    Con public void recuperar
        hilo4.recuperar();  hilo5.recuperar();   hilo6.recuperar();
    
    Con public synchronized void recuperar
        hilo4.recuperar();   
        hilo5.recuperar();    
        hilo6.recuperar();
     */
    public synchronized Integer recuperar() {
        while(this.hayValor==false){
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Contenedor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.hayValor = false;
        notifyAll();
        return this.valor;
    }
}
