package pe.pucp.transitsoft.db;

public class DBManagerMSSQL extends DBManager {

    protected DBManagerMSSQL() {
        super();
    }

    @Override
    protected String getURL() {
        String url = this.datosConexionMSSQL.getTipo_de_driver().concat("://");
        url = url.concat(this.datosConexionMSSQL.getNombre_de_host());
        url = url.concat(":");
        url = url.concat(this.datosConexionMSSQL.getPuerto());
        url = url.concat(";");
        url = url.concat("databaseName=" + this.datosConexionMSSQL.getBase_de_datos());
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
