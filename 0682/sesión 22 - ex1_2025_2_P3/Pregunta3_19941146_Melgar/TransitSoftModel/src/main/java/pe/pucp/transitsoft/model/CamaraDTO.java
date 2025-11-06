package pe.pucp.transitsoft.model;

public class CamaraDTO {
    private Integer id;
    private String modelo;
    private String codigoSerie;
    private Long latitud;
    private Long longitud;

    public CamaraDTO() {
        this.id = null;
        this.modelo = null;
        this.codigoSerie = null;
        this.latitud = null;
        this.longitud = null;
    }

    public CamaraDTO(Integer id, String modelo, String codigoSerie, Long latitud, Long longitud) {
        this.id = id;
        this.modelo = modelo;
        this.codigoSerie = codigoSerie;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the modelo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * @param modelo the modelo to set
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * @return the codigoSerie
     */
    public String getCodigoSerie() {
        return codigoSerie;
    }

    /**
     * @param codigoSerie the codigoSerie to set
     */
    public void setCodigoSerie(String codigoSerie) {
        this.codigoSerie = codigoSerie;
    }

    /**
     * @return the latitud
     */
    public Long getLatitud() {
        return latitud;
    }

    /**
     * @param latitud the latitud to set
     */
    public void setLatitud(Long latitud) {
        this.latitud = latitud;
    }

    /**
     * @return the longitud
     */
    public Long getLongitud() {
        return longitud;
    }

    /**
     * @param longitud the longitud to set
     */
    public void setLongitud(Long longitud) {
        this.longitud = longitud;
    }

    
}