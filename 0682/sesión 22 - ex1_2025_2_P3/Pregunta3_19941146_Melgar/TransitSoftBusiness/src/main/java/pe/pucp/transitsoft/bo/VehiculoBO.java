package pe.pucp.transitsoft.bo;

import java.util.ArrayList;
import pe.edu.pucp.softinv.daoImp.VehiculoDAOImpl;
import pe.pucp.transitsoft.dao.VehiculoDAO;
import pe.pucp.transitsoft.model.VehiculoDTO;


public class VehiculoBO {

    private VehiculoDAO vehiculoDAO;
    
    public VehiculoBO(){
        this.vehiculoDAO = new VehiculoDAOImpl();
    }
    
    public ArrayList<VehiculoDTO> listarPorPropietario(String descripion_propietario){
        return this.vehiculoDAO.listarPorPropietario(descripion_propietario);
    }
    
}
