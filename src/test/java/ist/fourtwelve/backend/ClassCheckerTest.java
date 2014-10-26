package ist.fourtwelve.backend;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.ArrayList;


/**
 * Coded by Scott
 */
public class ClassCheckerTest {

    private ArrayList<File> files = new ArrayList<File>();
    private ArrayList<String> params = new ArrayList<String>();
    //private Unzipper unzipper = new Unzipper();
    @Before
    public void setUp() throws Exception {
        try {
            URL website = new URL("http://matthewtporter.com/files/HelloWorld.java");
            ReadableByteChannel rbc = Channels.newChannel(website.openStream());
            FileOutputStream fos = new FileOutputStream("HelloWorld.java");
            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
            website = new URL("http://matthewtporter.com/files/FirstTest.java");
            rbc = Channels.newChannel(website.openStream());
            fos = new FileOutputStream("FirstTest.java");
            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
            website = new URL("http://matthewtporter.com/files/SecondTest.java");
            rbc = Channels.newChannel(website.openStream());
            fos = new FileOutputStream("SecondTest.java");
            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);

            files.add(new File("HelloWorld.java"));
            files.add(new File("FirstTest.java"));
            files.add(new File("SecondTest.java"));

        } catch(Exception e) {
            e.printStackTrace();
            Assert.fail("Could not download or open files from URL for testing.");
        }

        params.add("ArrayList");
        params.add("boolean");
        params.add("int");

    }

    /* Couldn't get to run without error 
    @After
    
    public void cleanUp() {
    // delete extracted directory
    unzipper.delete(new File("HelloWorld.java"));
    unzipper.delete(new File("FirstTest.java"));
    unzipper.delete(new File("SecondTest.java"));
    // delete downloaded zip
    // unzipper.delete(new File("2014-09-24.zip"));
    }
    }*/

    @Test
    public void testCheckForUsages() throws Exception {
        for(File file : files) {
            try {
                ClassChecker classChecker = new ClassChecker(file);
                classChecker.checkForUsages(params);
            } catch (Exception e) {
                Assert.fail("Could not check file.");
            }
        }
    }
}
