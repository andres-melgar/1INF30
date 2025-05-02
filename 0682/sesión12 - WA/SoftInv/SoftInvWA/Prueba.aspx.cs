using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using SoftInv.Model;
using SoftInvBusiness;

namespace SoftInvWA
{
    public partial class Prueba : System.Web.UI.Page
    {
        private AlmacenBO almacenBO;
        private BindingList<AlmacenesDTO> listaAlmacenes;

        public Prueba()
        {
            this.AlmacenBO = new AlmacenBO();
            this.ListaAlmacenes = this.AlmacenBO.ListarTodos();
        }

        public AlmacenBO AlmacenBO { get => almacenBO; set => almacenBO = value; }
        public BindingList<AlmacenesDTO> ListaAlmacenes { get => listaAlmacenes; set => listaAlmacenes = value; }

        protected void Page_Load(object sender, EventArgs e)
        {

        }
    }
}