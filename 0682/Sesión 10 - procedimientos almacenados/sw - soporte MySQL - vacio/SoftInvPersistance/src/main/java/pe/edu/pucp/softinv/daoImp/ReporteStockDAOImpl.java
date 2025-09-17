package pe.edu.pucp.softinv.daoImp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.pucp.softinv.dao.ReporteStockDAO;
import pe.edu.pucp.softinv.daoImp.util.ReporteStockParametrosBuilder;
import pe.edu.pucp.softinv.model.ReportesStocksDTO;

public class ReporteStockDAOImpl extends DAOImplBase implements ReporteStockDAO {

    private ReportesStocksDTO reporte;

    public ReporteStockDAOImpl() {
        super("INV_REPORTES_STOCKS");
        this.retornarLlavePrimaria = true;
        this.reporte = null;
    }

    @Override
    protected void configurarListaDeColumnas() {
        //no se incluirán las columnas pues no se generará el SQL genérico
        //sino un SQL específico para este reporte
    }

    @Override
    public ArrayList<ReportesStocksDTO> listarPorPeriodo(Integer año, Integer mes, Integer almacenId, Integer productoId) {
        Object parametros = new ReporteStockParametrosBuilder().
                conAño(año).
                conMes(mes).
                conAlmacenId(almacenId).
                conProductoId(productoId).
                BuilReporteStockParametros();
        String sql = this.generarSQLParaListarPorPeriodo();
        //TODO;
        return null;
    }

    private String generarSQLParaListarPorPeriodo() {
        String sql = "SELECT ";
        sql = sql.concat("r.ANHO, ");
        sql = sql.concat("r.MES, ");
        sql = sql.concat("r.ALMACEN_ID, ");
        sql = sql.concat("r.PRODUCTO_ID, ");
        sql = sql.concat("r.SALDO_INICIAL, ");
        sql = sql.concat("r.ENTRADAS, ");
        sql = sql.concat("r.SALIDAS, ");
        sql = sql.concat("r.SALDO_FINAL ");
        sql = sql.concat(" FROM INV_REPORTES_STOCKS r");
        sql = sql.concat(" WHERE r.ANHO = ?");
        return sql;
    }

    private void incluirValorDeParametrosParaListarPorPeriodo(Object objetoParametros) {
        //TODO
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.reporte = new ReportesStocksDTO();

        this.reporte.setSaldoInicial(this.resultSet.getDouble("SALDO_INICIAL"));
        this.reporte.setEntradas(this.resultSet.getInt("ENTRADAS"));
        this.reporte.setSalidas(this.resultSet.getInt("SALIDAS"));
        this.reporte.setSaldoFinal(this.resultSet.getDouble("SALDO_FINAL"));
    }

    @Override
    protected void agregarObjetoALaLista(List lista) throws SQLException {
        this.instanciarObjetoDelResultSet();
        lista.add(this.reporte);
    }

    @Override
    public void insertarDatosParaPrueba() {
        String sql = "call SP_INV_INSERTAR_DATOS_PRUEBA_REPORTE_STOCK ()";
        Boolean conTransacion = true;
        this.ejecutarProcedimientoAlmacenado(sql, conTransacion);
    }

    @Override
    public void eliminarDatosParaPrueba() {
        String sql = "call SP_INV_ELIMINAR_DATOS_PRUEBA_REPORTE_STOCK ()";
        Boolean conTransacion = true;
        this.ejecutarProcedimientoAlmacenado(sql, conTransacion);
    }

    @Override
    public void generarReporteStock(Integer año, Integer mes) {
        Object parametros = new ReporteStockParametrosBuilder().
                conAño(año).
                conMes(mes).
                BuilReporteStockParametros();
        String sql = "call SP_INV_GENERAR_REPORTE_STOCK (?, ?)";
        Boolean conTransacion = true;
        //TODO
    }
    
    private void incluirValorDeParametrosParaGenerarReporteStock(Object objetoParametros) {
        //TODO
    }

}
