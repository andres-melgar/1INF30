package pe.edu.pucp.softven.model;

public class TiendasDTO {

    private Integer tiendaId;
    private String nombre;
    private String direccion;
    private Boolean tienda_principal;
    private Double comision;

    public TiendasDTO() {
        this.tiendaId = null;
        this.nombre = null;
        this.direccion = null;
        this.tienda_principal = null;
        this.comision = null;
    }

    public TiendasDTO(Integer tiendaId, String nombre, String direccion, Boolean tienda_principal, Double comision) {
        this.tiendaId = tiendaId;
        this.nombre = nombre;
        this.direccion = direccion;
        this.tienda_principal = tienda_principal;
        this.comision = comision;
    }

    /**
     * @return the tiendaId
     */
    public Integer getTiendaId() {
        return tiendaId;
    }

    /**
     * @param tiendaId the tiendaId to set
     */
    public void setTiendaId(Integer tiendaId) {
        this.tiendaId = tiendaId;
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
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the tienda_principal
     */
    public Boolean getTienda_principal() {
        return tienda_principal;
    }

    /**
     * @param tienda_principal the tienda_principal to set
     */
    public void setTienda_principal(Boolean tienda_principal) {
        this.tienda_principal = tienda_principal;
    }

    /**
     * @return the comision
     */
    public Double getComision() {
        return comision;
    }

    /**
     * @param comision the comision to set
     */
    public void setComision(Double comision) {
        this.comision = comision;
    }

}
