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
    public class VendedorDAOImpl : DAOImplBase, VendedorDAO
    {
        private VendedoresDTO vendedor;

        public VendedorDAOImpl(): base("VEN_VENDEDORES")
        {
            this.retornarLlavePrimaria = true;
            this.vendedor = null;
        }

        protected override void ConfigurarListaDeColumnas()
        {
            // no lo implementaré pues ejecutaré una consulta diferente
        }

        protected override void InstanciarObjetoDelResultSet(DbDataReader lector)
        {
            TiendasDTO tienda = new TiendasDTO();
            tienda.TiendaId = this.lector.GetInt32(0);
            tienda.Nombre = this.lector.GetString(1);

            this.vendedor = new VendedoresDTO();
            this.vendedor.VendedorId = this.lector.GetInt32(2);
            this.vendedor.Paterno = this.lector.GetString(3);
            this.vendedor.Materno = this.lector.GetString(4);
            this.vendedor.Nombre = this.lector.GetString(5);
            this.vendedor.Tienda = tienda;
        }

        protected override void LimpiarObjetoDelResultSet()
        {
            this.vendedor = null;
        }

        protected override void AgregarObjetoALaLista(BindingList<Object> lista, DbDataReader lector)
        {
            this.InstanciarObjetoDelResultSet(lector);
            lista.Add(this.vendedor);
        }

        public BindingList<VendedoresDTO> ConsultarVendedores(int tiendaId, string nombres)
        {
            BindingList<Object> lista;
            string sql = this.GenerarSQLParaConsultaVendedores();
            VendedorParametro parametro = new VendedorParametro(tiendaId, nombres);            
            lista = base.ListarTodos(sql, this.incluirValorDeParametroParaConsultaDeVendedores, parametro);
            BindingList<VendedoresDTO> retorno = new BindingList<VendedoresDTO>();
            foreach (VendedoresDTO objecto in lista)
            {
                retorno.Add(objecto);
            }
            return retorno;
        }

        private string GenerarSQLParaConsultaVendedores()
        {
            string sql = "SELECT t.TIENDA_ID, ";
            sql += "t.NOMBRE AS NOMBRE_TIENDA, ";
            sql += "v.VENDEDOR_ID, ";
            sql += "v.PATERNO, ";
            sql += "v.MATERNO, ";
            sql += "v.NOMBRES ";
            sql += "FROM VEN_VENDEDORES v ";
            sql += "JOIN VEN_TIENDAS t ON ";
            sql += "T.TIENDA_ID = v.TIENDA_ID ";
            sql += "WHERE (0 = @TIENDA_ID OR v.TIENDA_ID = @TIENDA_ID) ";
            sql += "AND (v.PATERNO LIKE @NOMBRES OR v.MATERNO LIKE @NOMBRES OR v.NOMBRES LIKE @NOMBRES)";
            return sql;
        }

       private void incluirValorDeParametroParaConsultaDeVendedores(object vendedorParametroObjeto)
        {
            VendedorParametro vendedorParametro = (VendedorParametro)vendedorParametroObjeto;
            this.AgregarParametro("@TIENDA_ID", vendedorParametro.TiendaId);
            this.AgregarParametro("@NOMBRES", vendedorParametro.Nombres);
        }
        
    }
}
