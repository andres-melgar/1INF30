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
    public partial class almacen_gestion : System.Web.UI.Page
    {
        private AlmacenBO almacenBO;
        private int? almacenId;
        private bool estaModificando;

        public AlmacenBO AlmacenBO { get => almacenBO; set => almacenBO = value; }
        public int? AlmacenId { get => almacenId; set => almacenId = value; }
        public bool EstaModificando { get => estaModificando; set => estaModificando = value; }

        public almacen_gestion()
        {
            this.AlmacenBO = new AlmacenBO();
            this.AlmacenId = null;
            this.EstaModificando = false;
        }

        protected void Page_Init(object sender, EventArgs e)
        {
            this.AlmacenId = (int?)Session["almacenId"];
            string accion = Request.QueryString["accion"];
            if (accion!=null && accion=="modificar")
            {
                this.EstaModificando = true;
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
            AlmacenesDTO almacenDTO = this.AlmacenBO.ObtenerPorId(this.AlmacenId.Value);
            txtIdAlmacen.Text = almacenDTO.AlmacenId.ToString();
            txtNombre.Text = almacenDTO.Nombre;
            cbCentral.Checked = (bool)almacenDTO.AlmacenCentral;
        }

        protected void Page_Load(object sender, EventArgs e)
        {

        }

        protected void btnRegresar_Click(object sender, EventArgs e)
        {
            this.IrAlListado();            
        }

        private void IrAlListado()
        {
            Response.Redirect("almacen_listado.aspx");
        }

        protected void btnGuardar_Click(object sender, EventArgs e)
        {
            string nombre = txtNombre.Text;
            bool almacenCentral = cbCentral.Checked;
            if (this.EstaModificando)
                this.AlmacenBO.Modificar(this.AlmacenId.Value, nombre, almacenCentral);
            else
                this.AlmacenBO.Insertar(nombre, almacenCentral);
            this.IrAlListado();
        }
    }
}