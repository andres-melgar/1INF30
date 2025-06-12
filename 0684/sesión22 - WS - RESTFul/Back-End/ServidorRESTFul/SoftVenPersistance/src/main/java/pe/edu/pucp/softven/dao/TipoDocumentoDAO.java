package pe.edu.pucp.softven.dao;

import pe.edu.pucp.softven.model.TiposDocumentosDTO;

public interface TipoDocumentoDAO {

    public Integer insertar(TiposDocumentosDTO tipoDocumento);

    public Integer eliminar(TiposDocumentosDTO tipoDocumento);
}
