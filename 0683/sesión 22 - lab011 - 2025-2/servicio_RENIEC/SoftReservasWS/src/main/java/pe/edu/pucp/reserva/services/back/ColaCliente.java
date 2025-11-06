package pe.edu.pucp.reserva.services.back;

import java.util.ArrayList;
import java.util.HashMap;

public class ColaCliente {

    private static final String DNI_NO_ENCONTRADO = "00000000";
    private static Integer secuencia = 0;
    private static ArrayList<ClienteDTO> cola = new ArrayList();
    private static HashMap<String, Integer> map = new HashMap<String, Integer>();
    
    public static Boolean pide_vez(String DNI, String paterno, String materno, String nombres){
        Boolean existe = map.containsKey(DNI);
        if (existe)
            return false;
        ColaCliente.secuencia++;
        ClienteDTO cliente = new ClienteDTO(ColaCliente.secuencia, DNI, paterno, materno, nombres);
        ColaCliente.cola.add(cliente);
        ColaCliente.map.put(DNI, ColaCliente.secuencia);
        return true;
    }
    
    public static ClienteDTO avanzar(){
        if (ColaCliente.cola.isEmpty()){
            ClienteDTO cliente = new ClienteDTO();
            cliente.setDNI(DNI_NO_ENCONTRADO);
            return cliente;
        }
        ClienteDTO cliente = ColaCliente.cola.remove(0);
        ColaCliente.map.remove(cliente.getDNI());
        return cliente;
    }
}
