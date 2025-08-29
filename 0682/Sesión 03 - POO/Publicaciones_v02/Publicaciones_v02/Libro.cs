using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Publicaciones_v02
{
    public class Libro : Publicacion
    {
        private string edicion;
        private string lugar;
        private string editorial;

        public Libro(string nombre, string autor, int año, string edicion, string lugar, string editorial): base(nombre, autor, año)
        {
            this.Edicion = edicion;
            this.Lugar = lugar;
            this.Editorial = editorial;
        }

        public Libro(string nombre, string[] autores, int año, string edicion, string lugar, string editorial) : base(nombre, autores, año)
        {
            this.Edicion = edicion;
            this.Lugar = lugar;
            this.Editorial = editorial;
        }

        public string Edicion { get => edicion; set => edicion = value; }
        public string Lugar { get => lugar; set => lugar = value; }
        public string Editorial { get => editorial; set => editorial = value; }

        public override string ToString()
        {
            string referencia = "[1] ";
            for (int i = 0; i < this.Autores.Length; i++)
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
            referencia += ". ";
            referencia += this.Nombre;
            referencia += ". ";
            referencia += this.Edicion;
            referencia += ". ";
            referencia += this.Lugar;
            referencia += ". ";
            referencia += this.Editorial;
            referencia += ". ";
            referencia += this.Año;
            referencia += ".";
            return referencia;
        }
    }
}
