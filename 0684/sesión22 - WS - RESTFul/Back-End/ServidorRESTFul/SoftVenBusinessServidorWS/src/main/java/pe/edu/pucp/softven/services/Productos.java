package pe.edu.pucp.softven.services;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.ArrayList;
import pe.edu.pucp.softven.bo.server.ProductoBO;
import pe.edu.pucp.softven.model.ProductosDTO;

@Path("Productos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class Productos {

    private ProductoBO productoBO;

    public Productos() {
        this.productoBO = new ProductoBO();
    }

    @GET
    public ArrayList<ProductosDTO> listarTodos() {
        return this.productoBO.listarTodos();
    }

    @GET
    @Path("{id}")
    public Response obtenerPorId(@PathParam("id") Integer productoId) {
        ProductosDTO producto = this.productoBO.obtenerPorId(productoId);
        if (producto == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(producto).build();
    }

    @POST
    public Response insertar(ProductosDTO productosDTO) {
        productosDTO = this.productoBO.insertar(productosDTO);
        return Response.status(Response.Status.CREATED).entity(productosDTO).build();
    }

    @PUT
    public Response modificar(ProductosDTO productosDTO) {
        Integer respuesta = this.productoBO.modificar(productosDTO);
        if (respuesta > 0) {
            return Response.ok(productosDTO).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @DELETE
    @Path("{id}")
    public Response eliminar(@PathParam("id") Integer productoId) {
        Integer respuesta = this.productoBO.eliminar(productoId);
        if (respuesta > 0) {
            return Response.noContent().build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}
