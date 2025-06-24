using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.CompilerServices;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using SoftInv.BO;

namespace SoftInvWA
{
    public partial class reporte_producto : System.Web.UI.Page
    {
        private AlmacenBO almacenBO;

        public reporte_producto()
        {
            this.almacenBO = new AlmacenBO();
        }
        protected void Page_Load(object sender, EventArgs e)
        {
            byte[] reporte = this.almacenBO.reporteProductos();
            this.almacenBO.abrirReporte(Response, "ReporteVendedores", reporte);
        }
    }
}