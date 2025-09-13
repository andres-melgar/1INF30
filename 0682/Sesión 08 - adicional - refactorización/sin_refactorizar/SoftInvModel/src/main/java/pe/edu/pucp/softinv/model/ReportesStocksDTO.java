package pe.edu.pucp.softinv.model;

public class ReportesStocksDTO {

    private PeriodosDTO periodo;
    private ProductosDTO producto;
    private AlmacenesDTO almacen;
    private Double saldoInicial;
    private Integer entradas;
    private Integer salidas;
    private Double saldoFinal;

    public ReportesStocksDTO() {
        this.periodo = null;
        this.producto = null;
        this.almacen = null;
        this.saldoInicial = null;
        this.entradas = null;
        this.salidas = null;
        this.saldoFinal = null;
    }

    public ReportesStocksDTO(PeriodosDTO periodo, ProductosDTO producto, AlmacenesDTO almacen, Double saldoInicial, Integer entradas, Integer salidas, Double saldoFinal) {
        this.periodo = periodo;
        this.producto = producto;
        this.almacen = almacen;
        this.saldoInicial = saldoInicial;
        this.entradas = entradas;
        this.salidas = salidas;
        this.saldoFinal = saldoFinal;
    }

    /**
     * @return the periodo
     */
    public PeriodosDTO getPeriodo() {
        return periodo;
    }

    /**
     * @param periodo the periodo to set
     */
    public void setPeriodo(PeriodosDTO periodo) {
        this.periodo = periodo;
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
     * @return the saldoInicial
     */
    public Double getSaldoInicial() {
        return saldoInicial;
    }

    /**
     * @param saldoInicial the saldoInicial to set
     */
    public void setSaldoInicial(Double saldoInicial) {
        this.saldoInicial = saldoInicial;
    }

    /**
     * @return the entradas
     */
    public Integer getEntradas() {
        return entradas;
    }

    /**
     * @param entradas the entradas to set
     */
    public void setEntradas(Integer entradas) {
        this.entradas = entradas;
    }

    /**
     * @return the salidas
     */
    public Integer getSalidas() {
        return salidas;
    }

    /**
     * @param salidas the salidas to set
     */
    public void setSalidas(Integer salidas) {
        this.salidas = salidas;
    }

    /**
     * @return the saldoFinal
     */
    public Double getSaldoFinal() {
        return saldoFinal;
    }

    /**
     * @param saldoFinal the saldoFinal to set
     */
    public void setSaldoFinal(Double saldoFinal) {
        this.saldoFinal = saldoFinal;
    }
}
