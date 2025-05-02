using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SoftVen.Model
{
    public class VentasDetallesDTO
    {
        private int? ventaID;
        private int? item;
        private ProductosDTO producto;
        private int? cantidad;
        private double? precioVenta;
        private double? descuento;
        private double? igv;
        private double? subTotal;

        public VentasDetallesDTO()
        {
            this.VentaID = null;
            this.Item = null;
            this.Producto = null;
            this.Cantidad = null;
            this.PrecioVenta = null;
            this.Descuento = null;
            this.Igv = null;
            this.SubTotal = null;
        }

        public VentasDetallesDTO(int ventaID, int item, ProductosDTO producto, int cantidad, double precioVenta, double descuento, double IGV, double subTotal)
        {
            this.VentaID = ventaID;
            this.Item = item;
            this.Producto = producto;
            this.Cantidad = cantidad;
            this.PrecioVenta = precioVenta;
            this.Descuento = descuento;
            this.Igv = IGV;
            this.SubTotal = subTotal;
        }

        public int? VentaID { get => ventaID; set => ventaID = value; }
        public int? Item { get => item; set => item = value; }
        public ProductosDTO Producto { get => producto; set => producto = value; }
        public int? Cantidad { get => cantidad; set => cantidad = value; }
        public double? PrecioVenta { get => precioVenta; set => precioVenta = value; }
        public double? Descuento { get => descuento; set => descuento = value; }
        public double? Igv { get => igv; set => igv = value; }
        public double? SubTotal { get => subTotal; set => subTotal = value; }
    }
}
