package pe.edu.pucp.inf30.sesiones.publicaciones03.publicaciones.estandardAPA;

import pe.edu.pucp.inf30.sesiones.publicaciones03.publicaciones.Publicacion;

public class Articulo extends Publicacion {

    private String revista;
    private Integer volumen;
    private Integer numero;
    private String mes;

    public Articulo(String nombre, String nombre_completo_autor, Integer año, String revista, Integer volumen, Integer numero, String mes) {
        super(nombre, nombre_completo_autor, año);
        this.revista = revista;
        this.volumen = volumen;
        this.numero = numero;
        this.mes = mes;
    }

    public Articulo(String nombre, String nombres_completos_autores[], Integer año, String revista, Integer volumen, Integer numero, String mes) {
        super(nombre, nombres_completos_autores, año);
        this.revista = revista;
        this.volumen = volumen;
        this.numero = numero;
        this.mes = mes;
    }

    @Override
    public String toString() {
        String referencia = "[" + Publicacion.orden_presentacion.toString() + "]";
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
        referencia = referencia.concat(", \"");
        referencia = referencia.concat(nombre);
        referencia = referencia.concat("\", "); 
        referencia = referencia.concat(revista);
        referencia = referencia.concat(", vol. ");
        referencia = referencia.concat(volumen.toString());
        referencia = referencia.concat(", no. ");
        referencia = referencia.concat(numero.toString());
        referencia = referencia.concat(", ");
        referencia = referencia.concat(mes);
        referencia = referencia.concat(" ");
        referencia = referencia.concat(año.toString());
        referencia = referencia.concat(". ");
        return referencia;
    }public void referenciar() {
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
        referencia = referencia.concat(revista);
        referencia = referencia.concat(", ");
        referencia = referencia.concat(volumen.toString());
        referencia = referencia.concat("(");
        referencia = referencia.concat(numero.toString());
        referencia = referencia.concat(").");
        System.out.println(referencia);
    }
}