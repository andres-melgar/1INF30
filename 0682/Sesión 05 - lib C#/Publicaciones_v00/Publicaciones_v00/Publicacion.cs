using System;
using System.Collections;
using System.Collections.Generic;
using System.Data;
using System.Globalization;
using System.Linq;
using System.Runtime.Remoting.Metadata.W3cXsd2001;
using System.Text;
using System.Threading.Tasks;

namespace Publicaciones_v00
{

    public abstract class Publicacion
    {
        
        public static int orden_presentacion = 1;
        protected string nombre;
        protected ArrayList autores;
        protected int cantidad_autores;
        protected int año;

        public Publicacion(string nombre, string nombre_completo_autor, int año)
        {
            this.nombre = nombre;
            this.autores = new ArrayList();
            Autor autor = new Autor(nombre_completo_autor);
            this.autores.Add(autor);
            this.cantidad_autores = 1;
            this.año = año;
        }

        public Publicacion(string nombre, string[] nombres_completos_autores, int año)
        {
            this.nombre = nombre;
            this.autores = new ArrayList();
            for (int i = 0; i < nombres_completos_autores.Length; i++)
            {
                Autor autor = new Autor(nombres_completos_autores[i]);
                this.autores.Add(autor);
            }
            this.cantidad_autores = autores.Count;
            this.año = año;
        }

        public void Referenciar()
        {
            Console.WriteLine(this);
        }
    }
}