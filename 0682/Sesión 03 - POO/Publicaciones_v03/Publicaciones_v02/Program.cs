using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Publicaciones_v03
{
    public class Program
    {
        static void Main(string[] args)
        {
            Publicacion[] publicaciones = new Publicacion[3];

            //La línea sigiente falla porque Publicacion es abstracta
            //Publicacion p = new Publicacion("A sample publication", "John Doe", 2024);

            //Publicacion articulo = new Articulo("A relational model of data for large shared data banks", "E. F. Codd", 1970, "Communications of the ACM", 13, 6, "June");
            publicaciones[0] = new Articulo("A relational model of data for large shared data banks", "E. F. Codd", 1970, "Communications of the ACM", 13, 6, "June"); 

            string[] autores = { "Erich Gamma", "Richard Helm", "Ralph Johnson", "John Vlissides" };
            //Publicacion libro = new Libro("Design Patterns: Elements of Reusable Object-Oriented Software ", autores, 1994, "First Edition", "Boston, MA", "Addison-Wesley Professional");
            publicaciones[1] = new Libro("Design Patterns: Elements of Reusable Object-Oriented Software ", autores, 1994, "First Edition", "Boston, MA", "Addison-Wesley Professional");

            //Publicacion tesis = new Tesis("A system of logic based ordinals", "Alan Turing", 1938, "Tesis de Doctorado",  "Departamento de Matemáticas", "Universidad de Princeton", "Princeton", "NJ");
            publicaciones[2] = new Tesis("A system of logic based ordinals", "Alan Turing", 1938, "Tesis de Doctorado", "Departamento de Matemáticas", "Universidad de Princeton", "Princeton", "NJ");

            //Console.WriteLine(articulo.Referenciar());
            //Console.WriteLine(libro.Referenciar());
            //Console.WriteLine(tesis.Referenciar());
            foreach(Publicacion publicacion in publicaciones)
            {
                //Console.WriteLine(publicacion.MetodoAbstracto());
                Console.WriteLine(publicacion);
                Publicacion.orden_presentacion++;
            }
        }
    }
}
