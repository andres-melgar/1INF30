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

    public AlmacenBO() {
        //OJO, esto debe leerse de un .properties
        this.url = "http://localhost:8080/SoftInvBusinessServidorWS/resources/Almacenes";
        this.mapper = new ObjectMapper();
    }

    public Integer insertar(String nombre, Boolean almacen_central) throws JsonProcessingException, IOException, InterruptedException {
        this.crearHttpClient();
        AlmacenesDTO almacenDTO = this.crearDTO(nombre, almacen_central);
        String jsonRequest = this.serializarDTO(almacenDTO);
        this.crearHttpRequestPOST(jsonRequest);
        this.enviarRequest();
        AlmacenesDTO almacenRespuesta = this.deserializar(AlmacenesDTO.class);
        this.cerrarHttpClient();

        if (response.statusCode() == Response.Status.CREATED.getStatusCode()) {
            return almacenRespuesta.getAlmacenId();
        }
        return 0;
    }

    public Integer eliminar(Integer almacenId) throws IOException, InterruptedException {
        this.crearHttpClient();
        this.crearHttpRequestDELETE(almacenId);
        this.enviarRequest();
        this.cerrarHttpClient();

        if (this.response.statusCode() == Response.Status.NO_CONTENT.getStatusCode()) {
            return almacenId;
        }
        return 0;
    }

    public AlmacenesDTO obtenerPorId(Integer almacenId) throws IOException, InterruptedException {
        this.crearHttpClient();
        this.crearHttpRequestGET(almacenId);
        this.enviarRequest();
        this.cerrarHttpClient();
        if (this.response.statusCode() == Response.Status.NOT_FOUND.getStatusCode()) {
            return null;
        }
        AlmacenesDTO almacenDTORespuesta = this.deserializar(AlmacenesDTO.class);
        return almacenDTORespuesta;
    }

    public ArrayList<AlmacenesDTO> listarTodos() throws IOException, InterruptedException {
        this.crearHttpClient();
        this.crearHttpRequestGET();
        this.enviarRequest();
        this.cerrarHttpClient();
        ArrayList<AlmacenesDTO> listaAlmacenes = this.deserializarListaDTO(new TypeReference<ArrayList<AlmacenesDTO>>() {
        });
        return listaAlmacenes;
    }

    public Integer modificar(Integer almacenId, String nombre, Boolean almacen_central) throws JsonProcessingException, IOException, InterruptedException {
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

    private void crearHttpClient() {
        //EN ROJO
        this.cliente = HttpClient.newHttpClient();
    }

    private void cerrarHttpClient() {
        this.cliente.close();
    }

    private void crearHttpRequestDELETE(Integer almacenId) {
        //EN AZUL
        this.request = HttpRequest.newBuilder()
                .uri(URI.create(this.url + "/" + almacenId))
                .header("Content-Type", "application/json")
                .DELETE()
                .build();
    }

    private void crearHttpRequestPOST(String jsonRequest) {
        //EN AZUL
        this.request = HttpRequest.newBuilder()
                .uri(URI.create(this.url))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonRequest))
                .build();
    }

    private void enviarRequest() throws IOException, InterruptedException {
        //EN NEGRO -> envio
        this.response = this.cliente.send(this.request, HttpResponse.BodyHandlers.ofString());
    }

    private AlmacenesDTO crearDTO(String nombre, Boolean almacen_central) {
        Integer almacenId = null;
        return this.crearDTO(almacenId, nombre, almacen_central);
    }
    
    private AlmacenesDTO crearDTO(Integer almacenId, String nombre, Boolean almacen_central) {
        //EN BLANCO
        AlmacenesDTO almacenDTO = new AlmacenesDTO();
        almacenDTO.setAlmacenId(almacenId);
        almacenDTO.setNombre(nombre);
        almacenDTO.setAlmacen_central(almacen_central);
        return almacenDTO;
    }

    private String serializarDTO(AlmacenesDTO almacenDTO) throws JsonProcessingException {
        //EN VERDE - serialización        
        String jsonRequest = this.mapper.writeValueAsString(almacenDTO);
        return jsonRequest;
    }

    private AlmacenesDTO deserializar(Class<AlmacenesDTO> clase) throws JsonProcessingException {
        //EN VERDE - deserialización
        AlmacenesDTO almacenRespuesta = mapper.readValue(response.body(), clase);
        return almacenRespuesta;
    }

    private ArrayList<AlmacenesDTO> deserializarListaDTO(TypeReference<ArrayList<AlmacenesDTO>> typeReference) throws JsonProcessingException {
        //EN VERDE - deserialización
        ArrayList<AlmacenesDTO> listaAlmacenes = this.mapper.readValue(this.response.body(), typeReference);
        return listaAlmacenes;
    }

    private void crearHttpRequestGET() {
        Integer almacenId = null;
        this.crearHttpRequestGET(almacenId);
    }

    private void crearHttpRequestGET(Integer almacenId) {
        //EN AZUL
        String URLGET = this.url;
        if (almacenId != null) {
            URLGET = URLGET.concat("/" + almacenId);
        }
        this.request = HttpRequest.newBuilder()
                .uri(URI.create(URLGET))
                .header("Content-Type", "application/json")
                .GET()
                .build();
    }

    private void crearHttpRequestPUT(String jsonRequest) {
        //EN AZUL
        this.request = HttpRequest.newBuilder()
                .uri(URI.create(this.url))
                .header("Content-Type", "application/json")
                .PUT(HttpRequest.BodyPublishers.ofString(jsonRequest))
                .build();
    }

}
