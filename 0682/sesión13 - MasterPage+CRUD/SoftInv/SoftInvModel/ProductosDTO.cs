using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SoftInv.Model
{
    public class ProductosDTO
    {
        private int? productoId;
        private TiposProductosDTO tipoProducto;
        private string nombre;
        private string marca;
        private string modelo;

        public ProductosDTO()
        {
            this.ProductoId = null;
            this.TipoProducto = null;
            this.Nombre = null;
            this.Marca = null;
            this.Modelo = null;
        }

        public ProductosDTO(int productoId, TiposProductosDTO tipoProducto, string nombre, string marca, string modelo)
        {
            this.ProductoId = productoId;
            this.TipoProducto = tipoProducto;
            this.Nombre = nombre;
            this.Marca = marca;
            this.Modelo = modelo;
        }

        public int? ProductoId { get => productoId; set => productoId = value; }
        public TiposProductosDTO TipoProducto { get => tipoProducto; set => tipoProducto = value; }
        public string Nombre { get => nombre; set => nombre = value; }
        public string Marca { get => marca; set => marca = value; }
        public string Modelo { get => modelo; set => modelo = value; }
    }
}
