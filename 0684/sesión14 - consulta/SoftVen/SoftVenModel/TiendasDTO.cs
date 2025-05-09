using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SoftVen.Model
{
    public class TiendasDTO
    {
        private int? tiendaId;
        private string nombre;
        private string direccion;
        private bool? tiendaPrincipal;
        private double? comision;

        public TiendasDTO()
        {
            this.TiendaId = null;
            this.Nombre = null;
            this.Direccion = null;
            this.TiendaPrincipal = null;
            this.Comision = null;
        }

        public TiendasDTO(int tiendaId, string nombre, string direccion, bool tiendaPrincipal, double comision)
        {
            this.TiendaId = tiendaId;
            this.Nombre = nombre;
            this.Direccion = direccion;
            this.TiendaPrincipal = tiendaPrincipal;
            this.Comision = comision;
        }

        public int? TiendaId { get => tiendaId; set => tiendaId = value; }
        public string Nombre { get => nombre; set => nombre = value; }
        public string Direccion { get => direccion; set => direccion = value; }
        public bool? TiendaPrincipal { get => tiendaPrincipal; set => tiendaPrincipal = value; }
        public double? Comision { get => comision; set => comision = value; }
    }
}
