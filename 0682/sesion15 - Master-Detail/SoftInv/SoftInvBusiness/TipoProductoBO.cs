using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using SoftInv.Model;

namespace SoftInv.BO
{
    public class TipoProductoBO
    {
        private TipoProductoDAO tipoProductoDAO;

        public TipoProductoBO()
        {
            this.tipoProductoDAO = new TipoProductoDAOImpl();
        }    

        public BindingList<TiposProductosDTO> ConsultarTiposDeProductos(string nombre)
        {
            return this.tipoProductoDAO.ConsultarTiposDeProductos(nombre);
        }
    }
}
