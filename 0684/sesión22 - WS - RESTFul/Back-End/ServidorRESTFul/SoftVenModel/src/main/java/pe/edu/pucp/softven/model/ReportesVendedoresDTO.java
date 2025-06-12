package pe.edu.pucp.softven.model;

public class ReportesVendedoresDTO {

    private PeriodosDTO periodo;
    private TiendasDTO tienda;
    private VendedoresDTO vendedor;
    private Double totalVentas;
    private Double totalDescuentos;

    public ReportesVendedoresDTO() {
        this.periodo = null;
        this.tienda = null;
        this.vendedor = null;
        this.totalVentas = null;
        this.totalDescuentos = null;
    }

    public ReportesVendedoresDTO(PeriodosDTO periodo, ProductosDTO producto, TiendasDTO tienda, VendedoresDTO vendedor, Double totalVentas, Double totalDescuentos) {
        this.periodo = periodo;
        this.tienda = tienda;
        this.vendedor = vendedor;
        this.totalVentas = totalVentas;
        this.totalDescuentos = totalDescuentos;
    }

    public PeriodosDTO getPeriodo() {
        return periodo;
    }

    public void setPeriodo(PeriodosDTO periodo) {
        this.periodo = periodo;
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

    public Double getTotalVentas() {
        return totalVentas;
    }

    public void setTotalVentas(Double totalVentas) {
        this.totalVentas = totalVentas;
    }

    public Double getTotalDescuentos() {
        return totalDescuentos;
    }

    public void setTotalDescuentos(Double totalDescuentos) {
        this.totalDescuentos = totalDescuentos;
    }

}
