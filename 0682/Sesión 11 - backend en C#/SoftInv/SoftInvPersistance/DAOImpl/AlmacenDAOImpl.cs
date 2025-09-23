using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Data.Common;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Xml.Linq;
using SoftInv.DAO;
using SoftInv.DAOImpl.Util;
using SoftInv.Model;
using static System.Collections.Specialized.BitVector32;

namespace SoftInv.DAOImpl
{
    public class AlmacenDAOImpl : DAOImplBase, AlmacenDAO
    {
        private AlmacenesDTO almacen;

        public AlmacenDAOImpl() : base("INV_ALMACENES")
        {
            this.retornarLlavePrimaria = true;
            this.almacen = null;
        }

        protected override void ConfigurarListaDeColumnas()
        {
            this.listaColumnas.Add(new Columna("ALMACEN_ID", true, true));
            this.listaColumnas.Add(new Columna("NOMBRE", false, false));
            this.listaColumnas.Add(new Columna("ALMACEN_CENTRAL", false, false));
        }

        protected override void IncluirValorDeParametrosParaInsercion()
        {
            AgregarParametro("@NOMBRE", this.almacen.Nombre);
            AgregarParametro("@ALMACEN_CENTRAL", (bool)this.almacen.AlmacenCentral ? 1 : 0);
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
            this.almacen = new AlmacenesDTO();
            this.almacen.AlmacenId = this.lector.GetInt32(0);
            this.almacen.Nombre = this.lector.GetString(1);
            this.almacen.AlmacenCentral = this.lector.GetInt32(2) == 1;
        }

        protected override void LimpiarObjetoDelResultSet()
        {
            this.almacen = null;
        }

        protected override void AgregarObjetoALaLista(BindingList<Object> lista, DbDataReader lector)
        {
            this.InstanciarObjetoDelResultSet(lector);
            lista.Add(this.almacen);
        }

        public int Insertar(AlmacenesDTO almacen)
        {
            this.almacen = almacen;
            return base.Insertar();
        }

        public int Modificar(AlmacenesDTO almacen)
        {
            this.almacen = almacen;
            return base.Modificar();
        }

        public int Eliminar(AlmacenesDTO almacen)
        {
            this.almacen = almacen;
            return base.Eliminar();
        }

        public AlmacenesDTO ObtenerPorId(int almacenId)
        {
            this.almacen = new AlmacenesDTO();
            this.almacen.AlmacenId = almacenId;
            base.ObtenerPorId();
            return this.almacen;
        }

        public new BindingList<AlmacenesDTO> ListarTodos()
        {
            BindingList<Object> lista;
            lista = base.ListarTodos();
            BindingList<AlmacenesDTO> retorno = new BindingList<AlmacenesDTO>();
            foreach (AlmacenesDTO objecto in lista)
            {
                retorno.Add(objecto);
            }
            return retorno;
        }
    }                    
}
