package ist.fourtwelve.backend;

/**
 * Created by jrittle on 10/26/2014.
 * Output contains accessors and mutators for methods in other classes
 * @param outputString  outputString contains the output of a file
 * @param didCompile    didCompile is a boolean that checks if a file compiled
 * @param didRun        didRun is a boolean that checks if a process ran correctly
 */
public class Output {

    private String outputString;
    private boolean didCompile;
    private boolean didRun;

    //constructors
    public Output(){
        //meant to be empty
    }

    //accessors
    public String getOutputString(){
         return this.outputString;
    }

    public boolean getDidCompile(){
        return this.didCompile;
    }

    public boolean getDidRun(){
        return this.didRun;
    }

    //mutators
    public void setOutputString(String passedOutputString){
        this.outputString = passedOutputString;
    }

    public void setDidCompile(boolean passedDidCompile){
        this.didCompile = passedDidCompile;
    }

    public void setDidRun(boolean passedDidRun){
        this.didRun = passedDidRun;
    }
}
