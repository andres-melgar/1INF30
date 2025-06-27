package pe.edu.pucp.clase.consumidor_productor_v01;


public class Consumidor extends Thread{

    private Contenedor contenedor;
    
    public Consumidor(Contenedor contenedor){
        this.contenedor = contenedor;
    }
    
    @Override
    public void run(){
        for(int i=0; i<10; i++){
            Integer valor = contenedor.recuperar();
            System.out.println("Consumidor - recuperado: " + valor);
        }
    }
}
