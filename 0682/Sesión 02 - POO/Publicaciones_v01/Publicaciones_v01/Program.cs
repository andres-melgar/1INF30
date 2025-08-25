using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Publicaciones_v01
{
    public class Program
    {
        static void Main(string[] args)
        {
            //Publicacion publicacion = new Publicacion("A relational model of data for large shared data banks", "E. F. Codd", 1970);
            string[] autores = { "Erich Gamma", "Richard Helm", "Ralph Johnson", "John Vlissides" };
            Publicacion publicacion = new Publicacion("Design Patterns: Elements of Reusable Object-Oriented Software ", autores, 1994);

            //Son equivalentes
            Console.WriteLine(publicacion);
            //Console.WriteLine(publicacion.ToString());
            autores[0] = "Andrés Melgar";
            autores[1] = "Rony Cueva";
            Console.WriteLine(publicacion);

            publicacion.Nombre = "Diseño de patrones";
            Console.WriteLine(publicacion.Referenciar());
        }
    }
}
