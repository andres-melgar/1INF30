package pe.edu.pucp.softinv.daoImp;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import pe.edu.pucp.softinv.dao.TipoDocumentoDAO;
import pe.edu.pucp.softinv.db.DBManager;
import pe.edu.pucp.softinv.model.TiposDocumentosDTO;

public class TipoDocumentoDAOImpl implements TipoDocumentoDAO {

    private Connection conexion;
    private CallableStatement statement;
    protected ResultSet resultSet;

    @Override
    public Integer insertar(TiposDocumentosDTO tipoDocumento) {
        int resultado = 0;
        try {
            this.conexion = DBManager.getInstance().getConnection();
            this.conexion.setAutoCommit(false);
            String sql = "INSERT INTO INV_TIPOS_DOCUMENTOS (TIPO_DOCUMENTO_ID, NOMBRE) VALUES (?,?)";
            this.statement = this.conexion.prepareCall(sql);
            this.statement.setInt(1, tipoDocumento.getTipoDocumentoId());
            this.statement.setString(2, tipoDocumento.getNombre());
            resultado = this.statement.executeUpdate();
            this.conexion.commit();
        } catch (SQLException ex) {
            System.err.println("Error al intentar insertar - " + ex);
            try {
                if (this.conexion != null) {
                    this.conexion.rollback();
                }
            } catch (SQLException ex1) {
                System.err.println("Error al hacer rollback - " + ex1);
            }
        } finally {
            try {
                if (this.conexion != null) {
                    this.conexion.close();
                }
            } catch (SQLException ex) {
                System.err.println("Error al cerrar la conexión - " + ex);
            }
        }
        return resultado;
    }

    @Override
    public Integer eliminar(TiposDocumentosDTO tipoDocumento) {
        int resultado = 0;
        try {
            this.conexion = DBManager.getInstance().getConnection();
            this.conexion.setAutoCommit(false);
            String sql = "DELETE FROM INV_TIPOS_DOCUMENTOS WHERE TIPO_DOCUMENTO_ID=?";
            this.statement = this.conexion.prepareCall(sql);
            this.statement.setInt(1, tipoDocumento.getTipoDocumentoId());
            resultado = this.statement.executeUpdate();
            this.conexion.commit();
        } catch (SQLException ex) {
            System.err.println("Error al intentar eliminar - " + ex);
            try {
                if (this.conexion != null) {
                    this.conexion.rollback();
                }
            } catch (SQLException ex1) {
                System.err.println("Error al hacer rollback - " + ex1);
            }
        } finally {
            try {
                if (this.conexion != null) {
                    this.conexion.close();
                }
            } catch (SQLException ex) {
                System.err.println("Error al cerrar la conexión - " + ex);
            }
        }
        return resultado;
    }
}
