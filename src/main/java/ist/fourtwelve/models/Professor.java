package ist.fourtwelve.models;

/**
 * Professor, typically refered to a course professor in the college of IST
 */
public class Professor {

    /** a login username for the professor */
    private String username;
    /** a login password for the professor */
    private char[] password;

    /** contact information for the professor */
    private String email;

    /**
     * Partial Constructor of a professor. Setup of some of the attributes that make up a professor
     * @param username login username of the professor
     * @param password login password of the professor.
     */
    public Professor(String username, char[] password){
        this.username = username;
        this.password = password;
    }

    /**
     * Full Constructor of a professor. Setup of all the attributes that make up a professor
     * @param username login username of the professor
     * @param password login password of the professor.
     * @param email contact email for the professor.
     */
    public Professor(String username, char[] password, String email){
        this.username = username;
        this.password = password;
        this.email    = email;
    }

    /**
     * getUsername returns the username of the professor
     * @return the login username of the professor
     */
    public String getUsername(){
        return this.username;
    }
    /**
     * setUsername sets the username of professor
     * @param username is the login username of the professor
     */
    public void setUsername(String username){
        this.username = username;
    }

    /**
     * getPassword returns the password of the professor
     * @return the login password of the professor
     */
    public char[] getPassword(){
        return this.password;
    }
    /**
     * setPassword sets the password of professor
     * @param password is the login password of the professor
     */
    public void setPassword(char[] password){
        this.password = password;
    }

    /**
     * getEmail returns the email of the professor
     * @return the contact email of the professor
     */
    public String getEmail(){
        return this.email;
    }
    /**
     * setEmail sets the email of professor
     * @param email is the contact email of the professor
     */
    public void setEmail(String email){
        this.email = email;
    }
}
