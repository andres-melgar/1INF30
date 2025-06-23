package pe.edu.pucp.softven.reports;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import pe.edu.pucp.softven.db.DBManager;

public class ReporteUtil {

    //método genérico para invocar a cualquier reporte
    public static byte[] invocarReporte(String nombreReporte, HashMap parametros) {
        byte[] reporte = null;
        Connection conexion = DBManager.getInstance().getConnection();
        try {
            String nmReporte = "/" + nombreReporte + ".jasper";
            JasperReport jr = (JasperReport) JRLoader.loadObject(ReporteUtil.class.getResource(nmReporte));
            JasperPrint jp = JasperFillManager.fillReport(jr, parametros, conexion);
            reporte = JasperExportManager.exportReportToPdf(jp);
        } catch (JRException ex) {
            Logger.getLogger(ReporteUtil.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            try {
                conexion.close();
            } catch (SQLException ex) {
                Logger.getLogger(ReporteUtil.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return reporte;
    }

    //método para el reporte de vendedores
    public static byte[] reporteVendedores() {
        return invocarReporte("ReporteVendedores", null);
    }

    //método para el reporte de tiendas
    public static byte[] reporteTiendas(Integer pTiendaId) {
        HashMap parametros = new HashMap();
        //Si no saben que es HashMap ->revisar progra2, clase STL, clase Map
        parametros.put("pTiendaId", pTiendaId);
        return invocarReporte("ReporteTiendas", parametros);
    }
}
