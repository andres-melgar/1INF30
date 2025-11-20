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
        this.statement.setInt(1, this.tipoDocumento.getTipoDocumentoId());
        this.statement.setString(2, this.tipoDocumento.getNombre());
    }

    @Override
    protected void incluirValorDeParametrosParaEliminacion() throws SQLException {
        this.statement.setInt(1, this.tipoDocumento.getTipoDocumentoId());
    }

    @Override
    public Integer insertar(TiposDocumentosDTO tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
        return super.insertar();
    }

    @Override
    public Integer eliminar(TiposDocumentosDTO tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
        return super.eliminar();
    }
}
