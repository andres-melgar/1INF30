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
            this.movimientoId = null;
            this.tipoMovimiento = null;
            this.fechaMovimiento = null;
            this.fechaCreacion = null;
            this.tipoDocumento = null;
            this.numeroDocumento = null;
            this.almacen = null;
            this.producto = null;
            this.cantidad = null;
            this.valor = null;
        }

        public MovimientosDTO(int movimientoId, TiposMovimientosDTO tipoMovimiento, DateTime fechaMovimiento, DateTime fechaCreacion, TiposDocumentosDTO tipoDocumento, string numeroDocumento, AlmacenesDTO almacen, ProductosDTO producto, int cantidad, double valor)
        {
            this.movimientoId = movimientoId;
            this.tipoMovimiento = tipoMovimiento;
            this.fechaMovimiento = fechaMovimiento;
            this.fechaCreacion = fechaCreacion;
            this.tipoDocumento = tipoDocumento;
            this.numeroDocumento = numeroDocumento;
            this.almacen = almacen;
            this.producto = producto;
            this.cantidad = cantidad;
            this.valor = valor;
        }
    }
}
