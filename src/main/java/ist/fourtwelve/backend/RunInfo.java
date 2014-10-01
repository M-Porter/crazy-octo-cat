package ist.fourtwelve.backend;

/**
 * Created by Steven on 9/28/2014.
 */
import java.io.*;
import java.util.Scanner;


/**
 * Setup of the information related to running the program.
 * @author Steve
 *
 */
public class RunInfo {
    //Basic information; Defaults to this info if object is created without args.
    String studentName = "blank";
    String studentHandle = "000000";
    String className = "297D/";
    String configFileName = "./configBatch.txt";
    String path = "C:/Program Files/Java/jdk1.7.0_25/bin";
    String sourcePath = "./studentFiles";
    String testDataPath = sourcePath;
    String argsFileName = testDataPath + "/args.txt";
    String testInputFileName = testDataPath + "/TestInput.txt";
    // Compiler information
    String classPath;
    String studentPath;
    String inputFileStub;
    String outputFileName;
    //Batch/Single info
    int studentNumber = 0;
    int runNumber = 1;
    /*
    Basic constructor, Assumes nothing special and is used for testing purposes.
     */
    public RunInfo (){

    }//RunInfo()
    /*
    Full Constructor. For when you want to completely redo the configuration, or want to test a configuration
    @param sName Student Name for the specific directory
    @param sHandle Student Handle for grading purposes, otherwise unused atm
    @param cName Classname, Unused atm, but will be used to setup an additional directory to separate classes from each other.
    @param cFileName ConfigFileName, Where the configuration file is found for TestRunner.
    @param path Path to the java directory, unused?
    @param sPath SourcePath the first layer directory of where student files are found.
    @param tDataPath Used in test runner for proper data
    @param aFileName arguments file name for a mainly used arguments for the project.
    @param testInputFileName Where the test input is found.
    */
    public RunInfo (String sName,String sHandle,String cName,String cFileName,String path,String sPath,String tDataPath,String aFileName,String tInputFileName){
        this.studentName = sName;
        this.studentHandle = sHandle;
        this.className = cName;
        this.configFileName = cFileName;
        this.path = path;
        this.sourcePath = sPath;
        this.argsFileName = aFileName;
        this.testInputFileName = tInputFileName;
    }//RunInfo(args)

    public void batchSetup(){
        try
        {
//        config file has list of ordinal student number,
//        student name, and random handle
            File configFile = new File(configFileName);
            Scanner in = new Scanner(configFile);
            int runNumber = 1;

            while(in.hasNextLine())
            {
                String line  = in.nextLine();
                Scanner inLine = new Scanner(line);
//          debug code - print out scanned config info
//          System.out.print("scanned config info: ");
                while(inLine.hasNext())
                {
                    studentNumber = inLine.nextInt();
                    studentName = inLine.next();
                    studentHandle = inLine.next();
                }

//          set paths and file names:
                String classPath = "/java/bin/" + className + studentName;
                String studentPath = sourcePath + "/" + studentName;
                String inputFileStub = studentPath + "/input";
                String outputFileName = studentPath + "/output-" + studentName + ".txt";

//TODO: COMPILER NEEDS TO BE CALLED HERE BATCH IS SPECIAL, AS THE COMPILE RUNS THEN HAS ANOTHER LINE INPUT.



            }//while:hasNextLine
        }catch(IOException ioe){
            System.out.println("Batch IO Exception");
        }


//This ends the prep for the object to be sent to the compiler and test runner.
    }//batchSetup
    /*
     * Setup the information for the single test. Does not need to compile and run inside of RunInfo.
     */
    public void singleSetup(){
//TODO: Have it read from a config file? This was copied directly from the old files.
// Setup names for compiler
        classPath = sourcePath + "/bin"; //changed new setup of directories
        studentPath = sourcePath + "/projectFiles"; // /studentFiles/projectFiles
        inputFileStub = studentPath + "/input";
        outputFileName = studentPath + "/output-" + studentName + ".txt";
// Debug
/*    make sure set correctly
        System.out.println("classPath: " + classPath);
        System.out.println("studentPath: " + studentPath);
        System.out.println("inputFileStub: " + inputFileStub);
        System.out.println("outputFileName: " + outputFileName);
*/
//This ends the prep for the object to be sent to the compiler and test runner.
    }//singleSetup()

//TODO: Add methods and setup access modifiers.


}//RunInfo