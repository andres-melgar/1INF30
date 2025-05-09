using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using SoftInv.Model;

namespace SoftInv.DAO
{
    public interface AlmacenDAO 
    {
        int Insertar(AlmacenesDTO almacen);

        AlmacenesDTO ObtenerPorId(int almacenId);

        BindingList<AlmacenesDTO> ListarTodos();

        int Modificar(AlmacenesDTO almacen);

        int Eliminar(AlmacenesDTO almacen);
    }
}
