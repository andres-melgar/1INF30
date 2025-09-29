using SoftInv.Model;
using SoftInvBusiness;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SoftInvWA
{
    public partial class almacen_listado : System.Web.UI.Page
    {
        private AlmacenBO almacenBO;
        private IList<AlmacenesDTO> listaAlmacenes;

        public almacen_listado()
        {
            this.AlmacenBO = new AlmacenBO();
        }

        public AlmacenBO AlmacenBO { get => almacenBO; set => almacenBO = value; }
        public IList<AlmacenesDTO> ListaAlmacenes { get => listaAlmacenes; set => listaAlmacenes = value; }

        protected void Page_Load(object sender, EventArgs e)
        {

        }
    }
}