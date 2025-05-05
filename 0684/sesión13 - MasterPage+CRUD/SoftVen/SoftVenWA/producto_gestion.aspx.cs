using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using SoftVen.Model;
using SoftVenBusiness;

namespace SoftVenWA
{
    public partial class producto_gestion : System.Web.UI.Page
    {
        private ProductoBO productoBO;
        private int? productoId;
        private string accion;
        private bool estaModificando;

        public ProductoBO ProductoBO { get => productoBO; set => productoBO = value; }
        public int? ProductoId { get => productoId; set => productoId = value; }
        public string Accion { get => accion; set => accion = value; }
        public bool EstaModificando { get => estaModificando; set => estaModificando = value; }

        public producto_gestion()
        {
            this.ProductoBO = new ProductoBO();
            this.ProductoId = null;
            this.Accion = null;
            this.EstaModificando = false;
        }

        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void Page_Init(object sender, EventArgs e)
        {
            this.productoId = (int?)Session["productoId"];
            this.Accion = Request.QueryString["accion"];
            if (this.Accion != null && this.Accion == "modificar")
                this.EstaModificando = true;
            else
                this.EstaModificando = false;
            if (this.EstaModificando)
                this.CargarEntidad();
        }

        private void CargarEntidad()
        {
            ProductosDTO producto = this.ProductoBO.ObtenerPorId((int)this.ProductoId);
            txtCodigo.Text = producto.ProductoId.ToString();
            txtNombre.Text = producto.Nombre;
            txtDescripcion.Text = producto.Descripcion;
            txtPrecio.Text = producto.Precio.ToString();
        }

        protected void btnRegresar_Click(object sender, EventArgs e)
        {
            Response.Redirect("producto_listado.aspx");
        }

        protected void btnGuardar_Click(object sender, EventArgs e)
        {
            string nombre = txtNombre.Text;
            string descripcion = txtDescripcion.Text;
            double precio = double.Parse(txtPrecio.Text);
            this.ProductoBO.Insertar(nombre, descripcion, precio);
            Response.Redirect("producto_listado.aspx");
        }
    }
}