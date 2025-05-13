using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SoftInv.Model
{
    public class TiposMovimientosDTO
    {
        private int? tipoMovimientoId;
        private string nombre;
        private string descripcion;
        private TipoOperacion? tipoOperacion;

        public TiposMovimientosDTO()
        {
            this.TipoMovimientoId = null;
            this.Nombre = null;
            this.Descripcion = null;
            this.Operacion = null;
        }

        public TiposMovimientosDTO(int tipoMovimientoId, string nombre, string descripcion, TipoOperacion tipoOperacion)
        {
            this.TipoMovimientoId = tipoMovimientoId;
            this.Nombre = nombre;
            this.Descripcion = descripcion;
            this.Operacion = tipoOperacion;
        }

        public int? TipoMovimientoId { get => tipoMovimientoId; set => tipoMovimientoId = value; }
        public string Nombre { get => nombre; set => nombre = value; }
        public string Descripcion { get => descripcion; set => descripcion = value; }
        public TipoOperacion? Operacion { get => tipoOperacion; set => tipoOperacion = value; }
    }
}
