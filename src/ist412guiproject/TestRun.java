/**
 *      TODO:
 *//**
 *      TODO:
 */

package ist412guiproject;

import java.util.ArrayList;


/**
 *  @author cmb5837 Christopher M. Baldwin
 */
public class TestRun {
    
// ** INSTANCE VARIABLES **
    
    //** DESCRIPTORS
    //descriptive name of this test
    private String testName;
    
    //** INPUT
    //ArrayList of inputs to test
    private ArrayList<String> testInputs;
    
    //** STATUS
    //boolean indicating run success
    private boolean runSuccess;
    
    //** OUTPUT
    //Expected output stores an output value that indicates a successful run
    private String expectedOutput;
    //Observed output stores the actual output of this run of the program 
    private String observedOutput;
    
// ** CONSTRUCTORS **
    //takes name and a list of all the testInputs to run
    public TestRun (String name, ArrayList<String> inputs){
        this.testName   = name;
        this.testInputs = new ArrayList<String>(inputs);
        
    }
    //takes name and a list of all the test inputs to run, plus expected output
     public TestRun (String name, ArrayList<String> inputs, String expectOut){
        this.testName       = name;
        this.testInputs = new ArrayList<String>(inputs);
        this.expectedOutput = expectOut;
    }
    
     
// ** CORE METHODS **
     
    //Checks to see if the actual output is what we expected
    public boolean outputMatch(){
        if(this.expectedOutput.equals(this.observedOutput)){
            return true;
        }
        else{
            return false;
        }
    }
    
// ** GETTERS AND SETTERS **
    
    //** DESCRIPTORS
    //Store the name of this test
    public void setName(String name){
        this.testName = name;
    }
    //Get the name
    public String getName(){
        return this.testName;
    }
    
    //** INPUT
    //Access to this tests set of inputs to store them and to retrieve at runtime
    public ArrayList<String> getInputs(){
        return testInputs;
    }
    
    //** STATUS
    //Use to report whether the test was a success or failure
    public void reportRunSuccess(boolean result){
        this.runSuccess = result;
    }
    //retrieve success of failure of this run, did program crash?
    public boolean getRunSuccess(){
        return this.runSuccess;
    }

    
    //** OUTPUT
    //Store the expected output
    public void storeExpectOut(String output){
        this.expectedOutput =   output;
    }
    
    //Get the expected output
    public String getExpectOut(){
        return this.expectedOutput;
    }
    
     //Store the expected output
    public void storeObservOut(String output){
        this.observedOutput =   output;
    }
    
    //Get the observed output
    public String getObservOut(){
        return this.observedOutput;
    }
   
    
}
