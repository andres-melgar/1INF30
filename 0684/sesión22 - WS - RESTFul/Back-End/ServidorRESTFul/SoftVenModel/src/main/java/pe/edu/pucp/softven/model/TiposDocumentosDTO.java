package pe.edu.pucp.softven.model;

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

    public Integer getTipoDocumentoId() {
        return tipoDocumentoId;
    }

    public void setTipoDocumentoId(Integer tipoDocumentoId) {
        this.tipoDocumentoId = tipoDocumentoId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}
