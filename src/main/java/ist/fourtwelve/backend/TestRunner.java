package ist.fourtwelve.backend;

/**
 * Created by Steve on 9/28/2014.
 */
import java.io.*;
import java.util.*;
import java.lang.ProcessBuilder.Redirect;

public class TestRunner
{
    private int number;
    private String name;
    private String handle;
    private String path;
    private String classPath;
    private String sourcePath;
    private String studentPath;
    private String testDataPath;
    private String argsFileName;
    private String testInputFileName;
    private String inputFileStub;
    private String inputFileName;
    private String outputFileName;
    private int success;
    //Debug/Ouput
    private String varToString;
    private String runJavaMethodToString;
    /*
    Main Constructor, Set up of the initial info for running java, not compiling
    @args info object which holds all the information relating to paths and such for the program to run.
    //TODO: Cleanup name, number handle? Own object which handles this as per student or professor or class? RunInfo with this info as well.
     */
    public TestRunner(RunInfo info)
    {
        number = info.runNumber;
        name = info.studentName;
        handle = info.studentHandle;
        path = info.path;
        classPath = info.classPath;
        sourcePath = info.sourcePath;
        studentPath = info.studentPath;
        testDataPath = info.testDataPath;
        argsFileName = info.argsFileName;
        testInputFileName = info.testInputFileName;
        inputFileStub = info.inputFileStub;
        outputFileName = info.outputFileName;
        success = 1;  // Outcome of compilation, success = 0


    }
    public void runJava()
    {
        try
        {
            runJavaMethodToString = "";
//    set up input files
//    TestInput.txt has inputs for each test on a single line
            File testInputFile = new File(testInputFileName);
            Scanner testInputs = new Scanner(testInputFile);
//    input.txt has inputs for a single run each on a separate line
//    and is created immediately before each test run from TestInput.txt

//    instantiate output file
            File outputFile = new File(outputFileName);

//    instantiate command-line arguments file
            File argsFile = new File(argsFileName);

//    instantiate argument Scanner
            Scanner argsInput = new Scanner(argsFile);
            int run = 0;

            synchronized(outputFile)
            {
                while(argsInput.hasNextLine())
                {
                    run++;
//        declare arg ArrayList for java ProcessBuilder
                    List<String> arg = new ArrayList<String>();
                    String argsLine = argsInput.nextLine();
//        parse argsLine via TestTools.parseLine
                    arg = TestTools.parseLine(argsLine);
                    runJavaMethodToString += "arg is " + arg.toString() + "\n";
                    arg.add(0, "java");
                    runJavaMethodToString += "arg is " + arg.toString() + "\n";
                    arg.add(1, "-cp");
                    runJavaMethodToString += "arg is " + arg.toString() + "\n";
                    arg.add(2, classPath+"/"+name);
                    runJavaMethodToString += "arg is " + arg.toString() + "\n";
//        System.out.println(arg);

//        scan TestInput.txt
                    String testInputLine = testInputs.nextLine();
                    runJavaMethodToString += "testInputLine is " + testInputLine.toString() + "\n";
//        System.out.println(testInputLine);

//        create input file for current run
                    List<String> inputs = new ArrayList<String>();
                    inputs = TestTools.parseLine(testInputLine);
                    runJavaMethodToString += "inputs is " + inputs.toString() + "\n";
                    System.out.println("System.in inputs: " + inputs);
                    inputFileName = inputFileStub + run + ".txt";
                    runJavaMethodToString += "inputFileName is " + inputFileName.toString() + "\n";
                    PrintWriter writeTests = new PrintWriter(inputFileName);
                    runJavaMethodToString += "writeTests is " + writeTests.toString() + "\n";
                    for(String element : inputs)
                    {
                        writeTests.println(element);
                    }
                    writeTests.close();
                    File inputFile = new File(inputFileName);
//        create new java ProcessBuilder using arg ArrayList
                    //"java", "-cp", classPath+"/"+name, "ArrayLoops"
                    ProcessBuilder pb = new ProcessBuilder(arg);
                    runJavaMethodToString += "pb.command() is " + pb.command().toString() + "\n";
//        redirect standard input, error, and output files; print process arguments
                    pb.redirectInput(Redirect.from(inputFile));
                    pb.redirectErrorStream(true);
                    pb.redirectOutput(Redirect.appendTo(outputFile));
                    runJavaMethodToString += "pb.command() is " + pb.command().toString() + "\n";
                    System.out.println("java process arguments: " + pb.command());
//        start java process
                    Process p = pb.start();
                    runJavaMethodToString += "pb.start() has run \n";
//        want processes to run sequentially to keep output in order
//        basically joins thread to process to force sequential execution
//        need to be careful - if any process hangs, whole run hangs
// TODO: Debugging tools for some of this code is still in the original files, removed cause problems. (Seemed unfinished).
                    p.waitFor();
                    assert pb.redirectInput() == Redirect.PIPE;
                    assert pb.redirectOutput().file() == outputFile;
                    assert p.getInputStream().read() == -1;
                }
                return;
            }
        }
        catch(java.lang.IllegalThreadStateException itse){}
        catch(java.util.NoSuchElementException nsee)
        {
            System.out.println("java.util.NoSuchElementException: Probably Scanner error");
        }
        catch(IOException ioe)
        {
            System.out.println("Runtime IOException");
        }

        catch(InterruptedException ie)
        {
            System.out.println("Runtime InterruptedException");
        }

        catch(Exception e)
        {
            System.out.println("General Runtime Exception");
        }

    }
    //TODO: NEW ACCESS MODIFIERS ALSO METHODS TO GET THE INFORMATION??

    public String toString(){return varToString;}
    public String runJavaMethodToString(){return runJavaMethodToString;}
}