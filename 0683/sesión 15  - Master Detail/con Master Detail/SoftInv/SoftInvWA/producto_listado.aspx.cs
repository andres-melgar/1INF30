using SoftInv.BO;
using SoftInv.Model;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SoftInvWA
{
    public partial class producto_listado : System.Web.UI.Page
    {
        private TipoProductoBO tipoProductoBO;
        private IList<TiposProductosDTO> listaTipoProducto;
        
        public producto_listado()
        {
            this.tipoProductoBO = new TipoProductoBO();
            this.listaTipoProducto = null;
        }

        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void btnBuscarTipoProducto_Click(object sender, EventArgs e)
        {
            string script = "window.onload = function() { showModalFormTipoProducto() }; ";
            ClientScript.RegisterStartupScript(this.GetType(), "", script, true);
        }

        protected void ModalTipoProducto_lbBuscarTipoProducto_Click(object sender, EventArgs e)
        {
            string nombre = ModalTipoProducto_txtTipoProductoNombre.Text.Trim();
            this.listaTipoProducto = this.tipoProductoBO.ConsultarTiposDeProductos(nombre);
            ModalTipoProducto_gvTipoProductos.DataSource = this.listaTipoProducto;
            ModalTipoProducto_gvTipoProductos.DataBind();
        }

        protected void ModalTipoProducto_lbSeleccionar_Click(object sender, EventArgs e)
        {
            int tipoProductoId = Convert.ToInt32((sender as LinkButton).CommandArgument);
            Session["TipoProductoId"] = tipoProductoId;
            TiposProductosDTO tipoProducto = this.tipoProductoBO.ObtenerPorId(tipoProductoId);
            txtTipoProductoId.Text = tipoProducto.TipoProductoId.ToString();
            txtTipoProductoNombre.Text = tipoProducto.Nombre;
            txtTipoProductoDescripcion.Text = tipoProducto.Descripcion;

            //hacemos un PosBack para cerrar el modal
            ScriptManager.RegisterStartupScript(this, this.GetType(), "", "__doPostBack('','');", true);
        }
    }
}