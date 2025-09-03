using Publicaciones;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Publicaciones.EstandardAPA
{
    internal class Tesis: Publicacion
    {        
        private Clase_de_Tesis clase;
        private string departamento;
        private string institucion;
        private string ciudad;
        private string estado;
   
        public Tesis(string nombre, string nombre_completo_autor, int año, Clase_de_Tesis clase, string departamento, string institucion, string ciudad, string estado) 
            : base(nombre, nombre_completo_autor, año)
        {
            this.clase = clase;
            this.departamento = departamento;
            this.institucion= institucion;
            this.ciudad = ciudad;
            this.estado = estado;
        }

        public Tesis(string nombre, string[] nombres_completos_autores, int año, Clase_de_Tesis clase, string departamento, string institucion, string ciudad, string estado) 
            : base(nombre, nombres_completos_autores, año)
        {
            this.clase = clase;
            this.departamento = departamento;
            this.institucion = institucion;
            this.ciudad = ciudad;
            this.estado = estado;
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
            referencia += this.nombre;
            referencia += ". [";
            switch (this.clase)
            {
                case Clase_de_Tesis.DOCTORADO: referencia += "Tesis de Doctorado"; break;
                case Clase_de_Tesis.MAESTRIA: referencia += "Tesis de Maestría"; break;
                case Clase_de_Tesis.LICENCIATURA: referencia += "Tesis de Licenciatura"; break;
            }
            referencia += ", ";
            referencia += this.departamento;
            referencia += ", ";
            referencia += this.institucion;
            referencia += ", ";
            referencia += this.ciudad;
            referencia += ", ";
            referencia += this.estado;
            referencia += "].";
            return referencia;
        }
    }
}
