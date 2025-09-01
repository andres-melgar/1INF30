package pe.edu.pucp.inf30.sesiones.publicaciones02.publicaciones.estandardAPA;

import pe.edu.pucp.inf30.sesiones.publicaciones02.publicaciones.Clase_de_Tesis;
import pe.edu.pucp.inf30.sesiones.publicaciones02.publicaciones.Publicacion;

public class Tesis extends Publicacion {
    
    private Clase_de_Tesis clase;
    private String departamento;
    private String institucion;
    private String ciudad;
    private String estado;

    public Tesis(String nombre, String nombre_completo_autor, Integer año, Clase_de_Tesis clase, String departamento, String institucion, String ciudad, String estado) {
        super(nombre, nombre_completo_autor, año);
        this.clase = clase;
        this.departamento = departamento;
        this.institucion = institucion;
        this.ciudad = ciudad;
        this.estado = estado;
    }

    public Tesis(String nombre, String nombres_completos_autores[], Integer año, Clase_de_Tesis clase, String departamento, String institucion, String ciudad, String estado) {
        super(nombre, nombres_completos_autores, año);
        this.clase = clase;
        this.departamento = departamento;
        this.institucion = institucion;
        this.ciudad = ciudad;
        this.estado = estado;
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
        referencia = referencia.concat(" [");
        referencia = switch (clase) {
            case DOCTORADO -> referencia.concat("Tesis de Doctorado");
            case MAESTRIA -> referencia.concat("Tesis de Maestría");
            default -> referencia.concat("Tesis de Licenciatura");
        };
        referencia = referencia.concat(", ");
        referencia = referencia.concat(departamento);
        referencia = referencia.concat(", ");
        referencia = referencia.concat(institucion);
        referencia = referencia.concat(", ");
        referencia = referencia.concat(ciudad);
        referencia = referencia.concat(", ");
        referencia = referencia.concat(estado);        
        referencia = referencia.concat("].");
        return referencia;
    }
}