package pe.edu.pucp.softven.dao;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pe.edu.pucp.softven.daoImp.ProductoDAOImpl;
import pe.edu.pucp.softven.model.ProductosDTO;

public class ProductoDAOTest {

    private ProductoDAO productoDAO;

    public ProductoDAOTest() {
        this.productoDAO = new ProductoDAOImpl();
    }

    @Test
    public void testInsertar() {
        System.out.println("insertar");
        ArrayList<Integer> listaProductoId = new ArrayList<>();
        insertarProductos(listaProductoId);
        eliminarTodo();
    }

    private void insertarProductos(ArrayList<Integer> listaProductoId) {
        ProductosDTO productosDTO = new ProductosDTO();
        productosDTO.setNombre("Curso 1");
        productosDTO.setDescripcion("descripción del curso 1");
        productosDTO.setPrecio(299.99);
        Integer resultado = this.productoDAO.insertar(productosDTO);
        assertTrue(resultado != 0);
        listaProductoId.add(resultado);

        productosDTO = new ProductosDTO();
        productosDTO.setNombre("Curso 2");
        productosDTO.setDescripcion("descripción del curso 2");
        productosDTO.setPrecio(569.99);
        resultado = this.productoDAO.insertar(productosDTO);
        assertTrue(resultado != 0);
        listaProductoId.add(resultado);

        productosDTO = new ProductosDTO();
        productosDTO.setNombre("Curso 3");
        productosDTO.setDescripcion("descripción del curso 3");
        productosDTO.setPrecio(869.99);
        resultado = this.productoDAO.insertar(productosDTO);
        assertTrue(resultado != 0);
        listaProductoId.add(resultado);
    }

    @Test
    public void testObtenerPorId() {
        System.out.println("obtenerPorId");
        ArrayList<Integer> listaProductoId = new ArrayList<>();
        insertarProductos(listaProductoId);
        ProductosDTO almacen = this.productoDAO.obtenerPorId(listaProductoId.get(0));
        assertEquals(almacen.getProductoId(), listaProductoId.get(0));

        almacen = this.productoDAO.obtenerPorId(listaProductoId.get(1));
        assertEquals(almacen.getProductoId(), listaProductoId.get(1));

        almacen = this.productoDAO.obtenerPorId(listaProductoId.get(2));
        assertEquals(almacen.getProductoId(), listaProductoId.get(2));
        eliminarTodo();
    }

    @Test
    public void testListarTodos() {
        System.out.println("listarTodos");
        ArrayList<Integer> listaProductoId = new ArrayList<>();
        insertarProductos(listaProductoId);

        ArrayList<ProductosDTO> listaProductos = this.productoDAO.listarTodos();
        assertEquals(listaProductoId.size(), listaProductos.size());
        for (Integer i = 0; i < listaProductoId.size(); i++) {
            assertEquals(listaProductoId.get(i), listaProductos.get(i).getProductoId());
        }
        eliminarTodo();
    }

    @Test
    public void testModificar() {
        System.out.println("modificar");
        ArrayList<Integer> listaProductoId = new ArrayList<>();
        insertarProductos(listaProductoId);

        ArrayList<ProductosDTO> listaProductos = this.productoDAO.listarTodos();
        assertEquals(listaProductoId.size(), listaProductos.size());
        for (Integer i = 0; i < listaProductoId.size(); i++) {
            listaProductos.get(i).setNombre("NuevoNombre" + i.toString());
            listaProductos.get(i).setDescripcion("NuevsDescripcion" + i.toString());
            listaProductos.get(i).setPrecio(1000.44 + i);

            this.productoDAO.modificar(listaProductos.get(i));
        }

        ArrayList<ProductosDTO> listaProductosModificados = this.productoDAO.listarTodos();
        assertEquals(listaProductos.size(), listaProductosModificados.size());
        for (Integer i = 0; i < listaProductos.size(); i++) {
            assertEquals(listaProductos.get(i).getNombre(), listaProductosModificados.get(i).getNombre());
            assertEquals(listaProductos.get(i).getDescripcion(), listaProductosModificados.get(i).getDescripcion());
            assertEquals(listaProductos.get(i).getPrecio(), listaProductosModificados.get(i).getPrecio());
        }
        eliminarTodo();
    }

    @Test
    public void testEliminar() {
        System.out.println("eliminar");
        ArrayList<Integer> listaProductoId = new ArrayList<>();
        insertarProductos(listaProductoId);
        eliminarTodo();
    }

    private void eliminarTodo() {
        ArrayList<ProductosDTO> listaProductos = this.productoDAO.listarTodos();
        for (Integer i = 0; i < listaProductos.size(); i++) {
            Integer resultado = this.productoDAO.eliminar(listaProductos.get(i));
            assertNotEquals(0, resultado);
            ProductosDTO producto = this.productoDAO.obtenerPorId(listaProductos.get(i).getProductoId());
            assertNull(producto);
        }
    }

}
