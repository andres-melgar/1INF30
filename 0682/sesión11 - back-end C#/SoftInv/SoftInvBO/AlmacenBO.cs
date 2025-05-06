using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using SoftInv.DAO;
using SoftInv.DAOImpl;
using SoftInv.Model;

namespace SoftInvBusiness
{
    public class AlmacenBO
    {
        private AlmacenDAO almacenDAO;

        public AlmacenBO()
        {
            this.almacenDAO = new AlmacenDAOImpl();
        }

        public int Insertar(string nombre, bool almacenCentral)
        {
            AlmacenesDTO almacenesDTO = new AlmacenesDTO();
            almacenesDTO.Nombre = nombre;
            almacenesDTO.AlmacenCentral = almacenCentral;
            return this.almacenDAO.Insertar(almacenesDTO);
        }
    }
}
