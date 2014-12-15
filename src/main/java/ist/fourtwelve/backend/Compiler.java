package ist.fourtwelve.backend;

import java.io.*;
import java.util.*;
import java.lang.ProcessBuilder.Redirect;

import static java.lang.Thread.sleep;

/**
 * The class Compiler compiles the classes that are to be graded
 * @author mporter
 */
public class Compiler {
    /** Name of the student being compiled*/
    private String name;
    /** Location of where the code is being compiled to*/
    private String classPath;
    /** Location of where the student source code is found.*/
    private String studentPath;
    /** Location of the ouput file*/
    private String outputFileName;
    /** Whether or not the program compiled correctly*/
    private int success;
    /** Path of where the zip file is located*/
    private String zipFile;
    /** Object containing information related to compiling and running java code.*/
    private RunInfo info;

    /**
     * Suggested constructor. Set up of the information to compiling code.
     * @param info Given object of both compiling and run information.
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
     * Compiles the java code based on the given information about the project.
     * @return Integer related to compiling successfully or not
     */
    public int compileJava(){
        try {
            // Makes some directories for compiling
            boolean createStudentBinName = new File(classPath).mkdirs(); //studentFiles/bin/@name
            boolean createStudentProjectName = new File(studentPath).mkdirs(); //studentFiles/projectFiles/@name
            Unzipper zip = new Unzipper("./"+zipFile,studentPath);
            ProcessBuilder pb = new ProcessBuilder("javac", "-d", classPath, studentPath + "/*.java");
            if(info.isJunit()){
                pb = new ProcessBuilder("javac", "-classpath", "junit-4.11.jar","-d", classPath, studentPath + "/*.java");
            }
            else {
                pb = new ProcessBuilder("javac", "-d", classPath, studentPath + "/*.java");
            }
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
     * @return {@link #success} Returns if it compiled or not in integer form.
     */
    public int getSuccess(){return success;}

}
