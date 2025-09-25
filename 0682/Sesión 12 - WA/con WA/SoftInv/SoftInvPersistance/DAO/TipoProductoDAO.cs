using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using SoftInv.Model;

namespace SoftInv.DAO
{
    public interface TipoProductoDAO
    {
        IList<TiposProductosDTO> ConsultarTiposDeProductos(string nombre);

        TiposProductosDTO ObtenerPorId(int tipoProductoId);
    }
}
