package pe.pucp.transitsoft.util;

public class DatosConexion {

    private String driver;
    private String tipo_de_driver;
    private String base_de_datos;
    private String nombre_de_host;
    private String puerto;
    private String usuario;
    private String contraseña;

    public DatosConexion() {
        this.driver = null;
        this.tipo_de_driver = null;
        this.base_de_datos = null;
        this.nombre_de_host = null;
        this.puerto = null;
        this.usuario = null;
        this.contraseña = null;
    }

    public DatosConexion(String driver, String tipo_de_driver, String base_de_datos, String nombre_de_host, String puerto, String usuario, String contraseña) {
        this.driver = driver;
        this.tipo_de_driver = tipo_de_driver;
        this.base_de_datos = base_de_datos;
        this.nombre_de_host = nombre_de_host;
        this.puerto = puerto;
        this.usuario = usuario;
        this.contraseña = contraseña;
    }

    /**
     * @return the driver
     */
    public String getDriver() {
        return driver;
    }

    /**
     * @param driver the driver to set
     */
    public void setDriver(String driver) {
        this.driver = driver;
    }

    /**
     * @return the tipo_de_driver
     */
    public String getTipo_de_driver() {
        return tipo_de_driver;
    }

    /**
     * @param tipo_de_driver the tipo_de_driver to set
     */
    public void setTipo_de_driver(String tipo_de_driver) {
        this.tipo_de_driver = tipo_de_driver;
    }

    /**
     * @return the base_de_datos
     */
    public String getBase_de_datos() {
        return base_de_datos;
    }

    /**
     * @param base_de_datos the base_de_datos to set
     */
    public void setBase_de_datos(String base_de_datos) {
        this.base_de_datos = base_de_datos;
    }

    /**
     * @return the nombre_de_host
     */
    public String getNombre_de_host() {
        return nombre_de_host;
    }

    /**
     * @param nombre_de_host the nombre_de_host to set
     */
    public void setNombre_de_host(String nombre_de_host) {
        this.nombre_de_host = nombre_de_host;
    }

    /**
     * @return the puerto
     */
    public String getPuerto() {
        return puerto;
    }

    /**
     * @param puerto the puerto to set
     */
    public void setPuerto(String puerto) {
        this.puerto = puerto;
    }

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the contraseña
     */
    public String getContraseña() {
        return contraseña;
    }

    /**
     * @param contraseña the contraseña to set
     */
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

}
