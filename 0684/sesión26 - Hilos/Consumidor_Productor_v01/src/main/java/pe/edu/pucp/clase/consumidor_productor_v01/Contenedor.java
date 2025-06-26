package pe.edu.pucp.clase.consumidor_productor_v01;

/*Representa un contenedor de recursos compartido. Podría ser una base de datos,
    un archivo (json, xml, txt, etc), un TAD (lista, pila, cola, etc)
  ¿Recurso compartido por quien?
    Rpta: recurso compartido por varios hilos.
*/
public class Contenedor {
    
    private Integer valor;
    
    public void colocar(Integer valor){
        this.valor = valor;
    }
    
    public Integer recuperar(){
        return this.valor;
    }
}
