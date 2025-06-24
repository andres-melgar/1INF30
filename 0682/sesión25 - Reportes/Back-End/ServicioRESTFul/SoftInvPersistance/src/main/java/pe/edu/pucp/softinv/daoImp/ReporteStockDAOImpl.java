package pe.edu.pucp.softinv.daoImp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.edu.pucp.softinv.dao.ReporteStockDAO;
import pe.edu.pucp.softinv.daoImp.util.ReporteStockParametros;
import pe.edu.pucp.softinv.daoImp.util.ReporteStockParametrosBuilder;
import pe.edu.pucp.softinv.model.ReportesStocksDTO;

public class ReporteStockDAOImpl extends DAOImplBase implements ReporteStockDAO {

    private ReportesStocksDTO reporte;
    
    public ReporteStockDAOImpl() {
        super("INV_REPORTES_STOCKS");
        this.reporte = null;
    }

    @Override
    protected void configurarListaDeColumnas() {
        //no se incluirán columnas pues este DAO no corresponde
        //a un CRUD típico
    }
    
    @Override
    protected void agregarObjetoALaLista(List lista) throws SQLException {
        this.instanciarObjetoDelResultSet();
        lista.add(this.reporte);
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.reporte = new ReportesStocksDTO();
        this.reporte.setSaldoInicial(this.resultSet.getDouble("SALDO_INICIAL"));
    }

    @Override
    public void insertarDatosDePrueba() {
        String sql = "{call SP_INV_INSERTAR_DATOS_PRUEBA_REPORTE_STOCK()}";
        Boolean conTransaccion = true;
        this.ejecutarProcedimientoAlmacenado(sql, conTransaccion);
    }

    @Override
    public void eliminarDatosDePrueba() {
        String sql = "{call SP_INV_ELIMINAR_DATOS_PRUEBA_REPORTE_STOCK()}";
        Boolean conTransaccion = true;
        this.ejecutarProcedimientoAlmacenado(sql, conTransaccion);
    }

    @Override
    public void generarReporteStock(Integer año, Integer mes) {
        Object parametros = new ReporteStockParametrosBuilder().
                conAño(año).
                conMes(mes).
                BuilReporteStockParametros();
        String sql = "{call SP_INV_GENERAR_REPORTE_STOCK(?, ?)}";
        Boolean conTransaccion = true;
        this.ejecutarProcedimientoAlmacenado(sql, this::incluirValorDeParametrosParaGenerarReporteStock, parametros, conTransaccion);
    }

    private void incluirValorDeParametrosParaGenerarReporteStock(Object objetoParametros) {
        ReporteStockParametros parametros = (ReporteStockParametros) objetoParametros;
        try {
            this.statement.setInt(1, parametros.getAño());
            this.statement.setInt(2, parametros.getMes());
        } catch (SQLException ex) {
            Logger.getLogger(ReporteStockDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        return (ArrayList<ReportesStocksDTO>) super.listarTodos(sql, this::incluirValorDeParametrosParaListarPorPeriodo, parametros);
    }
    
    private void incluirValorDeParametrosParaListarPorPeriodo(Object objetoParametros){
        ReporteStockParametros parametros = (ReporteStockParametros) objetoParametros;
        try {
            this.statement.setInt(1, parametros.getAño());
        } catch (SQLException ex) {
            Logger.getLogger(ReporteStockDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    private String generarSQLParaListarPorPeriodo() {
        String sql = "SELECT r.ANHO, ";
        sql = sql.concat("r.MES, ");
        sql = sql.concat("a.ALMACEN_ID, ");
        sql = sql.concat("a.NOMBRE AS NOMBRE_ALMACEN, ");
        sql = sql.concat("a.ALMACEN_CENTRAL, ");
        sql = sql.concat("p.PRODUCTO_ID, ");
        sql = sql.concat("t.TIPO_PRODUCTO_ID, ");
        sql = sql.concat("t.NOMBRE AS NOMBRE_TIPO_PRODUCTO, ");
        sql = sql.concat("t.DESCRIPCION, ");
        sql = sql.concat("p.NOMBRE AS NOMBRE_PRODUCTO, ");
        sql = sql.concat("p.MARCA, ");
        sql = sql.concat("p.MODELO, ");
        sql = sql.concat("r.SALDO_INICIAL, r.ENTRADAS, r.SALIDAS, r.SALDO_FINAL ");
        sql = sql.concat("FROM INV_REPORTES_STOCKS r ");
        sql = sql.concat("JOIN INV_PRODUCTOS p ON p.PRODUCTO_ID = r.PRODUCTO_ID ");
        sql = sql.concat("JOIN INV_TIPOS_PRODUCTOS t on t.TIPO_PRODUCTO_ID = p.TIPO_PRODUCTO_ID ");
        sql = sql.concat("JOIN INV_ALMACENES a on a.ALMACEN_ID = r.ALMACEN_ID ");
        sql = sql.concat("WHERE r.ANHO = ? ");
        return sql;
    }

}
