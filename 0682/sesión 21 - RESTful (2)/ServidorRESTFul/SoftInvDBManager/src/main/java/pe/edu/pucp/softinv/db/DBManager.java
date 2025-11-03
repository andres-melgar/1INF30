package pe.edu.pucp.softinv.db;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import pe.edu.pucp.softinv.db.util.Cifrado;
import pe.edu.pucp.softinv.db.util.MotorDeBaseDeDatos;

public abstract class DBManager {

    private static final String ARCHIVO_CONFIGURACION = "jdbc.properties";    

    private Connection conexion;
    private String driver;
    protected String tipo_de_driver;
    protected String base_de_datos;
    protected String nombre_de_host;
    protected String puerto;
    private String usuario;
    private String contraseña;
    private static DBManager dbManager = null;
    
    protected DBManager(){
        //constructor protegido para evitar que se creen instancias.
        //Solo se podrá crear una instancia y esta debe hacerse usando el 
        //método getInstance()
    }

    public static DBManager getInstance() {
        if (DBManager.dbManager == null) {
            DBManager.createInstance();
        }
        return DBManager.dbManager;
    }

    private static void createInstance() {
        if (DBManager.dbManager == null) {     
            if (DBManager.obtenerMotorDeBaseDeDatos()==MotorDeBaseDeDatos.MYSQL)
                DBManager.dbManager = new DBManagerMySQL();
            else
                DBManager.dbManager = new DBManagerMSSQL();
            DBManager.dbManager.leer_archivo_de_propiedades();
        }
    }

    public Connection getConnection() {
        try {            
            Class.forName(this.driver);
            //System.out.println(this.usuario);
            //System.out.println(this.contraseña);
            //System.out.println(Cifrado.descifrarMD5(this.contraseña));
            this.conexion = DriverManager.getConnection(getURL(), this.usuario, Cifrado.descifrarMD5(this.contraseña));
        } catch (ClassNotFoundException | SQLException ex) {
            System.err.println("Error al generar la conexión - " + ex);
        }
        return conexion;
    }

    protected abstract String getURL();
    
    public abstract String retornarSQLParaUltimoAutoGenerado();

    private void leer_archivo_de_propiedades() {
        Properties properties = new Properties();
        try {
            //el siguiente código ha sido probado en MAC
            //el archivo de configuración se encuentra en la carpeta src/main/resources/jdbc.properties            
            String nmArchivoConf = "/" + ARCHIVO_CONFIGURACION;

            properties.load(this.getClass().getResourceAsStream(nmArchivoConf));
            this.driver = properties.getProperty("driver");
            this.tipo_de_driver = properties.getProperty("tipo_de_driver");
            this.base_de_datos = properties.getProperty("base_de_datos");
            this.nombre_de_host = properties.getProperty("nombre_de_host");
            this.puerto = properties.getProperty("puerto");
            this.usuario = properties.getProperty("usuario");
            this.contraseña = properties.getProperty("contrasenha");
        } catch (FileNotFoundException ex) {
            System.err.println("Error al leer el archivo de propiedades - " + ex);
        } catch (IOException ex) {
            System.err.println("Error al leer el archivo de propiedades - " + ex);
        }
    }
    
    private static MotorDeBaseDeDatos obtenerMotorDeBaseDeDatos() {
        Properties properties = new Properties();
        try {
            //el siguiente código ha sido probado en MAC
            //el archivo de configuración se encuentra en la carpeta src/main/resources/jdbc.properties            
            String nmArchivoConf = "/" + ARCHIVO_CONFIGURACION;

            properties.load(DBManager.class.getResourceAsStream(nmArchivoConf));            
            String tipo_de_driver = properties.getProperty("tipo_de_driver");
            if (tipo_de_driver.equals("jdbc:mysql"))
                return MotorDeBaseDeDatos.MYSQL;
            else
                return MotorDeBaseDeDatos.MSSQL;
        } catch (FileNotFoundException ex) {
            System.err.println("Error al leer el archivo de propiedades - " + ex);
        } catch (IOException ex) {
            System.err.println("Error al leer el archivo de propiedades - " + ex);
        }
        return null;
    }
}
