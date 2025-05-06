using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SoftInv.Model
{
    public class MovimientosDTO
    {
        private int? movimientoId;
        private TiposMovimientosDTO tipoMovimiento;
        private DateTime? fechaMovimiento;
        private DateTime? fechaCreacion;
        private TiposDocumentosDTO tipoDocumento;
        private string numeroDocumento;
        private AlmacenesDTO almacen;
        private ProductosDTO producto;
        private int? cantidad;
        private double? valor;

        public MovimientosDTO()
        {
            this.MovimientoId = null;
            this.TipoMovimiento = null;
            this.FechaMovimiento = null;
            this.FechaCreacion = null;
            this.TipoDocumento = null;
            this.NumeroDocumento = null;
            this.Almacen = null;
            this.Producto = null;
            this.Cantidad = null;
            this.Valor = null;
        }

        public MovimientosDTO(int movimientoId, TiposMovimientosDTO tipoMovimiento, DateTime fechaMovimiento, DateTime fechaCreacion, TiposDocumentosDTO tipoDocumento, string numeroDocumento, AlmacenesDTO almacen, ProductosDTO producto, int cantidad, double valor)
        {
            this.MovimientoId = movimientoId;
            this.TipoMovimiento = tipoMovimiento;
            this.FechaMovimiento = fechaMovimiento;
            this.FechaCreacion = fechaCreacion;
            this.TipoDocumento = tipoDocumento;
            this.NumeroDocumento = numeroDocumento;
            this.Almacen = almacen;
            this.Producto = producto;
            this.Cantidad = cantidad;
            this.Valor = valor;
        }

        public int? MovimientoId { get => movimientoId; set => movimientoId = value; }
        public TiposMovimientosDTO TipoMovimiento { get => tipoMovimiento; set => tipoMovimiento = value; }
        public DateTime? FechaMovimiento { get => fechaMovimiento; set => fechaMovimiento = value; }
        public DateTime? FechaCreacion { get => fechaCreacion; set => fechaCreacion = value; }
        public TiposDocumentosDTO TipoDocumento { get => tipoDocumento; set => tipoDocumento = value; }
        public string NumeroDocumento { get => numeroDocumento; set => numeroDocumento = value; }
        public AlmacenesDTO Almacen { get => almacen; set => almacen = value; }
        public ProductosDTO Producto { get => producto; set => producto = value; }
        public int? Cantidad { get => cantidad; set => cantidad = value; }
        public double? Valor { get => valor; set => valor = value; }
    }
}
