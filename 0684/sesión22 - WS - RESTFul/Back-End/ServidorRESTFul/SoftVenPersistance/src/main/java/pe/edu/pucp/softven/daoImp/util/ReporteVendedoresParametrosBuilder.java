package pe.edu.pucp.softven.daoImp.util;

public class ReporteVendedoresParametrosBuilder {
    
    private Integer año;
    private Integer mes;
    private Integer tiendaId;
    private Integer vendedorId;
    
    public ReporteVendedoresParametrosBuilder() {
        this.año = null;
        this.mes = null;
        this.tiendaId = null;
        this.vendedorId = null;
    }
    
    public ReporteVendedoresParametrosBuilder conAño(Integer año) {
        this.setAño(año);
        return this;
    }
    
    public ReporteVendedoresParametrosBuilder conMes(Integer mes) {
        this.setMes(mes);
        return this;
    }
    
    public ReporteVendedoresParametrosBuilder conTienda(Integer tiendaId) {
        this.setTiendaId(tiendaId);
        return this;
    }
    
    public ReporteVendedoresParametrosBuilder conVendedor(Integer vendedorId) {
        this.setVendedorId(vendedorId);
        return this;
    }
    
    public ReporteVendedoresParametros BuilReporteVendedoresParametros() {
        ReporteVendedoresParametros parametros = new ReporteVendedoresParametros();
        parametros.setAño(this.getAño());
        parametros.setMes(this.getMes());
        parametros.setTiendaId(this.tiendaId);
        parametros.setVendedorId(this.vendedorId);
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
     * @return the tiendaId
     */
    public Integer getTiendaId() {
        return tiendaId;
    }

    /**
     * @param tiendaId the tiendaId to set
     */
    public void setTiendaId(Integer tiendaId) {
        this.tiendaId = tiendaId;
    }

    /**
     * @return the vendedorId
     */
    public Integer getVendedorId() {
        return vendedorId;
    }

    /**
     * @param vendedorId the vendedorId to set
     */
    public void setVendedorId(Integer vendedorId) {
        this.vendedorId = vendedorId;
    }
}
