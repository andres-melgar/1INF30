using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SoftVen.Model
{
    public class ProductosDTO
    {
        private int? productoId;
        private string nombre;
        private string descripcion;
        private double? precio;

        public ProductosDTO()
        {
            this.ProductoId = null;
            this.Nombre = null;
            this.Descripcion = null;
            this.Precio = null;
        }

        public ProductosDTO(int productoId, string nombre, string descripcion, double precio)
        {
            this.ProductoId = productoId;
            this.Nombre = nombre;
            this.Descripcion = descripcion;
            this.Precio = precio;
        }

        public int? ProductoId { get => productoId; set => productoId = value; }
        public string Nombre { get => nombre; set => nombre = value; }
        public string Descripcion { get => descripcion; set => descripcion = value; }
        public double? Precio { get => precio; set => precio = value; }
    }
}
