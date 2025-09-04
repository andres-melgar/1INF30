package pe.edu.pucp.softinv.db;

import java.sql.Connection;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class DBManagerTest {
    
    public DBManagerTest() {
    }

    @org.junit.jupiter.api.Test
    public void testGetInstance() {
        //Lo comentado no se puede hacer porque el constructor es privado
        //DBManager dbManager = new DBManager();
        System.out.println("getInstance");
        DBManager dbManager = DBManager.getInstance();
        assertNotNull(dbManager);
        
    }
    
    @org.junit.jupiter.api.Test
    public void testGetConnection() {        
        System.out.println("getConnection");
        DBManager dbManager = DBManager.getInstance();
        Connection conexion = dbManager.getConnection();
        assertNotNull(conexion);       
    }

}
