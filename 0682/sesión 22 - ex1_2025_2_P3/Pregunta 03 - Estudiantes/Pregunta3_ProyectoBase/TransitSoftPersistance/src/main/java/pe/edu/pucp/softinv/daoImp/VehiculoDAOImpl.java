package pe.edu.pucp.softinv.daoImp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pe.pucp.transitsoft.dao.VehiculoDAO;
import pe.pucp.transitsoft.daoImp.util.Columna;
import pe.pucp.transitsoft.model.PropietarioDTO;
import pe.pucp.transitsoft.model.VehiculoDTO;

public class VehiculoDAOImpl extends DAOImplBase implements VehiculoDAO {

    private VehiculoDTO vehiculoDTO;

    public VehiculoDAOImpl() {
        super("VEHICULO");
        this.vehiculoDTO = null;
        this.retornarLlavePrimaria = true;
    }

    @Override
    protected void configurarListaDeColumnas() {
        this.listaColumnas.add(new Columna("ID", true, true));
        this.listaColumnas.add(new Columna("PLACA", false, false));
        this.listaColumnas.add(new Columna("MARCA", false, false));
        this.listaColumnas.add(new Columna("MODELO", false, false));
        this.listaColumnas.add(new Columna("ANHO", false, false));
    }

    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        PropietarioDTO propietario = new PropietarioDTO();
        propietario.setId(this.resultSet.getInt("ID_PROPIETARIO"));
        propietario.setDni(this.resultSet.getString("DNI"));
        propietario.setNombres(this.resultSet.getString("NOMBRES"));
        propietario.setApellidos(this.resultSet.getString("APELLIDOS"));
        propietario.setDireccion(this.resultSet.getString("DIRECCION"));
        
        this.vehiculoDTO = new VehiculoDTO();
        this.vehiculoDTO.setId(this.resultSet.getInt("ID_VEHICULO"));
        this.vehiculoDTO.setPlaca(this.resultSet.getString("PLACA"));
        this.vehiculoDTO.setMarca(this.resultSet.getString("MARCA"));
        this.vehiculoDTO.setModelo(this.resultSet.getString("MODELO"));
        this.vehiculoDTO.setAnho(this.resultSet.getInt("ANHO"));
        this.vehiculoDTO.setPropietario(propietario);
    }

    @Override
    protected void limpiarObjetoDelResultSet() {
        this.vehiculoDTO = null;
    }

    @Override
    protected void agregarObjetoALaLista(List lista) throws SQLException {
        this.instanciarObjetoDelResultSet();
        lista.add(this.vehiculoDTO);
    }

    @Override
    public ArrayList<VehiculoDTO> listarPorPropietario(String descripion_propietario) {
        String sql = this.generarSQLParaListarPorPropietario();
        return (ArrayList<VehiculoDTO>) super.listarTodos(sql, this::incluirValorDeParametrosParaListarPorPropietario, descripion_propietario);
    }

    private String generarSQLParaListarPorPropietario() {
        String sql = "SELECT 	V.ID AS ID_VEHICULO, ";
        sql = sql.concat("V.PLACA, ");
        sql = sql.concat("V.MARCA, ");
        sql = sql.concat("V.MODELO, ");
        sql = sql.concat("V.ANHO, ");
        sql = sql.concat("P.ID AS ID_PROPIETARIO, ");
        sql = sql.concat("P.DNI, ");
        sql = sql.concat("P.NOMBRES, ");
        sql = sql.concat("P.APELLIDOS, ");
        sql = sql.concat("P.DIRECCION ");
        sql = sql.concat("FROM VEHICULO V ");
        sql = sql.concat("JOIN VEHICULO_PROPIETARIO VP ON VP.ID_VEHICULO = V.ID ");
        sql = sql.concat("JOIN PROPIETARIO P ON P.ID = VP.ID_PROPIETARIO ");
        sql = sql.concat("WHERE (P.DNI LIKE ? OR P.NOMBRES LIKE ? OR P.APELLIDOS LIKE ?); ");
        return sql;
    }
    
    private void incluirValorDeParametrosParaListarPorPropietario(Object objetoParametros) {
        String cadena = (String) objetoParametros;
        cadena = cadena.trim();
        cadena = "%".concat(cadena).concat("%");
        try {
            this.statement.setString(1, cadena);
            this.statement.setString(2, cadena);
            this.statement.setString(3, cadena);
        } catch (SQLException ex) {
            Logger.getLogger(VehiculoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
