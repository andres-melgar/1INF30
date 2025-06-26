package pe.edu.pucp.clase.consumidor_productor_v02;

/* Objetivo: consumir los valores colocados en el recurso compartido.    
*/
public class Consumidor extends Thread{

    private Contenedor contenedor;
    
    public Consumidor(Contenedor contenedor){
        this.contenedor = contenedor;
    }
    
    @Override
    public void run(){
        for(int i=0; i<10; i++){
            Integer valor = this.contenedor.recuperar();
            System.out.println("Consumidor - recuperando: " + valor);
        }
    }
}
