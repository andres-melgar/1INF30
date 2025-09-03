using Publicaciones;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Publicaciones.EstandardAPA
{
    internal class Articulo: Publicacion
    {
        private string revista;
        private int volumen;
        private int numero;
        private string mes;

        public Articulo(string nombre, string nombre_completo_autor, int año, string revista, int volumen, int numero, string mes)
            : base(nombre, nombre_completo_autor, año)
        {
            this.revista = revista; 
            this.volumen = volumen;
            this.numero = numero;
            this.mes = mes;
        }

        public Articulo(string nombre, string[] nombres_completos_autores, int año, string revista, int volumen, int numero, string mes)
           : base(nombre, nombres_completos_autores, año)
        {
            this.revista = revista;
            this.volumen = volumen;
            this.numero = numero;
            this.mes = mes;
        }

        public override string ToString()
        {
            string referencia = "";
            for (int i = 0; i < this.autores.Count; i++)
            {
                if (i != 0)
                {
                    if (i == this.cantidad_autores - 1)
                        referencia += " and ";
                    else
                        referencia += ", ";
                }
                referencia += this.autores[i].ToString();
            }
            referencia += ". (";
            referencia += this.año;
            referencia += "). ";
            referencia += nombre;
            referencia += ". ";
            referencia += revista;
            referencia += ", ";
            referencia += this.volumen;
            referencia += " (";
            referencia += this.numero;
            referencia += ").";
            return referencia;
        }
    }
}
