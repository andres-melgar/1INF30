using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
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
    }
}
