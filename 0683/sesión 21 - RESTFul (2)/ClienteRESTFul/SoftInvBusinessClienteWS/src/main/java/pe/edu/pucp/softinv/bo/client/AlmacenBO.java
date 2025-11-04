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

    private HttpClient cliente;
    private HttpRequest request;
    private HttpResponse<String> response;
    private String url;

    public AlmacenBO() {
        //OJO, esto debe leerse de un .properties
        this.url = "http://localhost:8080/SoftInvBusinessServidorWS/resources/Almacenes";
    }

    public Integer insertar(String nombre, Boolean almacen_central) throws JsonProcessingException, IOException, InterruptedException {
        this.crearHttpClient();

        //EN BLANCO
        AlmacenesDTO almacenDTO = new AlmacenesDTO();
        almacenDTO.setNombre(nombre);
        almacenDTO.setAlmacen_central(almacen_central);

        //EN VERDE - serialización
        ObjectMapper mapper = new ObjectMapper();
        String jsonRequest = mapper.writeValueAsString(almacenDTO);

        this.crearHttpRequestPOST(jsonRequest);

        this.enviarRequest();

        //EN VERDE - deserialización
        AlmacenesDTO almacenRespuesta = mapper.readValue(response.body(), AlmacenesDTO.class);
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

    public AlmacenesDTO obtenerPorId(Integer almacenId) {
        return null;
    }

    public ArrayList<AlmacenesDTO> listarTodos() {
        return null;
    }

    public Integer modificar(Integer almacenId, String nombre, Boolean almacen_central) {
        return -1;
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
}
