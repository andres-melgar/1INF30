package pe.edu.pucp.softinv.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.io.IOException;
import java.util.ArrayList;
import pe.edu.pucp.softinv.bo.client.AlmacenBO;
import pe.edu.pucp.softinv.model.AlmacenesDTO;

@WebService(serviceName = "Almacenes")
public class Almacenes {
    
    private AlmacenBO almacenBO;
    
    public Almacenes(){
        this.almacenBO = new AlmacenBO();
    }

    @WebMethod(operationName = "inserta_almacen")
    public Integer insertar(@WebParam(name = "nombre")String nombre, @WebParam(name = "almacen_central")Boolean almacen_central) throws IOException, JsonProcessingException, InterruptedException{
        return this.almacenBO.insertar(nombre, almacen_central);
    }
    
    @WebMethod(operationName = "obtenerPorId")
    public AlmacenesDTO obtenerPorId(@WebParam(name = "id")Integer almacenId) throws IOException, InterruptedException{
        return this.almacenBO.obtenerPorId(almacenId);
    }
    
    @WebMethod(operationName = "listarTodos")
    public ArrayList<AlmacenesDTO> listarTodos() throws IOException, InterruptedException{
        return this.almacenBO.listarTodos();
    }
    
    @WebMethod(operationName = "modificar")
    public Integer modificar(@WebParam(name = "almacenId")Integer almacenId, @WebParam(name = "nombre")String nombre, @WebParam(name = "almacen_central")Boolean almacen_central) throws IOException, JsonProcessingException, InterruptedException{
        return this.almacenBO.modificar(almacenId, nombre, almacen_central);
    }
    
    @WebMethod(operationName = "eliminar")
    public Integer eliminar(Integer almacenId) throws IOException, InterruptedException{
        return this.almacenBO.eliminar(almacenId);
    }
}
