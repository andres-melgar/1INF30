package pe.edu.pucp.clase.consumidor_productor_v01;

/* Problema: Existe un recurso compartido. Este recurso compartido
    puede ser una base de datos, un archivo (json, xml, etc), una 
    imagen, una dll, etc. Unas clases necesitan colocar datos en
    el recurso compartido y otras clases necesitan sacar datos
    del recurso compartido. Las clases que colocan y sacan valores
    ejecutan sus labores en hilos diferentes.

*/
public class Consumidor_Productor_v01 {

    public static void main(String[] args) {
        Contenedor contenedor = new Contenedor();
        Productor productor = new Productor(contenedor);
        Consumidor consumidor = new Consumidor(contenedor);
        
       productor.start();
       consumidor.start();
    }
}
