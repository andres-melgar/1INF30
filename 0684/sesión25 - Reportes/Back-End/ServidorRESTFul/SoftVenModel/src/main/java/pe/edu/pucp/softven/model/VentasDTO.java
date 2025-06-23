package pe.edu.pucp.softven.model;

import java.util.Date;

public class VentasDTO {
    private Integer ventasId;
    private TiposDocumentosDTO tipoDocumento;
    private String numDocCliente;
    private String nombreCliente;
    private TiendasDTO tienda;
    private VendedoresDTO vendedor;
    private Date fechaVenta;
    private Date fechaCreacion;
    private Double totalVenta;
    private Estado estado;

    public VentasDTO() {
        this.ventasId = null;
        this.tipoDocumento = null;
        this.numDocCliente = null;
        this.nombreCliente = null;
        this.tienda = null;
        this.vendedor = null;
        this.fechaVenta = null;
        this.fechaCreacion = null;
        this.totalVenta = null;
        this.estado = null;
    }
    
    public VentasDTO(Integer ventasId, TiposDocumentosDTO tipoDocumento, String numDocCliente, String nombreCliente, TiendasDTO tienda, VendedoresDTO vendedor, Date fechaVenta, Date fechaCreacion, Double totalVenta, Estado estado) {
        this.ventasId = ventasId;
        this.tipoDocumento = tipoDocumento;
        this.numDocCliente = numDocCliente;
        this.nombreCliente = nombreCliente;
        this.tienda = tienda;
        this.vendedor = vendedor;
        this.fechaVenta = fechaVenta;
        this.fechaCreacion = fechaCreacion;
        this.totalVenta = totalVenta;
        this.estado = estado;
    }

    public Integer getVentasId() {
        return ventasId;
    }

    public void setVentasId(Integer ventasId) {
        this.ventasId = ventasId;
    }

    public TiposDocumentosDTO getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(TiposDocumentosDTO tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumDocCliente() {
        return numDocCliente;
    }

    public void setNumDocCliente(String numDocCliente) {
        this.numDocCliente = numDocCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public TiendasDTO getTienda() {
        return tienda;
    }

    public void setTienda(TiendasDTO tienda) {
        this.tienda = tienda;
    }

    public VendedoresDTO getVendedor() {
        return vendedor;
    }

    public void setVendedor(VendedoresDTO vendedor) {
        this.vendedor = vendedor;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Double getTotalVenta() {
        return totalVenta;
    }

    public void setTotalVenta(Double totalVenta) {
        this.totalVenta = totalVenta;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    
    
}
