package pe.edu.pucp.softven.model;

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

    public Integer getAnho() {
        return anho;
    }

    public void setAnho(Integer anho) {
        this.anho = anho;
    }

    public Integer getMes() {
        return mes;
    }

    public void setMes(Integer mes) {
        this.mes = mes;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
