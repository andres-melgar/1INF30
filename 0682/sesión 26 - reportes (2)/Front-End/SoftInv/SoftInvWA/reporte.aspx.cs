using SoftInvBusiness;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace SoftInvWA
{
    public partial class reporte : System.Web.UI.Page
    {
        private AlmacenBO almacenBO;

        public reporte()
        {
            this.almacenBO = new AlmacenBO();
        }

        protected void Page_Load(object sender, EventArgs e)
        {
            //byte[] reporte = this.almacenBO.ReporteProducto();
            byte[] reporte = this.almacenBO.ReporteTipoProducto(0);
            this.almacenBO.AbrirReporte(Response, "ReporteProducto.pdf", reporte);
        }
    }
}