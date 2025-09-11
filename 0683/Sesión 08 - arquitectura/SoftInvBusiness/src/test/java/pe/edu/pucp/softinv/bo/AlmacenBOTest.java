package pe.edu.pucp.softinv.bo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AlmacenBOTest {

    private AlmacenBO almacenBO;
    
    public AlmacenBOTest() {
        this.almacenBO = new AlmacenBO();
    }
    
    @Test
    public void testInsertar() {
        System.out.println("insertar");
        Integer resultado = this.almacenBO.insertar("Almacén Central BO", Boolean.TRUE);
        assert(resultado != 0);
    }
    
}
