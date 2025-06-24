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

    private ObjectMapper mapper;
    private HttpClient client;
    private HttpRequest request;
    private HttpResponse<String> response;
    private String url;

    public AlmacenBO() {
        this.mapper = new ObjectMapper();
        this.url = "http://localhost:8080/SoftInvBusinessServidorWS/resources/Almacenes";
        this.client = null;
        this.request = null;
        this.response = null;
    }

    private void crearHttpClient() {
        this.client = HttpClient.newHttpClient();
    }

    private void crearHttpRequestPOST(String jsonRequest) {
        this.request = HttpRequest.newBuilder()
                .uri(URI.create(this.url))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonRequest))
                .build();
    }

    private void crearHttpRequestGET() {
        Integer id = null;
        this.crearHttpRequestGET(id);
    }

    private void crearHttpRequestGET(Integer id) {
        String urlGET = this.url;
        if (id != null) {
            urlGET = urlGET.concat("/" + id);
        }

        this.request = HttpRequest.newBuilder()
                .uri(URI.create(urlGET))
                .header("Content-Type", "application/json")
                .GET()
                .build();
    }
    
    private void crearHttpRequestPUT(String jsonRequest) {
        this.request = HttpRequest.newBuilder()
                .uri(URI.create(this.url))
                .header("Content-Type", "application/json")
                .PUT(HttpRequest.BodyPublishers.ofString(jsonRequest))
                .build();
    }
    
    private void crearHttpRequestDELETE(Integer id) {
        String urlGET = this.url;
        if (id != null) {
            urlGET = urlGET.concat("/" + id);
        }

        this.request = HttpRequest.newBuilder()
                .uri(URI.create(urlGET))
                .header("Content-Type", "application/json")
                .DELETE()
                .build();
    }

    private void enviarRequest() throws IOException, InterruptedException {
        this.response = this.client.send(this.request, HttpResponse.BodyHandlers.ofString());
    }

    private void cerrarHttpClient() {
        this.client.close();
    }

    private String serializar(AlmacenesDTO almacenesDTO) throws JsonProcessingException {
        String jsonRequest = mapper.writeValueAsString(almacenesDTO);
        return jsonRequest;
    }

    private AlmacenesDTO deserializarDTO(Class<AlmacenesDTO> clase) throws JsonProcessingException {
        AlmacenesDTO almacenesDTORespuesta = mapper.readValue(this.response.body(), clase);
        return almacenesDTORespuesta;
    }

    private ArrayList<AlmacenesDTO> deserializarListaDTO(TypeReference<ArrayList<AlmacenesDTO>> typeReference) throws JsonProcessingException {
        String json = this.response.body();
        ArrayList<AlmacenesDTO> listaAlmacenes = this.mapper.readValue(json, typeReference);
        return listaAlmacenes;
    }

    private AlmacenesDTO crearDTO(Integer almacenID, String nombre, Boolean almacen_central) {
        AlmacenesDTO almacenesDTO = new AlmacenesDTO();
        almacenesDTO.setAlmacenId(almacenID);
        almacenesDTO.setNombre(nombre);
        almacenesDTO.setAlmacen_central(almacen_central);
        return almacenesDTO;
    }

    public Integer insertar(String nombre, Boolean almacen_central) throws JsonProcessingException, IOException, InterruptedException {
        AlmacenesDTO almacenesDTO = this.crearDTO(1, nombre, almacen_central);
        String jsonRequest = this.serializar(almacenesDTO);
        this.crearHttpClient();
        this.crearHttpRequestPOST(jsonRequest);
        this.enviarRequest();
        AlmacenesDTO almacenesDTORespuesta = this.deserializarDTO(AlmacenesDTO.class);
        this.cerrarHttpClient();
        if (response.statusCode() == Response.Status.CREATED.getStatusCode()) {
            return almacenesDTORespuesta.getAlmacenId();
        }
        return 0;
    }

    public AlmacenesDTO obtenerPorId(Integer almacenId) throws IOException, InterruptedException {
        this.crearHttpClient();
        this.crearHttpRequestGET(almacenId);
        this.enviarRequest();
        this.cerrarHttpClient();
        AlmacenesDTO almacenesDTORespuesta = this.deserializarDTO(AlmacenesDTO.class);
        return almacenesDTORespuesta;
    }

    public ArrayList<AlmacenesDTO> listarTodos() throws IOException, InterruptedException {
        this.crearHttpClient();
        this.crearHttpRequestGET();
        this.enviarRequest();
        this.cerrarHttpClient();
        ArrayList<AlmacenesDTO> listaAlmacenes = this.deserializarListaDTO(new TypeReference<ArrayList<AlmacenesDTO>>(){});
        return listaAlmacenes;
    }

    public Integer modificar(Integer almacenId, String nombre, Boolean almacen_central) throws JsonProcessingException, IOException, InterruptedException {
        AlmacenesDTO almacenesDTO = this.crearDTO(almacenId, nombre, almacen_central);
        String jsonRequest = this.serializar(almacenesDTO);
        this.crearHttpClient();
        this.crearHttpRequestPUT(jsonRequest);
        this.enviarRequest();
        this.cerrarHttpClient();
        if (this.response.statusCode() == Response.Status.OK.getStatusCode())
            return almacenId;
        return 0;
    }

    public Integer eliminar(Integer almacenId) throws IOException, InterruptedException {
         this.crearHttpClient();
         this.crearHttpRequestDELETE(almacenId);
         this.enviarRequest();
        this.cerrarHttpClient();
        if (this.response.statusCode() == Response.Status.NO_CONTENT.getStatusCode())
            return almacenId;
        return 0;
    }

}
