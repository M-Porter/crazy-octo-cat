/**
 *      TODO:
 */

package ist.fourtwelve.models;

import java.util.ArrayList;

/**
 * @author cmb5837 Christopher M. Baldwin
 */


public class Project {
    // ** INSTANCE VARIABLES **
    //** DESCRIPTORS
    // Name of the project
    private String projectName;


    //** INPUT
    //Source directory from which the project will be compiled
    private String srcDirPath;

    //Name of the main class to be compiled
    private String mainClassName;

    //Contains the input params for each testrun && stores output/results
    private ArrayList<TestRun> testRuns;


    //** STATUS
    //boolean indicating run success *(contains true if any one test compiles)*
    private boolean compileSuccess;

    // ** CONSTRUCTORS **
    public Project(String name, String srcPath,String mainClass, ArrayList<TestRun> tests){
        this.projectName    = name;
        this.srcDirPath     = srcPath;
        this.mainClassName  = mainClass;
        this.testRuns       = new ArrayList<TestRun>(tests);


    }
// ** CORE METHODS **

// ** GETTERS AND SETTERS **

    //** DESCRIPTORS
    //Store the name
    public void setName(String name){
        this.projectName = name;
    }
    //Get the name
    public String getName(){
        return this.projectName;
    }

    //Store the name of the main class
    public void setMainClassName(String name){
        this.mainClassName = name;
    }
    //Get the name of the main class
    public String getMainClassName(){
        return this.mainClassName;
    }

    //** INPUT
    // set the file path where the project will be found
    public void setSrcDir(String filepath){
        this.srcDirPath = filepath;
    }
    // return the file path the project is currently pointing to
    public String getSrcDir(){
        return this.srcDirPath;
    }

    public void setTestRuns(ArrayList<TestRun> testRuns){
        this.testRuns = testRuns;
    }
    public ArrayList<TestRun> getTestRuns(){
        return this.testRuns;
    }

    //** STATUS
    //Use to report whether the test was a success or failure
    public void reportCompileSuccess(boolean result){
        this.compileSuccess = result;
    }
    //retrieve success of failure of this run, did program crash?
    public boolean getCompileSuccess(){
        return this.compileSuccess;
    }






}
