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
            this.ListaAlmacenes = this.AlmacenBO.ListarTodos();
        }

        public AlmacenBO AlmacenBO { get => almacenBO; set => almacenBO = value; }
        public IList<AlmacenesDTO> ListaAlmacenes { get => listaAlmacenes; set => listaAlmacenes = value; }

        protected void Page_Load(object sender, EventArgs e)
        {
            dgvAlmacen.DataSource = this.ListaAlmacenes;
            dgvAlmacen.DataBind();
        }

        protected void lbEliminar_Click(object sender, EventArgs e)
        {            
            int almacenId = Int32.Parse((sender as LinkButton).CommandArgument);
            this.AlmacenBO.Eliminar(almacenId);
            Response.Redirect("almacen_listado.aspx");
        }

        protected void btnInsertar_Click(object sender, EventArgs e)
        {
            Response.Redirect("almacen_gestion.aspx");
        }

        protected void lblModificar_Click(object sender, EventArgs e)
        {
            int almacenId = Int32.Parse((sender as LinkButton).CommandArgument);
            Session["almacenId"] = almacenId;
            Response.Redirect("almacen_gestion.aspx?accion=modificar");
        }
    }
}