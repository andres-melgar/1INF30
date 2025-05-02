using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SoftVen.Model
{
    public class ReportesVendedoresDTO
    {
        private PeriodosDTO periodo;
        private ProductosDTO producto;
        private TiendasDTO tienda;
        private VendedoresDTO vendedor;
        private double? totalVentas;
        private double? totalDescuentos;

        public ReportesVendedoresDTO()
        {
            this.Periodo = null;
            this.Producto = null;
            this.Tienda = null;
            this.Vendedor = null;
            this.TotalVentas = null;
            this.TotalDescuentos = null;
        }

        public ReportesVendedoresDTO(PeriodosDTO periodo, ProductosDTO producto, TiendasDTO tienda, VendedoresDTO vendedor, double totalVentas, double totalDescuentos)
        {
            this.Periodo = periodo;
            this.Producto = producto;
            this.Tienda = tienda;
            this.Vendedor = vendedor;
            this.TotalVentas = totalVentas;
            this.TotalDescuentos = totalDescuentos;
        }

        public PeriodosDTO Periodo { get => periodo; set => periodo = value; }
        public ProductosDTO Producto { get => producto; set => producto = value; }
        public TiendasDTO Tienda { get => tienda; set => tienda = value; }
        public VendedoresDTO Vendedor { get => vendedor; set => vendedor = value; }
        public double? TotalVentas { get => totalVentas; set => totalVentas = value; }
        public double? TotalDescuentos { get => totalDescuentos; set => totalDescuentos = value; }
    }
}
