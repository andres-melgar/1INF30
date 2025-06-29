package pe.edu.pucp.softinv.services;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
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
public class Almacenes {

    private AlmacenBO almacenBO;

    public Almacenes() {
        this.almacenBO = new AlmacenBO();
    }
    
    @GET
     public ArrayList<AlmacenesDTO> listarTodos(){
         return this.almacenBO.listarTodos();
     }
    
     @GET
     @Path("{id}")
     public Response obtenerPorId(@PathParam("id") Integer almacenId){
         AlmacenesDTO almacenesDTO = this.almacenBO.obtenerPorId(almacenId);
         if (almacenesDTO == null){
             return Response.status(Response.Status.NOT_FOUND).build();
         }
         return Response.ok(almacenesDTO).build();         
     }
     
     @POST
     public Response insertar(AlmacenesDTO almacenesDTO){
         almacenesDTO = this.almacenBO.insertar(almacenesDTO);
         return Response.status(Response.Status.CREATED).entity(almacenesDTO).build();
     }
}
