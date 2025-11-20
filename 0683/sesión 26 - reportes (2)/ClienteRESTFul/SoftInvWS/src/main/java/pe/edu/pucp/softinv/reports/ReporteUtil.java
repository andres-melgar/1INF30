package pe.edu.pucp.softinv.reports;

import java.sql.Connection;
import java.util.HashMap;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import pe.edu.pucp.softinv.db.DBManager;

public class ReporteUtil {

    private static byte[] invocarReporte(String nombreReporte) {
        HashMap parametros = null;
        return invocarReporte(nombreReporte, parametros);
    }

    private static byte[] invocarReporte(String nombreReporte, HashMap parametros) {
        byte[] reporte = null;
        Connection conexion = DBManager.getInstance().getConnection();
        String nmReporte = "/" + nombreReporte + ".jasper";
        try {
            JasperReport jr = (JasperReport) JRLoader.loadObject(ReporteUtil.class.getResource(nmReporte));
            JasperPrint jp = JasperFillManager.fillReport(jr, parametros, conexion);    
            reporte = JasperExportManager.exportReportToPdf(jp);
        } catch (JRException ex) {
            System.getLogger(ReporteUtil.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }        
        return reporte;
    }
    
    public static byte[] reporteAlmacenes() {
        return invocarReporte("reporte_almacenes");
    }

    public static byte[] reporteTipoProducto(Integer tipoProductoId) {
        HashMap parametros = new HashMap();
        parametros.put("pTipoProductoId", tipoProductoId);
        return invocarReporte("reporte_por_tipo_producto", parametros);
    }
        
    
}
