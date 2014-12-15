package ist.fourtwelve.backend;

/**
 * Created by jrittle on 10/26/2014.
 * Output contains accessors and mutators for methods in other classes
 */
public class Output {
    //TODO: Compile run output. needs to be added here in some form.
    /** String of the run and compile output information. */
    private String outputString = "";
    /** Boolean that checks if a file compiled */
    private boolean didCompile;
    /** Boolean that checks if a process ran correctly */
    private boolean didRun;

    /** 
     * Nothing of importance.
     */
    public Output(){
        //meant to be empty
    }
    /**
     * Gets the ouput for the compile or run.
     * @return {@link #outputString} returns the output string
     */
    public String getOutputString(){
         return this.outputString;
    }

    /**
     * Tells if the run compiled correctly
     * @return {@link #didCompile} Where or not the program compiled.
     */
    public boolean getDidCompile(){
        return this.didCompile;
    }
    /**
     * Tells if the run ran correctly
     * @return {@link #didRun} Whether or not the program ran.
     */
    public boolean getDidRun(){
        return this.didRun;
    }

    /**
     * Sets the string that is the output from running and compiling
     * @param passedOutputString The string related to what output happened for the compile/run.
     */
    public void setOutputString(String passedOutputString){
        this.outputString = passedOutputString;
    }

    /**
     * Sets if the programs compiled correctly.
     * @param passedDidCompile Boolean of the project compiling
     */
    public void setDidCompile(boolean passedDidCompile){
        this.didCompile = passedDidCompile;
    }

    /**
     * Sets if the program ran correctly
     * @param passedDidRun Passed arg of if the program ran correctly.
     */
    public void setDidRun(boolean passedDidRun){
        this.didRun = passedDidRun;
    }
}
