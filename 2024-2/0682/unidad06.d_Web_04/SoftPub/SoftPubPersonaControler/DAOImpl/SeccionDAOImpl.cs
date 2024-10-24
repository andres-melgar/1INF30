﻿using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using MySql.Data.MySqlClient;
using SoftPubDBManager;
using SoftPubPersonaControler.DAO;
using SoftPubPersonaModel;

namespace SoftPubPersonaControler.DAOImpl
{
    public class SeccionDAOImpl : DAOImplBase, SeccionDAO
    {
        private Seccion seccion;

        public SeccionDAOImpl() : base("Seccion")
        {
            this.seccion = null;
        }

        public int insertar(Seccion seccion)
        {
            this.seccion = seccion;
            return base.insertar();
        }

        protected override string obtenerListaAtributosParaInsercion()
        {
            return "idSeccion, seccion, departamento";
        }

        protected override string incluirListaParametrosParaInsercion()
        {
            return "@idSeccion, @seccion, @departamento";
        }

        protected override void incluirValorParametrosParaInsercion()
        {
            this.Comando.Parameters.AddWithValue("@idSeccion", this.seccion.IdSeccion);
            this.Comando.Parameters.AddWithValue("@seccion", this.seccion.Nombre_Seccion);
            this.Comando.Parameters.AddWithValue("@departamento", this.seccion.Departamento);
        }

        public int modificar(Seccion seccion)
        {
            this.seccion = seccion;
            return base.modificar();
        }

        protected override string obtenerListaAtributosParaModificacion()
        {
            return "seccion=@seccion, departamento=@departamento";
        }

        protected override void incluirValorParametrosParaModificacion()
        {
            this.Comando.Parameters.AddWithValue("@idSeccion", this.seccion.IdSeccion);
            this.Comando.Parameters.AddWithValue("@seccion", this.seccion.Nombre_Seccion);
            this.Comando.Parameters.AddWithValue("@departamento", this.seccion.Departamento);
        }        

        public int eliminar(Seccion seccion)
        {
            this.seccion = seccion;
            return base.eliminar();
        }

        protected override string obtenerPredicadoParaLlavePrimaria()
        {
            return "idSeccion = @idSeccion";
        }

        protected override void incluirValorParametrosParaEliminacion()
        {
            this.Comando.Parameters.AddWithValue("@idSeccion", this.seccion.IdSeccion);
        }

        public BindingList<Object> listarTodos()
        {
            return base.listarTodos(null);
        }

        protected override void agregarObjetoALaLista(BindingList<object> lista, MySqlDataReader lector)
        {
            this.instanciarObjetoDelResultSet(this.Lector);
            lista.Add(this.seccion);
        }

        protected override string obtenerProyeccionParaSelect()
        {
            return "idSeccion, seccion, departamento";
        }

        public Seccion obtenerPorId(string idSeccion)
        {
            Seccion seccion = new Seccion();
            seccion.IdSeccion = idSeccion;
            this.seccion = seccion;
            base.obtenerPorId();
            return this.seccion;
        }

        protected override void incluirValorParametrosParaObtenerPorId()
        {
            this.Comando.Parameters.AddWithValue("@idSeccion", this.seccion.IdSeccion);
        }

        protected override void instanciarObjetoDelResultSet(MySqlDataReader lector)
        {
            this.seccion = new Seccion();
            this.seccion.IdSeccion = lector.GetString("idSeccion");
            this.seccion.Nombre_Seccion = lector.GetString("seccion");
            this.seccion.Departamento = lector.GetString("departamento");
        }

        protected override void limpiarObjetoDelResultSet()
        {
            this.seccion = null;
        }             
    }
}
