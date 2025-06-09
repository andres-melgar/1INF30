package pe.edu.pucp.softven.bo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductoBOTest {
    
    private ProductoBO productoBO;
    
    public ProductoBOTest() {
        this.productoBO = new ProductoBO();
    }
    
    @Test
    public void testInsertar() {
        System.out.println("insertar");
        Integer resultado = this.productoBO.insertar("Mi nuevo producto", "Descripción nuevo prod", 122.22);
        assertTrue(resultado > 0);
        
        resultado = this.productoBO.insertar("Mi nuevo producto2", "Descripción nuevo prod2", 322.22);
        assertTrue(resultado > 0);
    }
    
}
