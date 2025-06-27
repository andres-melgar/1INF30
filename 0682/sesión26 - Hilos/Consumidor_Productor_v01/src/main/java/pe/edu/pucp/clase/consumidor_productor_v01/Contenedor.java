package pe.edu.pucp.clase.consumidor_productor_v01;

/*Representa el recurso compartido. 
  El valor se accederá de manera concurrente por varias clases. */
public class Contenedor {

    private Integer valor;
    
    public void colocar(Integer valor){
        this.valor = valor;
    }
    
    public Integer recuperar(){
        return this.valor;
    }
}
