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
            AgregarParametro("@ALMACEN_ID", this.almacen.AlmacenId);
            AgregarParametro("@NOMBRE", this.almacen.Nombre);
            AgregarParametro("@ALMACEN_CENTRAL", (bool)this.almacen.AlmacenCentral ? 1 : 0);
        }
    
        protected override void IncluirValorDeParametrosParaEliminacion()
        {
            AgregarParametro("@ALMACEN_ID", this.almacen.AlmacenId);
        }

        protected override void IncluirValorDeParametrosParaObtenerPorId()
        {
            AgregarParametro("@ALMACEN_ID", this.almacen.AlmacenId);
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

        protected override void AgregarObjetoALaLista(IList<Object> lista, DbDataReader lector)
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

        public new IList<AlmacenesDTO> ListarTodos()
        {
            return base.ListarTodos()
               .Cast<AlmacenesDTO>()  
               .ToList();
        }
    }                    
}
