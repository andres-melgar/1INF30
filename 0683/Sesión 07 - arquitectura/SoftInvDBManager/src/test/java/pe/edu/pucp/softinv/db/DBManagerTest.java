package pe.edu.pucp.softinv.db;

import java.sql.Connection;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DBManagerTest {
    
    public DBManagerTest() {
    }

    @Test
    public void testGetInstance() {
        //La linea de abajo no funciona pues el DBManager 
        //es un Singleton (constructor privado)
        //DBManager dbManager = new DBManager();
        System.out.println("testGetInstance");
        DBManager dbManager = DBManager.getInstance();
        assertNotNull(dbManager);
    }
    
    @Test
    public void testGetConnection() {        
        System.out.println("testGetConnection");
        DBManager dbManager = DBManager.getInstance();
        Connection conexion = dbManager.getConnection();
        assertNotNull(conexion);
    }
    
}
