using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data.Common;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using SoftVen.DAO;
using SoftVen.DAOImpl.Util;
using SoftVen.Model;

namespace SoftVen.DAOImpl
{
    public class TiendaDAOImpl : DAOImplBase, TiendaDAO
    {
        private TiendasDTO tienda;

        public TiendaDAOImpl() : base("VEN_TIENDAS")
        {
            this.retornarLlavePrimaria = false;
            this.tienda = null;
        }

        protected override void ConfigurarListaDeColumnas()
        {
            this.listaColumnas.Add(new Columna("TIENDA_ID", true, false));
            this.listaColumnas.Add(new Columna("NOMBRE", false, false));
            this.listaColumnas.Add(new Columna("DIRECCION", false, false));
            this.listaColumnas.Add(new Columna("TIENDA_PRINCIPAL", false, false));
            this.listaColumnas.Add(new Columna("COMISION", false, false));
        }

        protected override void InstanciarObjetoDelResultSet(DbDataReader lector)
        {
            this.tienda = new TiendasDTO();
            this.tienda.TiendaId = this.lector.GetInt32(0);
            this.tienda.Nombre = this.lector.GetString(1);
            this.tienda.Direccion = this.lector.GetString(2);
            this.tienda.TiendaPrincipal = this.lector.GetInt32(3)==1;
            this.tienda.Comision = this.lector.GetDouble(4);
        }

        protected override void LimpiarObjetoDelResultSet()
        {
            this.tienda = null;
        }

        protected override void AgregarObjetoALaLista(BindingList<Object> lista, DbDataReader lector)
        {
            this.InstanciarObjetoDelResultSet(lector);
            lista.Add(this.tienda);
        }

        public new BindingList<TiendasDTO> ListarTodos()
        {
            BindingList<Object> lista;
            lista = base.ListarTodos();
            BindingList<TiendasDTO> retorno = new BindingList<TiendasDTO>();
            foreach (TiendasDTO objecto in lista)
            {
                retorno.Add(objecto);
            }
            return retorno;
        }
    }
}
