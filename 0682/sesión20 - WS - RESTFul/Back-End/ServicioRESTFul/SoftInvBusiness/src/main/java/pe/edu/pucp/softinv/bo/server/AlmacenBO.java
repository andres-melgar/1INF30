package pe.edu.pucp.softinv.bo.server;

import java.util.ArrayList;
import pe.edu.pucp.softinv.dao.AlmacenDAO;
import pe.edu.pucp.softinv.daoImp.AlmacenDAOImpl;
import pe.edu.pucp.softinv.model.AlmacenesDTO;

public class AlmacenBO {

    private AlmacenDAO almacenDAO;
    
    public AlmacenBO(){
        this.almacenDAO = new AlmacenDAOImpl();
    }
    
    public AlmacenesDTO insertar(AlmacenesDTO almacenesDTO){
        Integer id = this.almacenDAO.insertar(almacenesDTO);
        almacenesDTO.setAlmacenId(id);
        return almacenesDTO;
    }
    
    public AlmacenesDTO obtenerPorId(Integer almacenId){
        return this.almacenDAO.obtenerPorId(almacenId);
    }
    
    public ArrayList<AlmacenesDTO> listarTodos(){
        return this.almacenDAO.listarTodos();
    }
    
    public Integer modificar(AlmacenesDTO almacenesDTO){
        return this.almacenDAO.modificar(almacenesDTO);
    }
    
    public Integer eliminar(Integer almacenId){
        AlmacenesDTO almacenesDTO = new AlmacenesDTO();
        almacenesDTO.setAlmacenId(almacenId);
        return this.almacenDAO.eliminar(almacenesDTO);
    }
}
