using Publicaciones_v01.Publicaciones;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Publicaciones.EstandardIEEE
{
    public class ConcreteFactoryIEEE : AbstractFactoryPublicacion
    {
        public Publicacion CrearArticulo(string nombre, string nombre_completo_autor, int año, string revista, int volumen, int numero, string mes)
        {
            return new Articulo(nombre, nombre_completo_autor, año, revista, volumen, numero, mes);
        }

        public Publicacion CrearArticulo(string nombre, string[] nombres_completos_autores, int año, string revista, int volumen, int numero, string mes)
        {
            return new Articulo(nombre, nombres_completos_autores, año, revista, volumen, numero, mes);
        }

        public Publicacion CrearLibro(string nombre, string nombre_completo_autor, int año, string edicion, string lugar, string editorial)
        {
            return new Libro(nombre, nombre_completo_autor, año, edicion, lugar, editorial);
        }

        public Publicacion CrearLibro(string nombre, string[] nombres_completos_autores, int año, string edicion, string lugar, string editorial)
        {
            return new Libro(nombre, nombres_completos_autores, año, edicion, lugar, editorial);
        }

        public Publicacion CrearTesis(string nombre, string nombre_completo_autor, int año, Clase_de_Tesis clase, string departamento, string institucion, string ciudad, string estado)
        {
            return new Tesis(nombre, nombre_completo_autor, año, clase, departamento, institucion, ciudad, estado);
        }

        public Publicacion CrearTesis(string nombre, string[] nombres_completos_autores, int año, Clase_de_Tesis clase, string departamento, string institucion, string ciudad, string estado)
        {
            return new Tesis(nombre, nombres_completos_autores, año, clase, departamento, institucion, ciudad, estado);
        }
    }
}
