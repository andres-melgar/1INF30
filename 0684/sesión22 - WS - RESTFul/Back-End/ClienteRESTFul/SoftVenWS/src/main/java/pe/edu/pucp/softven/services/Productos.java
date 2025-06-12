package pe.edu.pucp.softven.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.io.IOException;
import java.util.ArrayList;
import pe.edu.pucp.softven.bo.client.ProductoBO;
import pe.edu.pucp.softven.model.ProductosDTO;

@WebService(serviceName = "productos")
public class Productos {

    private ProductoBO productoBO;

    public Productos() {
        this.productoBO = new ProductoBO();
    }

    @WebMethod(operationName = "insertar")
    public Integer insertar(@WebParam(name = "nombre") String nombre, @WebParam(name = "descripcion") String descripcion, @WebParam(name = "precio") Double precio) throws IOException, JsonProcessingException, InterruptedException {
        return this.productoBO.insertar(nombre, descripcion, precio);
    }

    @WebMethod(operationName = "obtenerPorId")
    public ProductosDTO obtenerPorId(@WebParam(name = "productoId") Integer productoId) throws IOException, InterruptedException {
        return this.productoBO.obtenerPorId(productoId);
    }

    @WebMethod(operationName = "listarTodos")
    public ArrayList<ProductosDTO> listarTodos() throws IOException, InterruptedException {
        return this.productoBO.listarTodos();
    }

    @WebMethod(operationName = "modificar")
    public Integer modificar(@WebParam(name = "productoId") Integer productoId, @WebParam(name = "nombre") String nombre, @WebParam(name = "descripcion") String descripcion, @WebParam(name = "precio") Double precio) throws IOException, JsonProcessingException, InterruptedException {
        return this.productoBO.modificar(productoId, nombre, descripcion, precio);
    }

    @WebMethod(operationName = "eliminar")
    public Integer eliminar(@WebParam(name = "productoId") Integer productoId) throws IOException, InterruptedException {
        return this.productoBO.eliminar(productoId);
    }

}
