package pe.edu.pucp.softven.model;

public class VentasDetalles {

    private Integer ventaID;
    private Integer item;
    private ProductosDTO producto;
    private Integer cantidad;
    private Double precioVenta;
    private Double descuento;
    private Double IGV;
    private Double subTotal;

    public VentasDetalles() {
        this.ventaID = null;
        this.item = null;
        this.producto = null;
        this.cantidad = null;
        this.precioVenta = null;
        this.descuento = null;
        this.IGV = null;
        this.subTotal = null;
    }

    public VentasDetalles(Integer ventaID, Integer item, ProductosDTO producto, Integer cantidad, Double precioVenta, Double descuento, Double IGV, Double subTotal) {
        this.ventaID = ventaID;
        this.item = item;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precioVenta = precioVenta;
        this.descuento = descuento;
        this.IGV = IGV;
        this.subTotal = subTotal;
    }

    public Integer getVentaID() {
        return ventaID;
    }

    public void setVentaID(Integer ventaID) {
        this.ventaID = ventaID;
    }

    public Integer getItem() {
        return item;
    }

    public void setItem(Integer item) {
        this.item = item;
    }

    public ProductosDTO getProducto() {
        return producto;
    }

    public void setProducto(ProductosDTO producto) {
        this.producto = producto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Double getDescuento() {
        return descuento;
    }

    public void setDescuento(Double descuento) {
        this.descuento = descuento;
    }

    public Double getIGV() {
        return IGV;
    }

    public void setIGV(Double IGV) {
        this.IGV = IGV;
    }

    public Double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(Double subTotal) {
        this.subTotal = subTotal;
    }

}
