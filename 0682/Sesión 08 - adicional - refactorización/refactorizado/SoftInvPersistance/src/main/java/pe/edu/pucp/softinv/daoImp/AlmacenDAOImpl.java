package pe.edu.pucp.softinv.daoImp;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import pe.edu.pucp.softinv.dao.AlmacenDAO;
import pe.edu.pucp.softinv.db.DBManager;
import pe.edu.pucp.softinv.model.AlmacenesDTO;

public class AlmacenDAOImpl implements AlmacenDAO {

    private Connection conexion;
    private CallableStatement statement;
    protected ResultSet resultSet;

    @Override
    public Integer insertar(AlmacenesDTO almacen) {
        int resultado = 0;
        try {
            this.conexion = DBManager.getInstance().getConnection();
            this.conexion.setAutoCommit(false);
            String sql = "INSERT INTO INV_ALMACENES (NOMBRE, ALMACEN_CENTRAL) VALUES (?,?)";
            this.statement = this.conexion.prepareCall(sql);
            this.statement.setString(1, almacen.getNombre());
            this.statement.setInt(2, almacen.getAlmacen_central() ? 1 : 0);
            //resultado = this.statement.executeUpdate();
            this.statement.executeUpdate();
            resultado = this.retornarUltimoAutoGenerado();
            this.conexion.commit();
        } catch (SQLException ex) {
            System.err.println("Error al intentar insertar - " + ex);
            try {
                if (this.conexion != null) {
                    this.conexion.rollback();
                }
            } catch (SQLException ex1) {
                System.err.println("Error al hacer rollback - " + ex1);
            }
        } finally {
            try {
                if (this.conexion != null) {
                    this.conexion.close();
                }
            } catch (SQLException ex) {
                System.err.println("Error al cerrar la conexión - " + ex);
            }
        }
        return resultado;
    }

    public Integer retornarUltimoAutoGenerado() {
        Integer resultado = null;
        try {
            String sql = "select @@last_insert_id as id";
            this.statement = this.conexion.prepareCall(sql);
            this.resultSet = this.statement.executeQuery();
            if (this.resultSet.next()) {
                resultado = this.resultSet.getInt("id");
            }
        } catch (SQLException ex) {
            System.err.println("Error al intentar retornarUltimoAutoGenerado - " + ex);
        }
        return resultado;
    }

    @Override
    public AlmacenesDTO obtenerPorId(Integer almacenId) {
        AlmacenesDTO almacen = null;
        try {
            this.conexion = DBManager.getInstance().getConnection();
            String sql = "SELECT ALMACEN_ID, NOMBRE, ALMACEN_CENTRAL FROM INV_ALMACENES WHERE ALMACEN_ID = ?";
            this.statement = this.conexion.prepareCall(sql);
            this.statement.setInt(1, almacenId);
            this.resultSet = this.statement.executeQuery();
            if (this.resultSet.next()) {
                almacen = new AlmacenesDTO();
                almacen.setAlmacenId(this.resultSet.getInt("ALMACEN_ID"));
                almacen.setNombre(this.resultSet.getString("NOMBRE"));
                almacen.setAlmacen_central(this.resultSet.getInt("ALMACEN_CENTRAL") == 1);
            }
        } catch (SQLException ex) {
            System.err.println("Error al intentar obtenerPorId - " + ex);
        } finally {
            try {
                if (this.conexion != null) {
                    this.conexion.close();
                }
            } catch (SQLException ex) {
                System.err.println("Error al cerrar la conexión - " + ex);
            }
        }
        return almacen;
    }

    @Override
    public ArrayList<AlmacenesDTO> listarTodos() {
        ArrayList<AlmacenesDTO> listaAlmacenes = new ArrayList<>();
        try {
            this.conexion = DBManager.getInstance().getConnection();
            String sql = "SELECT ALMACEN_ID, NOMBRE, ALMACEN_CENTRAL FROM INV_ALMACENES";
            this.statement = this.conexion.prepareCall(sql);
            this.resultSet = this.statement.executeQuery();
            while (this.resultSet.next()) {
                AlmacenesDTO almacen = new AlmacenesDTO();
                almacen.setAlmacenId(this.resultSet.getInt("ALMACEN_ID"));
                almacen.setNombre(this.resultSet.getString("NOMBRE"));
                almacen.setAlmacen_central(this.resultSet.getInt("ALMACEN_CENTRAL") == 1);
                listaAlmacenes.add(almacen);
            }
        } catch (SQLException ex) {
            System.err.println("Error al intentar listarTodos - " + ex);
        } finally {
            try {
                if (this.conexion != null) {
                    this.conexion.close();
                }
            } catch (SQLException ex) {
                System.err.println("Error al cerrar la conexión - " + ex);
            }
        }
        return listaAlmacenes;
    }

    @Override
    public Integer modificar(AlmacenesDTO almacen) {
        int resultado = 0;
        try {
            this.conexion = DBManager.getInstance().getConnection();
            this.conexion.setAutoCommit(false);
            String sql = "UPDATE INV_ALMACENES SET NOMBRE=?, ALMACEN_CENTRAL=? WHERE ALMACEN_ID=?";
            this.statement = this.conexion.prepareCall(sql);
            this.statement.setString(1, almacen.getNombre());
            this.statement.setInt(2, almacen.getAlmacen_central() ? 1 : 0);
            this.statement.setInt(3, almacen.getAlmacenId());
            resultado = this.statement.executeUpdate();
            this.conexion.commit();
        } catch (SQLException ex) {
            System.err.println("Error al intentar modificar - " + ex);
            try {
                if (this.conexion != null) {
                    this.conexion.rollback();
                }
            } catch (SQLException ex1) {
                System.err.println("Error al hacer rollback - " + ex1);
            }
        } finally {
            try {
                if (this.conexion != null) {
                    this.conexion.close();
                }
            } catch (SQLException ex) {
                System.err.println("Error al cerrar la conexión - " + ex);
            }
        }
        return resultado;
    }

    @Override
    public Integer eliminar(AlmacenesDTO almacen) {
        int resultado = 0;
        try {
            this.conexion = DBManager.getInstance().getConnection();
            this.conexion.setAutoCommit(false);
            String sql = "DELETE FROM INV_ALMACENES WHERE ALMACEN_ID=?";
            this.statement = this.conexion.prepareCall(sql);
            this.statement.setInt(1, almacen.getAlmacenId());
            resultado = this.statement.executeUpdate();
            this.conexion.commit();
        } catch (SQLException ex) {
            System.err.println("Error al intentar eliminar - " + ex);
            try {
                if (this.conexion != null) {
                    this.conexion.rollback();
                }
            } catch (SQLException ex1) {
                System.err.println("Error al hacer rollback - " + ex1);
            }
        } finally {
            try {
                if (this.conexion != null) {
                    this.conexion.close();
                }
            } catch (SQLException ex) {
                System.err.println("Error al cerrar la conexión - " + ex);
            }
        }
        return resultado;
    }
}
