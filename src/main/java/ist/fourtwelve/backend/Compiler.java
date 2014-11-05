package ist.fourtwelve.backend;

import java.io.*;
import java.util.*;
import java.lang.ProcessBuilder.Redirect;

/**
 * The class Compiler compiles the classes that are to be graded
 * @author mporter
 */
public class Compiler {
    /** Name is the name of the class that is to be compiled*/
    private String name;
    /** {@link RunInfo#classPath}, is the location where the code is compiled to*/
    private String classPath;
    /** studentPath is the location where the source code is found*/
    private String studentPath;
    /** outputFileName outputFileName is the location of the output file*/
    private String outputFileName;
    /** success success is the integer that holds a certain value depending on whether or not the class has complied succesfully*/
    private int success;
    /** zipFile is the path of the zipfile that contains the student classes*/
    private String zipFile;
    /** info contains the run info for the class*/
    private RunInfo info;
    /**
    Constructor, needs a RunInfo object to initialize this object.
    @param info current information about the compile.
     */
    public Compiler(RunInfo info) {
        name = info.getStudentName();
        classPath = info.getClassPath() + "/" + name;
        studentPath = info.getStudentPath() + "/" + name;
        outputFileName = info.getOutputFileName();
        zipFile = info.getZipFile();
        this.info = info;
        success = 1;  // Outcome of compilation, success = 0
    }
    /**
     * compileJava is the method that compiles the classes that are to be graded 
     * @return     the method returns the variable success, which depending on the value of the variable indicates whether or not the compile was successful
     */
    public int compileJava(){
        try {
            // Makes some directories for compiling
            boolean createStudentBinName = new File(classPath).mkdirs(); //studentFiles/bin/@name
            boolean createStudentProjectName = new File(studentPath).mkdirs(); //studentFiles/projectFiles/@name
            Unzipper zip = new Unzipper("./"+zipFile,studentPath);

            ProcessBuilder pb = new ProcessBuilder("javac", "-d", classPath, studentPath + "/*.java");
            System.out.println(pb.command().toString()); //Debug
            File outputFile = new File(outputFileName);// set up output file
            //Not sure what the delete thing does. Clears the file? Makes sure the path is correct? Pretty sure just clears the file though
            outputFile.delete();
            pb.redirectErrorStream(true);
            pb.redirectOutput(Redirect.appendTo(outputFile));
            //    start javac process
            Process p = pb.start();
            success = p.waitFor(); //Returns anything else but 1 if it doesn't run.
            assert pb.redirectInput() == Redirect.PIPE;
            assert pb.redirectOutput().file() == outputFile;
            assert p.getInputStream().read() == -1;
        }catch (IOException ioe){
            System.out.println("Compiler CompileJava IOException");
            ioe.printStackTrace();
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Compiler Unhandled Exception");
        }
        return success;
    }
    /**
    Probably shouldn't be here but moves a file from one location to the next.
    @param filePath Current file in a directory
    @param toFilePath Desired destination for the first file.
     */
    public void moveFile(String filePath, String toFilePath){
        InputStream inStream = null;
        OutputStream outStream = null;
        try{
            //Setup
            File afile =new File(filePath);
            File bfile =new File(toFilePath);
            inStream = new FileInputStream(afile);
            outStream = new FileOutputStream(bfile);
            //1MB Buffer
            byte[] buffer = new byte[1024];
            int length;
            //copy the file content in bytes
            while ((length = inStream.read(buffer)) > 0){
                outStream.write(buffer, 0, length);
            }
            inStream.close();
            outStream.close();
            //delete the original file
            afile.delete();
            System.out.println("File is copied successful!");
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    /**
     * Gets whether or not the program compiled
     * @return Returns if it compiled or not in integer form.
     */
    public int getSuccess(){return success;}

}
