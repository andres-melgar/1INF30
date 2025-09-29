using System;
using System.Collections.Generic;
using System.ComponentModel;
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

        public int Eliminar(int almacenId)
        {
            AlmacenesDTO almacenesDTO = new AlmacenesDTO();
            almacenesDTO.AlmacenId = almacenId;
            return this.almacenDAO.Eliminar(almacenesDTO);
        }

        public int Modificar(int almacenId, string nombre, bool almacenCentral)
        {
            AlmacenesDTO almacenesDTO = new AlmacenesDTO();
            almacenesDTO.AlmacenId = almacenId;
            almacenesDTO.Nombre = nombre;
            almacenesDTO.AlmacenCentral = almacenCentral;
            return this.almacenDAO.Modificar(almacenesDTO);
        }

        public AlmacenesDTO ObtenerPorId(int almacenId)
        {
            return this.almacenDAO.ObtenerPorId(almacenId);
        }

        public IList<AlmacenesDTO> ListarTodos()
        {
            return this.almacenDAO.ListarTodos();
        }
    }
}
