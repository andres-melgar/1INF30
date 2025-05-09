using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using SoftVen.DAO;
using SoftVen.DAOImpl;
using SoftVen.Model;

namespace SoftVen.BO
{
    public class TiendaBO
    {
        private TiendaDAO tiendaDAO;

        public TiendaBO()
        {
            this.tiendaDAO = new TiendaDAOImpl();
        }

        public BindingList<TiendasDTO> ListarTodos()
        {
            BindingList <TiendasDTO> listaTiendas = this.tiendaDAO.ListarTodos();
            TiendasDTO tienda = new TiendasDTO();
            tienda.TiendaId = 0;
            tienda.Nombre = "Todas las tiendas";
            listaTiendas.Insert(0, tienda);
            return listaTiendas;
        }

    }
}
