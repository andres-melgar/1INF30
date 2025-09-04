package pe.edu.pucp.softinv.db;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class DBManager {

    private static final String ARCHIVO_CONFIGURACION = "jdbc.properties";
        
    private Connection conexion;
    private String driver;
    private String tipo_de_driver;
    private String base_de_datos;
    private String nombre_de_host;
    private String puerto;
    private String usuario;
    private String contraseña;
    
    private static DBManager dbManager = null;
    
    private DBManager(){
        //No hace nada el constructor
    }
    
    public static DBManager getInstance(){
        if (DBManager.dbManager == null){
            DBManager.createInstance();
        }
        return DBManager.dbManager;
    }
    
    private static void createInstance() {
        if (DBManager.dbManager == null){
            DBManager.dbManager = new DBManager();
            DBManager.dbManager.leer_archivo_de_propiedades();
        }
    }
    
    private void leer_archivo_de_propiedades() {
        // El archivo se encuentra en la carpeta de resources
        // por eso se agrega el /
        String nmArchivoConf = "/" + ARCHIVO_CONFIGURACION;
        
        Properties properties = new Properties();
        try {
            properties.load(this.getClass().getResourceAsStream(nmArchivoConf));
            this.driver = properties.getProperty("driver");
            this.tipo_de_driver = properties.getProperty("tipo_de_driver");
            this.base_de_datos = properties.getProperty("base_de_datos");
            this.nombre_de_host = properties.getProperty("nombre_de_host");
            this.puerto = properties.getProperty("puerto");
            this.usuario = properties.getProperty("usuario");
            this.contraseña = properties.getProperty("contrasenha");
        } catch (IOException ex) {
            System.getLogger(DBManager.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
                
    }
    
    public Connection getConnection(){
        try {
            Class.forName(this.driver);
            this.conexion = DriverManager.getConnection(this.getURL(), this.usuario, this.contraseña);
        } catch (ClassNotFoundException ex) {
            System.getLogger(DBManager.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        } catch (SQLException ex) {
            System.getLogger(DBManager.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
        return this.conexion;
    }

    private String getURL() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
