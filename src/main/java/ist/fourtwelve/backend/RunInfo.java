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
    
    /** studentName is the name of the student whose files are being graded */
    private String studentName = "blank";
    /** studentHandle is the ID of the student */
    private String studentHandle = "000000";
    /** className is the name of the student's class and is set to 297D by default*/
    private String className = "297D/";
    /** ConfigFileName is something that isn't used anymore */
    private String configFileName = "./configBatch.txt";
    /** path is the location of the files on the computer */
    private String path = System.getProperty("java.class.path");
    /** sourcePath is the location of the source files on the computer */
    private String sourcePath = "./studentFiles";
    /** testDataPath is the location of the test data on the computer*/
    private String testDataPath = sourcePath; //needed?
    /** argsFileName is the name of the arguement files */
    private String argsFileName = testDataPath + "/args.txt";
    /** testInputFileName is the name of the input files using testing */
    private String testInputFileName = testDataPath + "/TestInput.txt";
    /** zipFile is the name of the student zipfile */
    private String zipFile = studentName + ".zip";
    // Compiler information
    /** classPath is the location of a class on the computer */
    private String classPath;
    /** student path is the location of the student files on the computer */
    private String studentPath;
    /** inputFileName is the name of the directory where the student java files are found */
    private String inputFileStub;
    /** outputFileName is the name of the output file */
    private String outputFileName;
    /** args is an arraylist of arguments */
    private ArrayList<String> args; //scanner inputs atm
    private ArrayList<String> scannerInputs;
    private String classList; //class name for the project
    private JFrame frame;
    /**
    Basic constructor, Assumes nothing special and is used for testing purposes. Defaults to above, testing purposes only.
     */
    public RunInfo (){
        args = new ArrayList<String>();
        args.add("10 4");
        args.add("15 6");
        args.add("20 8");
        classList = "ArrayLoops";
    }//RunInfo()
    /**
    * Full Constructor. For when you want to completely redo the configuration, or want to test a configuration
    * @param sName Student Name for the specific directory
    * @param sHandle Student Handle for grading purposes, otherwise unused atm
    * @param cName Classname, Unused atm, but will be used to setup an additional directory to separate classes from each other.
    * @param cFileName ConfigFileName, Where the configuration file is found for RunJava.
    * @param sPath SourcePath the first layer directory of where student files are found.
    * @param aFileName arguments file name for a mainly used arguments for the project.
    * @param tInputFileName Where the test input is found.
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
    //TODO: Remove or add missing modifying methods.
    /**
     * Gets the string {@link #studentName}
     * @return {@link #studentName} the current student name for this run.
     */
    public String getStudentName(){return studentName;}
    /**
     * Gets the string {@link #studentHandle}
     * @return {@link #studentHandle} the current student handle being used for this run
     */
    public String getStudentNameHandleName(){return studentHandle;}
    /**
     * Gets the string {@link #className}
     * @return {@link #className} the current run's class name.
     */
    public String getClassName(){return className;}
    /**
     * Gets the string {@link #configFileName}
     * @return {@link #configFileName} the current run's configuration file name.
     */
    public String getConfigFileName(){return configFileName;}
    /**
     * Gets the string {@link #sourcePath}
     * @return {@link #sourcePath} the current run's source path.
     */
    public String getSourcePath(){return sourcePath;}
    /** getArgsFileName gets the string argsFileName */
    public String getArgsFileName(){return argsFileName;}
    /** getTestInputFileName gets the string testInputFileName */
    public String getTestInputFileName(){return testInputFileName;}
    /** getZipFile gets the string zipFile */
    public String getZipFile(){return zipFile;}
    /** getClassPath gets the string classPath */
    public String getClassPath(){return classPath;}
    /** getStudentPath gets the string classPath */
    public String getStudentPath(){return studentPath;}
    /** getArgs gets the arraylist args */
    public ArrayList<String> getArgs(){return args;}
    /** getClassList gets the string classList */
    public String getClassList(){return classList;}
    /** getOutputFileName gets the string outputFileName */
    public String getOutputFileName(){return outputFileName;}
    /** getInputFileStub gets the string getInputFileStub */
    public String getInputFileStub(){return inputFileStub;}
    /** getFrame gets the JFrame frame */
    public JFrame getFrame(){return frame;}
    /** gets the current list of scanner inputs for the run */
    public ArrayList<String> getScannerInputs(){return scannerInputs;}
    /** sets the current scanner inputs for this run */
    public void setScannerInputs(ArrayList<String> x){this.scannerInputs = x;}
    /** setFrame sets the frame to x */
    public void setFrame(JFrame x){this.frame = x;}
    /** setInputFileStub sets the string inputFileStub to x + "/input" */
    public void setInputFileStub(String x){this.inputFileStub = x + "/input";}
    /** setArgs sets the arraylist args to x */
    public void setArgs(ArrayList<String> x){this.args = x;}
    /** setClassList sets the string ClassList to x */
    public void setClassList(String x){this.classList = x;}
    /** setClassPath sets the string classPath to x */
    public void setClassPath(String x){this.classPath = x + "/bin";} // You give it the src path
    /** setStudentPath sets the string studentPath to x */
    public void setStudentPath(String x){this.studentPath = x + "/projectFiles" ;} // You give it the src path
    /** setStudentName sets student Name to x */
    public void setStudentName(String x){this.studentName = x;}
    /** setOutputFileName sets the string outputFileName to x */
    public void setOutputFileName(String x){this.outputFileName =x;}
    /** setStudentHandle sets the string studentHandle to x */
    public void setStudentHandle(String x){this.studentHandle = x;}
    /** setClassName sets the string className to x */
    public void setClassName(String x){this.className = x;}
    /** setConfigFileName sets the configFileName to x */
    public void setConfigFileName(String x){this.configFileName = x;}
    /** setSourcePath sets the sourcePath to x */
    public void setSourcePath(String x){this.sourcePath = x;}
    /** setArgsFileName sets the string argsFileName to x */
    public void setArgsFileName(String x){this.argsFileName = x;}
    /** setTestInputFileName sets the string testInputFileName to x */
    public void setTestInputFileName(String x){this.testInputFileName = x;}
    /** setZipFile sets the string zipFile to x */
    public void setZipFile (String x){this.zipFile = /*x*/  "blank.zip";} //TESTING PURPOSES, ISSUE.
}//RunInfo