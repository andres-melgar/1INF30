package pe.edu.pucp.softinv.bo;

import pe.edu.pucp.softinv.bo.server.AlmacenBO;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pe.edu.pucp.softinv.model.AlmacenesDTO;

/**
 *
 * @author andres
 */
public class AlmacenBOTest {
    
    private AlmacenBO almacenBO;
    
    public AlmacenBOTest() {
        this.almacenBO = new AlmacenBO();
    }

    @Test
    public void testInsertar() {
        System.out.println("insertar");
        AlmacenesDTO almacenDTO = new AlmacenesDTO();
        almacenDTO.setNombre("Mi almacen central");
        almacenDTO.setAlmacen_central(Boolean.TRUE);
        Integer resultado = this.almacenBO.insertar(almacenDTO).getAlmacenId();
        assertTrue(resultado>0);
        
        almacenDTO = new AlmacenesDTO();
        almacenDTO.setNombre("Mi segundo almacen");
        almacenDTO.setAlmacen_central(Boolean.FALSE);
        resultado = this.almacenBO.insertar(almacenDTO).getAlmacenId();
        assertTrue(resultado>0);
        
        almacenDTO = new AlmacenesDTO();
        almacenDTO.setNombre("Mi tercer almacen");
        almacenDTO.setAlmacen_central(Boolean.FALSE);
        resultado = this.almacenBO.insertar(almacenDTO).getAlmacenId();
        assertTrue(resultado>0);
    }
    
}
