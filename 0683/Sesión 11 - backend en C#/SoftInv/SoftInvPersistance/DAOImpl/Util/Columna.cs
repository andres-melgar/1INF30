using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SoftInv.DAOImpl.Util
{
    public class Columna
    {
        private string nombre;
        private bool? esLlavePrimaria;
        private bool? esAutoGenerado;

        public Columna()
        {
            this.Nombre = null;
            this.EsLlavePrimaria = null;
            this.EsAutoGenerado = null;
        }

        public Columna(string nombre, bool esLlavePrimaria, bool esAutoGenerado)
        {
            this.Nombre = nombre;
            this.EsLlavePrimaria = esLlavePrimaria;
            this.EsAutoGenerado = esAutoGenerado;
        }

        public string Nombre { get => nombre; set => nombre = value; }
        public bool? EsLlavePrimaria { get => esLlavePrimaria; set => esLlavePrimaria = value; }
        public bool? EsAutoGenerado { get => esAutoGenerado; set => esAutoGenerado = value; }
    }
}
