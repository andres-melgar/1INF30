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
    public class VendedorBO
    {
        private VendedorDAO vendedorDAO;

        public VendedorBO()
        {
            this.vendedorDAO = new VendedorDAOImpl();
        }

        public BindingList<VendedoresDTO> ConsultarVendedores(int tiendaId, string nombres)
        {
            return this.vendedorDAO.ConsultarVendedores(tiendaId, nombres);
        }
    }
}
