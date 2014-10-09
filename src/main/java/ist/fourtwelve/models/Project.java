package ist.fourtwelve.models;


public class Project {

    // Name of the project
    private String projectName;


    //** May need a solution for team based projects **
    //Pointer reference to associated student class
    private Student student;

    //Source directory from which the project will be compiled
    private String srcDirPath;




    //** NEED SOME WAY OF DOING THE FOLLOWING THINGS **
    //Running a specific number of tests on a java program
    //Passing accurate inputs to the back-end team for testing, per run
    //checking whether each individual test compiled or failed to compile
    //Either:
    //Automatically testing to see if the correct output was generated
    //Showing the instructor the output from all test runs
    //Or Both
    //Associating Each Project with the correct student for grading


    //** ^^ Proposed Solution to above ^^ **
    //make a class called 'run', and have an arraylist of runs
    //each containing the above listed parameters


    /*
    private int numTestRuns;

    //Results of the attempted run
    //Did it compile?
    private boolean compileSuccess = false;
    //What was the output
    private String  outputCapture;

    */

}