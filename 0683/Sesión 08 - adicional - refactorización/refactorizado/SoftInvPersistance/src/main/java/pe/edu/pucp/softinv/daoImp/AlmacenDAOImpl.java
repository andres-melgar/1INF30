package pe.edu.pucp.softinv.daoImp;

import java.sql.SQLException;
import java.util.ArrayList;
import pe.edu.pucp.softinv.dao.AlmacenDAO;
import pe.edu.pucp.softinv.daoImp.util.Columna;
import pe.edu.pucp.softinv.db.DBManager;
import pe.edu.pucp.softinv.model.AlmacenesDTO;

public class AlmacenDAOImpl extends DAOImplBase implements AlmacenDAO {

    private AlmacenesDTO almacen;

    public AlmacenDAOImpl() {
        super("INV_ALMACENES");
        this.almacen = null;
        this.retornarLlavePrimaria = true;
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
    protected void incluirValorDeParametrosParaEliminacion() throws SQLException{
        this.statement.setInt(1, this.almacen.getAlmacenId());
    }

    @Override
    public Integer insertar(AlmacenesDTO almacen) {        
        this.almacen = almacen;
        return super.insertar();
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
        this.almacen = almacen;
        return super.modificar();
    }

    @Override
    public Integer eliminar(AlmacenesDTO almacen) {
        this.almacen = almacen;
        return super.eliminar();
    }

}
