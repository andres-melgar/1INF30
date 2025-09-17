package pe.edu.pucp.softinv.daoImp.util;

public class ReporteStockParametrosBuilder {

    private Integer año;
    private Integer mes;
    private Integer almacenId;
    private Integer productoId;

    public ReporteStockParametrosBuilder() {
        this.año = null;
        this.mes = null;
        this.almacenId = null;
        this.productoId = null;
    }

    public ReporteStockParametrosBuilder conAño(Integer año) {
        this.año = año;
        return this;
    }

    public ReporteStockParametrosBuilder conMes(Integer mes) {
        this.mes = mes;
        return this;
    }

    public ReporteStockParametrosBuilder conAlmacenId(Integer almacenId) {
        this.almacenId = almacenId;
        return this;
    }

    public ReporteStockParametrosBuilder conProductoId(Integer productoId) {
        this.productoId = productoId;
        return this;
    }

    public ReporteStockParametros BuilReporteStockParametros() {
        ReporteStockParametros parametros = new ReporteStockParametros();
        parametros.setAño(this.getAño());
        parametros.setMes(this.getMes());
        parametros.setAlmacenId(this.getAlmacenId());
        parametros.setProductoId(this.getProductoId());
        return parametros;
    }

    /**
     * @return the año
     */
    public Integer getAño() {
        return año;
    }

    /**
     * @param año the año to set
     */
    public void setAño(Integer año) {
        this.año = año;
    }

    /**
     * @return the mes
     */
    public Integer getMes() {
        return mes;
    }

    /**
     * @param mes the mes to set
     */
    public void setMes(Integer mes) {
        this.mes = mes;
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

}
