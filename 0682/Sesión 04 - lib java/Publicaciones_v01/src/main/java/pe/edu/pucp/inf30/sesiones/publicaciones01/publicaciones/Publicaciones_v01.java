package pe.edu.pucp.inf30.sesiones.publicaciones01.publicaciones;

import pe.edu.pucp.inf30.sesiones.publicaciones01.publicaciones.estandardIEEE.Tesis;
import pe.edu.pucp.inf30.sesiones.publicaciones01.publicaciones.estandardIEEE.Libro;
import pe.edu.pucp.inf30.sesiones.publicaciones01.publicaciones.estandardIEEE.Articulo;

public class Publicaciones_v01 {

    public static void main(String[] args) {
        Publicacion publicaciones[] = new Publicacion[3];
        publicaciones[0] = new Articulo("A relational model of data for large shared data banks", "Codd, Edgar Frank", 1970, "Communications of the ACM", 13, 6, "junio");
        String autores[]= {"Gamma, Erich", "Helm, Richard", "Johnson, Ralph", "Vlissides, John"};        
        publicaciones[1] = new Libro("Design Patterns: Elements of Reusable Object-Oriented Software", autores, 1970, "1er edición", "Massachusetts", "Addison-Wesley Professional");
        publicaciones[2] = new Tesis("A system of logic based on ordinals", "Turing, Alan Mathison", 1938, Clase_de_Tesis.DOCTORADO, "Departamento de Matemáticas", "Universidad de Princeton", "Princeton", "NJ");                
        
        for (Publicacion publicacion : publicaciones) {
            publicacion.referenciar();
            Publicacion.orden_presentacion++;
        }
    }

}
