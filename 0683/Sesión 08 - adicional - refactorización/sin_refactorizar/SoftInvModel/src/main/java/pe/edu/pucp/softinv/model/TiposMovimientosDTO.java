package pe.edu.pucp.softinv.model;

public class TiposMovimientosDTO {

    private Integer tipoMovimientoId;
    private String nombre;
    private String descripcion;
    private TipoOperacion tipoOperacion;

    public TiposMovimientosDTO() {
        this.tipoMovimientoId = null;
        this.nombre = null;
        this.descripcion = null;
        this.tipoOperacion = null;
    }
    
    public TiposMovimientosDTO(Integer tipoMovimientoId, String nombre, String descripcion, TipoOperacion tipoOperacion) {
        this.tipoMovimientoId = tipoMovimientoId;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipoOperacion = tipoOperacion;
    }

    /**
     * @return the tipoMovimientoId
     */
    public Integer getTipoMovimientoId() {
        return tipoMovimientoId;
    }

    /**
     * @param tipoMovimientoId the tipoMovimientoId to set
     */
    public void setTipoMovimientoId(Integer tipoMovimientoId) {
        this.tipoMovimientoId = tipoMovimientoId;
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

    /**
     * @return the tipoOperacion
     */
    public TipoOperacion getTipoOperacion() {
        return tipoOperacion;
    }

    /**
     * @param tipoOperacion the tipoOperacion to set
     */
    public void setTipoOperacion(TipoOperacion tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }
}
