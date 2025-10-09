using System;
using System.Collections.Generic;
using System.Data.Common;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using MySql.Data.MySqlClient;

namespace SoftInv.Db
{
    public class DBManagerMySQL: DBManager
    {
        private DBManagerMySQL()
        {
            //construtor ocultado que no se puedan crear instancias desde fuera de la clase
        }

        public static void CreateConcreteInstance()
        {
            if (DBManager.dbManager == null)
                DBManager.dbManager = new DBManagerMySQL();
        }

        protected override void RealizarConexionABaseDeDatos(string cadenaDeConexion)
        {
            this.conexion = new MySqlConnection(cadenaDeConexion);
        }

        protected override string ObtenerCadenaDeConexion()
        {
            MySqlConnectionStringBuilder csBuilder = new MySqlConnectionStringBuilder()
            {
                Server = $"{this.nombreDeHost},{this.puerto}",
                Database = this.baseDeDatos,
                UserID = this.usuario,
                Password = DBManager.Descifrar(this.contraseña)
            };

            return csBuilder.ConnectionString;
        }

        public override DbCommand CrearComando()
        {
            return new MySqlCommand();
        }

        public override string RetornarSQLParaUltimoAutoGenerado()
        {
            string sql = "SELECT @@LAST_INSERT_ID AS ID";
            return sql;
        }
    }
}
