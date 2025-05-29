package pe.edu.pucp.softven.daoImp.util;

public class Columna {

    private String nombre;
    private Tipo_Dato tipoDato;
    private Boolean esllavePrimaria;
    private Boolean esAutoGenerado;

    public Columna(String nombre, Tipo_Dato tipoDato, Boolean esllavePrimaria, Boolean esAutoGenerado) {
        this.nombre = nombre;
        this.tipoDato = tipoDato;
        this.esllavePrimaria = esllavePrimaria;
        this.esAutoGenerado = esAutoGenerado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Tipo_Dato getTipoDato() {
        return tipoDato;
    }

    public void setTipoDato(Tipo_Dato tipoDato) {
        this.tipoDato = tipoDato;
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
