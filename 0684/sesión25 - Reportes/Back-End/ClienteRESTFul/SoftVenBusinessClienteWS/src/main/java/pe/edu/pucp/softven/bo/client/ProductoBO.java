package pe.edu.pucp.softven.bo.client;

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
import pe.edu.pucp.softven.model.ProductosDTO;

public class ProductoBO {

    private String url;
    private ObjectMapper mapper;
    private HttpClient client;
    private HttpRequest request;
    private HttpResponse<String> response;

    public ProductoBO() {
        this.url = "http://localhost:8080/SoftVenBusinessServidorWS/resources/Productos";
        this.mapper = new ObjectMapper();
        this.client = null;
        this.request = null;
        this.response = null;
    }

    private void crearHttpClient() {
        this.client = HttpClient.newHttpClient();
    }

    private void cerrarHttpClient() {
        this.client.close();
    }

    private void crearHttpRequestPOST(String jsonRequest) {
        this.request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(jsonRequest))
                .build();
    }

    private void crearHttpRequestGET() {
        Integer productoId = null;
        this.crearHttpRequestGET(productoId);
    }

    private void crearHttpRequestGET(Integer productoId) {
        String urlGET = this.url;
        if (productoId != null) {
            urlGET = urlGET.concat("/" + productoId);
        }

        this.request = HttpRequest.newBuilder()
                .uri(URI.create(urlGET))
                .GET()
                .build();
    }

    private void crearHttpRequestPUT(String jsonRequest) {
        this.request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .header("Content-Type", "application/json")
                .PUT(HttpRequest.BodyPublishers.ofString(jsonRequest))
                .build();
    }
    
    private void crearHttpRequestDELETE(Integer productoId) {
        String urlGET = this.url;
        if (productoId != null) {
            urlGET = urlGET.concat("/" + productoId);
        }

        this.request = HttpRequest.newBuilder()
                .uri(URI.create(urlGET))
                .DELETE()
                .build();
    }

    private void enviarRequest() throws IOException, InterruptedException {
        this.response = this.client.send(this.request, HttpResponse.BodyHandlers.ofString());
    }

    private ProductosDTO crearDTO(Integer productoId, String nombre, String descripcion, Double precio) {
        ProductosDTO productosDTO = new ProductosDTO();
        productosDTO.setProductoId(productoId);
        productosDTO.setNombre(nombre);
        productosDTO.setDescripcion(descripcion);
        productosDTO.setPrecio(precio);
        return productosDTO;
    }

    private String serializar(ProductosDTO productosDTO) throws JsonProcessingException {
        String jsonRequest = this.mapper.writeValueAsString(productosDTO);
        return jsonRequest;
    }

    private ProductosDTO deserializar(Class<ProductosDTO> clase) throws JsonProcessingException {
        ProductosDTO produtosDTORespuesta = mapper.readValue(this.response.body(), clase);
        return produtosDTORespuesta;
    }

    private ArrayList<ProductosDTO> deserializarListaDTO(TypeReference<ArrayList<ProductosDTO>> typeReference) throws JsonProcessingException {
        String json = this.response.body();
        ArrayList<ProductosDTO> listaProductos = this.mapper.readValue(json, typeReference);
        return listaProductos;
    }

    public Integer insertar(String nombre, String descripcion, Double precio) throws JsonProcessingException, IOException, InterruptedException {
//        ProductosDTO productosDTO = new ProductosDTO();
//        productosDTO.setNombre(nombre);
//        productosDTO.setDescripcion(descripcion);
//        productosDTO.setPrecio(precio);
//        
//        //vamos a serializar el objeto
//        ObjectMapper mapper = new ObjectMapper();
//        String jsonRequest = mapper.writeValueAsString(productosDTO);
//        
//        //se creará el requiest
//        HttpRequest request = HttpRequest.newBuilder()
//                .uri(URI.create(url))
//                .header("Content-Type", "application/json")
//                .POST(HttpRequest.BodyPublishers.ofString(jsonRequest))
//                .build();
//        
//        //creamos el cliente HTTP
//        HttpClient client = HttpClient.newHttpClient();
//        
//        //enviar el request por el cliente
//        HttpResponse<String> response = client.senHttpClient client = HttpClient.newHttpClient();d(request, HttpResponse.BodyHandlers.ofString());
//        
//        //deserializar
//        ProductosDTO produtosDTORespuesta = mapper.readValue(response.body(), ProductosDTO.class);
//        client.close();
//        if (response.statusCode() == Response.Status.CREATED.getStatusCode())
//            return produtosDTORespuesta.getProductoId();
//        return 0;

        ProductosDTO productosDTO = this.crearDTO(null, nombre, descripcion, precio);
        String jsonRequest = this.serializar(productosDTO);
        this.crearHttpClient();
        this.crearHttpRequestPOST(jsonRequest);
        this.enviarRequest();
        ProductosDTO produtosDTORespuesta = this.deserializar(ProductosDTO.class);
        this.cerrarHttpClient();

        if (response.statusCode() == Response.Status.CREATED.getStatusCode()) {
            return produtosDTORespuesta.getProductoId();
        }
        return 0;
    }

    public ProductosDTO obtenerPorId(Integer productoId) throws IOException, InterruptedException {
        this.crearHttpClient();
        this.crearHttpRequestGET(productoId);
        this.enviarRequest();
        this.cerrarHttpClient();
        ProductosDTO productoDTORespuesta = this.deserializar(ProductosDTO.class);
        return productoDTORespuesta;
    }

    public ArrayList<ProductosDTO> listarTodos() throws IOException, InterruptedException {
        this.crearHttpClient();
        this.crearHttpRequestGET();
        this.enviarRequest();
        this.cerrarHttpClient();
        ArrayList<ProductosDTO> listaProductos = this.deserializarListaDTO(new TypeReference<ArrayList<ProductosDTO>>() {
        });
        return listaProductos;
    }

    public Integer modificar(Integer productoId, String nombre, String descripcion, Double precio) throws JsonProcessingException, IOException, InterruptedException {
        ProductosDTO productosDTO = this.crearDTO(productoId, nombre, descripcion, precio);
        String jsonRequest = this.serializar(productosDTO);
        this.crearHttpClient();
        this.crearHttpRequestPUT(jsonRequest);
        this.enviarRequest();
        this.cerrarHttpClient();

        if (this.response.statusCode() == Response.Status.OK.getStatusCode()) {
            return productosDTO.getProductoId();
        }
        return 0;
    }

    public Integer eliminar(Integer productoId) throws IOException, InterruptedException {
        this.crearHttpClient();
        this.crearHttpRequestDELETE(productoId);
        this.enviarRequest();
        this.cerrarHttpClient();
        
        if (this.response.statusCode() == Response.Status.NO_CONTENT.getStatusCode()) {
            return productoId;
        }
        return 0;
    }    

}
