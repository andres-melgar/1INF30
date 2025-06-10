package pe.edu.pucp.softinv.daoImp.util;

public class ReporteStockParametros {

    private Integer año;
    private Integer mes;
    private Integer almacenId;
    private Integer productoId;

    public ReporteStockParametros() {
        this.año = null;
        this.mes = null;
        this.almacenId = null;
        this.productoId = null;
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
