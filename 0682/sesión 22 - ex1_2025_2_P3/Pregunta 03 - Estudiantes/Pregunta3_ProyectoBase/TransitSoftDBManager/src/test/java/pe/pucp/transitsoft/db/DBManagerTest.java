package pe.pucp.transitsoft.db;

import java.sql.Connection;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class DBManagerTest {
    
    @Test
    public void testGetInstance() {
        System.out.println("getInstance");                
        DBManager dBManager = DBManager.getInstance();
        assertNotNull(dBManager);
    }

    @Test
    public void testGetConnection() {
        System.out.println("getConnection");                
        DBManager dBManager = DBManager.getInstance();
        Connection conexion = dBManager.getConnection();
        assertNotNull(conexion);
    }
}
