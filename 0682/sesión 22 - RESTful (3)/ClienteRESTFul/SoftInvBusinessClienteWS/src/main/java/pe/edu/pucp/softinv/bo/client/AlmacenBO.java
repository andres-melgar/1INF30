package pe.edu.pucp.softinv.bo.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.ws.rs.core.Response;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import pe.edu.pucp.softinv.model.AlmacenesDTO;

public class AlmacenBO {
    
    private HttpClient cliente;
    private HttpRequest request;
    private HttpResponse<String> response;
    private String url;
    private ObjectMapper mapper;
    
    public AlmacenBO(){
        //este valor se debe leer de un properties
        //this.url = "http://localhost:8080/SoftInvBusinessServidorWS/resources/Almacenes";
        this.url = "http://localhost:8080/SoftInvBusinessServidorWS-1.0-SNAPSHOT/resources/Almacenes";
        this.mapper = new ObjectMapper();
    }
    
    public Integer insertar(String nombre, Boolean almacen_central) throws JsonProcessingException, IOException, InterruptedException{        
        /*
        //CÓDIGO SIN REFACTORIZACIÓN
        //ROJO
        HttpClient cliente = HttpClient.newHttpClient();
        
        //VERDE
        //VERDE - objeto en memoria
        AlmacenesDTO almacenDTO = new AlmacenesDTO();
        almacenDTO.setNombre(nombre);
        almacenDTO.setAlmacen_central(almacen_central);
        
        //VERDE - serializar
        ObjectMapper mapper = new ObjectMapper();
        String jsonRequest = mapper.writeValueAsString(almacenDTO);
        
        //AZUL
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/SoftInvBusinessServidorWS/resources/Almacenes"))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonRequest))
                .build();
        
        //NEGRO
        HttpResponse<String> response = cliente.send(request, HttpResponse.BodyHandlers.ofString());
        
        //VERDE - deserializar
        AlmacenesDTO almacenDTORespuesta = mapper.readValue(response.body(), AlmacenesDTO.class);
        cliente.close();
        if (response.statusCode() == Response.Status.CREATED.getStatusCode())
            return almacenDTORespuesta.getAlmacenId(); 
        */
        this.crearHttpClient();
        AlmacenesDTO almacenDTO = this.crearDTO(null, nombre, almacen_central);
        String jsonRequest = this.serializarDTO(almacenDTO);
        this.crearHttpRequestPOST(jsonRequest);
        this.enviarRequest();
        AlmacenesDTO almacenDTORespuesta = this.deserializarDTO(AlmacenesDTO.class);                
        this.cerrarHttpClient();
        if (response.statusCode() == Response.Status.CREATED.getStatusCode())
            return almacenDTORespuesta.getAlmacenId();        
        return 0;                
    }
    
     public Integer modificar(Integer almacenId, String nombre, Boolean almacen_central) throws JsonProcessingException, IOException, InterruptedException{         
        this.crearHttpClient();
        AlmacenesDTO almacenDTO = this.crearDTO(almacenId, nombre, almacen_central);
        String jsonRequest = this.serializarDTO(almacenDTO);
        this.crearHttpRequestPUT(jsonRequest);
        this.enviarRequest();        
        this.cerrarHttpClient();
        if (this.response.statusCode() == Response.Status.OK.getStatusCode())
            return almacenId;
        return 0;
    }
     
     public Integer eliminar(Integer almacenId) throws IOException, InterruptedException{
        this.crearHttpClient();
        this.crearHttpRequestDELETE(almacenId);
        this.enviarRequest();
        this.cerrarHttpClient();
        if (this.response.statusCode() == Response.Status.NO_CONTENT.getStatusCode())
            return almacenId;
        return 0;
    }
    
