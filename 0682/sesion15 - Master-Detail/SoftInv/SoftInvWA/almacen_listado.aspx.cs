using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using SoftInv.BO;
using SoftInv.Model;

namespace SoftInvWA
{
    public partial class almacen_listado : System.Web.UI.Page
    {
        private AlmacenBO almacenBO;
        private BindingList<AlmacenesDTO> listaAlmacenes;

        public almacen_listado() 
        { 
            this.AlmacenBO = new AlmacenBO();
            this.ListaAlmacenes = this.AlmacenBO.ListarTodos();
        }

        public AlmacenBO AlmacenBO { get => almacenBO; set => almacenBO = value; }
        public BindingList<AlmacenesDTO> ListaAlmacenes { get => listaAlmacenes; set => listaAlmacenes = value; }

        protected void Page_Load(object sender, EventArgs e)
        {
            dgvAlmacen.DataSource = this.ListaAlmacenes;
            dgvAlmacen.DataBind();
        }

        protected void lbEliminar_Click(object sender, EventArgs e)
        {
            int almacenID = Int32.Parse(((LinkButton)sender).CommandArgument);
            this.AlmacenBO.Eliminar(almacenID);
            Response.Redirect("almacen_listado.aspx");
        }

        protected void btnInsertar_Click(object sender, EventArgs e)
        {
            Response.Redirect("almacen_gestion.aspx");
        }

        protected void lbModificar_Click(object sender, EventArgs e)
        {
            int almacenId = Int32.Parse(((LinkButton)sender).CommandArgument);
            Session["almacenId"] = almacenId;            
            Response.Redirect("almacen_gestion.aspx?accion=modificar");
        }

        protected void btnRegresar_Click(object sender, EventArgs e)
        {
            Response.Redirect("index.aspx");
        }
    }
}