using Publicaciones;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Publicaciones.EstandardIEEE
{
    public class Libro: Publicacion
    {
        private string edicion;
        private string lugar;
        private string editorial;

        public Libro(string nombre, string nombre_completo_autor, int año, string edicion, string lugar, string editorial) 
            : base(nombre, nombre_completo_autor, año)
        {
            this.edicion= edicion;
            this.lugar = lugar;
            this.editorial = editorial;
        }

        public Libro(string nombre, string[] nombres_completos_autores, int año, string edicion, string lugar, string editorial) 
            : base(nombre, nombres_completos_autores, año)
        {
            this.edicion = edicion;
            this.lugar = lugar;
            this.editorial = editorial;
        }

        public override string ToString()
        {
            string referencia = "["+ Publicacion.orden_presentacion + "] ";
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
            referencia += ". ";
            referencia += this.nombre;
            referencia += ". ";
            referencia += this.edicion;
            referencia += ". ";
            referencia += this.lugar;
            referencia += ". ";
            referencia += this.editorial;
            referencia += ". ";
            referencia += this.año;
            referencia += ".";
            return referencia;
        }
    }
}
