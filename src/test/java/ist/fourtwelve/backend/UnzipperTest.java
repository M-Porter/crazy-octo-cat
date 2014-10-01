package ist.fourtwelve.backend;

import org.junit.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class UnzipperTest {

    private String zipURL;
    private String fileName;
    private Unzipper unzipper;

    @Before
    public void startUp() throws IOException {

        zipURL = "http://matthewtporter.com/files/2014-09-24.zip";
        fileName = zipURL.substring(zipURL.lastIndexOf('/') + 1);

        // check if file already downloaded
        // if so, skip downloading
        File newFile = new File(fileName);
        if(!newFile.exists()) {
            URL website = new URL(zipURL);
            ReadableByteChannel rbc = Channels.newChannel(website.openStream());
            FileOutputStream fos = new FileOutputStream("2014-09-24.zip");
            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
        }

        // create new unzipper
        try {
            unzipper = new Unzipper(fileName);
        } catch(Exception e) {
            org.junit.Assert.fail("Could not download or open .zip from URL for testing.");
        }

    }

    @Test
    public void testDecompression() {

        try {
            // download and decompress zip
            unzipper.decompress();
        } catch (IOException e) {
            org.junit.Assert.fail("Unzipping failed. See stack trace.");
        }

    }

    @After
    public void cleanUp() {
        // delete extracted directory
        unzipper.delete(new File("2014-09-24"));
        // delete downloaded zip
        // unzipper.delete(new File("2014-09-24.zip"));
    }

}