using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SoftInv.Model
{
    public class TiposProductosDTO
    {
        private int? tipoProductoId;
        private string nombre;
        private string descripcion;

        public TiposProductosDTO()
        {
            this.TipoProductoId = null;
            this.Nombre = null;
            this.Descripcion = null;
        }

        public TiposProductosDTO(int tipoProductoId, string nombre, string descripcion)
        {
            this.TipoProductoId = tipoProductoId;
            this.Nombre = nombre;
            this.Descripcion = descripcion;
        }

        public int? TipoProductoId { get => tipoProductoId; set => tipoProductoId = value; }
        public string Nombre { get => nombre; set => nombre = value; }
        public string Descripcion { get => descripcion; set => descripcion = value; }
    }
}
