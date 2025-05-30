package pe.edu.pucp.softinv.bo;

import pe.edu.pucp.softinv.dao.AlmacenDAO;
import pe.edu.pucp.softinv.daoImp.AlmacenDAOImpl;
import pe.edu.pucp.softinv.model.AlmacenesDTO;

public class AlmacenBO {

    private AlmacenDAO almacenDAO;
    
    public AlmacenBO(){
        this.almacenDAO = new AlmacenDAOImpl();
    }
    
    public Integer insertar(String nombre, Boolean almacen_central){
        AlmacenesDTO almacenesDTO = new AlmacenesDTO();
        almacenesDTO.setNombre(nombre);
        almacenesDTO.setAlmacen_central(almacen_central);
        return this.almacenDAO.insertar(almacenesDTO);
    }
}
