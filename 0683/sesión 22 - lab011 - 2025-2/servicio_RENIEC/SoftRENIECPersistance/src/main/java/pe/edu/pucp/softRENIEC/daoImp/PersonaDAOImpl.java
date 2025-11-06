package pe.edu.pucp.softRENIEC.daoImp;

import java.sql.SQLException;
import java.util.List;
import pe.edu.pucp.softRENIEC.dao.PersonaDAO;
import pe.edu.pucp.softRENIEC.daoImp.util.Columna;
import pe.edu.pucp.softRENIEC.model.PersonasDTO;

public class PersonaDAOImpl extends DAOImplBase implements PersonaDAO {
    
    private PersonasDTO personaDTO;
    
    public PersonaDAOImpl() {
        super("REG_PERSONAS");
        this.personaDTO = null;
    }
    
    @Override
    protected void configurarListaDeColumnas() {
        this.listaColumnas.add(new Columna("DNI", true, false));
        this.listaColumnas.add(new Columna("MATERNO", false, false));
        this.listaColumnas.add(new Columna("PATERNO", false, false));
        this.listaColumnas.add(new Columna("NOMBRES", false, false));
    }
        
    @Override
    protected void incluirValorDeParametrosParaObtenerPorId() throws SQLException {
        this.statement.setString(1, this.personaDTO.getDNI());
    }
    
    @Override
    protected void instanciarObjetoDelResultSet() throws SQLException {
        this.personaDTO = new PersonasDTO();
        this.personaDTO.setDNI(this.resultSet.getString("DNI"));
        this.personaDTO.setPaterno(this.resultSet.getString("PATERNO"));
        this.personaDTO.setMaterno(this.resultSet.getString("MATERNO"));
        this.personaDTO.setNombres(this.resultSet.getString("NOMBRES"));
    }
    
    @Override
    protected void limpiarObjetoDelResultSet() {
        this.personaDTO = null;
    }
    
    @Override
    protected void agregarObjetoALaLista(List lista) throws SQLException{
        this.instanciarObjetoDelResultSet();
        lista.add(this.personaDTO);
    }        

    @Override
    public PersonasDTO obtenerPorId(String DNI) {
        this.personaDTO = new PersonasDTO();
        this.personaDTO.setDNI(DNI);
        super.obtenerPorId();
        return this.personaDTO;
    }
        
}
