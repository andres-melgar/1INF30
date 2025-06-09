package pe.edu.pucp.softven.dao;

import java.util.ArrayList;
import pe.edu.pucp.softven.model.ReportesVendedoresDTO;

 
public interface ReporteVendedorDAO {

    public ArrayList<ReportesVendedoresDTO> listarPorPeriodo(Integer año, Integer mes, Integer tiendaId);
    
    public void insertarDatosParaPrueba();
    
    public void eliminarDatosParaPrueba();
    
    public void generarReporteVendedores(Integer año, Integer mes);
}
