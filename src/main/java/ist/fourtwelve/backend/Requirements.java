package ist.fourtwelve.backend;

/**
 * Requirements contains methods contains accessors and mutators for methods in other classes
 * Created by Steven on 10/26/2014.
 */
public class Requirements {
    
    /** constructor for requirements */
    public Requirements(){

    }
    /** keywordUsage is used to determine what keywords were used 
     * 
     * @return {@link null}    returns a null value by default
     */
    public String keywordUsage(){
        return null;
    }
    //entireFile/Filename
    //prints out the file name.
    //print method names...
    /** lineCount keeps track of what line is being read in 
     * 
     * @return {@link null}     returns 0 by default
     */
    public int lineCount(){
        return 0;
    }
    /**
     * hardCoded checks to see if the file or class is hard coded
     * @return {@link false}     returns false by default
     */
    public boolean hardCoded(){
        return false;
    }

}
