using SoftInvBusiness.SoftInvWSAlmacenes;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SoftInvBusiness
{    

    public class AlmacenBO
    {
        private AlmacenesClient clienteSOAP;

        public AlmacenBO()
        {
            this.clienteSOAP = new AlmacenesClient();
        }

        public int Insertar(string nombre, bool almacenCentral)
        {
            return this.clienteSOAP.insertar_almacen(nombre, almacenCentral);
        }

        public int Eliminar(int almacenId)
        {            
            return this.clienteSOAP.eliminar(almacenId);
        }

        public int Modificar(int almacenId, string nombre, bool almacenCentral)
        {            
            return this.clienteSOAP.modificar(almacenId, nombre, almacenCentral);
        }

        public almacenesDTO ObtenerPorId(int almacenId)
        {
            return this.clienteSOAP.obtenerPorId(almacenId);
        }

        public IList<almacenesDTO> ListarTodos()
        {
            return this.clienteSOAP.listarTodos();
        }
    }
}
