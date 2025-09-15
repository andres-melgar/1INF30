package pe.edu.pucp.softinv.model;

import java.util.Date;

public class MovimientosDTO {

    private Integer movimientoId;
    private TiposMovimientosDTO tipoMovimiento;
    private Date fechaMovimiento;
    private Date fechaCreacion;
    private TiposDocumentosDTO tipoDocumento;
    private String numeroDocumento;
    private AlmacenesDTO almacen;
    private ProductosDTO producto;
    private Integer cantidad;
    private Double valor;

    public MovimientosDTO() {
        this.movimientoId = null;
        this.tipoMovimiento = null;
        this.fechaMovimiento = null;
        this.fechaCreacion = null;
        this.tipoDocumento = null;
        this.numeroDocumento = null;
        this.almacen = null;
        this.producto = null;
        this.cantidad = null;
        this.valor = null;
    }

    public MovimientosDTO(Integer movimientoId, TiposMovimientosDTO tipoMovimiento, Date fechaMovimiento, Date fechaCreacion, TiposDocumentosDTO tipoDocumento, String numeroDocumento, AlmacenesDTO almacen, ProductosDTO producto, Integer cantidad, Double valor) {
        this.movimientoId = movimientoId;
        this.tipoMovimiento = tipoMovimiento;
        this.fechaMovimiento = fechaMovimiento;
        this.fechaCreacion = fechaCreacion;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.almacen = almacen;
        this.producto = producto;
        this.cantidad = cantidad;
        this.valor = valor;
    }

    /**
     * @return the movimientoId
     */
    public Integer getMovimientoId() {
        return movimientoId;
    }

    /**
     * @param movimientoId the movimientoId to set
     */
    public void setMovimientoId(Integer movimientoId) {
        this.movimientoId = movimientoId;
    }

    /**
     * @return the tipoMovimiento
     */
    public TiposMovimientosDTO getTipoMovimiento() {
        return tipoMovimiento;
    }

    /**
     * @param tipoMovimiento the tipoMovimiento to set
     */
    public void setTipoMovimiento(TiposMovimientosDTO tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    /**
     * @return the fechaMovimiento
     */
    public Date getFechaMovimiento() {
        return fechaMovimiento;
    }

    /**
     * @param fechaMovimiento the fechaMovimiento to set
     */
    public void setFechaMovimiento(Date fechaMovimiento) {
        this.fechaMovimiento = fechaMovimiento;
    }

    /**
     * @return the fechaCreacion
     */
    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    /**
     * @param fechaCreacion the fechaCreacion to set
     */
    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    /**
     * @return the tipoDocumento
     */
    public TiposDocumentosDTO getTipoDocumento() {
        return tipoDocumento;
    }

    /**
     * @param tipoDocumento the tipoDocumento to set
     */
    public void setTipoDocumento(TiposDocumentosDTO tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    /**
     * @return the numeroDocumento
     */
    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    /**
     * @param numeroDocumento the numeroDocumento to set
     */
    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    /**
     * @return the almacen
     */
    public AlmacenesDTO getAlmacen() {
        return almacen;
    }

    /**
     * @param almacen the almacen to set
     */
    public void setAlmacen(AlmacenesDTO almacen) {
        this.almacen = almacen;
    }

    /**
     * @return the producto
     */
    public ProductosDTO getProducto() {
        return producto;
    }

    /**
     * @param producto the producto to set
     */
    public void setProducto(ProductosDTO producto) {
        this.producto = producto;
    }

    /**
     * @return the cantidad
     */
    public Integer getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * @return the valor
     */
    public Double getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(Double valor) {
        this.valor = valor;
    }
}
