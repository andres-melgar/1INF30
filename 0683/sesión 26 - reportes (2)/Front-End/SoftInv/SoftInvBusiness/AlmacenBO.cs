using SoftInvBusiness.SoftInvWSAlmacenes;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Web;

namespace SoftInvBusiness
{    

    public class AlmacenBO
    {
        private AlmacenesClient clienteSOAP;

        public AlmacenBO()
        {
            this.clienteSOAP = new AlmacenesClient();
        }

        public int Insertar(string nombre, bool almacenCentral)
        {
            return this.clienteSOAP.insertar_almacen(nombre, almacenCentral);
        }

        public int Eliminar(int almacenId)
        {            
            return this.clienteSOAP.eliminar(almacenId);
        }

        public int Modificar(int almacenId, string nombre, bool almacenCentral)
        {            
            return this.clienteSOAP.modificar(almacenId, nombre, almacenCentral);
        }

        public almacenesDTO ObtenerPorId(int almacenId)
        {
            return this.clienteSOAP.obtenerPorId(almacenId);
        }

        public IList<almacenesDTO> ListarTodos()
        {
            return this.clienteSOAP.listarTodos();
        }

        public byte[] ReporteAlmacenes()
        {
            return this.clienteSOAP.reporteAlmacenes();
        }

        public byte[] ReporteTipoProducto(int tipoProductoId)
        {
            return this.clienteSOAP.reporteTipoProducto(tipoProductoId);
        }

        public void abrirReporte(HttpResponse response, string nombreReporte, byte[] reporte)
        {
            response.Clear();
            response.ContentType = "application/pdf";
            response.AddHeader("Content-Disposition", "inline; filename=" + nombreReporte + ".pdf");
            response.BinaryWrite(reporte);
            response.End();
        }
    }
}
