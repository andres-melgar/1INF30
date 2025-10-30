package pe.edu.pucp.softinv.daoImp.util;

//esta clase representa la clase que incorporará los metadatos a la solución
public class Columna {
    private String nombre;
    private Boolean esLlavePrimaria;
    private Boolean esAutoGenerado;

    public Columna(String nombre, Boolean esLlavePrimaria, Boolean esAutoGenerado) {
        this.nombre = nombre;
        this.esLlavePrimaria = esLlavePrimaria;
        this.esAutoGenerado = esAutoGenerado;
    }
        
    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the esLlavePrimaria
     */
    public Boolean getEsLlavePrimaria() {
        return esLlavePrimaria;
    }

    /**
     * @param esLlavePrimaria the esLlavePrimaria to set
     */
    public void setEsLlavePrimaria(Boolean esLlavePrimaria) {
        this.esLlavePrimaria = esLlavePrimaria;
    }

    /**
     * @return the esAutoGenerado
     */
    public Boolean getEsAutoGenerado() {
        return esAutoGenerado;
    }

    /**
     * @param esAutoGenerado the esAutoGenerado to set
     */
    public void setEsAutoGenerado(Boolean esAutoGenerado) {
        this.esAutoGenerado = esAutoGenerado;
    }
    
    
}
