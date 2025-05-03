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
    public partial class Prueba : System.Web.UI.Page
    {
        private ProductoBO productoBO;
        BindingList<ProductosDTO> listaProductos;

        public Prueba()
        {
            this.ProductoBO = new ProductoBO();
            this.ListaProductos = this.ProductoBO.ListarTodos();    
        }

        public ProductoBO ProductoBO { get => productoBO; set => productoBO = value; }
        public BindingList<ProductosDTO> ListaProductos { get => listaProductos; set => listaProductos = value; }

        protected void Page_Load(object sender, EventArgs e)
        {

        }
    }
}