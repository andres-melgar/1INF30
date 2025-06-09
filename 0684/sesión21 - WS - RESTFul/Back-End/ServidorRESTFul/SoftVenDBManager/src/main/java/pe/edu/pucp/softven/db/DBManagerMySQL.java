package pe.edu.pucp.softven.db;

public class DBManagerMySQL extends DBManager {

    protected DBManagerMySQL() {
        //
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
        url = url.concat("?useSSL=false");
        return url;
    }

    @Override
    public String retornarSQLParaUltimoAutoGenerado() {
        String sql = "select @@last_insert_id as id";
        return sql;
    }
}
