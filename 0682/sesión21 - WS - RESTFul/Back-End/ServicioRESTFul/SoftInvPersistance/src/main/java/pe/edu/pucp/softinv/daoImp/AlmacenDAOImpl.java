package pe.edu.pucp.softinv.daoImp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.edu.pucp.softinv.dao.AlmacenDAO;
import pe.edu.pucp.softinv.daoImp.util.Columna;
import pe.edu.pucp.softinv.model.AlmacenesDTO;

public class AlmacenDAOImpl extends DAOImplBase implements AlmacenDAO {

    private AlmacenesDTO almacen;

    public AlmacenDAOImpl() {
        super("INV_ALMACENES");
        this.retornarLlavePrimaria = true;
        this.almacen = null;
    }

    @Override
    protected void configurarListaDeColumnas() {
        this.listaColumnas.add(new Columna("ALMACEN_ID", true, true));
        this.listaColumnas.add(new Columna("NOMBRE", false, false));
        this.listaColumnas.add(new Columna("ALMACEN_CENTRAL", false, false));
    }

    @Override
    protected void incluirValorDeParametrosParaInsercion() throws SQLException {
        this.statement.setString(1, this.almacen.getNombre());
        this.statement.setInt(2, this.almacen.getAlmacen_central() ? 1 : 0);
    }

    @Override
    protected void incluirValorDeParametrosParaModificacion() throws SQLException {
        this.statement.setString(1, this.almacen.getNombre());
        this.statement.setInt(2, this.almacen.getAlmacen_central() ? 1 : 0);
        this.statement.setInt(3, this.almacen.getAlmacenId());
    }

    @Override
    protected void incluirValorDeParametrosParaEliminacion() throws SQLException {
        this.statement.setInt(1, this.almacen.getAlmacenId());
    }

    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        this.statement.setInt(1, this.almacen.getAlmacenId());
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.almacen = new AlmacenesDTO();
        this.almacen.setAlmacenId(this.resultSet.getInt("ALMACEN_ID"));
        this.almacen.setNombre(this.resultSet.getString("NOMBRE"));
        this.almacen.setAlmacen_central(this.resultSet.getInt("ALMACEN_CENTRAL") == 1);
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.almacen = null;
    }

    @Override
    protected void agregarObjetoALaLista(List lista) throws SQLException {
        this.instanciarObjetoDelResultSet();
        lista.add(this.almacen);
    }

    @Override
    public Integer insertar(AlmacenesDTO almacen) {
        this.almacen = almacen;
        return super.insertar();
//        int resultado = 0;
//        try {
//            this.conexion = DBManager.getInstance().getConnection();
//            this.conexion.setAutoCommit(false);
//            String sql = this.generarSQLParaInsercion();
//            this.statement = this.conexion.prepareCall(sql);
//            this.statement.setString(1, almacen.getNombre());
//            this.statement.setInt(2, almacen.getAlmacen_central() ? 1 : 0);
//            //resultado = this.statement.executeUpdate();
//            this.statement.executeUpdate();
//            resultado = this.retornarUltimoAutoGenerado();
//            this.conexion.commit();
//        } catch (SQLException ex) {
//            System.err.println("Error al intentar insertar - " + ex);
//            try {
//              if (this.conexion != null) {
//                  this.conexion.rollback();
//              }
//            } catch (SQLException ex1) {
//              System.err.println("Error al hacer rollback - " + ex1);
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
    public AlmacenesDTO obtenerPorId(Integer almacenId) {
        this.almacen = new AlmacenesDTO();
        this.almacen.setAlmacenId(almacenId);
        super.obtenerPorId();
        return this.almacen;
//        AlmacenesDTO almacen = null;
//        try {
//            this.conexion = DBManager.getInstance().getConnection();
//            String sql = this.generarSQLParaObtenerPorId();
//            this.statement = this.conexion.prepareCall(sql);
//            this.statement.setInt(1, almacenId);
//            this.resultSet = this.statement.executeQuery();
//            if (this.resultSet.next()) {
//                almacen = new AlmacenesDTO();
//                almacen.setAlmacenId(this.resultSet.getInt("ALMACEN_ID"));
//                almacen.setNombre(this.resultSet.getString("NOMBRE"));
//                almacen.setAlmacen_central(this.resultSet.getInt("ALMACEN_CENTRAL") == 1);
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
//        return almacen;
    }

    @Override
    public ArrayList<AlmacenesDTO> listarTodos() {
        return (ArrayList<AlmacenesDTO>) super.listarTodos();
//        ArrayList<AlmacenesDTO> listaAlmacenes = new ArrayList<>();
//        try {
//            this.conexion = DBManager.getInstance().getConnection();
//            String sql = this.generarSQLParaListarTodos();
//            this.statement = this.conexion.prepareCall(sql);
//            this.resultSet = this.statement.executeQuery();
//            while (this.resultSet.next()) {
//                AlmacenesDTO almacen = new AlmacenesDTO();
//                almacen.setAlmacenId(this.resultSet.getInt("ALMACEN_ID"));
//                almacen.setNombre(this.resultSet.getString("NOMBRE"));
//                almacen.setAlmacen_central(this.resultSet.getInt("ALMACEN_CENTRAL") == 1);
//                listaAlmacenes.add(almacen);
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
//        return listaAlmacenes;
    }

    @Override
    public Integer modificar(AlmacenesDTO almacen) {
        this.almacen = almacen;
        return super.modificar();
//        int resultado = 0;
//        try {
//            this.conexion = DBManager.getInstance().getConnection();
//            this.conexion.setAutoCommit(false);
//            String sql = this.generarSQLParaModificacion();
//            this.statement = this.conexion.prepareCall(sql);
//            this.statement.setString(1, almacen.getNombre());
//            this.statement.setInt(2, almacen.getAlmacen_central() ? 1 : 0);
//            this.statement.setInt(3, almacen.getAlmacenId());
//            resultado = this.statement.executeUpdate();
//            this.conexion.commit();
//        } catch (SQLException ex) {
//            System.err.println("Error al intentar modificar - " + ex);
//            try {
//              if (this.conexion != null) {
//                  this.conexion.rollback();
//              }
//            } catch (SQLException ex1) {
//              System.err.println("Error al hacer rollback - " + ex1);
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
    public Integer eliminar(AlmacenesDTO almacen) {
        this.almacen = almacen;
        return super.eliminar();
//        int resultado = 0;
//        try {
//            this.conexion = DBManager.getInstance().getConnection();
//            this.conexion.setAutoCommit(false);
//            String sql = this.generarSQLParaEliminacion();
//            this.statement = this.conexion.prepareCall(sql);
//            this.statement.setInt(1, almacen.getAlmacenId());
//            resultado = this.statement.executeUpdate();
//            this.conexion.commit();
//        } catch (SQLException ex) {
//            System.err.println("Error al intentar eliminar - " + ex);
//            try {
//              if (this.conexion != null) {
//                  this.conexion.rollback();
//              }
//            } catch (SQLException ex1) {
//              System.err.println("Error al hacer rollback - " + ex1);
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
