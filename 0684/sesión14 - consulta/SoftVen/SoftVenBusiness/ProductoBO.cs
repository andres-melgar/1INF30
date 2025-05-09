using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using SoftVen.DAO;
using SoftVen.Model;
using SoftVenPersistance.DAOImpl;

namespace SoftVen.BO
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

        public int Modificar(int productoId, string nombre, string descripcion, double precio)
        {
            ProductosDTO productosDTO = new ProductosDTO();
            productosDTO.ProductoId = productoId;
            productosDTO.Nombre = nombre;
            productosDTO.Descripcion = descripcion;
            productosDTO.Precio = precio;
            return this.productoDAO.Modificar(productosDTO);
        }

        public int Eliminar(int productoId)
        {
            ProductosDTO productosDTO = new ProductosDTO();
            productosDTO.ProductoId = productoId;
            return this.productoDAO.Eliminar(productosDTO);
        }

        public ProductosDTO ObtenerPorId(int productoId)
        {
            return this.productoDAO.ObtenerPorId(productoId);
        }

        public BindingList<ProductosDTO> ListarTodos()
        {
            return this.productoDAO.ListarTodos();
        }
    }
}
