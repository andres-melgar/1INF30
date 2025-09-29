using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SoftInv.Model
{
    public class PeriodosDTO
    {
        private int? anho;
        private int? mes;
        private string descripcion;

        public PeriodosDTO()
        {
            this.Anho = null;
            this.Mes = null;
            this.Descripcion = null;
        }

        public PeriodosDTO(int anho, int mes, string descripcion)
        {
            this.Anho = anho;
            this.Mes = mes;
            this.Descripcion = descripcion;
        }

        public int? Anho { get => anho; set => anho = value; }
        public int? Mes { get => mes; set => mes = value; }
        public string Descripcion { get => descripcion; set => descripcion = value; }
    }
}
