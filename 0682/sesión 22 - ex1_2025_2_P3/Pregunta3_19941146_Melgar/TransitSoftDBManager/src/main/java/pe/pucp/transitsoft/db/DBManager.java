package pe.pucp.transitsoft.db;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import pe.pucp.transitsoft.util.Cifrado;
import pe.pucp.transitsoft.util.DatosConexion;
import pe.pucp.transitsoft.util.MotorDeBaseDeDatos;

/* TAREA: ¿Qué cambios debería hacer para que pueda soportar
           2 motores independientes de su tipo, por ejemplo
            MySQL y MySQL
            MSSQL y MSSQ
            MySQL y MSSQL
            MSSQL y Oracle
            Oracle y MySQL?
 */
public abstract class DBManager {

    private static final String ARCHIVO_CONFIGURACION_MYSQL = "jdbc.mysql.properties";
    private static final String ARCHIVO_CONFIGURACION_MSSQL = "jdbc.mssql.properties";

    private Connection conexionMySQL;
    private Connection conexionMSSQL;
    protected DatosConexion datosConexionMySQL;
    protected DatosConexion datosConexionMSSQL;
    private static DBManager dbManagerMySQL = null;
    private static DBManager dbManagerMSSQL = null;

    protected DBManager() {
        this.datosConexionMySQL = new DatosConexion();
        this.datosConexionMSSQL = new DatosConexion();
    }

    public static DBManager getInstanceMySQL() {
        if (DBManager.dbManagerMySQL == null) {
            DBManager.createInstance();
        }
        return DBManager.dbManagerMySQL;
    }

    public static DBManager getInstanceMSSQL() {
        if (DBManager.dbManagerMSSQL == null) {
            DBManager.createInstance();
        }
        return DBManager.dbManagerMSSQL;
    }

    private static void createInstance() {
        DBManager.dbManagerMySQL = new DBManagerMySQL();
        DBManager.dbManagerMSSQL = new DBManagerMSSQL();
        DBManager.dbManagerMySQL.leer_archivo_de_propiedades(MotorDeBaseDeDatos.MYSQL);
        DBManager.dbManagerMSSQL.leer_archivo_de_propiedades(MotorDeBaseDeDatos.MSSQL);
    }

    public Connection getConnectionMySQL() {
        try {
            Class.forName(this.datosConexionMySQL.getDriver());
            this.conexionMySQL = DriverManager.getConnection(getURL(), this.datosConexionMySQL.getUsuario(), Cifrado.descifrarMD5(this.datosConexionMySQL.getContraseña()));
        } catch (ClassNotFoundException | SQLException ex) {
            System.err.println("Error al generar la conexión - " + ex);
        }
        return this.conexionMySQL;
    }
    
    public Connection getConnectionMSSQL() {
        try {
            Class.forName(this.datosConexionMSSQL.getDriver());
            this.conexionMSSQL = DriverManager.getConnection(getURL(), this.datosConexionMSSQL.getUsuario(), Cifrado.descifrarMD5(this.datosConexionMSSQL.getContraseña()));
        } catch (ClassNotFoundException | SQLException ex) {
            System.err.println("Error al generar la conexión - " + ex);
        }
        return this.conexionMSSQL;
    }

    protected abstract String getURL();

    private void leer_archivo_de_propiedades(MotorDeBaseDeDatos motor) {
        Properties properties = new Properties();
        try {
            String nmArchivoConf;
            if (motor == MotorDeBaseDeDatos.MYSQL) {
                nmArchivoConf = "/" + ARCHIVO_CONFIGURACION_MYSQL;
            } else {
                nmArchivoConf = "/" + ARCHIVO_CONFIGURACION_MSSQL;
            }

            properties.load(this.getClass().getResourceAsStream(nmArchivoConf));
            if (motor == MotorDeBaseDeDatos.MYSQL) {
                this.cargarDatosDeConexion(properties, this.datosConexionMySQL);
            } else {
                this.cargarDatosDeConexion(properties, this.datosConexionMSSQL);
            }
        } catch (FileNotFoundException ex) {
            System.err.println("Error al leer el archivo de propiedades - " + ex);
        } catch (IOException ex) {
            System.err.println("Error al leer el archivo de propiedades - " + ex);
        }
    }
    
    public abstract String retornarSQLParaUltimoAutoGenerado();

    private void cargarDatosDeConexion(Properties properties, DatosConexion datosConexion) {
        datosConexion.setDriver(properties.getProperty("driver"));
        datosConexion.setTipo_de_driver(properties.getProperty("tipo_de_driver"));
        datosConexion.setBase_de_datos(properties.getProperty("base_de_datos"));
        datosConexion.setNombre_de_host(properties.getProperty("nombre_de_host"));
        datosConexion.setPuerto(properties.getProperty("puerto"));
        datosConexion.setUsuario(properties.getProperty("usuario"));
        datosConexion.setContraseña(properties.getProperty("contrasenha"));
    }
}
