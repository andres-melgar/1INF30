using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Web;
using SoftInvBusiness.almacenesWS;

namespace SoftInv.BO
{
    public class AlmacenBO
    {
        private AlmacenesClient almacenesClienteSOAP;

        public AlmacenBO()
        {
            this.almacenesClienteSOAP = new AlmacenesClient();
        }

        public int Insertar(string nombre, bool almacenCentral)
        {
            return this.almacenesClienteSOAP.insertar(nombre, almacenCentral);
        }

        public int Eliminar(int almacenId)
        {
            return this.almacenesClienteSOAP.eliminar(almacenId);
        }

        public int Modificar(int almacenId, string nombre, bool almacenCentral)
        {
            return this.almacenesClienteSOAP.modificar(almacenId, nombre, almacenCentral);
        }

        public almacenesDTO ObtenerPorId(int almacenId)
        {
            return this.almacenesClienteSOAP.obtenerPorId(almacenId);
        }

        public BindingList<almacenesDTO> ListarTodos()
        {
            almacenesDTO[] arreglo = this.almacenesClienteSOAP.listarTodos();
            return new BindingList<almacenesDTO>(arreglo);
        }

        public byte[] reporteProductos()
        {
            return this.almacenesClienteSOAP.reporteProductos();
        }

        public byte[] reporteTipoDeProductos(int pTipoProductoId)
        {
            return this.almacenesClienteSOAP.reporteTipoDeProductos(pTipoProductoId);
        }

        public void abrirReporte(HttpResponse response, string nombreReporte, byte[] reporte)
        {
            response.Clear();
            response.ContentType = "application/pdf";
            response.AddHeader("Content-Disposition", "inline;filename=" + nombreReporte + ".pdf");
            response.BinaryWrite(reporte);
            response.End();
        }
    }
}
