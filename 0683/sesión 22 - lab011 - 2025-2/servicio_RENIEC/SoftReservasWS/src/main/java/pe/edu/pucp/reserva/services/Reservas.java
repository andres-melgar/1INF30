package pe.edu.pucp.reserva.services;

import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import pe.edu.pucp.reserva.services.back.ClienteDTO;
import pe.edu.pucp.reserva.services.back.ColaCliente;

@WebService(serviceName = "Reservas")
public class Reservas {

    @WebMethod(operationName = "pide_vez")
    public Boolean pide_vez(@WebParam(name = "DNI") String DNI, @WebParam(name = "paterno")String paterno, @WebParam(name = "materno")String materno, @WebParam(name = "nombre")String nombre) {
        return ColaCliente.pide_vez(DNI, paterno, materno, nombre);
    }
    
    @WebMethod(operationName = "avanzar")
    public ClienteDTO avanzar() {
        return ColaCliente.avanzar();
    }
}
