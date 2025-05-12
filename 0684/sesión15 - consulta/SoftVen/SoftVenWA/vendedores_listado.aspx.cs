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
        private VendedorBO vendedorBO;
        private BindingList<TiendasDTO> listaTiendas;
        private BindingList<VendedoresDTO> listaVendedores;

        public TiendaBO TiendaBO { get => tiendaBO; set => tiendaBO = value; }
        public BindingList<TiendasDTO> ListaTiendas { get => listaTiendas; set => listaTiendas = value; }
        public VendedorBO VendedorBO { get => vendedorBO; set => vendedorBO = value; }
        public BindingList<VendedoresDTO> ListaVendedores { get => listaVendedores; set => listaVendedores = value; }

        public vendedores_listado()
        {
            this.TiendaBO = new TiendaBO();
            this.VendedorBO = new VendedorBO();
            this.ListaTiendas = null;
            this.ListaVendedores = null;
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
            int tiendaId = Int32.Parse(ddlTienda.SelectedValue);
            string nombre = txtNombre.Text;
            this.ListaVendedores = this.VendedorBO.ConsultarVendedores(tiendaId, nombre);
            gvVendedores.DataSource = this.ListaVendedores;
            gvVendedores.DataBind();
        }
    }
}