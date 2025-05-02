using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using SoftVen.Model;

namespace SoftVen.DAO
{
    public interface ProductoDAO
    {
        int Insertar(ProductosDTO producto);

        ProductosDTO ObtenerPorId(int productoId);

        BindingList<ProductosDTO> ListarTodos();

        int Modificar(ProductosDTO producto);

        int Eliminar(ProductosDTO producto);
    }
}
