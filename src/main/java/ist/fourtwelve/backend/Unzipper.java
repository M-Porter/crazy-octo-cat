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

import java.nio.file.*;

import static java.lang.Thread.sleep;
import static java.nio.file.StandardCopyOption.*;

/**
 * Created by mporter on 9/28/14.
 * Modified by jrittle on 10/22/14.
 * Unzipper is used to unzip the student files 
 */
public class Unzipper {
    
    private String argFile;
    private String outputDir;

    /**
     * Constructor used to simply unzip a file.
     * Given a name of the current date
     * @param passedZipFile
     * @throws IOException
     */
    public Unzipper(String passedZipFile) throws IOException {
        //filename for the file to be unzipped
        this.argFile = passedZipFile;

        //string holding default output folder name based off of date
        this.outputDir = new SimpleDateFormat("yyyy-MM-dd").format(new Date());

        //start the decompression
        decompress();
    }

    /**
     * Preferred Constructor
     * Constructor to allow for a custom output directory.
     * @param passedZipFile Zip file needs a specific setup. If the java file is simply on the top directory of the zip file it fails. If it is within another folder, it works correctly. e.g. zip.zip/zip/*.java
     * @param passedOutputDir
     * @throws IOException
     */
    public Unzipper(String passedZipFile, String passedOutputDir) throws IOException {
        //filename for the file to be unzipped
        this.argFile = passedZipFile;

        //string holding custom output directory path
        this.outputDir = passedOutputDir;

        //start the decompression
        try{
            decompress();
        }catch(Exception ex){
                System.out.println("here: "+currentEntryName);
            ex.printStackTrace();
        }
    }

    /**
     * Method decompresses the specified zip file
     * @throws IOException
     */
    public void decompress() throws IOException {

        ZipFile zipFile = new ZipFile(this.argFile);
        Enumeration<?> enu = zipFile.entries();

        //loop over the enumeration elements and process each zipped entity
        while (enu.hasMoreElements()) {

            ZipEntry zipEntry = (ZipEntry) enu.nextElement();

            String currentEntryName = zipEntry.getName();

            /*Force it to make a directory with the last '/' "*/
            String dir = currentEntryName.substring(0,currentEntryName.lastIndexOf('/'));
            File temp = new File(dir);
            temp.mkdirs();

            System.out.println("Zip Entry =" + currentEntryName);
            long size = zipEntry.getSize();
            long compressedSize = zipEntry.getCompressedSize();

            //ignoring extraneous data included by an unzip on OSX
            if(!currentEntryName.contains("__MACOSX")) {
                System.out.printf("name: %-32s | size: %6d | compressed size: %6d\n",
                        currentEntryName, size, compressedSize);
            }

            //create a directory if the current element is a directory
            File file = new File(currentEntryName);
            if (currentEntryName.endsWith("/")) {
                file.mkdirs();
                continue;
            }else if (currentEntryName.endsWith(".zip")){
                Unzipper innerUnzipper = new Unzipper(currentEntryName, "./");
            }

            //write the current zipped element to an unzipped element
            InputStream is = zipFile.getInputStream(zipEntry);
            FileOutputStream fos = new FileOutputStream(file);
            byte[] bytes = new byte[1024];
            int length;

            while ((length = is.read(bytes)) >= 0) {
                fos.write(bytes, 0, length);
            }

            //close io file streams
            is.close();
            fos.close();

        }

        //close zip filestream
        zipFile.close();

        // for mac purposes only, if this directory exists, delete it
        if(System.getProperty("os.name").toLowerCase().contains("mac")) {
            File newFile = new File("__MACOSX");
            if(newFile.isDirectory()) delete(new File("__MACOSX"));
        }

        //move unzipped content into a specified directory
        moveUnzippedContent();

    }



    /**
     * Method deletes a file if exists.
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

    /**
     * Method copies content from the directory created during unzipping
     * to a specified directory and then deletes the initial directory
     */
    public void moveUnzippedContent(){
        try{

            //get the name of the zip file.
            // .length()-4 is to remove the '.zip' extension
            String inputFolderStr = argFile.substring(0, (argFile.length()-4));

            //file handles for the input and output folders to be used in creating paths
            File inputFolder = new File(inputFolderStr);
            File outputFolder = new File(this.outputDir);

            //create the output directory
            outputFolder.mkdirs();

            //iterate over the unzipped files and copy them into the output directory
            if (inputFolder.isDirectory()){
                for (File c : inputFolder.listFiles()){
                    Path inPath = FileSystems.getDefault().getPath(inputFolderStr, c.getName());
                    Path outPath = FileSystems.getDefault().getPath(this.outputDir, c.getName());
                    Files.copy(inPath, outPath, REPLACE_EXISTING);

                    System.out.println("inpath: "+inPath);
                    System.out.println("outpath: "+outPath);
                }
            }else{
                Path inPath = FileSystems.getDefault().getPath("", inputFolder.getName());
                Path outPath = FileSystems.getDefault().getPath(this.outputDir, inputFolderStr);
                Files.copy(inPath, outPath, REPLACE_EXISTING);

                System.out.println("inpath: "+inPath);
                System.out.println("outpath: "+outPath);
            }
            //deletes the initial unzipped folder
            delete(inputFolder);

        }catch (IOException ex){
            System.out.println("IOException in moveUnzippedContent. MSG: "+ex);
            ex.printStackTrace();
        }
    }
}
