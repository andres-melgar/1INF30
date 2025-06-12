package pe.edu.pucp.softpub.db;

import pe.edu.pucp.softven.db.DBManager;
import java.sql.Connection;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author andres
 */
public class DBManagerTest {
    
    
    @org.junit.jupiter.api.Test
    public void testGetInstance() {
        System.out.println("getInstance");                
        DBManager dBManager = DBManager.getInstance();
        assertNotNull(dBManager);
    }

    @org.junit.jupiter.api.Test
    public void testGetConnection() {
        System.out.println("getConnection");                
        DBManager dBManager = DBManager.getInstance();
        Connection conexion = dBManager.getConnection();
        assertNotNull(conexion);
    }
}
