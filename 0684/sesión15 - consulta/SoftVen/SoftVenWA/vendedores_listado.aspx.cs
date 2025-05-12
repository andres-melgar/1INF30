using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using SoftVen.BO;
using SoftVen.Model;

namespace SoftVenWA
{
    public partial class vendedores_listado : System.Web.UI.Page
    {
        private TiendaBO tiendaBO;
        private BindingList<TiendasDTO> listaTiendas;

        public TiendaBO TiendaBO { get => tiendaBO; set => tiendaBO = value; }
        public BindingList<TiendasDTO> ListaTiendas { get => listaTiendas; set => listaTiendas = value; }

        public vendedores_listado()
        {
            this.TiendaBO = new TiendaBO();
            this.ListaTiendas = null;
        }

        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void Page_Init(object sender, EventArgs e)
        {
            this.CargarTiendas();
        }

        private void CargarTiendas()
        {
            this.ListaTiendas = this.TiendaBO.ListarTodos();
            ddlTienda.DataSource = this.ListaTiendas;
            ddlTienda.DataValueField = "TiendaID";
            ddlTienda.DataTextField = "Nombre";
            ddlTienda.DataBind();
        }

        protected void btnRegresar_Click(object sender, EventArgs e)
        {
            Response.Redirect("index.aspx");
        }

        protected void btnConsultarVendedores_Click(object sender, EventArgs e)
        {

        }
    }
}