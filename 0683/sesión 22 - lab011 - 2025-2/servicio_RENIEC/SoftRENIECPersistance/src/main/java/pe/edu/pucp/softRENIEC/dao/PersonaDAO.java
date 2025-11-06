package pe.edu.pucp.softRENIEC.dao;

import pe.edu.pucp.softRENIEC.model.PersonasDTO;

public interface PersonaDAO {
    
    public PersonasDTO obtenerPorId(String DNI);
        
}
