using ClienteRENIEC.RENIEC;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ClienteRENIEC
{
    public class PersonaBO
    {
        private ConsultaDNIClient clienteSOAP;

        public PersonaBO()
        {
            this.clienteSOAP = new ConsultaDNIClient();
        }

        public personasDTO consulta(string DNI)
        {
            return this.clienteSOAP.consulta(DNI);
        }
    }
}
