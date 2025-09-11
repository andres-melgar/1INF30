package pe.edu.pucp.softinv.bo;

import pe.edu.pucp.softinv.dao.AlmacenDAO;
import pe.edu.pucp.softinv.daoImpl.AlmacenDAOImpl;
import pe.edu.pucp.softinv.model.AlmacenesDTO;

public class AlmacenBO {
    
    private AlmacenDAO almacenDAO;
    
    public AlmacenBO(){
        this.almacenDAO = new AlmacenDAOImpl();
    }
    
    public Integer insertar(String nombre, Boolean almacen_central){
        AlmacenesDTO almacen = new AlmacenesDTO();
        almacen.setNombre(nombre);
        almacen.setAlmacen_central(almacen_central);
        return this.almacenDAO.insertar(almacen);
    }
    
}
