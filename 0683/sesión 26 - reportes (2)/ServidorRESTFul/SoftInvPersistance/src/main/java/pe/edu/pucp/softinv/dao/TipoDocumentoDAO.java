
package pe.edu.pucp.softinv.dao;

import pe.edu.pucp.softinv.model.TiposDocumentosDTO;

public interface TipoDocumentoDAO {
    
    public Integer insertar(TiposDocumentosDTO tipoDocumento);
    
    public Integer eliminar(TiposDocumentosDTO tipoDocumento);
    
}
