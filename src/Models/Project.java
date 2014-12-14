/**
 *      TODO:
 */

package Models;

import ist412guiproject.TestRun;
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
    
    //Contains the input params for each testrun && stores output/results
    private ArrayList<TestRun> testRuns;
    
    
    //** STATUS
    //boolean indicating run success *(contains true if any one test compiles)*
    private boolean compileSuccess;

// ** CONSTRUCTORS **
    public Project(String name){
        this.projectName = name;
    }
    
    public Project(String name, String srcPath, ArrayList<TestRun> tests){
        this.projectName    = name;
        this.srcDirPath     = srcPath;
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
