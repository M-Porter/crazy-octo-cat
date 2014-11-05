/*
 * Check if the download function in Unzipper Class obtained the correct file
 */
package ist.fourtwelve.backend;

import java.io.File;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author phu
 */
public class DownloadJUnitTest {
    
    /*
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
    */
    
    @Test
    public void testDownloadFolder() {
        File file = new File("C:\\Users\\phu\\Documents\\NetBeansProjects\\crazy-octo-cat-master\\studentFiles");
        assertTrue(file.exists());
    }
}