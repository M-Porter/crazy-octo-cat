package ist.fourtwelve.backend;

/**
 * Created by Steve on 9/28/2014.
 */
import ist.fourtwelve.views.TestProjectGenerationView;

import java.io.*;
import java.util.*;
import java.lang.ProcessBuilder.Redirect;

import static java.lang.Thread.sleep;
/**
 * RunJava is a central class that runs the entire process
 * @author Steve
 */
public class RunJava
{
    /** Name of the student */
    private String name;
    /** Location where class files go to */
    private String classPath;
    /** Location of where the input files eventually go */
    private String inputFileStub;
    /** Name of the input file name, usually input#*/
    private String inputFileName;
    /** Name of the output file.*/
    private String outputFileName;
    /** Returned number if the program ran correctly or not. If 0, then ran correctly. otherwise not.*/
    private int success;
    /** Container class related to both information for running and compiling java code */
    private RunInfo info;
    /** The main class the program is supposed to run*/
    private String classes;

    /**
     * Only constructor, used to setup a few variables to have a local copy.
     * @param info Given information related to both compiling and running java code.
     */
    public RunJava(RunInfo info)
    {
        name = info.getStudentName();
        classPath = info.getClassPath();
        inputFileStub = info.getInputFileStub();
        outputFileName = info.getOutputFileName();
        success = 1;  // Outcome of compilation, success = 0
        this.info = info;

    }
    /** 
     * The runJava method is the method that runs the whole process of reading in, checking the student files for errors, running and compiles those files, and writing to an output files
     * @return {@link #success} Returns success which indicates whether or not the run was successful
     */
    public int runJava()
    {
        try
        {
//    instantiate output file
            File outputFile = new File(outputFileName);

            int run = 0;
            int i =0;
            List<String> inputs = new ArrayList<String>();
            classes = info.getClassList();
            inputs = info.getScannerInputs();
            int size = inputs.size();
            synchronized(outputFile)
            {
                while(i < size)
                {
                    inputs = info.getScannerInputs(); //Repopulate the input arraylist is needed to get the arguments(its just how its setup). TODO: Setup so this doesnt need to happen?
                    run++;

                    //TODO: Needs to handle if this is a junit test or not.....java -cp .:/usr/share/java/junit.jar org.junit.runner.JUnitCore [test class name]

//        declare arg ArrayList for java ProcessBuilder
                    List<String> arg = new ArrayList<String>();

                    arg.add(0, "java");
                    arg.add(1, "-cp");

                   if(info.isJunit()){
                        arg.add(2,classPath+"/"+name + ";junit-4.11.jar;hamcrest-core-1.3.jar"); //ProgramJUnitTest
                        arg.add(3,"org.junit.runner.JUnitCore"); //junit.textui.TestRunner
                        arg.add(4,classes);
                    }
                    else{
                        arg.add(2, classPath+"/"+name);
                        arg.add(3, classes);
                        arg.add(4, info.getArgs().get(i));
                    }
                   //scan Stuff from the GUI, scanner inputs
                    String testInputLine = inputs.get(i);

                    //Scanner inputs are handled here.

                    inputs = TestTools.parseLine(testInputLine);
                    System.out.println("System.in inputs: " + inputs);

                    inputFileName = inputFileStub + run + ".txt";
                    PrintWriter writeTests = new PrintWriter(inputFileName);
                    for(String element : inputs)
                    {
                        writeTests.println(element);
                    }
                    writeTests.close();
                    File inputFile = new File(inputFileName);

                    //Scanner inputs are finished being handled.


                    ProcessBuilder pb = new ProcessBuilder(arg);

//        redirect standard input, error, and output files; print process arguments
                    pb.redirectInput(Redirect.from(inputFile));
                    pb.redirectErrorStream(true);
                    pb.redirectOutput(Redirect.appendTo(outputFile));



                    System.out.println("java process arguments: " + pb.command());
                    Process p = pb.start(); //Run the code

                    success = p.waitFor();
                    sleep(500); //Sleep used here to ensure the code had a generous amount of time to run. Not needed
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
}