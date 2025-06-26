package pe.edu.pucp.clase.consumidor_productor_v02;

import java.util.logging.Level;
import java.util.logging.Logger;

/*Representa un contenedor de recursos compartido. Podría ser una base de datos,
    un archivo (json, xml, txt, etc), un TAD (lista, pila, cola, etc)
  ¿Recurso compartido por quien?
    Rpta: recurso compartido por varios hilos.
*/
public class Contenedor {
    
    private Integer valor;
    private Boolean hayValor = false;
    
    /* synchronized hace que el método puede ser invocado por un
    solo hilo a la vez. Entonces, solo un hilo podrá colocar un valor
    en un instante del tiempo */
    public synchronized void colocar(Integer valor){
        while(this.hayValor == true){
            try {
                //wait hace que la clase Contenedor suspenda la ejecución
                //del hilo hasta que se notifique
                //¿Cómo se notifica?
                //Rpta: con la instrucción notifyAll
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Contenedor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.valor = valor;
        this.hayValor = true;
        /*Notifica al hilo que recupera que ya se colocó el valor*/
        notifyAll();
    }
    
    /* synchronized hace que el método puede ser invocado por un
    solo hilo a la vez. Entonces, solo un hilo podrá recuperar un valor
    en un instante del tiempo */
    public synchronized Integer recuperar(){
        while (this.hayValor == false){
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Contenedor.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        this.hayValor = false;
        /*Notifica al hilo que coloca que ya se recuperó el valor*/
        notifyAll(); 
        return this.valor;
    }
}
