package ist.fourtwelve.backend;

/**
 * Created by mporter on 9/28/14.
 */
import java.io.*;
import java.util.*;
import java.lang.ProcessBuilder.Redirect;

public class Compiler {
    private int number;
    private String name;
    private String handle;
    private String path;
    private String classPath;
    private String sourcePath;
    private String studentPath;
    private String outputFileName;
    private int success;

    public Compiler(RunInfo info) {
        name = info.studentName;
        handle = info.studentHandle;
        path = info.path;
        classPath = info.classPath;
        sourcePath = info.sourcePath;
        studentPath = info.studentPath;
        outputFileName = info.outputFileName;
        success = 1;  // Outcome of compilation, success = 0
    }

    public int compileJava(){
        try {

            String tempName = "/" + name;
            boolean createStudentDir = new File(sourcePath).mkdir(); //studentFiles
            boolean createStudentBin = new File(classPath).mkdir(); //studentFiles/bin
            boolean createStudentProject = new File(studentPath).mkdir(); //studentFiles/projectFiles
            boolean createStudentBinName = new File(classPath+tempName).mkdir(); //studentFiles/bin/@name
            boolean createStudentProjectName = new File(studentPath+tempName).mkdir(); //studentFiles/projectFiles/@name

            ProcessBuilder pb = new ProcessBuilder("javac", "-d", classPath+tempName, studentPath+tempName + "/*.java"); //THIS ASSUMES PATHS ARE RIGHT
            System.out.println(pb.command().toString()); //Debug
            //    set up output file
            File outputFile = new File(outputFileName);
            //    System.out.println(outputFileName);
            outputFile.delete();
            pb.redirectErrorStream(true);
            pb.redirectOutput(Redirect.appendTo(outputFile));

            //    start javac process
            Process p = pb.start();
            //    need other processes to wait for compilation to finish
            //    basically joins the thread to the javac process to force sequential
            //    execution - need to be careful - if any process hangs, whole run hangs
            success = p.waitFor();

            assert pb.redirectInput() == Redirect.PIPE;
            assert pb.redirectOutput().file() == outputFile;
            assert p.getInputStream().read() == -1;
        }catch (IOException ioe){
            System.out.println("Compiler CompileJava IOException");
        }catch(Exception e){
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
            File afile =new File(filePath);
            File bfile =new File(toFilePath);
            inStream = new FileInputStream(afile);
            outStream = new FileOutputStream(bfile);
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
}
