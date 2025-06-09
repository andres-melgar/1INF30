package pe.edu.pucp.softven.daoImp;

import java.sql.SQLException;
import pe.edu.pucp.softven.dao.TipoDocumentoDAO;
import pe.edu.pucp.softven.daoImp.util.Columna;
import pe.edu.pucp.softven.daoImp.util.Tipo_Dato;
import pe.edu.pucp.softven.db.DBManager;
import pe.edu.pucp.softven.model.TiposDocumentosDTO;

public class TipoDocumentoDAOImpl extends DAOImplBase implements TipoDocumentoDAO {

    private TiposDocumentosDTO tipoDocumento;

    public TipoDocumentoDAOImpl() {
        super("VEN_TIPOS_DOCUMENTOS");
        this.tipoDocumento = null;
    }

    @Override
    protected void configurarListaDeColumnas() {
        this.listaColumnas.add(new Columna("TIPO_DOCUMENTO_ID", Tipo_Dato.ENTERO, true, false));
        this.listaColumnas.add(new Columna("NOMBRE", Tipo_Dato.CADENA, false, false));
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.statement.setInt(1, this.tipoDocumento.getTipoDocumentoId());
        this.statement.setString(2, this.tipoDocumento.getNombre());
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
//            String sql = "INSERT INTO VEN_TIPOS_DOCUMENTOS (TIPO_DOCUMENTO_ID, NOMBRE) VALUES (?,?)";
//            this.statement = this.conexion.prepareCall(sql);
//            this.statement.setInt(1, tipoDocumento.getTipoDocumentoId());
//            this.statement.setString(2, tipoDocumento.getNombre());
//            resultado = this.statement.executeUpdate();
//            this.conexion.commit();
//        } catch (SQLException ex) {
//            System.err.println("Error al intentar insertar - " + ex);
//            try {
//                if (this.conexion != null) {
//                    this.conexion.rollback();
//                }
//            } catch (SQLException ex1) {
//                System.err.println("Error al hacer rollback - " + ex1);
//            }
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
//            String sql = "DELETE FROM VEN_TIPOS_DOCUMENTOS WHERE TIPO_DOCUMENTO_ID=?";
//            this.statement = this.conexion.prepareCall(sql);
//            this.statement.setInt(1, tipoDocumento.getTipoDocumentoId());
//            resultado = this.statement.executeUpdate();
//            this.conexion.commit();
//        } catch (SQLException ex) {
//            System.err.println("Error al intentar eliminar - " + ex);
//            try {
//                if (this.conexion != null) {
//                    this.conexion.rollback();
//                }
//            } catch (SQLException ex1) {
//                System.err.println("Error al hacer rollback - " + ex1);
//            }
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
