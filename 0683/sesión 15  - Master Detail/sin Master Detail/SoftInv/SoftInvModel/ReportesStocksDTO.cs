using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SoftInv.Model
{
    public class ReportesStocksDTO
    {
        private PeriodosDTO periodo;
        private ProductosDTO producto;
        private AlmacenesDTO almacen;
        private int? saldoInicial;
        private int? entradas;
        private int? salidas;
        private int? saldoFinal;

        public ReportesStocksDTO()
        {
            this.Periodo = null;
            this.Producto = null;
            this.Almacen = null;
            this.SaldoInicial = null;
            this.Entradas = null;
            this.Salidas = null;
            this.SaldoFinal = null;
        }

        public ReportesStocksDTO(PeriodosDTO periodo, ProductosDTO producto, AlmacenesDTO almacen, int saldoInicial, int entradas, int salidas, int saldoFinal)
        {
            this.Periodo = periodo;
            this.Producto = producto;
            this.Almacen = almacen;
            this.SaldoInicial = saldoInicial;
            this.Entradas = entradas;
            this.Salidas = salidas;
            this.SaldoFinal = saldoFinal;
        }

        public PeriodosDTO Periodo { get => periodo; set => periodo = value; }
        public ProductosDTO Producto { get => producto; set => producto = value; }
        public AlmacenesDTO Almacen { get => almacen; set => almacen = value; }
        public int? SaldoInicial { get => saldoInicial; set => saldoInicial = value; }
        public int? Entradas { get => entradas; set => entradas = value; }
        public int? Salidas { get => salidas; set => salidas = value; }
        public int? SaldoFinal { get => saldoFinal; set => saldoFinal = value; }
    }
}
