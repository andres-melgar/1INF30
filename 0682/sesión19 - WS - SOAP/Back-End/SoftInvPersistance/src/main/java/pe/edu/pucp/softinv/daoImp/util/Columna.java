package pe.edu.pucp.softinv.daoImp.util;

public class Columna {

    private String nombre;
    private Boolean esllavePrimaria;
    private Boolean esAutoGenerado;

    public Columna(String nombre, Boolean esllavePrimaria, Boolean esAutoGenerado) {
        this.nombre = nombre;
        this.esllavePrimaria = esllavePrimaria;
        this.esAutoGenerado = esAutoGenerado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getEsllavePrimaria() {
        return esllavePrimaria;
    }

    public void setEsllavePrimaria(Boolean esllavePrimaria) {
        this.esllavePrimaria = esllavePrimaria;
    }

    public Boolean getEsAutoGenerado() {
        return esAutoGenerado;
    }

    public void setEsAutoGenerado(Boolean esAutoGenerado) {
        this.esAutoGenerado = esAutoGenerado;
    }

}
