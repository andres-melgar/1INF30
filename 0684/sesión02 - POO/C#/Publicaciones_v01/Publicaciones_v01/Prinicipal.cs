﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Publicaciones_v01
{
    public class Prinicipal
    {
        static void Main(string[] args)
        {
            Publicacion publicacion = new Publicacion("A relational model of data for large shared data banks", "Edgard Frank Codd", 1970);
            publicacion.Referenciar();
            //Console.WriteLine(publicacion);

            string[] autores = { "Erich Gamma", "Richard Helm", "Ralph Johnson", "John Vlissides"};
            publicacion = new Publicacion("Design Patterns: Elements of Reusable Object-Oriented Software", autores, 1994);
            publicacion.Referenciar();
            //Console.WriteLine(publicacion);

            publicacion = new Publicacion("Systems of Logic Based on Ordinals", "Alan Turing", 1938);
            publicacion.Referenciar();
            //Console.WriteLine(publicacion);

            Publicacion otra_publicacion = new Publicacion(publicacion);
            otra_publicacion.Referenciar();
            //Console.WriteLine(otra_publicacion);
        }
    }
}
