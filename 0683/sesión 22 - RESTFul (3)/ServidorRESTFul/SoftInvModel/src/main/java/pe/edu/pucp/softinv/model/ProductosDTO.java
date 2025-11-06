package pe.edu.pucp.softinv.model;

public class ProductosDTO {

    private Integer productoId;
    private TiposProductosDTO tipoProducto;
    private String nombre;
    private String marca;
    private String modelo;

    public ProductosDTO() {
        this.productoId = null;
        this.tipoProducto = null;
        this.nombre = null;
        this.marca = null;
        this.modelo = null;
    }

    public ProductosDTO(Integer productoId, TiposProductosDTO tipoProducto, String nombre, String marca, String modelo) {
        this.productoId = productoId;
        this.tipoProducto = tipoProducto;
        this.nombre = nombre;
        this.marca = marca;
        this.modelo = modelo;
    }

    /**
     * @return the productoId
     */
    public Integer getProductoId() {
        return productoId;
    }

    /**
     * @param productoId the productoId to set
     */
    public void setProductoId(Integer productoId) {
        this.productoId = productoId;
    }

    /**
     * @return the tipoProducto
     */
    public TiposProductosDTO getTipoProducto() {
        return tipoProducto;
    }

    /**
     * @param tipoProducto the tipoProducto to set
     */
    public void setTipoProducto(TiposProductosDTO tipoProducto) {
        this.tipoProducto = tipoProducto;
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
     * @return the marca
     */
    public String getMarca() {
        return marca;
    }

    /**
     * @param marca the marca to set
     */
    public void setMarca(String marca) {
        this.marca = marca;
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
}
