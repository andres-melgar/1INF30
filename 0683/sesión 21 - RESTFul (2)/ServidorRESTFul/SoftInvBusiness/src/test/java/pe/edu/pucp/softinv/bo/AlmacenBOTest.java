package pe.edu.pucp.softinv.bo;

import pe.edu.pucp.softinv.bo.server.AlmacenBO;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pe.edu.pucp.softinv.model.AlmacenesDTO;

public class AlmacenBOTest {
    
    private AlmacenBO almacenBO;
    
    public AlmacenBOTest() {
        this.almacenBO = new AlmacenBO();
    }

    @Test
    public void testInsertar() {
        System.out.println("insertar");
        ArrayList<Integer> listaAlmacenId = new ArrayList<>();
        insertarAlmacenes(listaAlmacenId);
        eliminarTodo();
    }
    
    private void insertarAlmacenes(ArrayList<Integer> listaAlmacenId) {        
        AlmacenesDTO almacen = new AlmacenesDTO();
        almacen.setNombre("Almacén central");
        almacen.setAlmacen_central(Boolean.TRUE);
        Integer resultado = this.almacenBO.insertar(almacen);
        assertTrue(resultado != 0);
        listaAlmacenId.add(resultado);
                
        almacen = new AlmacenesDTO();
        almacen.setNombre("Almacén PUCP");
        almacen.setAlmacen_central(Boolean.FALSE);
        resultado = this.almacenBO.insertar(almacen);
        assertTrue(resultado != 0);
        listaAlmacenId.add(resultado);
                
        almacen = new AlmacenesDTO();
        almacen.setNombre("Almacén Progra3");
        almacen.setAlmacen_central(Boolean.FALSE);
        resultado = this.almacenBO.insertar(almacen);
        assertTrue(resultado != 0);
        listaAlmacenId.add(resultado);        
    }
    
    @Test
    public void testObtenerPorId() {
        System.out.println("obtenerPorId");
        ArrayList<Integer> listaAlmacenId = new ArrayList<>();
        insertarAlmacenes(listaAlmacenId);
        AlmacenesDTO almacen = this.almacenBO.obtenerPorId(listaAlmacenId.get(0));
        assertEquals(almacen.getAlmacenId(), listaAlmacenId.get(0));
        
        almacen = this.almacenBO.obtenerPorId(listaAlmacenId.get(1));
        assertEquals(almacen.getAlmacenId(), listaAlmacenId.get(1));
        
        almacen = this.almacenBO.obtenerPorId(listaAlmacenId.get(2));
        assertEquals(almacen.getAlmacenId(), listaAlmacenId.get(2));
        eliminarTodo();
    }
    
    @Test
    public void testListarTodos() {
        System.out.println("listarTodos");
        ArrayList<Integer> listaAlmacenId = new ArrayList<>();
        insertarAlmacenes(listaAlmacenId);
        
        ArrayList<AlmacenesDTO> listaAlmacenes = this.almacenBO.listarTodos();
        assertEquals(listaAlmacenId.size(), listaAlmacenes.size());
        for (Integer i = 0; i < listaAlmacenId.size(); i++) {
            assertEquals(listaAlmacenId.get(i), listaAlmacenes.get(i).getAlmacenId());
        }
        eliminarTodo();
    }
    
    @Test
    public void testModificar() {
        System.out.println("modificar");
        ArrayList<Integer> listaAlmacenId = new ArrayList<>();
        insertarAlmacenes(listaAlmacenId);
        
        ArrayList<AlmacenesDTO> listaAlmacenes = this.almacenBO.listarTodos();
        assertEquals(listaAlmacenId.size(), listaAlmacenes.size());
        for (Integer i = 0; i < listaAlmacenId.size(); i++) {
            listaAlmacenes.get(i).setNombre("NuevoNombre" + i.toString());
            listaAlmacenes.get(i).setAlmacen_central(!listaAlmacenes.get(i).getAlmacen_central());
            
            AlmacenesDTO almacen = new AlmacenesDTO();
            almacen.setAlmacenId(listaAlmacenes.get(i).getAlmacenId());
            almacen.setNombre(listaAlmacenes.get(i).getNombre());
            almacen.setAlmacen_central(listaAlmacenes.get(i).getAlmacen_central());   
            this.almacenBO.modificar(almacen);
        }
        
        ArrayList<AlmacenesDTO> listaAlmacenesModificados = this.almacenBO.listarTodos();
        assertEquals( listaAlmacenes.size(), listaAlmacenesModificados.size());
        for (Integer i = 0; i < listaAlmacenes.size(); i++) {
            assertEquals(listaAlmacenes.get(i).getNombre(), listaAlmacenesModificados.get(i).getNombre());
            assertEquals(listaAlmacenes.get(i).getAlmacen_central(), listaAlmacenesModificados.get(i).getAlmacen_central());
        }
        eliminarTodo();
    }
    
    @Test
    public void testEliminar() {
        System.out.println("eliminar");
        ArrayList<Integer> listaAlmacenId = new ArrayList<>();
        insertarAlmacenes(listaAlmacenId);
        eliminarTodo();
    }
    
    private void eliminarTodo(){                
        ArrayList<AlmacenesDTO> listaAlmacenes = this.almacenBO.listarTodos();
        for (Integer i = 0; i < listaAlmacenes.size(); i++) {
            Integer resultado = this.almacenBO.eliminar(listaAlmacenes.get(i).getAlmacenId());
            assertNotEquals(0, resultado);
            AlmacenesDTO almacen = this.almacenBO.obtenerPorId(listaAlmacenes.get(i).getAlmacenId());
            assertNull(almacen);
        }
    }
    
}
