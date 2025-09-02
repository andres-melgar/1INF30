package pe.edu.pucp.inf30.sesiones.publicaciones03.publicaciones;

public interface AbstractFactoryPublicacion {
    
    public abstract Publicacion crearArticulo(String nombre, String nombre_completo_autor, Integer año, String revista, Integer volumen, Integer numero, String mes);
    
    public abstract Publicacion crearArticulo(String nombre, String nombres_completos_autores[], Integer año, String revista, Integer volumen, Integer numero, String mes);
    
    public abstract Publicacion crearLibro(String nombre, String nombre_completo_autor, Integer año, String edicion, String lugar, String editorial);
    
    public abstract Publicacion crearLibro(String nombre, String nombres_completos_autores[], Integer año, String edicion, String lugar, String editorial);
    
    public abstract Publicacion crearTesis(String nombre, String nombre_completo_autor, Integer año, Clase_de_Tesis clase, String departamento, String institucion, String ciudad, String estado);
    
    public abstract Publicacion crearTesis(String nombre, String nombres_completos_autores[], Integer año, Clase_de_Tesis clase, String departamento, String institucion, String ciudad, String estado);
}
