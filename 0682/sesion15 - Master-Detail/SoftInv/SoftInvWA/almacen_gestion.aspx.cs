using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using SoftInv.BO;

namespace SoftInvWA
{
    public partial class almacen_gestion : System.Web.UI.Page
    {
        private AlmacenBO almacenBO;

        public almacen_gestion()
        {
            this.almacenBO = new AlmacenBO();
        }

        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void btnRegresar_Click(object sender, EventArgs e)
        {
            Response.Redirect("almacen_listado.aspx");
        }

        protected void btnGuardar_Click(object sender, EventArgs e)
        {
            string nombre = txtNombre.Text;
            bool almacenCentral = cbCentral.Checked;
            this.almacenBO.Insertar(nombre, almacenCentral);
            //this.almacenBO.Insertar(txtNombre.Text, cbCentral.Checked);
            Response.Redirect("almacen_listado.aspx");
        }
    }
}