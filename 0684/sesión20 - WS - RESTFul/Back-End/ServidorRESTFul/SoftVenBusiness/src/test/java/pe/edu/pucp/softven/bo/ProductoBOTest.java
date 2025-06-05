package pe.edu.pucp.softven.bo;

import pe.edu.pucp.softven.bo.server.ProductoBO;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pe.edu.pucp.softven.model.ProductosDTO;

public class ProductoBOTest {
    
    private ProductoBO productoBO;
    
    public ProductoBOTest() {
        this.productoBO = new ProductoBO();
    }
    
    @Test
    public void testInsertar() {
        System.out.println("insertar");
        ProductosDTO producto = new ProductosDTO();
        producto.setNombre("Mi nuevo producto");
        producto.setDescripcion("Descripción nuevo prod");
        producto.setPrecio(122.22);
        Integer resultado = this.productoBO.insertar(producto).getProductoId();
        assertTrue(resultado > 0);
        
        producto.setNombre("Mi nuevo producto2");
        producto.setDescripcion("Descripción nuevo prod2");
        producto.setPrecio(322.22);
        resultado = this.productoBO.insertar(producto).getProductoId();
        assertTrue(resultado > 0);
    }
    
}
