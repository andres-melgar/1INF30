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
            //Publicacion publicacion = new Publicacion("A Relational Model of Data for Large Shared Data Banks", "Codd", 1970);            
            string [] autores = new string[] { "Gamma", "Helm", "Johnson", "Vlissides" };
            Publicacion publicacion = new Publicacion("Design Patterns: Elements of Reusable Object-Oriented Software", autores, 1994);
            Console.WriteLine(publicacion);
            //Console.WriteLine(publicacion.ToString());
            //publicacion.Referenciar();
            autores[0] = "Melgar";
            autores[1] = "Cueva";
            Console.WriteLine(publicacion);
        }
    }
}
