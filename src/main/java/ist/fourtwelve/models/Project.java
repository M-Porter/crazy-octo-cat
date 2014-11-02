package ist.fourtwelve.models;

import java.util.ArrayList;

/**
 * @author cmb5837 Christopher M. Baldwin
 */

/**
 * Project, typically a java project submitted by an undergraduate of IST
 */
public class Project {
    /** a name for the project */
    private String projectName;

    /** a source directory from which the project will be compiled */
    private String srcDirPath;

    /** the Name of the main class to be compiled */
    private String mainClassName;

    /** an array list containing the input params for each testrun & stores output/results */
    private ArrayList<TestRun> testRuns;

    /** a boolean indicating run success (contains true if any one test compiles) */
    private boolean compileSuccess;

    /**
     * Full Constructor of a Project. Setup of all the attributes that make up a project
     * @param name the name of the project
     * @param srcPath the path to the source files of the project
     * @param mainClass the name of the main class of the project
     * @param tests an array list of the tests for the project
     */
    public Project(String name, String srcPath,String mainClass, ArrayList<TestRun> tests){
        this.projectName    = name;
        this.srcDirPath     = srcPath;
        this.mainClassName  = mainClass;
        this.testRuns       = new ArrayList<TestRun>(tests);


    }

    /**
     * getName returns the name of the project
     * @return the name of the project
     */
    public String getName(){
        return this.projectName;
    }
    /**
     * setName sets the name of the project
     * @param name is the name to be given to the project
     */
    public void setName(String name){
        this.projectName = name;
    }

    /**
     * getMainClassName returns the name of the main class of the project
     * @return the name of the main class of the project
     */
    public String getMainClassName(){
        return this.mainClassName;
    }
    /**
     * setMainClassName sets the name of the main class of the project
     * @param name is the name to be given to the main class of the project
     */
    public void setMainClassName(String name){
        this.mainClassName = name;
    }

    /**
     * getSrcDir returns the directory of the source files of the project
     * @return the directory of the source files of the project
     */
    public String getSrcDir(){
        return this.srcDirPath;
    }
    /**
     * setSrcDir sets the directory of the source files of the project
     * @param filepath is the directory of the source files of the project
     */
    public void setSrcDir(String filepath){
        this.srcDirPath = filepath;
    }
    
    /**
     * getTestRuns returns an array list of the test runs for the project
     * @return an array list of the test runs for the project
     */
    public ArrayList<TestRun> getTestRuns(){
        return this.testRuns;
    }
    /**
     * setTestRuns sets the test runs for the project
     * @param testRuns is an array list of the test runs for the project
     */
    public void setTestRuns(ArrayList<TestRun> testRuns){
        this.testRuns = testRuns;
    }
    
    /**
     * getCompileSuccess returns a boolean indicating whether or not the project compiled
     * @return a boolean indicating whether or not the project compiled
     */
    public boolean getCompileSuccess(){
        return this.compileSuccess;
    }
    //** STATUS
    //Use to report whether the test was a success or failure

    /**
     * reportCompileSuccess set the compilation success indicator
     * @param result is a boolean indicating whether or not the project compiled
     */
    public void reportCompileSuccess(boolean result){
        this.compileSuccess = result;
    }
    






}
