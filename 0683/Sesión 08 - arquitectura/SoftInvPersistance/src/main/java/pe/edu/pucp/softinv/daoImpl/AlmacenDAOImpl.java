package pe.edu.pucp.softinv.daoImpl;

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
    private ResultSet resultSet;

    @Override
    public Integer insertar(AlmacenesDTO almacen) {
        Integer resultado = 0;
        try {
            this.conexion = DBManager.getInstance().getConnection();
            this.conexion.setAutoCommit(false);
            String sql = "INSERT INTO INV_ALMACENES(NOMBRE, ALMACEN_CENTRAL) VALUES (?,?)";
            this.statement = this.conexion.prepareCall(sql);
            this.statement.setString(1, almacen.getNombre());
            this.statement.setInt(2, almacen.getAlmacen_central() ? 1 : 0);
            this.statement.executeUpdate();
            resultado = this.retornarUltimoAutoGenerado();
            almacen.setAlmacenId(resultado);
            this.conexion.commit();
        } catch (SQLException ex) {
            try {
                if (this.conexion != null) {
                    this.conexion.rollback();
                }
            } catch (SQLException ex1) {
                System.getLogger(AlmacenDAOImpl.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex1);
            }
            System.getLogger(AlmacenDAOImpl.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        } finally {
            try {
                if (this.conexion != null) {
                    this.conexion.close();
                }
            } catch (SQLException ex) {
                System.getLogger(AlmacenDAOImpl.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
            }
            this.conexion = null;
        }
        return resultado;
    }

    private Integer retornarUltimoAutoGenerado() {
        Integer resultado = null;
        try {
            String sql = "SELECT @@LAST_INSERT_ID AS ID";
            this.statement = this.conexion.prepareCall(sql);
            this.resultSet = this.statement.executeQuery();
            if (this.resultSet.next()) {
                resultado = this.resultSet.getInt("ID");
            }
        } catch (SQLException ex) {
            System.getLogger(AlmacenDAOImpl.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return resultado;
    }

    @Override
    public AlmacenesDTO obtenerPorId(Integer almacenId) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<AlmacenesDTO> listarTodos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Integer modificar(AlmacenesDTO almacen) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Integer eliminar(AlmacenesDTO almacen) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
