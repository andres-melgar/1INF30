using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SoftVen.DAOImpl.Util
{
    public class VendedorParametro
    {
        int? tiendaId;
        string nombres;

        public VendedorParametro()
        {
            this.TiendaId = null;
            this.Nombres = null;
        }

        public VendedorParametro(int? tiendaId, string nombres)
        {
            this.TiendaId = tiendaId;
            this.Nombres = nombres;
        }

        public int? TiendaId { get => tiendaId; set => tiendaId = value; }
        public string Nombres { get => "%"+nombres+"%"; set => nombres = value; }
    }
}
