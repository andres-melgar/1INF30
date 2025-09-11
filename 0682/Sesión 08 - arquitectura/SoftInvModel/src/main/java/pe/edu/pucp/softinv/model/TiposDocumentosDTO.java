package pe.edu.pucp.softinv.model;

public class TiposDocumentosDTO {

    private Integer tipoDocumentoId;
    private String nombre;

    public TiposDocumentosDTO() {
        this.tipoDocumentoId = null;
        this.nombre = null;
    }

    public TiposDocumentosDTO(Integer tipoDocumentoId, String nombre) {
        this.tipoDocumentoId = tipoDocumentoId;
        this.nombre = nombre;
    }

    /**
     * @return the tipoDocumentoId
     */
    public Integer getTipoDocumentoId() {
        return tipoDocumentoId;
    }

    /**
     * @param tipoDocumentoId the tipoDocumentoId to set
     */
    public void setTipoDocumentoId(Integer tipoDocumentoId) {
        this.tipoDocumentoId = tipoDocumentoId;
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

}
