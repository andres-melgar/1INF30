package pe.edu.pucp.softven.bo;

import java.util.ArrayList;
import pe.edu.pucp.softven.dao.ProductoDAO;
import pe.edu.pucp.softven.daoImp.ProductoDAOImpl;
import pe.edu.pucp.softven.model.ProductosDTO;

public class ProductoBO {

    private ProductoDAO productoDAO;
    
    public ProductoBO(){
        this.productoDAO = new ProductoDAOImpl();
    }
    
    public Integer insertar(String nombre, String descripcion, Double precio){
        ProductosDTO productosDTO = new ProductosDTO();
        productosDTO.setNombre(nombre);
        productosDTO.setDescripcion(descripcion);
        productosDTO.setPrecio(precio);
        
        return this.productoDAO.insertar(productosDTO);
    }
    
    public ProductosDTO obtenerPorId(Integer productoId){
        return this.productoDAO.obtenerPorId(productoId);
    }
    
    public ArrayList<ProductosDTO> listarTodos(){
        return this.productoDAO.listarTodos();
    }
    
    public Integer modificar(Integer productoId, String nombre, String descripcion, Double precio){
        ProductosDTO productosDTO = new ProductosDTO();
        productosDTO.setProductoId(productoId);
        productosDTO.setNombre(nombre);
        productosDTO.setDescripcion(descripcion);
        productosDTO.setPrecio(precio);
        return this.productoDAO.modificar(productosDTO);
    }
    
    public Integer eliminar(Integer productoId){
        ProductosDTO productosDTO = new ProductosDTO();
        productosDTO.setProductoId(productoId);
        return this.productoDAO.eliminar(productosDTO);
    }
    
}
