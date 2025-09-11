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
        String nombre = "Almacen Central BO";
        Boolean almacen_central = true;
        Integer resultado = this.almacenBO.insertar(nombre, almacen_central);
        assert(resultado != 0);
    }
    
}
