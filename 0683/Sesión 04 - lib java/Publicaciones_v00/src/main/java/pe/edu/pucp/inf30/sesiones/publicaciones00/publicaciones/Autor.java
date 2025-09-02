package pe.edu.pucp.inf30.sesiones.publicaciones00.publicaciones;

public class Autor {

    private String apellidos;
    private String nombres;

    public Autor(String nombre_completo_autor) {
        Integer posicion_coma = nombre_completo_autor.indexOf(",");
        this.apellidos = nombre_completo_autor.substring(0, posicion_coma).trim();
        this.nombres = nombre_completo_autor.substring(posicion_coma + 1).trim();
    }

    @Override
    public String toString() {
        String copia_nombre = this.nombres;
        String abreviatura = "";
        Integer posicion_blanco;
        do {
            posicion_blanco = copia_nombre.indexOf(" ");
            if (!abreviatura.equals("")) {
                abreviatura = abreviatura.concat(" ");
            }
            abreviatura = abreviatura.concat(copia_nombre.substring(0, 1));
            abreviatura = abreviatura.concat(".");
            if (posicion_blanco != -1) {
                copia_nombre = copia_nombre.substring(posicion_blanco + 1).trim();
            }
        } while (posicion_blanco != -1);
        return abreviatura.concat(" ").concat(this.apellidos);
    }
}
