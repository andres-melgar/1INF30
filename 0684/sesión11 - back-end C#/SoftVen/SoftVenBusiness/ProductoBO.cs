using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using SoftVen.DAO;
using SoftVen.Model;
using SoftVenPersistance.DAOImpl;

namespace SoftVenBusiness
{
    public class ProductoBO
    {
        private ProductoDAO productoDAO;

        public ProductoBO()
        {
            productoDAO = new ProductoDAOImpl();
        }

        public int Insertar(string nombre, string descripcion, double precio)
        {
            ProductosDTO productosDTO = new ProductosDTO();
            productosDTO.Nombre = nombre;
            productosDTO.Descripcion = descripcion;
            productosDTO.Precio = precio;

            return this.productoDAO.Insertar(productosDTO);
        }
    }
}
