package pe.edu.pucp.softven.dao;

import java.util.ArrayList;
import pe.edu.pucp.softven.model.ProductosDTO;

public interface ProductoDAO {

    public Integer insertar(ProductosDTO producto);
    
    public ProductosDTO obtenerPorId(Integer productoId);
    
    public ArrayList<ProductosDTO> listarTodos();
    
    public Integer modificar(ProductosDTO producto);
    
    public Integer eliminar(ProductosDTO producto);
}
