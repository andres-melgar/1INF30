package pe.edu.pucp.softinv.model;

public class PeriodosDTO {

    private Integer anho;
    private Integer mes;
    private String descripcion;

    public PeriodosDTO() {
        this.anho = null;
        this.mes = null;
        this.descripcion = null;
    }

    public PeriodosDTO(Integer anho, Integer mes, String descripcion) {
        this.anho = anho;
        this.mes = mes;
        this.descripcion = descripcion;
    }

    /**
     * @return the anho
     */
    public Integer getAnho() {
        return anho;
    }

    /**
     * @param anho the anho to set
     */
    public void setAnho(Integer anho) {
        this.anho = anho;
    }

    /**
     * @return the mes
     */
    public Integer getMes() {
        return mes;
    }

    /**
     * @param mes the mes to set
     */
    public void setMes(Integer mes) {
        this.mes = mes;
    }

    /**
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
