package pe.edu.pucp.inf30.sesiones.publicaciones02.publicaciones;

import java.util.ArrayList;

public abstract class Publicacion {

    public static Integer orden_presentacion = 1;
    protected String nombre;
    protected ArrayList<Autor> autores;
    protected Integer cantidad_autores;
    protected Integer año;

    public Publicacion(String nombre, String nombre_completo_autor, Integer año) {
        this.nombre = nombre;
        this.autores = new ArrayList<>();
        Autor autor = new Autor(nombre_completo_autor);
        this.autores.add(autor);
        this.cantidad_autores = 1;
        this.año = año;
    }

    public Publicacion(String nombre, String nombres_completos_autores[], Integer año) {
        this.nombre = nombre;
        this.autores = new ArrayList<>();
        for (String nombres_completos_autor_loop : nombres_completos_autores) {
            Autor autor = new Autor(nombres_completos_autor_loop);
            this.autores.add(autor);
        }
        this.cantidad_autores = this.autores.size();
        this.año = año;
    }
       
    public void referenciar(){
        System.out.println(this);
    }
}
