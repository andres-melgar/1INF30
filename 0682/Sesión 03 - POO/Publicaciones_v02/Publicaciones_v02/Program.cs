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
            Articulo articulo = new Articulo("A relational model of data for large shared data banks", "E. F. Codd", 1970, "Communications of the ACM", 13, 6, "June");
            
            string[] autores = { "Erich Gamma", "Richard Helm", "Ralph Johnson", "John Vlissides" };
            Libro libro = new Libro("Design Patterns: Elements of Reusable Object-Oriented Software ", autores, 1994, "First Edition", "Boston, MA", "Addison-Wesley Professional");
            
            Tesis tesis = new Tesis("A system of logic based ordinals", "Alan Turing", 1938, "Tesis de Doctorado",  "Departamento de Matemáticas", "Universidad de Princeton", "Princeton", "NJ");

            Console.WriteLine(articulo.Referenciar());
            Console.WriteLine(libro.Referenciar());
            Console.WriteLine(tesis.Referenciar());
        }
    }
}
