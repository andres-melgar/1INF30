package pe.edu.pucp.softinv.services;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import pe.edu.pucp.softinv.bo.AlmacenBO;
import pe.edu.pucp.softinv.model.AlmacenesDTO;

@WebService(serviceName = "almacenes")
public class Almacenes {

    private AlmacenBO almacenBO;

    public Almacenes() {
        this.almacenBO = new AlmacenBO();
    }

    @WebMethod(operationName = "insertar")
    public Integer insertar(@WebParam(name = "nombre")String nombre, @WebParam(name = "almacen_central")Boolean almacen_central) {
        return this.almacenBO.insertar(nombre, almacen_central);
    }

    @WebMethod(operationName = "obtenerPorId")
    public AlmacenesDTO obtenerPorId(@WebParam(name = "almacenId")Integer almacenId) {
        return this.almacenBO.obtenerPorId(almacenId);
    }

    @WebMethod(operationName = "listarTodos")
    public ArrayList<AlmacenesDTO> listarTodos() {
        return this.almacenBO.listarTodos();
    }

    @WebMethod(operationName = "modificar")
    public Integer modificar(@WebParam(name = "almacenId")Integer almacenId, @WebParam(name = "nombre")String nombre, @WebParam(name = "almacen_central")Boolean almacen_central) {
        return this.almacenBO.modificar(almacenId, nombre, almacen_central);
    }

    @WebMethod(operationName = "eliminar")
    public Integer eliminar(@WebParam(name = "almacenId") Integer almacenId) {
        return this.almacenBO.eliminar(almacenId);
    }
}
