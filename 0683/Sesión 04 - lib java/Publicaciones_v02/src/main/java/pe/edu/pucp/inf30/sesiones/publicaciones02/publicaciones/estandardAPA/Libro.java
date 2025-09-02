package pe.edu.pucp.inf30.sesiones.publicaciones02.publicaciones.estandardAPA;

import pe.edu.pucp.inf30.sesiones.publicaciones02.publicaciones.Publicacion;

public class Libro extends Publicacion {

    private String edicion;
    private String lugar;
    private String editorial;

    public Libro(String nombre, String nombre_completo_autor, Integer año, String edicion, String lugar, String editorial) {
        super(nombre, nombre_completo_autor, año);
        this.edicion = edicion;
        this.lugar = lugar;
        this.editorial = editorial;
    }

    public Libro(String nombre, String nombres_completos_autores[], Integer año, String edicion, String lugar, String editorial) {
        super(nombre, nombres_completos_autores, año);
        this.edicion = edicion;
        this.lugar = lugar;
        this.editorial = editorial;
    }

    @Override
    public String toString() {
        String referencia = "";
        for (int i = 0; i < cantidad_autores; i++) {
            if (i != 0) {
                if (i == cantidad_autores - 1) {
                    referencia = referencia.concat(" and ");
                } else {
                    referencia = referencia.concat(", ");
                }
            }
            referencia = referencia.concat(autores.get(i).toString());
        }
        referencia = referencia.concat(". (");
        referencia = referencia.concat(año.toString());
        referencia = referencia.concat("). ");        
        referencia = referencia.concat(nombre);
        referencia = referencia.concat(". ");
        referencia = referencia.concat(edicion);
        referencia = referencia.concat(". ");
        referencia = referencia.concat(lugar);
        referencia = referencia.concat(". ");
        referencia = referencia.concat(editorial);
        referencia = referencia.concat(". ");
        return referencia;
    }
}