using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data.Common;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using SoftInv.DAO;
using SoftInv.DAOImpl;
using SoftInv.DAOImpl.Util;
using SoftInv.Model;

namespace SoftInv.DAOImpl
{
    public class TipoProductoDAOImpl : DAOImplBase, TipoProductoDAO
    {
        private TiposProductosDTO tiposProductos;

        public TipoProductoDAOImpl() : base("INV_TIPOS_PRODUCTOS")
        {
            this.retornarLlavePrimaria = false;
            this.tiposProductos = null;
        }

        protected override void ConfigurarListaDeColumnas()
        {
            this.listaColumnas.Add(new Columna("TIPO_PRODUCTO_ID", true, false));
            this.listaColumnas.Add(new Columna("NOMBRE", false, false));
            this.listaColumnas.Add(new Columna("DESCRIPCION", false, false));
        }

        protected override void AgregarObjetoALaLista(BindingList<Object> lista, DbDataReader lector)
        {
            this.InstanciarObjetoDelResultSet(lector);
            lista.Add(this.tiposProductos);
        }

        protected override void InstanciarObjetoDelResultSet(DbDataReader lector)
        {
            this.tiposProductos = new TiposProductosDTO();
            this.tiposProductos.TipoProductoId = this.lector.GetInt32(0);
            this.tiposProductos.Nombre = this.lector.GetString(1);
            this.tiposProductos.Descripcion = this.lector.GetString(2);
        }

        public BindingList<TiposProductosDTO> ConsultarTiposDeProductos(string nombre)
        {
            BindingList<Object> lista;
            lista = base.ListarTodos();
            BindingList<TiposProductosDTO> retorno = new BindingList<TiposProductosDTO>();
            foreach (TiposProductosDTO objecto in lista)
            {
                retorno.Add(objecto);
            }
            return retorno;
        }
    }
}
