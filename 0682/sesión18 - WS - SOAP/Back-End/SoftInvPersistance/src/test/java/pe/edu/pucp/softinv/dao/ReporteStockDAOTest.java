package pe.edu.pucp.softinv.dao;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import pe.edu.pucp.softinv.daoImp.ReporteStockDAOImpl;
import pe.edu.pucp.softinv.model.ReportesStocksDTO;

public class ReporteStockDAOTest {
    
    private ReporteStockDAO reporteStockDAO;
    
    public ReporteStockDAOTest() {
        this.reporteStockDAO = new ReporteStockDAOImpl();
    }

    @Test
    public void testListarPorPeriodo() {
        System.out.println("listarPorPeriodo");
        this.reporteStockDAO.insertarDatosDePrueba();
        this.reporteStockDAO.generarReporteStock(2025, 1);
        this.reporteStockDAO.generarReporteStock(2025, 2);
        this.reporteStockDAO.generarReporteStock(2025, 3);
        ArrayList<ReportesStocksDTO> listado = this.reporteStockDAO.listarPorPeriodo(2025, null, null, null);
        assertNotNull(listado);
        this.reporteStockDAO.eliminarDatosDePrueba();
    }
    
}
