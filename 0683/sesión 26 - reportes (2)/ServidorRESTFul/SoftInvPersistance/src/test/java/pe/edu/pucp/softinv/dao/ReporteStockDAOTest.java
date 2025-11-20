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
        System.out.println("testListarPorPeriodo");
        reporteStockDAO.insertarDatosParaPrueba();
        reporteStockDAO.generarReporteStock(2025, 1);
        reporteStockDAO.generarReporteStock(2025, 2);
        reporteStockDAO.generarReporteStock(2025, 3);

        ArrayList<ReportesStocksDTO> listado = reporteStockDAO.listarPorPeriodo(2025, 1, null, null);
        assertNotNull(listado);
        this.imprimirListado(listado);

        reporteStockDAO.eliminarDatosParaPrueba();
    }

    private void imprimirListado(ArrayList<ReportesStocksDTO> listado) {
        for (ReportesStocksDTO reporte : listado) {
            System.out.println(reporte);
        }
    }

}
