package ist.fourtwelve.backend;

/**
 * Created by Steve on 9/28/2014.
 */
import ist.fourtwelve.views.TestProjectGenerationView;

import java.io.*;
import java.util.*;
import java.lang.ProcessBuilder.Redirect;

import static java.lang.Thread.sleep;

public class RunJava
{
    private int number;
    private String name;
    private String classPath;
    private String sourcePath;
    private String studentPath;
    private String testDataPath;
    private String testInputFileName;
    private String inputFileStub;
    private String inputFileName;
    private String outputFileName;
    private int success;
    private RunInfo info;
    private String classes;
    //Debug/Ouput
    private String runJavaMethodToString;
    /*
    Main Constructor, Set up of the initial info for running java, not compiling
    @args info object which holds all the information relating to paths and such for the program to run.
    //TODO: Cleanup name, number handle? Own object which handles this as per student or professor or class? RunInfo with this info as well.
     */
    public RunJava(RunInfo info)
    {
        number = info.runNumber;
        name = info.studentName;
        classPath = info.classPath;
        sourcePath = info.sourcePath;
        studentPath = info.studentPath;
        testDataPath = info.testDataPath;
        testInputFileName = info.testInputFileName;
        inputFileStub = info.inputFileStub;
        outputFileName = info.outputFileName;
        success = 1;  // Outcome of compilation, success = 0
        this.info = info;

    }
    public int runJava()
    {
        try
        {
            runJavaMethodToString = "";

//    instantiate output file
            File outputFile = new File(outputFileName);

//    instantiate argument Scanner
            int run = 0;
            int i =0;
            List<String> inputs = new ArrayList<String>();
            classes = info.getClassList();
            inputs = info.getArgs();
            int size = inputs.size();
            synchronized(outputFile)
            {
                while(i < size)
                {
                    inputs = info.getArgs(); //Repopulate the input arraylist is needed to get the arguments(its just how its setup). TODO: Setup so this doesnt need to happen?
                    run++;

//        declare arg ArrayList for java ProcessBuilder
                    List<String> arg = new ArrayList<String>();

                    arg.add(0, "java");
                    arg.add(1, "-cp");
                    arg.add(2, classPath+"/"+name);
                    arg.add(3, classes);

//        scan Stuff from the GUI
                    String testInputLine = inputs.get(i);

//        create input file for current run

                    //Stuff dealing with inputs is needed.
                    //TODO:Refactor how this parses the inputs for the arguments. This of course is between scanner and actual arguments, scanner here arguments above.
                    inputs = TestTools.parseLine(testInputLine);
                    //runJavaMethodToString += "inputs is " + inputs.toString() + "\n";
                    System.out.println("System.in inputs: " + inputs);
                    inputFileName = inputFileStub + run + ".txt";
                    //runJavaMethodToString += "inputFileName is " + inputFileName.toString() + "\n";
                    PrintWriter writeTests = new PrintWriter(inputFileName);
                    runJavaMethodToString += "writeTests is " + writeTests.toString() + "\n";
                    for(String element : inputs)
                    {
                        writeTests.println(element);
                    }
                    writeTests.close();
                    File inputFile = new File(inputFileName);
//        create new java ProcessBuilder using arg ArrayList

                    ProcessBuilder pb = new ProcessBuilder(arg);

//        redirect standard input, error, and output files; print process arguments
                    pb.redirectInput(Redirect.from(inputFile));
                    pb.redirectErrorStream(true);
                    pb.redirectOutput(Redirect.appendTo(outputFile));
                    //TODO: Output currently only does the first line of output. Multiple lines do not show up on the GUI at least.


                    /*myScanner = new Scanner(outputFile);
                    tempString = "";
                    while(myScanner.hasNextLine())
                    {
                        tempString += myScanner.nextLine() + "\n";
                    }
                    System.out.println("\n\n\n\n tempString is " + tempString);*/

                    //runJavaMethodToString += "pb.command() is " + pb.command().toString() + "\n";
                    System.out.println("java process arguments: " + pb.command());
//        start java process
                    Process p = pb.start();
                    //runJavaMethodToString += "pb.start() has run \n";
//        want processes to run sequentially to keep output in order
//        basically joins thread to process to force sequential execution
//        need to be careful - if any process hangs, whole run hangs b/c @output file
// TODO: Debugging tools for some of this code is still in the original files, removed cause problems. (Seemed unfinished).
                    success = p.waitFor();
                    sleep(500);
                    assert pb.redirectInput() == Redirect.PIPE;
                    assert pb.redirectOutput().file() == outputFile;
                    assert p.getInputStream().read() == -1;
                    i++;
                }
                return success;
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
            e.printStackTrace();
        }
        return success;
    }
    //TODO: NEW ACCESS MODIFIERS ALSO METHODS TO GET THE INFORMATION?? tl;dr not really
    public String runJavaMethodToString(){return runJavaMethodToString;}
}