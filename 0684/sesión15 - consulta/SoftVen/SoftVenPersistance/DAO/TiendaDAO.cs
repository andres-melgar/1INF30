using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using SoftVen.Model;

namespace SoftVen.DAO
{
    public interface TiendaDAO
    {
        BindingList<TiendasDTO> ListarTodos();
    }
}
