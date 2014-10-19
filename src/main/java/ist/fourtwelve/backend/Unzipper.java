package ist.fourtwelve.backend;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * Created by mporter on 9/28/14.
 */
public class Unzipper {

    private String argFile;
    private String outputDir;
    private String varToString;

    /**
     * Preferred constructor for project.
     * @param zipFile
     * @throws IOException
     */
    public Unzipper(String zipFile) throws IOException {
        this.argFile = zipFile;
        this.outputDir = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }

    /**
     * Constructor to allow for a custom output directory.
     * @param zipFile
     * @param outputDir
     * @throws IOException
     */
    public Unzipper(String zipFile, String outputDir) throws IOException {
        this.argFile = zipFile;
        this.outputDir = outputDir;
        varToString = "argFile is " + zipFile + "\n" + "outputDir is " + outputDir + "\n";
    }

    /**
     *
     * @throws IOException
     */
    public void decompress() throws IOException {

        ZipFile zipFile = new ZipFile(argFile);
        Enumeration<?> enu = zipFile.entries();

        while (enu.hasMoreElements()) {

            ZipEntry zipEntry = (ZipEntry) enu.nextElement();

            String name = zipEntry.getName();

            long size = zipEntry.getSize();
            long compressedSize = zipEntry.getCompressedSize();

            if(!name.contains("__MACOSX")) {
                System.out.printf("name: %-32s | size: %6d | compressed size: %6d\n",
                        name, size, compressedSize);
                varToString += "name: " + name + " | size: " + size + " | compressed size: " + compressedSize + "\n";
                //System.out.println("varToString is \n" + varToString);
            }

            File file = new File(name);
            if (name.endsWith("/")) {
                file.mkdirs();
                continue;
            }

            InputStream is = zipFile.getInputStream(zipEntry);
            FileOutputStream fos = new FileOutputStream(file);
            byte[] bytes = new byte[1024];
            int length;

            while ((length = is.read(bytes)) >= 0) {
                fos.write(bytes, 0, length);
        }

            is.close();
            fos.close();

        }

        zipFile.close();

        // for mac purposes only, if this directory exists, delete it
        if(System.getProperty("os.name").toLowerCase().contains("mac")) {
            File newFile = new File("__MACOSX");
            if(newFile.isDirectory()) delete(new File("__MACOSX"));
        }

    }

    /**
     * Method deletes director if exists.
     * @param f
     */
    public void delete(File f) {
        if(f.isDirectory()) {
            for(File c : f.listFiles()) {
                delete(c);
            }
        }
        if(!f.delete()) {
            System.out.println("Failed to delete " + f);
        }
    }
    public String toString()
    {
        return varToString;
    }

}
