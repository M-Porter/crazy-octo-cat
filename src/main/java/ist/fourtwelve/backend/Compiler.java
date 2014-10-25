package ist.fourtwelve.backend;

/**
 * Created by mporter on 9/28/14.
 */
import java.io.*;
import java.util.*;
import java.lang.ProcessBuilder.Redirect;

public class Compiler {

    private String name;
    private String classPath;
    private String studentPath;
    private String outputFileName;
    private int success;
    private String zipFile;
    private RunInfo info;
    //Debug/Output
    private String compileJavaMethodToString;

    /*
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
    public int compileJava(){
        try {
            // Makes some directories for compiling
            boolean createStudentBinName = new File(classPath).mkdirs(); //studentFiles/bin/@name
            boolean createStudentProjectName = new File(studentPath).mkdirs(); //studentFiles/projectFiles/@name
            System.out.println(classPath);
            System.out.println(studentPath);
            compileJavaMethodToString = "";
            compileJavaMethodToString += "createStudentBinName is " + createStudentBinName + "\n";
            compileJavaMethodToString += "createStudentProjectName is " + createStudentProjectName + "\n";
            /*
            Unzips the students work, into similar directories, Deletes work already in the directory.
            //TOD          */
            //Unzipper zip = new Unzipper(zipFile);
            //zip.decompress();O: The zip file gotta be the way we want it. and match the above file directories.



            ProcessBuilder pb = new ProcessBuilder("javac", "-d", classPath, studentPath + "/*.java"); //THIS ASSUMES PATHS ARE RIGHT
            System.out.println(pb.command().toString()); //Debug
            compileJavaMethodToString += "pb.command() is " + pb.command().toString() + "\n";
            //    set up output file
            File outputFile = new File(outputFileName);
            //    System.out.println(outputFileName);
            //Not sure what the delete thing does. Clears the file? Makes sure the path is correct?
            outputFile.delete();
            pb.redirectErrorStream(true);
            compileJavaMethodToString += "redirectErrorStream is " + true + "\n";
            pb.redirectOutput(Redirect.appendTo(outputFile));
            compileJavaMethodToString += "pb.redirectOutput(Redirect.appendTo(outputFile)) has run \n";
//TODO: Most of the information needs to be changed, but already this can be changed via runInfo,
            //    start javac process
            Process p = pb.start();
            compileJavaMethodToString += "pb.start() has run \n";
            //    need other processes to wait for compilation to finish
            //    basically joins the thread to the javac process to force sequential
            //    execution - need to be careful - if any process hangs, whole run hangs
            success = p.waitFor(); //Returns anything else but 1 if it doesn't run.
            compileJavaMethodToString += "success is " + success + "\n";
            assert pb.redirectInput() == Redirect.PIPE;
            assert pb.redirectOutput().file() == outputFile;
            assert p.getInputStream().read() == -1;
        }catch (IOException ioe){
            System.out.println("Compiler CompileJava IOException");
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Unknown Exception");
        }
        return success;
    }
    /*
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

    public void setDirectories(String binDir, String projectDir){
        classPath = binDir;
        studentPath = projectDir;
    }
    //TODO Access modifying methods?? Needed or not?
    public void setClassPath(String classPath){this.classPath = classPath;}
    public void setStudentPath(String studentPath){this.studentPath = studentPath;}
    public String compileJavaMethodToString(){ return compileJavaMethodToString;}
}
