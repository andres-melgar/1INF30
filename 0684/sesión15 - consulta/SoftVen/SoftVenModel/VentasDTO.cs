using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SoftVen.Model
{
    public class VentasDTO
    {
        private int? ventasId;
        private TiposDocumentosDTO tipoDocumento;
        private string numDocCliente;
        private string nombreCliente;
        private TiendasDTO tienda;
        private VendedoresDTO vendedor;
        private DateTime? fechaVenta;
        private DateTime? fechaCreacion;
        private double? totalVenta;
        private Estado? estado;

        public VentasDTO()
        {
            this.VentasId = null;
            this.TipoDocumento = null;
            this.NumDocCliente = null;
            this.NombreCliente = null;
            this.Tienda = null;
            this.Vendedor = null;
            this.FechaVenta = null;
            this.FechaCreacion = null;
            this.TotalVenta = null;
            this.Estado = null;
        }

        public VentasDTO(int ventasId, TiposDocumentosDTO tipoDocumento, string numDocCliente, string nombreCliente, TiendasDTO tienda, VendedoresDTO vendedor, DateTime fechaVenta, DateTime fechaCreacion, double totalVenta, Estado estado)
        {
            this.VentasId = ventasId;
            this.TipoDocumento = tipoDocumento;
            this.NumDocCliente = numDocCliente;
            this.NombreCliente = nombreCliente;
            this.Tienda = tienda;
            this.Vendedor = vendedor;
            this.FechaVenta = fechaVenta;
            this.FechaCreacion = fechaCreacion;
            this.TotalVenta = totalVenta;
            this.Estado = estado;
        }

        public int? VentasId { get => ventasId; set => ventasId = value; }
        public TiposDocumentosDTO TipoDocumento { get => tipoDocumento; set => tipoDocumento = value; }
        public string NumDocCliente { get => numDocCliente; set => numDocCliente = value; }
        public string NombreCliente { get => nombreCliente; set => nombreCliente = value; }
        public TiendasDTO Tienda { get => tienda; set => tienda = value; }
        public VendedoresDTO Vendedor { get => vendedor; set => vendedor = value; }
        public DateTime? FechaVenta { get => fechaVenta; set => fechaVenta = value; }
        public DateTime? FechaCreacion { get => fechaCreacion; set => fechaCreacion = value; }
        public double? TotalVenta { get => totalVenta; set => totalVenta = value; }
        public Estado? Estado { get => estado; set => estado = value; }
    }
}
