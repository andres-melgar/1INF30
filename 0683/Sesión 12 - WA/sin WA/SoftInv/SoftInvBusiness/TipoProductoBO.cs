using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using SoftInv.Model;
using SoftInv.DAO;
using SoftInv.DAOImpl;

namespace SoftInv.BO
{
    public class TipoProductoBO
    {
        private TipoProductoDAO tipoProductoDAO;

        public TipoProductoBO()
        {
            this.tipoProductoDAO = new TipoProductoDAOImpl();
        }

        public IList<TiposProductosDTO> ConsultarTiposDeProductos(string nombre)
        {
            return this.tipoProductoDAO.ConsultarTiposDeProductos(nombre);
        }

        public TiposProductosDTO ObtenerPorId(int tipoProductoId)
        {
            return this.tipoProductoDAO.ObtenerPorId(tipoProductoId);
        }
    }
}
