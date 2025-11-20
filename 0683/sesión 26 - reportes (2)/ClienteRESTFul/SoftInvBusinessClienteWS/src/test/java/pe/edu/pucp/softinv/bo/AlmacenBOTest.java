package pe.edu.pucp.softinv.bo;

import com.fasterxml.jackson.core.JsonProcessingException;
import java.io.IOException;
import pe.edu.pucp.softinv.bo.client.AlmacenBO;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pe.edu.pucp.softinv.model.AlmacenesDTO;

public class AlmacenBOTest {
    
    private AlmacenBO almacenBO;
    
    public AlmacenBOTest() {
        this.almacenBO = new AlmacenBO();
    }

//    @Test
//    public void testInsertar() throws IOException, JsonProcessingException, InterruptedException {
//        System.out.println("insertar");
//        ArrayList<Integer> listaAlmacenId = new ArrayList<>();
//        insertarAlmacenes(listaAlmacenId);
//        eliminarTodo();
//    }
//    
//    private void insertarAlmacenes(ArrayList<Integer> listaAlmacenId) throws IOException, JsonProcessingException, InterruptedException {        
//        Integer resultado = this.almacenBO.insertar("Almacén central", Boolean.TRUE);
//        assertTrue(resultado != 0);
//        listaAlmacenId.add(resultado);
//                
//        resultado = this.almacenBO.insertar("Almacén PUCP", Boolean.FALSE);
//        assertTrue(resultado != 0);
//        listaAlmacenId.add(resultado);
//                
//        resultado = this.almacenBO.insertar("Almacén Progra3", Boolean.FALSE);
//        assertTrue(resultado != 0);
//        listaAlmacenId.add(resultado);        
//    }
//    
//    @Test
//    public void testObtenerPorId() throws IOException, JsonProcessingException, InterruptedException {
//        System.out.println("obtenerPorId");
//        ArrayList<Integer> listaAlmacenId = new ArrayList<>();
//        insertarAlmacenes(listaAlmacenId);
//        AlmacenesDTO almacen = this.almacenBO.obtenerPorId(listaAlmacenId.get(0));
//        assertEquals(almacen.getAlmacenId(), listaAlmacenId.get(0));
//        
//        almacen = this.almacenBO.obtenerPorId(listaAlmacenId.get(1));
//        assertEquals(almacen.getAlmacenId(), listaAlmacenId.get(1));
//        
//        almacen = this.almacenBO.obtenerPorId(listaAlmacenId.get(2));
//        assertEquals(almacen.getAlmacenId(), listaAlmacenId.get(2));
//        eliminarTodo();
//    }
//    
//    @Test
//    public void testListarTodos() throws IOException, JsonProcessingException, InterruptedException {
//        System.out.println("listarTodos");
//        ArrayList<Integer> listaAlmacenId = new ArrayList<>();
//        insertarAlmacenes(listaAlmacenId);
//        
//        ArrayList<AlmacenesDTO> listaAlmacenes = this.almacenBO.listarTodos();
//        assertEquals(listaAlmacenId.size(), listaAlmacenes.size());
//        for (Integer i = 0; i < listaAlmacenId.size(); i++) {
//            assertEquals(listaAlmacenId.get(i), listaAlmacenes.get(i).getAlmacenId());
//        }
//        eliminarTodo();
//    }
//    
//    @Test
//    public void testModificar() throws IOException, JsonProcessingException, InterruptedException {
//        System.out.println("modificar");
//        ArrayList<Integer> listaAlmacenId = new ArrayList<>();
//        insertarAlmacenes(listaAlmacenId);
//        
//        ArrayList<AlmacenesDTO> listaAlmacenes = this.almacenBO.listarTodos();
//        assertEquals(listaAlmacenId.size(), listaAlmacenes.size());
//        for (Integer i = 0; i < listaAlmacenId.size(); i++) {
//            listaAlmacenes.get(i).setNombre("NuevoNombre" + i.toString());
//            listaAlmacenes.get(i).setAlmacen_central(!listaAlmacenes.get(i).getAlmacen_central());
//            this.almacenBO.modificar(listaAlmacenes.get(i).getAlmacenId(), listaAlmacenes.get(i).getNombre(), listaAlmacenes.get(i).getAlmacen_central());
//        }
//        
//        ArrayList<AlmacenesDTO> listaAlmacenesModificados = this.almacenBO.listarTodos();
//        assertEquals( listaAlmacenes.size(), listaAlmacenesModificados.size());
//        for (Integer i = 0; i < listaAlmacenes.size(); i++) {
//            assertEquals(listaAlmacenes.get(i).getNombre(), listaAlmacenesModificados.get(i).getNombre());
//            assertEquals(listaAlmacenes.get(i).getAlmacen_central(), listaAlmacenesModificados.get(i).getAlmacen_central());
//        }
//        eliminarTodo();
//    }
//    
//    @Test
//    public void testEliminar() throws IOException, JsonProcessingException, InterruptedException {
//        System.out.println("eliminar");
//        ArrayList<Integer> listaAlmacenId = new ArrayList<>();
//        insertarAlmacenes(listaAlmacenId);
//        eliminarTodo();
//    }
//    
//    private void eliminarTodo() throws IOException, InterruptedException{                
//        ArrayList<AlmacenesDTO> listaAlmacenes = this.almacenBO.listarTodos();
//        for (Integer i = 0; i < listaAlmacenes.size(); i++) {
//            Integer resultado = this.almacenBO.eliminar(listaAlmacenes.get(i).getAlmacenId());
//            assertNotEquals(0, resultado);
//            AlmacenesDTO almacen = this.almacenBO.obtenerPorId(listaAlmacenes.get(i).getAlmacenId());
//            assertNull(almacen);
//        }
//    }
    
}
