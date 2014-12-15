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
    private ArrayList<String> args;
    /** List of Scanner Inputs used to run the code*/
    private ArrayList<String> scannerInputs;
    /** Current main class name, could be changed to a list*/
    private String classList; //class name for the project
    /** Main frame used to direct the output */
    private JFrame frame;
    /** Used to tell if the run is a junit run or not */
    private boolean isJunit;
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
    * Full Constructor. For when you want to completely redo the configuration, or want to test a configuration, without using the methods
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
    /**
     * getArgsFileName gets the string argsFileName
     * @return {@link #argsFileName} returns the filename
     */
    public String getArgsFileName(){return argsFileName;}
    /**
     * getTestInputFileName gets the string testInputFileName
     * @return {@link #testInputFileName} returns the test file name
     */
    public String getTestInputFileName(){return testInputFileName;}
    /**
     * getZipFile gets the string zipFile
     * @return {@link #zipFile} returns the name of the zip file
     */
    public String getZipFile(){return zipFile;}
    /**
     * getClassPath gets the string classPath
     * @return {@link #classPath} returns the name of the class location
     */
    public String getClassPath(){return classPath;}
    /**
     * getStudentPath gets the string classPath
     * @return {@link #studentPath} returns the location of the student file
     */
    public String getStudentPath(){return studentPath;}
    /**
     * getArgs gets the arraylist args
     * @return {@link #args} returns the arraylist arguments
     */
    public ArrayList<String> getArgs(){return args;}
    /**
     * getClassList gets the string classList
     * @return {@link #classList} returns the classlist
     */
    public String getClassList(){return classList;}
    /**
     * getOutputFileName gets the string outputFileName
     * @return {@link #outputFileName} returns the output file name
     */
    public String getOutputFileName(){return outputFileName;}
    /**
     * getInputFileStub gets the string getInputFileStub
     * @return {@link #inputFileStub} returns the inputfilestub
     */
    public String getInputFileStub(){return inputFileStub;}
    /**
     * getFrame gets the JFrame frame
     * @return {@link #frame} The current JFrame
     */
    public JFrame getFrame(){return frame;}
    /**
     * gets the current list of scanner inputs for the run
     * @return {@link #scannerInputs} The current list of scanner inputs.
     */
    public ArrayList<String> getScannerInputs(){return scannerInputs;}
    /**
     * {@link #isJunit} tells if this run is a junit test or not
     * @return {@link #isJunit} if the run is a junit test or not.
     */
    public boolean isJunit(){return isJunit;}

    /**
     * Sets up if the run is a junit test or not
     * @param x If it is a junit test, or not.
     */
    public void setJunit(boolean x){this.isJunit = x;}

    /**
     * Sets the current scanner inputs for this run
     * @param x Given scanner inputs used for the run.
     */
    public void setScannerInputs(ArrayList<String> x){this.scannerInputs = x;}

    /**
     * Sets the frame for the ouput, needs to be cast appropriately.
     * @param x Given frame for the output to go to
     */
    public void setFrame(JFrame x){this.frame = x;}

    /**
     * Sets the input file stub, given a non full path, appends /input to the end, to give the file name starts with input.
     * @param x Given stub, without /input at the end.
     */
    public void setInputFileStub(String x){this.inputFileStub = x + "/input";}

    /**
     * Sets the arguments used to run the java code.
     * @param x Given list of arguments for the code to run with.
     */
    public void setArgs(ArrayList<String> x){this.args = x;}

    /**
     * Sets the list/single main class for the run.
     * @param x Given main class for the current run.
     */
    public void setClassList(String x){this.classList = x;}

    /**
     * Sets path to what directory you want to setup a /bin directory in. CHANGE THIS, ALWAYS CREATES A BIN DIRECTORY FOR CLASS FILES.
     * @param x Given directory you want a /bin directory created in.
     */
    public void setClassPath(String x){this.classPath = x + "/bin";} // You give it the src path

    /**
     * Sets path to what directory you want to setup a /projectFiles directory in. CHANGE THIS, ALWAYS CREATES A PROJECTFILES DIRECTORY FOR STUDENT FILES.
     * @param x Given directory you want a /projectFiles directory created in.
     */
    public void setStudentPath(String x){this.studentPath = x + "/projectFiles" ;} // You give it the src path

    /**
     * Sets the student name for the run
     * @param x Given student name for the run.
     */
    public void setStudentName(String x){this.studentName = x;}

    /**
     * Sets the output file name. THIS MIGHT NEED TO BE A DIRECTORY
     * @param x Given output file name. THIS MIGHT NEED TO BE A DIRECTORY
     */
    public void setOutputFileName(String x){this.outputFileName =x;}

    /**
     * Sets the student handle for the run
     * @param x Given student handle for the run.
     */
    public void setStudentHandle(String x){this.studentHandle = x;}
    /**
     * Sets the class name for the run.
     * @param x Given class name for the run.
     */
    public void setClassName(String x){this.className = x;}

    /* Unused methods.
    public void setConfigFileName(String x){this.configFileName = x;}
    public void setSourcePath(String x){this.sourcePath = x;}
    public void setArgsFileName(String x){this.argsFileName = x;}
    public void setTestInputFileName(String x){this.testInputFileName = x;}
    */

    /**
     * Sets the zip file for the run/compile. CURRENTLY CODED SO THAT IT ONLY LOOKS FOR A CERTAIN FILE. NOT DYNAMIC aTM>
     * @param x Given zip file.
     */
    public void setZipFile (String x){this.zipFile = /*x*/  "blank3.zip";} //TESTING PURPOSES, ISSUE.
}//RunInfo