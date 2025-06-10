package pe.edu.pucp.softinv.bo.client;

import com.fasterxml.jackson.core.JsonProcessingException;
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

    private void crearHttpRequestGET(Integer id) {
        String urlGET = this.url;
        if (id != null) {
            urlGET += urlGET.concat("/" + id);
        }

        this.request = HttpRequest.newBuilder()
                .uri(URI.create(urlGET))
                .header("Content-Type", "application/json")
                .GET()
                .build();
    }
    
    private void enviarRequest() throws IOException, InterruptedException {
        this.response = this.client.send(this.request, HttpResponse.BodyHandlers.ofString());
    }
    
    private void cerrarHttpClient() {
        this.client.close();
    }
    
    private AlmacenesDTO deserializarDTO(Class<AlmacenesDTO> clase) throws JsonProcessingException {
        AlmacenesDTO almacenesDTORespuesta = mapper.readValue(this.response.body(), clase);
        return almacenesDTORespuesta;
    }

    public Integer insertar(String nombre, Boolean almacen_central) throws JsonProcessingException, IOException, InterruptedException {
        AlmacenesDTO almacenesDTO = new AlmacenesDTO();
        almacenesDTO.setNombre(nombre);
        almacenesDTO.setAlmacen_central(almacen_central);

        //serializar        
        String jsonRequest = mapper.writeValueAsString(almacenesDTO);

        //creamos el request
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(this.url))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonRequest))
                .build();

        this.crearHttpClient();
        this.enviarRequest();

        //deserializar
        AlmacenesDTO almacenesDTORespuesta = mapper.readValue(response.body(), AlmacenesDTO.class);

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

    public ArrayList<AlmacenesDTO> listarTodos() {
        return null;
    }

    public Integer modificar(Integer almacenId, String nombre, Boolean almacen_central) {
        AlmacenesDTO almacenesDTO = new AlmacenesDTO();
        almacenesDTO.setAlmacenId(almacenId);
        almacenesDTO.setNombre(nombre);
        almacenesDTO.setAlmacen_central(almacen_central);

        return null;
    }

    public Integer eliminar(Integer almacenId) {
        AlmacenesDTO almacenesDTO = new AlmacenesDTO();
        almacenesDTO.setAlmacenId(almacenId);

        return null;
    }

    

    

    

}
