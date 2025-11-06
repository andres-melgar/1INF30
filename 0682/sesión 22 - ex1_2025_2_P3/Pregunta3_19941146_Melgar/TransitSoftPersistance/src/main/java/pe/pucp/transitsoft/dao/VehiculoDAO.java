package pe.pucp.transitsoft.dao;

import java.util.ArrayList;
import pe.pucp.transitsoft.model.VehiculoDTO;

public interface VehiculoDAO {
    
    public ArrayList<VehiculoDTO> listarPorPropietario(String descripion_propietario);
    
}
