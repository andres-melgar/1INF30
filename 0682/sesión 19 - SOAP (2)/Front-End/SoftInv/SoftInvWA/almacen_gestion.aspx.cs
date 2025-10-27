using SoftInvBusiness;
using SoftInvBusiness.clienteSOAP;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SoftInvWA
{
    public partial class almacen_gestion : System.Web.UI.Page
    {
        private AlmacenBO almacenBO;
        private int? almacenId;
        private bool estaModificando;
        private string cabeceraPagina;

        public AlmacenBO AlmacenBO { get => almacenBO; set => almacenBO = value; }
        public int? AlmacenId { get => almacenId; set => almacenId = value; }
        public bool EstaModificando { get => estaModificando; set => estaModificando = value; }
        public string CabeceraPagina { get => cabeceraPagina; set => cabeceraPagina = value; }

        public almacen_gestion()
        {
            this.AlmacenBO = new AlmacenBO();
            this.AlmacenId = null;
            this.EstaModificando = false;
            this.CabeceraPagina = "Creación de Almacén";
        }

        protected void Page_Init(object sender, EventArgs e)
        {
            if (Session["almacenId"] != null)
                this.AlmacenId = (int)Session["almacenId"];
            String accion = Request.QueryString["accion"];
            if (accion != null && accion == "modificar")
            {
                this.EstaModificando = true;
                this.CabeceraPagina = "Modificación de Almacén";
            }
            else
            {
                this.EstaModificando = false;
            }
            if (this.EstaModificando)
                this.CargarEntidad();
        }

        private void CargarEntidad()
        {
            almacenesDTO almacenDTO = this.AlmacenBO.ObtenerPorId((int)this.AlmacenId);
            txtIdAlmacen.Text = almacenDTO.almacenId.ToString();
            txtNombre.Text = almacenDTO.nombre;
            cbCentral.Checked = (bool)almacenDTO.almacen_central;
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
            bool central = cbCentral.Checked;
            if (this.EstaModificando)
                this.AlmacenBO.Modificar((int)this.AlmacenId, nombre, central);
            else
                this.AlmacenBO.Insertar(nombre, central);
            Response.Redirect("almacen_listado.aspx");
        }
    }
}