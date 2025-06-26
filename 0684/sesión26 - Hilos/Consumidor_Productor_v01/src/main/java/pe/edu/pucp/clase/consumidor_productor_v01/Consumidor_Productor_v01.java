package pe.edu.pucp.clase.consumidor_productor_v01;

public class Consumidor_Productor_v01 {

    public static void main(String[] args) {
        Contenedor contenedor = new Contenedor();
        Productor productor = new Productor(contenedor);
        Consumidor consumidor = new Consumidor(contenedor);
        
        productor.start();
        consumidor.start();
    }
}
