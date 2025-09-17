package pe.edu.pucp.softinv.bo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TipoDocumentoBOTest {
    
    private TipoDocumentoBO tipoDocumentoBO;
    
    public TipoDocumentoBOTest() {
        this.tipoDocumentoBO = new TipoDocumentoBO();
    }
    
    @Test
    public void testInsertar() {
        System.out.println("insertar");                
        Integer resultado = this.tipoDocumentoBO.insertar(1, "Orden de compra");
        assertTrue(resultado != 0);
                
        resultado = this.tipoDocumentoBO.insertar(2, "Guía de remisión");
        assertTrue(resultado != 0);
        
        resultado = this.tipoDocumentoBO.eliminar(1);
        assertTrue(resultado != 0);

        resultado = this.tipoDocumentoBO.eliminar(2);
        assertTrue(resultado != 0);
    }    
    
}
