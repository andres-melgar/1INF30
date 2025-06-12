package pe.edu.pucp.softven.daoImp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.edu.pucp.softven.dao.ReporteVendedorDAO;
import pe.edu.pucp.softven.daoImp.util.ReporteVendedoresParametros;
import pe.edu.pucp.softven.daoImp.util.ReporteVendedoresParametrosBuilder;
import pe.edu.pucp.softven.model.ReportesVendedoresDTO;

public class ReporteVendedoresDAOImpl extends DAOImplBase implements ReporteVendedorDAO {

    private ReportesVendedoresDTO reporte;
    
    public ReporteVendedoresDAOImpl() {
        super("VEN_REPORTES_VENDEDORES");
        this.reporte = null;
    }

    @Override
    protected void configurarListaDeColumnas() {
        //no se configura porque se invocará a procedimientos almacenados
        //y SQL con varios joins
    }
    
    @Override
    protected void agregarObjetoALaLista(List lista) throws SQLException {
        this.instanciarObjetoDelResultSet();
        lista.add(this.reporte);
    }
    
    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.reporte = new ReportesVendedoresDTO();
        this.reporte.setTotalVentas(this.resultSet.getDouble("TOTAL_VENTAS"));
        this.reporte.setTotalDescuentos(this.resultSet.getDouble("TOTAL_DESCUENTOS"));
    }

    @Override
    public void insertarDatosParaPrueba() {
        String sql = "{CALL SP_VEN_INSERTAR_DATOS_PRUEBA_REPORTE_VENDEDORES()}";
        Boolean conTransaccion = true;
        this.ejecutarProcedimientoAlmacenado(sql, conTransaccion);
    }

    @Override
    public void eliminarDatosParaPrueba() {
        String sql = "{CALL SP_VEN_ELIMINAR_DATOS_PRUEBA_REPORTE_VENDEDORES()}";
        Boolean conTransaccion = true;
        this.ejecutarProcedimientoAlmacenado(sql, conTransaccion);
    }

    @Override
    public void generarReporteVendedores(Integer año, Integer mes) {
        Object parametros = new ReporteVendedoresParametrosBuilder().
                conAño(año).
                conMes(mes).
                BuilReporteVendedoresParametros();
        String sql = "{CALL SP_VEN_GENERAR_REPORTE_VENDEDORES(?, ?)}";
        Boolean conTransaccion = true;
        this.ejecutarProcedimientoAlmacenado(sql, this::incluirValorDelParametroParaGenerarReporteDeVendedores, parametros, conTransaccion);
    }

    private void incluirValorDelParametroParaGenerarReporteDeVendedores(Object objetoParametros) {
        ReporteVendedoresParametros parametros = (ReporteVendedoresParametros) objetoParametros;
        try {
            this.statement.setInt(1, parametros.getAño());
            this.statement.setInt(2, parametros.getMes());
        } catch (SQLException ex) {
            Logger.getLogger(ReporteVendedoresDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public ArrayList<ReportesVendedoresDTO> listarPorPeriodo(Integer año, Integer mes, Integer tiendaId) {
        Object parametros = new ReporteVendedoresParametrosBuilder().
                conAño(año).
                conMes(mes).
                conTienda(tiendaId).
                BuilReporteVendedoresParametros();
        String sql = this.generarSQLParaListarPorPeriodo();
        return (ArrayList<ReportesVendedoresDTO>) super.listarTodos(sql, this::incluirValorDeParametroParaListarPorPeriodo,  parametros);
    }

    private void incluirValorDeParametroParaListarPorPeriodo(Object objetoParametros){
        ReporteVendedoresParametros parametros = (ReporteVendedoresParametros)objetoParametros;
        try {
            this.statement.setInt(1, parametros.getAño());
        } catch (SQLException ex) {
            Logger.getLogger(ReporteVendedoresDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private String generarSQLParaListarPorPeriodo() {
        String sql = "SELECT r.ANHO, ";
        sql = sql.concat("r.MES, ");
        sql = sql.concat("t.TIENDA_ID, ");
        sql = sql.concat("t.NOMBRE, ");
        sql = sql.concat("t.DIRECCION, ");
        sql = sql.concat("t.TIENDA_PRINCIPAL, ");
        sql = sql.concat("t.COMISION, ");
        sql = sql.concat("v.VENDEDOR_ID, ");
        sql = sql.concat("v.PATERNO, ");
        sql = sql.concat("v.MATERNO, ");
        sql = sql.concat("v.NOMBRES, ");
        sql = sql.concat("r.TOTAL_VENTAS, ");
        sql = sql.concat("r.TOTAL_DESCUENTOS ");
        sql = sql.concat("FROM VEN_REPORTES_VENDEDORES r ");
        sql = sql.concat("JOIN VEN_TIENDAS t ON t.TIENDA_ID = r.TIENDA_ID ");
        sql = sql.concat("JOIN VEN_VENDEDORES v ON v.VENDEDOR_ID = r.VENDEDOR_ID ");
        sql = sql.concat("AND v.TIENDA_ID = r.TIENDA_ID ");
        sql = sql.concat("WHERE r.ANHO = ?" );
        return sql;
    }

}
