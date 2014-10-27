package ist.fourtwelve.backend;

/**
 * Created by jrittle on 10/26/2014.
 */
public class Output {

    private String outputString;
    private Requirements requirementsObject;
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

    public Requirements getRequirements(){
        return requirementsObject;
    }

    public boolean getDidCompile(){
        return didCompile;
    }

    public boolean getDidRun(){
        return didRun;
    }

    //mutators
    public void setOutputString(String passedOutputString){
        this.outputString = passedOutputString;
    }

    public void setRequirements(Requirements passedRequirements){
        this.requirementsObject = passedRequirements;
    }

    public void setDidCompile(boolean passedDidCompile){
        this.didCompile = passedDidCompile;
    }

    public void setDidRun(boolean passedDidRun){
        this.didRun = passedDidRun;
    }
}
