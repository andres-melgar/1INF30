using ClienteRENIEC.RENIEC;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace PruebaRENIEC
{
    internal class Program
    {
        static void Main(string[] args)
        {
            ClienteRENIEC.PersonaBO personaBO = new ClienteRENIEC.PersonaBO();
            
            personasDTO persona = personaBO.consulta("23485697");
            Console.WriteLine("DNI: " + persona.DNI);            
            Console.WriteLine("Apellido Paterno: " + persona.paterno);
            Console.WriteLine("Apellido Materno: " + persona.materno);
            Console.WriteLine("Nombres: " + persona.nombres);
            Console.ReadLine();
        }
    }
}
