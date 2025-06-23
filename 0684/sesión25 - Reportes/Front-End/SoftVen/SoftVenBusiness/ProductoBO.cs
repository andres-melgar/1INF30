using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Web;
using SoftVenBusiness.productoWS;

namespace SoftVen.BO
{
    public class ProductoBO
    {
        private ProductosClient productosClienteSOAP;

        public ProductoBO()
        {
            this.productosClienteSOAP = new ProductosClient();
        }

        public int Insertar(string nombre, string descripcion, double precio)
        {
            return this.productosClienteSOAP.insertar(nombre, descripcion, precio);
        }

        public int Modificar(int productoId, string nombre, string descripcion, double precio)
        {
            return this.productosClienteSOAP.modificar(productoId, nombre, descripcion, precio);
        }

        public int Eliminar(int productoId)
        {
            return this.productosClienteSOAP.eliminar(productoId);
        }

        public productosDTO ObtenerPorId(int productoId)
        {
            return this.productosClienteSOAP.obtenerPorId(productoId);
        }

        public BindingList<productosDTO> ListarTodos()
        {
            productosDTO[] arreglo = this.productosClienteSOAP.listarTodos();
            return new BindingList<productosDTO>(arreglo);
        }

        public byte[] reporteVendedores()
        {
            return this.productosClienteSOAP.reporteVendedores();
        }

        public byte[] reporteTiendas(int pTiendaId)
        {
            return this.productosClienteSOAP.reporteTiendas(pTiendaId);
        }

        public void abrirReporte(HttpResponse response, string nombreDeReporte, byte[] reporte)
        {
            response.Clear();
            response.ContentType = "application/pdf";
            response.AddHeader("Content-Disposition", "inline;filename=" + nombreDeReporte + ".pdf");
            response.BinaryWrite(reporte);
            response.End();
        }
    }
}
