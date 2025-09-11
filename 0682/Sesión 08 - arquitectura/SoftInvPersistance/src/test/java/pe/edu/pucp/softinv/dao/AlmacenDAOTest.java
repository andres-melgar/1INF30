package pe.edu.pucp.softinv.dao;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pe.edu.pucp.softinv.daoImpl.AlmacenDAOImpl;
import pe.edu.pucp.softinv.model.AlmacenesDTO;


public class AlmacenDAOTest {

    private AlmacenDAO almacen;
    
    public AlmacenDAOTest() {
        this.almacen = new AlmacenDAOImpl();
    }

    @Test
    public void testInsertar() {
        System.out.println("insertar");
        AlmacenesDTO almacen = new AlmacenesDTO();
        almacen.setNombre("Almacén Central");
        almacen.setAlmacen_central(Boolean.TRUE);        
        Integer resultado = this.almacen.insertar(almacen);
        assert(resultado != 0);
        System.out.println("resultado: " + resultado);
    }
    
}
