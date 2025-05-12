using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SoftVen.Model
{
    public class VendedoresDTO
    {
        private int? vendedorId;
        private string nombre;
        private string paterno;
        private string materno;
        private TiendasDTO tienda;

        public VendedoresDTO()
        {
            this.VendedorId = null;
            this.Nombre = null;
            this.Paterno = null;
            this.Materno = null;
            this.Tienda = null;
        }

        public VendedoresDTO(int vendedorId, string nombre, string paterno, string materno, TiendasDTO tienda)
        {
            this.VendedorId = vendedorId;
            this.Nombre = nombre;
            this.Paterno = paterno;
            this.Materno = materno;
            this.Tienda = tienda;
        }

        public int? VendedorId { get => vendedorId; set => vendedorId = value; }
        public string Nombre { get => nombre; set => nombre = value; }
        public string Paterno { get => paterno; set => paterno = value; }
        public string Materno { get => materno; set => materno = value; }
        public TiendasDTO Tienda { get => tienda; set => tienda = value; }
    }
}
