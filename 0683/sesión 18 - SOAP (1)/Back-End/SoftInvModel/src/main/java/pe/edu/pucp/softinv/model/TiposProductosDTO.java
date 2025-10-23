package pe.edu.pucp.softinv.model;

public class TiposProductosDTO {

    private Integer tipoProductoId;
    private String nombre;
    private String descripcion;

    public TiposProductosDTO() {
        this.tipoProductoId = null;
        this.nombre = null;
        this.descripcion = null;
    }
    
    public TiposProductosDTO(Integer tipoProductoId, String nombre, String descripcion) {
        this.tipoProductoId = tipoProductoId;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    /**
     * @return the tipoProductoId
     */
    public Integer getTipoProductoId() {
        return tipoProductoId;
    }

    /**
     * @param tipoProductoId the tipoProductoId to set
     */
    public void setTipoProductoId(Integer tipoProductoId) {
        this.tipoProductoId = tipoProductoId;
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
