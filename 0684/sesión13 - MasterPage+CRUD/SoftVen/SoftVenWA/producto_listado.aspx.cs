using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using SoftVen.Model;
using SoftVenBusiness;

namespace SoftVenWA
{
    public partial class producto_listado : System.Web.UI.Page
    {
        private ProductoBO productoBO;
        private BindingList<ProductosDTO> listaProductos;

        public producto_listado()
        {
            this.ProductoBO = new ProductoBO();
            this.ListaProductos = this.ProductoBO.ListarTodos();
        }

        public ProductoBO ProductoBO { get => productoBO; set => productoBO = value; }
        public BindingList<ProductosDTO> ListaProductos { get => listaProductos; set => listaProductos = value; }

        protected void Page_Load(object sender, EventArgs e)
        {
            dgvProducto.DataSource = ListaProductos;
            dgvProducto.DataBind();
        }

        protected void lbEliminar_Click(object sender, EventArgs e)
        {
            int productoId = Int32.Parse(((LinkButton)sender).CommandArgument);
            this.ProductoBO.Eliminar(productoId);
            Response.Redirect("producto_listado.aspx");
        }

        protected void lbModificar_Click(object sender, EventArgs e)
        {
            int productoId = Int32.Parse(((LinkButton)sender).CommandArgument);
            Session["productoId"] = productoId;
            Response.Redirect("producto_gestion.aspx?accion=modificar");
        }

        protected void btnInsertar_Click(object sender, EventArgs e)
        {
            Response.Redirect("producto_gestion.aspx");
        }
    }
}