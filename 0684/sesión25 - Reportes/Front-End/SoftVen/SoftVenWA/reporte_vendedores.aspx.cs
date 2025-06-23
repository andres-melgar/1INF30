using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using SoftVen.BO;

namespace SoftVenWA
{
    public partial class reporte_vendedores : System.Web.UI.Page
    {
        //1. incorporamos BO para traer el reporte
        private ProductoBO productoBO;

        public reporte_vendedores()
        {
            this.productoBO = new ProductoBO();
        }
        protected void Page_Load(object sender, EventArgs e)
        {
            //2 traemos al front la secuencia de bits del pdf
            byte [] reporte = this.productoBO.reporteVendedores();
            //3 mostramos el PDF
            this.productoBO.abrirReporte(Response, "ReporteVendedores.pdf", reporte);
        }
    }
}