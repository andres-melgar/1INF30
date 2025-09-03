using Publicaciones;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Publicaciones_v01.Publicaciones
{
    public interface AbstractFactoryPublicacion
    {
        Publicacion CrearArticulo(string nombre, string nombre_completo_autor, int año, string revista, int volumen, int numero, string mes);

        Publicacion CrearArticulo(string nombre, string[] nombres_completos_autores, int año, string revista, int volumen, int numero, string mes);

        Publicacion CrearLibro(string nombre, string nombre_completo_autor, int año, string edicion, string lugar, string editorial);

        Publicacion CrearLibro(string nombre, string[] nombres_completos_autores, int año, string edicion, string lugar, string editorial);

        Publicacion CrearTesis(string nombre, string nombre_completo_autor, int año, Clase_de_Tesis clase, string departamento, string institucion, string ciudad, string estado);

        Publicacion CrearTesis(string nombre, string[] nombres_completos_autores, int año, Clase_de_Tesis clase, string departamento, string institucion, string ciudad, string estado);
    }
}
