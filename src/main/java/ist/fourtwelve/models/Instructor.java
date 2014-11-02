package ist.fourtwelve.models;
import java.util.ArrayList;

/**
 * @author cmb5837
 */
public class Instructor {
    /** the username is the username String that the instructor uses to log on*/
    private String username;
    /** the password is the password char[] that the instructor uses to log on*/
    private char[] password;
    
    /** the email is the email String that the instructor uses for contact information*/
    private String email;
    
    /** courseList is the arrayList of courses that the instructor has access to*/
    private ArrayList<Course> courseList;
    
    /**
     * this Instructor constructor takes in the username and password
     * @param username is the String that the instructor uses to log in
     * @param password is the charArray that the instructor uses to log in
     */
    public Instructor(String username, char[] password){
        this.username = username;
        this.password = password;
    }
    
    /**
     * this Instructor constructor takes in the username, password and email
     * @param username is the String that the instructor uses to log in
     * @param password is the charArray that the instructors uses to log in
     * @param email  is the String that the instructor can be contacted at
     */
    public Instructor(String username, char[] password, String email){
        this.username = username;
        this.password = password;
        this.email    = email;
    }
    
    /**
     * getUsername returns the string of the username
     * @return the current username
     */
    public String getUsername(){
        return this.username;
    }
    
    /**
     * setUserName sets the username string
     * @param username  is the input username that will be set
     */
    public void setUsername(String username){
        this.username = username;
    }
    
    /**
     * getPassword returns the charArray of the password
     * @return the current password
     */
    public char[] getPassword(){
        return this.password;   
    }
    
    /**
     * setPassword sets the password charArray
     * @param password  is the input password that will be set
     */
    public void setPassword(char[] password){
        this.password = password;
    }
    
    /**
     * getEmail returns the string of the email
     * @return the current email
     */
    public String getEmail(){
        return this.email;
    }
    
    /**
     * setEmail sets the string email
     * @param email is the input email that will be set
     */
    public void setEmail(String email){
        this.email = email;
    }
    
    /**
     * getCourseList returns the current course list
     * @return the arrayList of courses
     */
    public ArrayList<Course> getCourseList(){
        return this.courseList;
    }
    
 
}
