using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data.Common;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using SoftVen.DAO;
using SoftVen.DAOImpl;
using SoftVen.DAOImpl.Util;
using SoftVen.Model;

namespace SoftVenPersistance.DAOImpl
{
    public class ProductoDAOImpl: DAOImplBase, ProductoDAO
    {
        private ProductosDTO producto;

        public ProductoDAOImpl(): base("VEN_PRODUCTOS")
        {            
            this.retornarLlavePrimaria = true;
            this.producto = null;
        }

        protected override void ConfigurarListaDeColumnas()
        {
            this.listaColumnas.Add(new Columna("PRODUCTO_ID", true, true));
            this.listaColumnas.Add(new Columna("NOMBRE",  false, false));
            this.listaColumnas.Add(new Columna("DESCRIPCION", false, false));
            this.listaColumnas.Add(new Columna("PRECIO", false, false));
        }

        protected override void IncluirValorDeParametrosParaInsercion()
        {            
            this.AgregarParametro("@NOMBRE", this.producto.Nombre);
            this.AgregarParametro("@DESCRIPCION", this.producto.Descripcion);
            this.AgregarParametro("@PRECIO", this.producto.Precio);
        }
        
        protected override void IncluirValorDeParametrosParaModificacion()
        {
            //this.statement.setString(1, this.almacen.getNombre());
            //this.statement.setInt(2, this.almacen.getAlmacen_central() ? 1 : 0);
            //this.statement.setInt(3, this.almacen.getAlmacenId());
        }

        protected override void IncluirValorDeParametrosParaEliminacion()
        {
            //this.statement.setInt(1, this.almacen.getAlmacenId());
        }

        protected override void IncluirValorDeParametrosParaObtenerPorId()
        {
            //this.statement.setInt(1, this.almacen.getAlmacenId());
        }

        protected override void InstanciarObjetoDelResultSet(DbDataReader lector)
        {
            this.producto = new ProductosDTO();
            this.producto.ProductoId = this.lector.GetInt32(0);
            this.producto.Nombre = this.lector.GetString(1);
            this.producto.Descripcion = this.lector.GetString(2);
            this.producto.Precio = this.lector.GetDouble(3);
        }

        protected override void LimpiarObjetoDelResultSet()
        {
            this.producto = null;
        }

        protected override void AgregarObjetoALaLista(BindingList<Object> lista, DbDataReader lector)
        {
            this.InstanciarObjetoDelResultSet(lector);
            lista.Add(this.producto);
        }

        public int Insertar(ProductosDTO producto)
        {
            this.producto = producto;
            return base.Insertar();
        }

        public int Modificar(ProductosDTO producto)
        {
            this.producto = producto;
            return base.Modificar();
        }

        public int Eliminar(ProductosDTO producto)
        {
            this.producto = producto;
            return base.Eliminar();
        }

        public ProductosDTO ObtenerPorId(int productoId)
        {
            this.producto = new ProductosDTO();
            this.producto.ProductoId = productoId;
            base.ObtenerPorId();
            return this.producto;
        }

        public new BindingList<ProductosDTO> ListarTodos()
        {
            BindingList<Object> lista;
            lista = base.ListarTodos();
            BindingList<ProductosDTO> retorno = new BindingList<ProductosDTO>();
            foreach (ProductosDTO objecto in lista)
            {
                retorno.Add(objecto);
            }
            return retorno;
        }
    }
}
