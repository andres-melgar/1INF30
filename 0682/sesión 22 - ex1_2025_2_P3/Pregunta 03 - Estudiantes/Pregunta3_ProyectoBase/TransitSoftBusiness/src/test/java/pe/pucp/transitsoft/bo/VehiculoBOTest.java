package pe.pucp.transitsoft.bo;

import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import pe.pucp.transitsoft.model.VehiculoDTO;

public class VehiculoBOTest {
    
    private VehiculoBO vehiculoBO;
    
    public VehiculoBOTest() {
        this.vehiculoBO = new VehiculoBO();
    }
    
    @Test
    public void testListarPorPropietario() {
        System.out.println("listarPorPropietario");
        String descripion_propietario = "Monica";
        VehiculoBO instance = new VehiculoBO();
        ArrayList<VehiculoDTO> listaVehiculos = instance.listarPorPropietario(descripion_propietario);
        assertNotNull(listaVehiculos);
        
        for(VehiculoDTO vehiculoDTO: listaVehiculos)
            System.out.println(vehiculoDTO);
    }
    
}
