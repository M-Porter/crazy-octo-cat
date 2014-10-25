package ist.fourtwelve.backend;

/**
 * Created by Steven on 9/28/2014.
 */
import javax.swing.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;


/**
 * Setup of the information related to running the program.
 * @author Steve
 *
 */
public class RunInfo {
    //Basic information; Defaults to this info if object is created without args.

    //TODO: Should these be private @attributes of run info.
    //TODO: Student/Class/Professor thing relating to what GUI was working with?
    private String studentName = "blank";
    private String studentHandle = "000000";
    private String className = "297D/";
    private String configFileName = "./configBatch.txt";
    private String path = System.getProperty("java.class.path");
    private String sourcePath = "./studentFiles";
    private String testDataPath = sourcePath; //needed?
    private String argsFileName = testDataPath + "/args.txt";
    private String testInputFileName = testDataPath + "/TestInput.txt";
    private String zipFile = studentName + ".zip";
    // Compiler information
    private String classPath;
    private String studentPath;
    private String inputFileStub;
    private String outputFileName;
    private ArrayList<String> args; //scanner inputs atm
    private String classList; //class name for the project
    private JFrame frame;
    /*
    Basic constructor, Assumes nothing special and is used for testing purposes. Defaults to above.
     */
    public RunInfo (){
        args = new ArrayList<String>();
        args.add("10 4");
        args.add("15 6");
        args.add("20 8");
        classList = "ArrayLoops";
    }//RunInfo()
    /*
    Full Constructor. For when you want to completely redo the configuration, or want to test a configuration
    @param sName Student Name for the specific directory
    @param sHandle Student Handle for grading purposes, otherwise unused atm
    @param cName Classname, Unused atm, but will be used to setup an additional directory to separate classes from each other.
    @param cFileName ConfigFileName, Where the configuration file is found for RunJava.
    @param path Path to the java directory, unused?
    @param sPath SourcePath the first layer directory of where student files are found.
    @param tDataPath Used in test runner for proper data
    @param aFileName arguments file name for a mainly used arguments for the project.
    @param testInputFileName Where the test input is found.
    */
    public RunInfo (String sName,String sHandle,String cName,String cFileName,String sPath,String aFileName,String tInputFileName){
        this.studentName = sName;
        this.studentHandle = sHandle;
        this.className = cName;
        this.configFileName = cFileName;
        this.sourcePath = sPath;
        //Does not assume the above configuration. Removal from arguments? Setup similar as above?
        this.argsFileName = aFileName;
        this.testInputFileName = tInputFileName;
        this.testDataPath = sourcePath; //needed?
        args = new ArrayList<String>();
        args.add("10 4");
        args.add("15 6");
        args.add("20 8");
        classList = "ArrayLoops";
    }//RunInfo(args)


        //TODO: Integrate Unzipper for this project. Both Batch and Single.
    /*
     * Setup the information for the single test. Does not need to compile and run inside of RunInfo.
     */
    public void singleSetup(){
//TODO: Have it read from a config file? This was copied directly from the old files.
// Setup names for compiler
        classPath = sourcePath + "/bin"; //changed new setup of directories
        studentPath = sourcePath + "/projectFiles"; // /studentFiles/projectFiles
        inputFileStub = studentPath + "/input"; // /studentFiles/projectFiles/input
        outputFileName = studentPath + "/output-" + studentName + ".txt"; // /studentFiles/projectFiles/output-'blank'.txt
        this.zipFile = studentPath + "/" + studentName + "/" + studentName + ".zip"; // zip setup
        System.out.println(zipFile);
//This ends the prep for the object to be sent to the compiler and test runner.
    }//singleSetup()
    //TODO: Remove or add missing modifying methods.
    public String getStudentName(){return studentName;}
    public String getStudentNameHandleName(){return studentHandle;}
    public String getClassName(){return className;}
    public String getConfigFileName(){return configFileName;}
    public String getSourcePath(){return sourcePath;}
    public String getArgsFileName(){return argsFileName;}
    public String getTestInputFileName(){return testInputFileName;}
    public String getZipFile(){return zipFile;}
    public String getClassPath(){return classPath;}
    public String getStudentPath(){return studentPath;}
    public ArrayList<String> getArgs(){return args;}
    public String getClassList(){return classList;}
    public String getOutputFileName(){return outputFileName;}
    public String getInputFileStub(){return inputFileStub;}
    public JFrame getFrame(){return frame;}
    public void setFrame(JFrame x){this.frame = x;}
    public void setInputFileStub(String x){this.inputFileStub = x + "/input";}
    public void setArgs(ArrayList<String> x){this.args = x;}
    public void setClassList(String x){this.classList = x;}
    public void setClassPath(String x){this.classPath = x + "/bin";} // You give it the src path
    public void setStudentPath(String x){this.studentPath = x + "/projectFiles" ;} // You give it the src path
    public void setStudentName(String x){this.studentName = x;}
    public void setOutputFileName(String x){this.outputFileName =x;}
    public void setStudentHandle(String x){this.studentHandle = x;}
    public void setClassName(String x){this.className = x;}
    public void setConfigFileName(String x){this.configFileName = x;}
    public void setSourcePath(String x){this.sourcePath = x;}
    public void setArgsFileName(String x){this.argsFileName = x;}
    public void setTestInputFileName(String x){this.testInputFileName = x;}
    public void setZipFile (String x){this.zipFile = x;}
}//RunInfo