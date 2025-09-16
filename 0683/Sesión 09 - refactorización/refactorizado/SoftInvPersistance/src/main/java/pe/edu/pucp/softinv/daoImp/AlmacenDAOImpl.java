package pe.edu.pucp.softinv.daoImp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
    protected void agregarObjetoALaLista(List lista) throws SQLException{
        this.instanciarObjetoDelResultSet();
        lista.add(this.almacen);
    }
    
    @Override
    public Integer insertar(AlmacenesDTO almacen) {        
        this.almacen = almacen;
        return super.insertar();
    }
    
    @Override
    public AlmacenesDTO obtenerPorId(Integer almacenId) {
        this.almacen = new AlmacenesDTO();
        this.almacen.setAlmacenId(almacenId);
        super.obtenerPorId();
        return this.almacen;
    }
    
    @Override
    public ArrayList<AlmacenesDTO> listarTodos() {
        return (ArrayList<AlmacenesDTO>) super.listarTodos();
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
