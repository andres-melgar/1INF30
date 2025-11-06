package pe.pucp.transitsoft.db;


public class DBManagerMySQL extends DBManager{
    
    protected DBManagerMySQL(){
        
    }

    @Override
    protected String getURL() {
        String url = this.tipo_de_driver.concat("://");
        url = url.concat(this.nombre_de_host);
        url = url.concat(":");
        url = url.concat(this.puerto);
        url = url.concat("/");
        url = url.concat(this.base_de_datos);
        return url;
    }
    
    @Override
    public String retornarSQLParaUltimoAutoGenerado(){
        String sql = "SELECT @@LAST_INSERT_ID AS ID";
        return sql;
    }
    
}
