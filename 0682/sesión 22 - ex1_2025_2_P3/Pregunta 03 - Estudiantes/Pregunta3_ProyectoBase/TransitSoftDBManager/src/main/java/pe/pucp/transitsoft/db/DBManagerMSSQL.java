package pe.pucp.transitsoft.db;

public class DBManagerMSSQL extends DBManager {

    protected DBManagerMSSQL() {
        
    }

    @Override
    protected String getURL() {
        String url = this.tipo_de_driver.concat("://");
        url = url.concat(this.nombre_de_host);
        url = url.concat(":");
        url = url.concat(this.puerto);
        url = url.concat(";");
        url = url.concat("databaseName=" + this.base_de_datos);
        url = url.concat(";encrypt=false");
        System.out.println(url);
        return url;
    }
    
    @Override
    public String retornarSQLParaUltimoAutoGenerado(){
        String sql = "SELECT @@IDENTITY AS ID";
        return sql;
    }
    
}