    public AlmacenesDTO obtenerPorId(Integer almacenId) throws IOException, InterruptedException{
        this.crearHttpClient();
        this.crearHttpRequestGET(almacenId);
        this.enviarRequest();
        this.cerrarHttpClient();
        if (this.response.statusCode() == Response.Status.NOT_FOUND.getStatusCode()){
            return null;
        }
        AlmacenesDTO almacenesDTORespuesta = this.deserializarDTO(AlmacenesDTO.class);        
        return almacenesDTORespuesta;
    }
    
    public ArrayList<AlmacenesDTO> listarTodos() throws IOException, InterruptedException{
        this.crearHttpClient();
        this.crearHttpRequestGET();
        this.enviarRequest();
        this.cerrarHttpClient();
        ArrayList<AlmacenesDTO> listaAlmacenes = this.deserializarListaDTO(new TypeReference<ArrayList<AlmacenesDTO>>(){});
        return listaAlmacenes;
    }               
    
    private void crearHttpClient() {
        //ROJO
        this.cliente = HttpClient.newHttpClient();
    }

    private void cerrarHttpClient() {
        this.cliente.close();
    }

    private AlmacenesDTO crearDTO(Integer almacenId, String nombre, Boolean almacen_central) {
        //VERDE
        //VERDE - objeto en memoria
        AlmacenesDTO almacenDTO = new AlmacenesDTO();
        almacenDTO.setAlmacenId(almacenId);
        almacenDTO.setNombre(nombre);
        almacenDTO.setAlmacen_central(almacen_central);
        return almacenDTO;
    }

    private String serializarDTO(AlmacenesDTO almacenDTO) throws JsonProcessingException {
        //VERDE - serializar
        ObjectMapper mapper = new ObjectMapper();
        String jsonRequest = mapper.writeValueAsString(almacenDTO);
        return jsonRequest;
    }

    private void crearHttpRequestPUT(String jsonRequest) {
        //AZUL
        this.request = HttpRequest.newBuilder()
                .uri(URI.create(this.url))
                .header("Content-Type", "application/json")
                .PUT(HttpRequest.BodyPublishers.ofString(jsonRequest))
                .build();
    }

    private void crearHttpRequestPOST(String jsonRequest) {
        //AZUL
        this.request = HttpRequest.newBuilder()
                .uri(URI.create(this.url))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonRequest))
                .build();
    }

    private void enviarRequest() throws IOException, InterruptedException {
        //NEGRO
        this.response = this.cliente.send(this.request, HttpResponse.BodyHandlers.ofString());
    }

    private AlmacenesDTO deserializarDTO(Class<AlmacenesDTO> clase) throws JsonProcessingException {
        //VERDE - deserializar
        String json = this.response.body();
        AlmacenesDTO almacenDTORespuesta = this.mapper.readValue(json, clase);        
        return almacenDTORespuesta;
    }
    
    //ESTE MÉTODO ES DIFERENTE AL ANTERIOR PUESTO QUE VA A DESERIALIZAR
    //UNA LISTA DE OBJETOS.
    private ArrayList<AlmacenesDTO> deserializarListaDTO(TypeReference<ArrayList<AlmacenesDTO>> typeReference) throws JsonProcessingException {
        String json = this.response.body();
        ArrayList<AlmacenesDTO> listaAlmacenes = this.mapper.readValue(json, typeReference);
        return listaAlmacenes;
    }

    private void crearHttpRequestDELETE(Integer almacenId) {
        //AZUL
        this.request = HttpRequest.newBuilder()
                .uri(URI.create(this.url + "/" + almacenId))
                .header("Content-Type", "application/json")
                .DELETE()
                .build();
    }

    private void crearHttpRequestGET() {
        Integer almacenId = null;
        this.crearHttpRequestGET(almacenId);
    }
    
    private void crearHttpRequestGET(Integer almacenId) {
        String URLGET = this.url;
        if (almacenId != null){
            URLGET = URLGET.concat("/" + almacenId);
        }
        //AZUL
        this.request = HttpRequest.newBuilder()
                .uri(URI.create(URLGET))
                .header("Content-Type", "application/json")
                .GET()
                .build();
    }            

}
