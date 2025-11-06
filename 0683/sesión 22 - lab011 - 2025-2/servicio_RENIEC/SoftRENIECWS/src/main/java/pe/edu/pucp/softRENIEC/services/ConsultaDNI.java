package pe.edu.pucp.softRENIEC.services;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import pe.edu.pucp.softRENIEC.bo.PersonaBO;
import pe.edu.pucp.softRENIEC.model.PersonasDTO;

@WebService(serviceName = "ConsultaDNI")
public class ConsultaDNI {

    private PersonaBO personaBO;
    
    public ConsultaDNI(){
        this.personaBO = new PersonaBO();
    }
    
    @WebMethod(operationName = "consulta")
    public PersonasDTO consulta(@WebParam(name = "DNI") String DNI) {
        return this.personaBO.obtenerPorId(DNI);
    }
}
