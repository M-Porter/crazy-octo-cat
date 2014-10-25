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
    private String name;
    private String classPath;
    private String sourcePath;
    private String studentPath;
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
        name = info.getStudentName();
        classPath = info.getClassPath();
        sourcePath = info.getSourcePath();
        studentPath = info.getStudentPath();
        inputFileStub = info.getInputFileStub();
        outputFileName = info.getOutputFileName();
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

                    //TODO: Argument Inputs added on and handled...

//        declare arg ArrayList for java ProcessBuilder
                    List<String> arg = new ArrayList<String>();

                    arg.add(0, "java");
                    arg.add(1, "-cp");
                    arg.add(2, classPath+"/"+name);
                    arg.add(3, classes);

//        scan Stuff from the GUI, scanner inputs
                    String testInputLine = inputs.get(i);

                    //Scanner inputs are handled here.

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


//        Runs the code we already built.

                    ProcessBuilder pb = new ProcessBuilder(arg);

//        redirect standard input, error, and output files; print process arguments
                    pb.redirectInput(Redirect.from(inputFile));
                    pb.redirectErrorStream(true);
                    pb.redirectOutput(Redirect.appendTo(outputFile));


                    //runJavaMethodToString += "pb.command() is " + pb.command().toString() + "\n";
                    System.out.println("java process arguments: " + pb.command());
//        start java process
                    Process p = pb.start();
                    //runJavaMethodToString += "pb.start() has run \n";

                    success = p.waitFor();
                    sleep(500); //Sleep used here to ensure the code had a generous amount of time to run.
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