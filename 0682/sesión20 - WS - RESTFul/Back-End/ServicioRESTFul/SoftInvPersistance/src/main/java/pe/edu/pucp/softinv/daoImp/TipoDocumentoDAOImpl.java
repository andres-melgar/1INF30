package pe.edu.pucp.softinv.daoImp;

import java.sql.SQLException;
import pe.edu.pucp.softinv.dao.TipoDocumentoDAO;
import pe.edu.pucp.softinv.daoImp.util.Columna;
import pe.edu.pucp.softinv.model.TiposDocumentosDTO;

public class TipoDocumentoDAOImpl extends DAOImplBase implements TipoDocumentoDAO {

    private TiposDocumentosDTO tipoDocumento;

    public TipoDocumentoDAOImpl() {
        super("INV_TIPOS_DOCUMENTOS");
        this.tipoDocumento = null;
    }

    @Override
    protected void configurarListaDeColumnas() {
        this.listaColumnas.add(new Columna("TIPO_DOCUMENTO_ID", true, false));
        this.listaColumnas.add(new Columna("NOMBRE", false, false));
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.statement.setInt(1, tipoDocumento.getTipoDocumentoId());
        this.statement.setString(2, tipoDocumento.getNombre());
    }

    @Override
    protected void incluirValorDeParametrosParaEliminacion() throws SQLException {
        this.statement.setInt(1, tipoDocumento.getTipoDocumentoId());
    }

    @Override
    public Integer insertar(TiposDocumentosDTO tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
        return super.insertar();
//        int resultado = 0;
//        try {
//            this.conexion = DBManager.getInstance().getConnection();
//            this.conexion.setAutoCommit(false);
//            String sql = this.generarSQLParaInsercion();
//            this.statement = this.conexion.prepareCall(sql);
//            this.statement.setInt(1, tipoDocumento.getTipoDocumentoId());
//            this.statement.setString(2, tipoDocumento.getNombre());
//            resultado = this.statement.executeUpdate();
//            this.conexion.commit();
//        } catch (SQLException ex) {
//            System.err.println("Error al intentar insertar - " + ex);
//        } finally {
//            try {
//                if (this.conexion != null) {
//                    this.conexion.close();
//                }
//            } catch (SQLException ex) {
//                System.err.println("Error al cerrar la conexión - " + ex);
//            }
//        }
//        return resultado;
    }

    @Override
    public Integer eliminar(TiposDocumentosDTO tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
        return super.eliminar();
//        int resultado = 0;
//        try {
//            this.conexion = DBManager.getInstance().getConnection();
//            this.conexion.setAutoCommit(false);
//            String sql = this.generarSQLParaEliminacion();
//            this.statement = this.conexion.prepareCall(sql);
//            this.statement.setInt(1, tipoDocumento.getTipoDocumentoId());
//            resultado = this.statement.executeUpdate();
//            this.conexion.commit();
//        } catch (SQLException ex) {
//            System.err.println("Error al intentar eliminar - " + ex);
//        } finally {
//            try {
//                if (this.conexion != null) {
//                    this.conexion.close();
//                }
//            } catch (SQLException ex) {
//                System.err.println("Error al cerrar la conexión - " + ex);
//            }
//        }
//        return resultado;
    }
}
