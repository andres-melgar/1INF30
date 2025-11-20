package pe.edu.pucp.softinv.services;

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
import pe.edu.pucp.softinv.bo.server.AlmacenBO;
import pe.edu.pucp.softinv.model.AlmacenesDTO;

@Path("Almacenes")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class Almacen {

    private AlmacenBO almacenBO;

    public Almacen() {
        this.almacenBO = new AlmacenBO();
    }

    @POST
    public Response insertar(AlmacenesDTO almacenesDTO){        
        Integer respuesta = this.almacenBO.insertar(almacenesDTO);        
        if (respuesta == 0)
            return Response.status(Response.Status.NOT_ACCEPTABLE).build();
        return Response.status(Response.Status.CREATED).entity(almacenesDTO).build();
    }
    
    @PUT
    public Response modificar(AlmacenesDTO almacenesDTO){  
        Integer respuesta = this.almacenBO.modificar(almacenesDTO);
        if (respuesta==0)
            return Response.status(Response.Status.NOT_MODIFIED).build();
        return Response.ok(almacenesDTO).build();
    }
    
    @DELETE
    @Path("{id}")
    public Response eliminar(@PathParam("id") Integer almacenId){
        Integer respuesta = this.almacenBO.eliminar(almacenId);
        if (respuesta>0)
            return Response.noContent().build();
        return Response.status(Response.Status.NOT_FOUND).build();
    }
    
    @GET
    public ArrayList<AlmacenesDTO> listarTodos() {
        return this.almacenBO.listarTodos();
    }

    @GET
    @Path("{id}")
    public Response obtenerPorId(@PathParam("id") Integer almacenId) {
        AlmacenesDTO almacen = this.almacenBO.obtenerPorId(almacenId);
        if (almacen == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(almacen).build();
    }

}
