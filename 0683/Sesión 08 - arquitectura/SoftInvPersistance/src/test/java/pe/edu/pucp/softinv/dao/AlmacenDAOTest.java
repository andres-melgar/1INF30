package pe.edu.pucp.softinv.dao;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pe.edu.pucp.softinv.daoImpl.AlmacenDAOImpl;
import pe.edu.pucp.softinv.model.AlmacenesDTO;

public class AlmacenDAOTest {

    private AlmacenDAO almacenDAO;
    
    public AlmacenDAOTest() {
        this.almacenDAO = new AlmacenDAOImpl();
    }

    @Test
    public void testInsertar() {
        System.out.println("insertar");
        AlmacenesDTO almacenDTO = new AlmacenesDTO();
        almacenDTO.setNombre("Almacén central");
        almacenDTO.setAlmacen_central(Boolean.TRUE);
        Integer resultado = this.almacenDAO.insertar(almacenDTO);
        assert(resultado !=0 );
        System.out.println("Resultado: " + resultado);
        System.out.println("POJO: " + almacenDTO.getAlmacenId());
    }
    
}
