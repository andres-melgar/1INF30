package pe.edu.pucp.softinv.db;

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
        //System.out.println(url);
        return url;
    }

    @Override
    public String retornarSQLParaUltimoAutoGenerado() {
        return "select @@last_insert_id as id";
    }
}
