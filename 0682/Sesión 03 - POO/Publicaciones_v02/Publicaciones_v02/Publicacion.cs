using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Publicaciones_v02
{
    public class Publicacion
    {
        private string nombre;
        private string[] autores;
        private int cantidad_autores;
        private int año;

        public string Nombre { get => nombre; set => nombre = value; }
        public string[] Autores { get => autores; set => autores = value; }
        public int Cantidad_autores { get => cantidad_autores; set => cantidad_autores = value; }
        public int Año { get => año; set => año = value; }

        public Publicacion(string nombre, string autor, int año)
        {
            this.Nombre = nombre;
            this.Autores = new string[1];
            this.Autores[0] = autor;
            this.Cantidad_autores = 1;
            this.Año = año;
        }

        public Publicacion(string nombre, string[] autores, int año)
        {
            this.Nombre = nombre;
            //esto está mal, porque autores es una referencia
            //this.autores = autores;            
            this.Autores = new string[autores.Length];
            for (int i=0; i<autores.Length; i++)
            {
                this.Autores[i] = autores[i];
            }
            this.Cantidad_autores = this.Autores.Length;
            this.Año = año;
        }

        public Publicacion(Publicacion publicacion)
        {
            this.Nombre = publicacion.Nombre;
            this.Autores = new string[publicacion.Cantidad_autores];
            for (int i = 0; i < Autores.Length; i++)
            {
                this.Autores[i] = publicacion.Autores[i];
            }
            this.Cantidad_autores = this.Autores.Length;
            this.Año = publicacion.Año;
        }

        public override string ToString()
        {
            string referencia = "[1] ";
            for (int i=0; i<this.Cantidad_autores; i++)
            {
                if (i != 0)
                {
                    if (i == this.Cantidad_autores - 1)
                        referencia += " and ";
                    else
                        referencia += ", ";
                }
                referencia += this.Autores[i];
            }
            referencia += ".";
            referencia += this.Nombre;
            referencia += ".";
            referencia += this.Año;
            referencia += ".";
            return referencia;
        }

        public string Referenciar()
        {
            return this.ToString();
        }

    }
}
