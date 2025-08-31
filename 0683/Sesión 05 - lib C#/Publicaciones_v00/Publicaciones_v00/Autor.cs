using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Publicaciones_v00
{ 

    internal class Autor
    {
        private string apellidos;
        private string nombres;

        public Autor(string nombre_completo_autor)
        {
            int posicion_coma = nombre_completo_autor.IndexOf(",");
            this.apellidos = nombre_completo_autor.Substring(0, posicion_coma).Trim();
            this.nombres = nombre_completo_autor.Substring(++posicion_coma).Trim();
        }
        public override string ToString()
        {
            string copia_nombre = this.nombres;
            string abreviatura = "";
            int posicion_blanco;
            do
            {
                posicion_blanco = copia_nombre.IndexOf(" ");
                if (!abreviatura.Equals(""))
                    abreviatura += " ";
                abreviatura += copia_nombre.Substring(0, 1);
                abreviatura += ".";
                if (posicion_blanco != -1)
                    copia_nombre = copia_nombre.Substring(posicion_blanco + 1).Trim();
            }
            while (posicion_blanco != -1);
            return abreviatura + " " + this.apellidos;
        }
    }
}