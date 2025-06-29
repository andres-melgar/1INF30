package pe.edu.pucp.softven.bo.server;

import java.util.ArrayList;
import pe.edu.pucp.softven.dao.ProductoDAO;
import pe.edu.pucp.softven.daoImp.ProductoDAOImpl;
import pe.edu.pucp.softven.model.ProductosDTO;

public class ProductoBO {

    private ProductoDAO productoDAO;
    
    public ProductoBO(){
        this.productoDAO = new ProductoDAOImpl();
    }
    
    public ProductosDTO insertar(ProductosDTO productosDTO){
        Integer id = this.productoDAO.insertar(productosDTO);
        productosDTO.setProductoId(id);
        return productosDTO;
    }
    
    public ProductosDTO obtenerPorId(Integer productoId){
        return this.productoDAO.obtenerPorId(productoId);
    }
    
    public ArrayList<ProductosDTO> listarTodos(){
        return this.productoDAO.listarTodos();
    }
    
    public Integer modificar(ProductosDTO productosDTO){        
        return this.productoDAO.modificar(productosDTO);
    }
    
    public Integer eliminar(Integer productoId){
        ProductosDTO productosDTO = new ProductosDTO();
        productosDTO.setProductoId(productoId);
        return this.productoDAO.eliminar(productosDTO);
    }
    
}
