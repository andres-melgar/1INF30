package pe.pucp.transitsoft.db;


public class DBManagerMySQL extends DBManager{
    
    protected DBManagerMySQL(){
        super();
    }

    @Override
    protected String getURL() {
        String url = this.datosConexionMySQL.getTipo_de_driver().concat("://");
        url = url.concat(this.datosConexionMySQL.getNombre_de_host());
        url = url.concat(":");
        url = url.concat(this.datosConexionMySQL.getPuerto());
        url = url.concat("/");
        url = url.concat(this.datosConexionMySQL.getBase_de_datos());
        return url;
    }
    
    @Override
    public String retornarSQLParaUltimoAutoGenerado(){
        String sql = "SELECT @@LAST_INSERT_ID AS ID";
        return sql;
    }
    
}
