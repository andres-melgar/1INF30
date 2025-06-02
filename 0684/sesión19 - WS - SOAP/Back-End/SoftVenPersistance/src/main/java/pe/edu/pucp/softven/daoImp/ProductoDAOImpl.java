package pe.edu.pucp.softven.daoImp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.pucp.softven.dao.ProductoDAO;
import pe.edu.pucp.softven.daoImp.util.Columna;
import pe.edu.pucp.softven.daoImp.util.Tipo_Dato;
import pe.edu.pucp.softven.model.ProductosDTO;

public class ProductoDAOImpl extends DAOImplBase implements ProductoDAO {

    private ProductosDTO producto;

    public ProductoDAOImpl() {
        super("VEN_PRODUCTOS");
        this.retornarLlavePrimaria = true;
        this.producto = null;
    }

    @Override
    protected void configurarListaDeColumnas() {
        this.listaColumnas.add(new Columna("PRODUCTO_ID", Tipo_Dato.ENTERO, true, true));
        this.listaColumnas.add(new Columna("NOMBRE", Tipo_Dato.CADENA, false, false));
        this.listaColumnas.add(new Columna("DESCRIPCION", Tipo_Dato.CADENA, false, false));
        this.listaColumnas.add(new Columna("PRECIO", Tipo_Dato.REAL, false, false));
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.statement.setString(1, this.producto.getNombre());
        this.statement.setString(2, this.producto.getDescripcion());
        this.statement.setDouble(3, this.producto.getPrecio());
    }

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        this.statement.setString(1, this.producto.getNombre());
        this.statement.setString(2, this.producto.getDescripcion());
        this.statement.setDouble(3, this.producto.getPrecio());
        this.statement.setInt(4, this.producto.getProductoId());
    }

    @Override
    protected void incluirValorDeParametrosParaEliminacion() throws SQLException {
        this.statement.setInt(1, this.producto.getProductoId());
    }

    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        this.statement.setInt(1, this.producto.getProductoId());
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.producto = new ProductosDTO();
        this.producto.setProductoId(this.resultSet.getInt("PRODUCTO_ID"));
        this.producto.setNombre(this.resultSet.getString("NOMBRE"));
        this.producto.setDescripcion(this.resultSet.getString("DESCRIPCION"));
        this.producto.setPrecio(this.resultSet.getDouble("PRECIO"));
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.producto = null;
    }

    @Override
    protected void agregarObjetoALaLista(List lista) throws SQLException {
        this.instanciarObjetoDelResultSet();
        lista.add(this.producto);
    }

    @Override
    public Integer insertar(ProductosDTO producto) {
        this.producto = producto;
        return super.insertar();
//        int resultado = 0;
//        try {
//            this.conexion = DBManager.getInstance().getConnection();
//            this.conexion.setAutoCommit(false);
//            String sql = "INSERT INTO VEN_PRODUCTOS (NOMBRE, DESCRIPCION, PRECIO) VALUES (?,?,?)";
//            this.statement = this.conexion.prepareCall(sql);
//            this.statement.setString(1, producto.getNombre());
//            this.statement.setString(2, producto.getDescripcion());
//            this.statement.setDouble(3, producto.getPrecio());
//            //resultado = this.statement.executeUpdate();
//            this.statement.executeUpdate();
//            resultado = this.retornarUltimoAutoGenerado();
//            this.conexion.commit();
//        } catch (SQLException ex) {
//            System.err.println("Error al intentar insertar - " + ex);
//            try {
//                if (this.conexion != null) {
//                    this.conexion.rollback();
//                }
//            } catch (SQLException ex1) {
//                System.err.println("Error al hacer rollback - " + ex1);
//            }
//        } finally {
//            try {
//                if (this.conexion != null) {
//                    this.conexion.close();
//                }
//            } catch (SQLException ex) {
//                System.err.println("Error al cerrar la conexión - " + ex);
//            }
//        }
//        return resultado;
    }

    @Override
    public ProductosDTO obtenerPorId(Integer productoId) {
        this.producto = new ProductosDTO();
        this.producto.setProductoId(productoId);
        super.obtenerPorId();
        return this.producto;
//        ProductosDTO producto = null;
//        try {
//            this.conexion = DBManager.getInstance().getConnection();
//            String sql = "SELECT PRODUCTO_ID, NOMBRE, DESCRIPCION, PRECIO FROM VEN_PRODUCTOS WHERE PRODUCTO_ID = ?";
//            this.statement = this.conexion.prepareCall(sql);
//            this.statement.setInt(1, productoId);
//            this.resultSet = this.statement.executeQuery();
//            if (this.resultSet.next()) {
//                producto = new ProductosDTO();
//                producto.setProductoId(this.resultSet.getInt("PRODUCTO_ID"));
//                producto.setNombre(this.resultSet.getString("NOMBRE"));
//                producto.setDescripcion(this.resultSet.getString("DESCRIPCION"));
//                producto.setPrecio(this.resultSet.getDouble("PRECIO"));
//            }
//        } catch (SQLException ex) {
//            System.err.println("Error al intentar obtenerPorId - " + ex);
//        } finally {
//            try {
//                if (this.conexion != null) {
//                    this.conexion.close();
//                }
//            } catch (SQLException ex) {
//                System.err.println("Error al cerrar la conexión - " + ex);
//            }
//        }
//        return producto;
    }

    @Override
    public ArrayList<ProductosDTO> listarTodos() {
        return (ArrayList<ProductosDTO>) super.listarTodos();
//        ArrayList<ProductosDTO> listaProductos = new ArrayList<>();
//        try {
//            this.conexion = DBManager.getInstance().getConnection();
//            String sql = "SELECT PRODUCTO_ID, NOMBRE, DESCRIPCION, PRECIO FROM VEN_PRODUCTOS";
//            this.statement = this.conexion.prepareCall(sql);
//            this.resultSet = this.statement.executeQuery();
//            while (this.resultSet.next()) {
//                ProductosDTO producto = new ProductosDTO();
//                producto.setProductoId(this.resultSet.getInt("PRODUCTO_ID"));
//                producto.setNombre(this.resultSet.getString("NOMBRE"));
//                producto.setDescripcion(this.resultSet.getString("DESCRIPCION"));
//                producto.setPrecio(this.resultSet.getDouble("PRECIO"));
//                listaProductos.add(producto);
//            }
//        } catch (SQLException ex) {
//            System.err.println("Error al intentar listarTodos - " + ex);
//        } finally {
//            try {
//                if (this.conexion != null) {
//                    this.conexion.close();
//                }
//            } catch (SQLException ex) {
//                System.err.println("Error al cerrar la conexión - " + ex);
//            }
//        }
//        return listaProductos;
    }

    @Override
    public Integer modificar(ProductosDTO producto) {
        this.producto = producto;
        return super.modificar();
//        int resultado = 0;
//        try {
//            this.conexion = DBManager.getInstance().getConnection();
//            this.conexion.setAutoCommit(false);
//            String sql = "UPDATE VEN_PRODUCTOS SET NOMBRE=?, DESCRIPCION=?, PRECIO=? WHERE PRODUCTO_ID=?";
//            this.statement = this.conexion.prepareCall(sql);
//            this.statement.setString(1, producto.getNombre());
//            this.statement.setString(2, producto.getDescripcion());
//            this.statement.setDouble(3, producto.getPrecio());
//            this.statement.setInt(4, producto.getProductoId());
//
//            resultado = this.statement.executeUpdate();
//            this.conexion.commit();
//        } catch (SQLException ex) {
//            System.err.println("Error al intentar modificar - " + ex);
//            try {
//                if (this.conexion != null) {
//                    this.conexion.rollback();
//                }
//            } catch (SQLException ex1) {
//                System.err.println("Error al hacer rollback - " + ex1);
//            }
//        } finally {
//            try {
//                if (this.conexion != null) {
//                    this.conexion.close();
//                }
//            } catch (SQLException ex) {
//                System.err.println("Error al cerrar la conexión - " + ex);
//            }
//        }
//        return resultado;
    }

    @Override
    public Integer eliminar(ProductosDTO producto) {
        this.producto = producto;
        return super.eliminar();
//        int resultado = 0;
//        try {
//            this.conexion = DBManager.getInstance().getConnection();
//            this.conexion.setAutoCommit(false);
//            String sql = "DELETE FROM VEN_PRODUCTOS WHERE PRODUCTO_ID=?";
//            this.statement = this.conexion.prepareCall(sql);
//            this.statement.setInt(1, producto.getProductoId());
//            resultado = this.statement.executeUpdate();
//            this.conexion.commit();
//        } catch (SQLException ex) {
//            System.err.println("Error al intentar eliminar - " + ex);
//            try {
//                if (this.conexion != null) {
//                    this.conexion.rollback();
//                }
//            } catch (SQLException ex1) {
//                System.err.println("Error al hacer rollback - " + ex1);
//            }
//        } finally {
//            try {
//                if (this.conexion != null) {
//                    this.conexion.close();
//                }
//            } catch (SQLException ex) {
//                System.err.println("Error al cerrar la conexión - " + ex);
//            }
//        }
//        return resultado;
    }

}
