using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Publicaciones_v02
{
    public class Program
    {
        static void Main(string[] args)
        {
            string[] autores = new string[] { "Gamma", "Helm", "Johnson", "Vlissides" };
            Publicacion publicacion = new Publicacion("Design Patterns: Elements of Reusable Object-Oriented Software", autores, 1994);
            Console.WriteLine(publicacion);
            autores[0] = "Melgar";
            autores[1] = "Cueva";
            Console.WriteLine(publicacion);
        }
    }
}
