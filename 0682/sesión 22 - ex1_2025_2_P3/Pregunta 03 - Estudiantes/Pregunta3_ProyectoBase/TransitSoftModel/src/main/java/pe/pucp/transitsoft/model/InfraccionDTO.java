package pe.pucp.transitsoft.model;

import java.util.Date;

public class InfraccionDTO {
    private String placa;
    private Double velocidad;
    private Double limite;
    private Double exceso;
    private String marcaVehiculo;
    private String modeloVehiculo;
    private Integer anhoVehiculo;
    private String dniPropietario;
    private String nombresPropietario;
    private String apellidosPropietario;
    private String direccionPropietario;
    private String modeloCamara;
    private String codigoSerieCamara;
    private Long latitud;
    private Long longitud;
    private Double monto;
    private Date fechaCaptura;
    private Date fechaRegistro;

    public InfraccionDTO() {
        this.placa = null;
        this.velocidad = null;
        this.limite = null;
        this.exceso = null;
        this.marcaVehiculo = null;
        this.modeloVehiculo = null;
        this.anhoVehiculo = null;
        this.dniPropietario = null;
        this.nombresPropietario = null;
        this.apellidosPropietario = null;
        this.direccionPropietario = null;
        this.modeloCamara = null;
        this.codigoSerieCamara = null;
        this.latitud = null;
        this.longitud = null;
        this.monto = null;
        this.fechaCaptura = null;
        this.fechaRegistro = null;
    }

    public InfraccionDTO(String placa, Double velocidad, Double limite, Double exceso, String marcaVehiculo, String modeloVehiculo, Integer anhoVehiculo, String dniPropietario, String nombresPropietario, String apellidosPropietario, String direccionPropietario, String modeloCamara, String codigoSerieCamara, Long latitud, Long longitud, Double monto, Date fechaCaptura, Date fechaRegistro) {
        this.placa = placa;
        this.velocidad = velocidad;
        this.limite = limite;
        this.exceso = exceso;
        this.marcaVehiculo = marcaVehiculo;
        this.modeloVehiculo = modeloVehiculo;
        this.anhoVehiculo = anhoVehiculo;
        this.dniPropietario = dniPropietario;
        this.nombresPropietario = nombresPropietario;
        this.apellidosPropietario = apellidosPropietario;
        this.direccionPropietario = direccionPropietario;
        this.modeloCamara = modeloCamara;
        this.codigoSerieCamara = codigoSerieCamara;
        this.latitud = latitud;
        this.longitud = longitud;
        this.monto = monto;
        this.fechaCaptura = fechaCaptura;
        this.fechaRegistro = fechaRegistro;
    }

    /**
     * @return the placa
     */
    public String getPlaca() {
        return placa;
    }

    /**
     * @param placa the placa to set
     */
    public void setPlaca(String placa) {
        this.placa = placa;
    }

    /**
     * @return the velocidad
     */
    public Double getVelocidad() {
        return velocidad;
    }

    /**
     * @param velocidad the velocidad to set
     */
    public void setVelocidad(Double velocidad) {
        this.velocidad = velocidad;
    }

    /**
     * @return the limite
     */
    public Double getLimite() {
        return limite;
    }

    /**
     * @param limite the limite to set
     */
    public void setLimite(Double limite) {
        this.limite = limite;
    }

    /**
     * @return the exceso
     */
    public Double getExceso() {
        return exceso;
    }

    /**
     * @param exceso the exceso to set
     */
    public void setExceso(Double exceso) {
        this.exceso = exceso;
    }

    /**
     * @return the marcaVehiculo
     */
    public String getMarcaVehiculo() {
        return marcaVehiculo;
    }

    /**
     * @param marcaVehiculo the marcaVehiculo to set
     */
    public void setMarcaVehiculo(String marcaVehiculo) {
        this.marcaVehiculo = marcaVehiculo;
    }

    /**
     * @return the modeloVehiculo
     */
    public String getModeloVehiculo() {
        return modeloVehiculo;
    }

    /**
     * @param modeloVehiculo the modeloVehiculo to set
     */
    public void setModeloVehiculo(String modeloVehiculo) {
        this.modeloVehiculo = modeloVehiculo;
    }

    /**
     * @return the anhoVehiculo
     */
    public Integer getAnhoVehiculo() {
        return anhoVehiculo;
    }

    /**
     * @param anhoVehiculo the anhoVehiculo to set
     */
    public void setAnhoVehiculo(Integer anhoVehiculo) {
        this.anhoVehiculo = anhoVehiculo;
    }

    /**
     * @return the dniPropietario
     */
    public String getDniPropietario() {
        return dniPropietario;
    }

    /**
     * @param dniPropietario the dniPropietario to set
     */
    public void setDniPropietario(String dniPropietario) {
        this.dniPropietario = dniPropietario;
    }

    /**
     * @return the nombresPropietario
     */
    public String getNombresPropietario() {
        return nombresPropietario;
    }

    /**
     * @param nombresPropietario the nombresPropietario to set
     */
    public void setNombresPropietario(String nombresPropietario) {
        this.nombresPropietario = nombresPropietario;
    }

    /**
     * @return the apellidosPropietario
     */
    public String getApellidosPropietario() {
        return apellidosPropietario;
    }

    /**
     * @param apellidosPropietario the apellidosPropietario to set
     */
    public void setApellidosPropietario(String apellidosPropietario) {
        this.apellidosPropietario = apellidosPropietario;
    }

    /**
     * @return the direccionPropietario
     */
    public String getDireccionPropietario() {
        return direccionPropietario;
    }

    /**
     * @param direccionPropietario the direccionPropietario to set
     */
    public void setDireccionPropietario(String direccionPropietario) {
        this.direccionPropietario = direccionPropietario;
    }

    /**
     * @return the modeloCamara
     */
    public String getModeloCamara() {
        return modeloCamara;
    }

    /**
     * @param modeloCamara the modeloCamara to set
     */
    public void setModeloCamara(String modeloCamara) {
        this.modeloCamara = modeloCamara;
    }

    /**
     * @return the codigoSerieCamara
     */
    public String getCodigoSerieCamara() {
        return codigoSerieCamara;
    }

    /**
     * @param codigoSerieCamara the codigoSerieCamara to set
     */
    public void setCodigoSerieCamara(String codigoSerieCamara) {
        this.codigoSerieCamara = codigoSerieCamara;
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

    /**
     * @return the monto
     */
    public Double getMonto() {
        return monto;
    }

    /**
     * @param monto the monto to set
     */
    public void setMonto(Double monto) {
        this.monto = monto;
    }

    /**
     * @return the fechaCaptura
     */
    public Date getFechaCaptura() {
        return fechaCaptura;
    }

    /**
     * @param fechaCaptura the fechaCaptura to set
     */
    public void setFechaCaptura(Date fechaCaptura) {
        this.fechaCaptura = fechaCaptura;
    }

    /**
     * @return the fechaRegistro
     */
    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    /**
     * @param fechaRegistro the fechaRegistro to set
     */
    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    
    
}
