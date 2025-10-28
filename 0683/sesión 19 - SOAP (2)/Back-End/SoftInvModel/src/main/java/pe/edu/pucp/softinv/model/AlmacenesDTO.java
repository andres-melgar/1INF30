package pe.edu.pucp.softinv.model;

public class AlmacenesDTO {

    private Integer almacenId;
    private String nombre;
    private Boolean almacen_central;

    public AlmacenesDTO() {
        this.almacenId = null;
        this.nombre = null;
        this.almacen_central = null;
    }
    
    public AlmacenesDTO(Integer almacenId, String nombre, Boolean almacen_central) {
        this.almacenId = almacenId;
        this.nombre = nombre;
        this.almacen_central = almacen_central;
    }

    /**
     * @return the almacenId
     */
    public Integer getAlmacenId() {
        return almacenId;
    }

    /**
     * @param almacenId the almacenId to set
     */
    public void setAlmacenId(Integer almacenId) {
        this.almacenId = almacenId;
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
     * @return the almacen_central
     */
    public Boolean getAlmacen_central() {
        return almacen_central;
    }

    /**
     * @param almacen_central the almacen_central to set
     */
    public void setAlmacen_central(Boolean almacen_central) {
        this.almacen_central = almacen_central;
    }
    
    
}
