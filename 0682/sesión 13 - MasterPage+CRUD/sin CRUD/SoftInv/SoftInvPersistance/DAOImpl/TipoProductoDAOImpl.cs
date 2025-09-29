using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data.Common;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using SoftInv.DAO;
using SoftInv.DAOImpl.Util;
using SoftInv.Model;

namespace SoftInv.DAOImpl
{
    public class TipoProductoDAOImpl : DAOImplBase, TipoProductoDAO
    {
        private TiposProductosDTO tipoProducto;

        public TipoProductoDAOImpl() : base("INV_TIPOS_PRODUCTOS")
        {
            this.retornarLlavePrimaria = false;
            this.tipoProducto = null;
        }

        protected override void ConfigurarListaDeColumnas()
        {
            this.listaColumnas.Add(new Columna("TIPO_PRODUCTO_ID", true, false));
            this.listaColumnas.Add(new Columna("NOMBRE", false, false));
            this.listaColumnas.Add(new Columna("DESCRIPCION", false, false));
        }

        protected override void IncluirValorDeParametrosParaObtenerPorId()
        {
            AgregarParametro("@TIPO_PRODUCTO_ID", this.tipoProducto.TipoProductoId);
        }

        protected override void InstanciarObjetoDelResultSet(DbDataReader lector)
        {
            this.tipoProducto = new TiposProductosDTO();
            this.tipoProducto.TipoProductoId = this.lector.GetInt32(0);
            this.tipoProducto.Nombre = this.lector.GetString(1);
            this.tipoProducto.Descripcion = this.lector.GetString(2);
        }

        protected override void LimpiarObjetoDelResultSet()
        {
            this.tipoProducto = null;
        }

        protected override void AgregarObjetoALaLista(IList<Object> lista, DbDataReader lector)
        {
            this.InstanciarObjetoDelResultSet(lector);
            lista.Add(this.tipoProducto);
        }

        public IList<TiposProductosDTO> ConsultarTiposDeProductos(string nombre)
        {            
            string sql = this.GenerarSQLParaConsultarTiposDeProductos();
            return base.ListarTodos(sql, this.IncluirValorDeParametrosParaConsultarVendedores, nombre)
                .Cast<TiposProductosDTO>()
                .ToList(); ;            
        }

        private string GenerarSQLParaConsultarTiposDeProductos()
        {
            string sql = "SELECT TIPO_PRODUCTO_ID, ";
            sql += "NOMBRE, ";
            sql += "DESCRIPCION ";
            sql += "FROM INV_TIPOS_PRODUCTOS ";            
            sql += "WHERE (NOMBRE LIKE @NOMBRE OR DESCRIPCION LIKE @NOMBRE)";
            return sql;
        }

        private void IncluirValorDeParametrosParaConsultarVendedores(object parametroObjeto)
        {
            string nombre = (string)parametroObjeto;
            nombre = "%" + nombre.Trim() + "%";
            this.AgregarParametro("@NOMBRE", nombre);
        }

        public TiposProductosDTO ObtenerPorId(int tipoProductoId)
        {
            this.tipoProducto = new TiposProductosDTO();
            this.tipoProducto.TipoProductoId = tipoProductoId;
            base.ObtenerPorId();
            return this.tipoProducto;
        }
    }
}
