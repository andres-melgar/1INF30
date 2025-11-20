package pe.edu.pucp.softinv.daoImp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.pucp.softinv.dao.ReporteStockDAO;
import pe.edu.pucp.softinv.daoImp.util.ReporteStockParametros;
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
                BuildReporteStockParametros();
        String sql = this.generarSQLParaListarPorPeriodo();        
        return (ArrayList<ReportesStocksDTO>) super.listarTodos(sql, this::incluirValorDeParametrosParaListarPorPeriodo, parametros);
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
        sql = sql.concat(" JOIN INV_PRODUCTOS p ON p.PRODUCTO_ID = r.PRODUCTO_ID ");
        sql = sql.concat(" JOIN INV_TIPOS_PRODUCTOS t on t.TIPO_PRODUCTO_ID = p.TIPO_PRODUCTO_ID     ");
        sql = sql.concat(" JOIN INV_ALMACENES a on a.ALMACEN_ID = r.ALMACEN_ID ");
        sql = sql.concat(" WHERE r.ANHO = ?");
        return sql;
    }

    private void incluirValorDeParametrosParaListarPorPeriodo(Object objetoParametros) {
        ReporteStockParametros parametros = (ReporteStockParametros) objetoParametros;
        try {            
            this.statement.setInt(1, parametros.getAño());            
        } catch (SQLException ex) {
            System.getLogger(ReporteStockDAOImpl.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.reporte = new ReportesStocksDTO();

//        AlmacenesDTO almacen = new AlmacenesDTO();
//        almacen.setAlmacenId(this.resultSet.getInt("ALMACEN_ID"));
//        almacen.setNombre(this.resultSet.getString("NOMBRE_ALMACEN"));
//        this.reporte.setAlmacen(almacen);
        
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
        String sql = "{call SP_INV_INSERTAR_DATOS_PRUEBA_REPORTE_STOCK ()}";
        Boolean conTransacion = true;
        this.ejecutarProcedimientoAlmacenado(sql, conTransacion);
    }

    @Override
    public void eliminarDatosParaPrueba() {
        String sql = "{call SP_INV_ELIMINAR_DATOS_PRUEBA_REPORTE_STOCK ()}";
        Boolean conTransacion = true;
        this.ejecutarProcedimientoAlmacenado(sql, conTransacion);
    }

    @Override
    public void generarReporteStock(Integer año, Integer mes) {
        Object parametros = new ReporteStockParametrosBuilder().
                conAño(año).
                conMes(mes).
                BuildReporteStockParametros();
        String sql = "{call SP_INV_GENERAR_REPORTE_STOCK (?, ?)}";
        Boolean conTransacion = true;
        this.ejecutarProcedimientoAlmacenado(sql, this::incluirValorDeParametrosParaGenerarReporteStock, parametros, conTransacion);
    }
    
    private void incluirValorDeParametrosParaGenerarReporteStock(Object objetoParametros) {
        ReporteStockParametros parametros = (ReporteStockParametros) objetoParametros;
        try {            
            this.statement.setInt(1, parametros.getAño());
            this.statement.setInt(2, parametros.getMes());
        } catch (SQLException ex) {
            System.getLogger(ReporteStockDAOImpl.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }

}
