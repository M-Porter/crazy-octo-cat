package ist.fourtwelve.backend;

/**
 * Created by jrittle on 10/26/2014.
 * Output contains accessors and mutators for methods in other classes
 */
public class Output {
    //TODO: Compile run output. needs to be added here in some form.
    /** outputString contains the output of a file */
    private String outputString = "";
    /** didCompile is a boolean that checks if a file compiled */
    private boolean didCompile;
    /** didRun is a boolean that checks if a process ran correctly */
    private boolean didRun;

    /** 
     * constructor Output is meant to be empty
     */
    public Output(){
        //meant to be empty
    }
    //accessors
    /** getOutputString gets the object outputString 
     * @return {@link #outputString} returns the output string
     */
    public String getOutputString(){
         return this.outputString;
    }
    /** getDidCompile gets the object didCompile 
     * @return {@link #didCompile} returns the boolean that indicates whether or not the files compiled
     */
    public boolean getDidCompile(){
        return this.didCompile;
    }
    /** getDidRun gets the object didRun 
     * @return {@link #didRun} returns the boolean that indicates whether or not the run was successful
     */
    public boolean getDidRun(){
        return this.didRun;
    }

    //mutators
    /** setOutputString sets the object outputString */
    public void setOutputString(String passedOutputString){
        this.outputString = passedOutputString;
    }
    /** setDidCompile sets the object didCompile */
    public void setDidCompile(boolean passedDidCompile){
        this.didCompile = passedDidCompile;
    }
    /** setDidRun sets the object didRun */
    public void setDidRun(boolean passedDidRun){
        this.didRun = passedDidRun;
    }
}
