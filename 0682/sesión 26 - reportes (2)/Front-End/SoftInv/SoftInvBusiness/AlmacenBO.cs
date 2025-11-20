using SoftInvBusiness.clienteSOAP;
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
            return this.clienteSOAP.inserta_almacen(nombre, almacenCentral);
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

        public byte[] ReporteProducto()
        {
            return this.clienteSOAP.reporteProducto();
        }

        public byte[] ReporteTipoProducto(int tipoProductoId)
        {
            return this.clienteSOAP.reporteTipoProducto(tipoProductoId);
        }

        public void AbrirReporte(HttpResponse response, string nombreReporte, byte[] reporte)
        {
            response.Clear();
            response.ContentType = "application/pdf";
            response.AddHeader("Content-Disposition", "inline; filename=" + nombreReporte);
            response.BinaryWrite(reporte);
            response.End();
        }
    }
}
