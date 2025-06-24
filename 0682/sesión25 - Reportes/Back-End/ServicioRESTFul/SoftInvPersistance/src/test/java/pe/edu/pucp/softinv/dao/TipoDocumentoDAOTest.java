package pe.edu.pucp.softinv.dao;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pe.edu.pucp.softinv.daoImp.TipoDocumentoDAOImpl;
import pe.edu.pucp.softinv.model.TiposDocumentosDTO;

public class TipoDocumentoDAOTest {

    private TipoDocumentoDAO tipoDocumentoDAO;
    
    public TipoDocumentoDAOTest() {
        this.tipoDocumentoDAO = new TipoDocumentoDAOImpl();
    }

    @Test
    public void testInsertar() {
        System.out.println("insertar");
        
        TiposDocumentosDTO tipoDocumentos = new TiposDocumentosDTO();
        tipoDocumentos.setTipoDocumentoId(1);
        tipoDocumentos.setNombre("Orden de compra");
        Integer resultado = this.tipoDocumentoDAO.insertar(tipoDocumentos);
        assertTrue(resultado != 0);
        
        tipoDocumentos = new TiposDocumentosDTO();
        tipoDocumentos.setTipoDocumentoId(2);
        tipoDocumentos.setNombre("Guía de remisión");
        resultado = this.tipoDocumentoDAO.insertar(tipoDocumentos);
        assertTrue(resultado != 0);
        
        tipoDocumentos = new TiposDocumentosDTO();
        tipoDocumentos.setTipoDocumentoId(1);
        resultado = this.tipoDocumentoDAO.eliminar(tipoDocumentos);
        assertTrue(resultado != 0);
        
        tipoDocumentos = new TiposDocumentosDTO();
        tipoDocumentos.setTipoDocumentoId(2);
        resultado = this.tipoDocumentoDAO.eliminar(tipoDocumentos);
        assertTrue(resultado != 0);
    }
    
}
