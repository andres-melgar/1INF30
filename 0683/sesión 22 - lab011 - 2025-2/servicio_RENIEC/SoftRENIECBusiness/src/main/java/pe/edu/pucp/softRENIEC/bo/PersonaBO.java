package pe.edu.pucp.softRENIEC.bo;

import pe.edu.pucp.softRENIEC.dao.PersonaDAO;
import pe.edu.pucp.softRENIEC.daoImp.PersonaDAOImpl;
import pe.edu.pucp.softRENIEC.model.PersonasDTO;

public class PersonaBO {

    private PersonaDAO personaDAO;
    private static final String DNI_NO_ENCOTRADO = "00000000";
    private static final String PERSONAS_NO_ENCOTRADO = "NO ENCONTRADO";

    public PersonaBO() {
        this.personaDAO = new PersonaDAOImpl();
    }

    public PersonasDTO obtenerPorId(String DNI) {
        PersonasDTO personaDTO = this.personaDAO.obtenerPorId(DNI);
        if (personaDTO == null){
            personaDTO = new PersonasDTO();
            personaDTO.setDNI(DNI_NO_ENCOTRADO);
            personaDTO.setPaterno(PERSONAS_NO_ENCOTRADO);
            personaDTO.setMaterno(PERSONAS_NO_ENCOTRADO);
            personaDTO.setNombres(PERSONAS_NO_ENCOTRADO);
        }
        return personaDTO;
    }

}
