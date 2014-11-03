package ist.fourtwelve.models;

import java.util.ArrayList;


/**
 *  Holds all the information related to running a program
 *  @author cmb5837 Christopher M. Baldwin
 */
public class TestRun {

    /**Descriptive name of this test */
    private String testName;
    /**ArrayList of inputs to test*/
    private ArrayList<String> testInputs;
    /**boolean indicating run success*/
    private boolean runSuccess;
    /**Expected output stores an output value that indicates a successful run*/
    private String expectedOutput;
    /**Observed output stores the actual output of this run of the program*/
    private String observedOutput;
    /**
     * Takes name and a list of all the testInputs to run
     * @param name Given name of the test run
     * @param inputs List of inputs that the test should have
     */
    public TestRun (String name, ArrayList<String> inputs){
        this.testName   = name;
        this.testInputs = new ArrayList<String>(inputs);
    }
    /**
     * Takes name and a list of all the test inputs to run, plus expected output
     * @param name Given name of the test run
     * @param inputs List of inputs that the test should have
     * @param expectOut Given expected output of the test
     */
     public TestRun (String name, ArrayList<String> inputs, String expectOut){
        this.testName       = name;
        this.testInputs = new ArrayList<String>(inputs);
        this.expectedOutput = expectOut;
    }
    /**
     * Checks to see if the actual output is what we expected
     * @return Returns if the output matches the expected output.
     */
    public boolean outputMatch(){
        if(this.expectedOutput.equals(this.observedOutput)){
            return true;
        }
        else{
            return false;
        }
    }
    /**
     * Sets the name of this specific test run
     * @param name Given name of the test run
     */
    public void setName(String name){this.testName = name;}
    /**
     * Gets the name of this specific test run.
     * @return Returns the name of this specific test run
     */
    public String getName(){ return this.testName;}
    /**
     * Access to this tests set of inputs to store them and to retrieve at runtime
     * @return Returns the given set of test inputs of this test run.
     */
    public ArrayList<String> getInputs(){return testInputs;}
    /**
     * Use to report whether the test was a success or failure
     * @param result Sets the test run with a specific boolean if it passed or failed..
     */
    public void reportRunSuccess(boolean result){this.runSuccess = result;}
    /**
     * Retrieve success of failure of this run, did program crash?
     * @return Returns the sucess of this specific test run.
     */
    public boolean getRunSuccess(){return this.runSuccess;}
    /**
     * Sets the expected output for the program when it runs.
     * @param output Given output that this test run is supposed to result in displaying
     */
    public void setExpectedOut(String output){this.expectedOutput =   output;}
    /**
     * Gets the expected output the program is supposed to check when it runs
     * @return Returns the output the program is supposed to compile to.
     */
    public String getExpectedOut(){return this.expectedOutput;}
    /**
     * Sets the observed output of this specific test run
     * @param output Given ouput this test run actually had when run
     */
    public void setObservedOut(String output){this.observedOutput =   output;}
    /**
     * Gets the observed output the test run concluded with after running
     * @return Returns the given ouput this test run had when it ran.
     */
    public String getObservedOut(){return this.observedOutput;}
   
    
}
