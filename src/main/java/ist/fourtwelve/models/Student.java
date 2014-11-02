/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ist.fourtwelve.models;
import java.util.ArrayList;

/**
 * Student, typically refered to an undergraduate in the college of IST
 */
public class Student {
    /**ArrayList of projects the student belongs to*/
    private ArrayList<Project> theProjectList;
    /**A number the student can be identified by*/
    private int studentID;
    /**A way to personally identify a student */
    private String firstName;
    /**A formal way to personally identify a student properly, goes along with the firstName*/
    private String lastName;
    /**
     * Full Constructor of a student. Setup of all the attributes that make up a student
     * @param fName firstName of the student
     * @param lName lastName of the student.
     * @param ID studentID of the student.
     * @param projects List of projects the student is currently engaged with.
     */
    public Student(String fName, String lName, int ID, ArrayList<Project> projects){
        firstName = fName;
        lastName = lName;
        studentID = ID;
        theProjectList = projects;
    }
    /**
     * Partial constructor of student. Set of the main information for the student.
     * @param fName firstName of the student
     * @param lName lastName of the student.
     * @param ID studentID of the student.
     */
    public Student(String fName, String lName, int ID){
        firstName = fName;
        lastName = lName;
        studentID = ID;
        theProjectList = new ArrayList();
    }
    /**
     *
     * @return
     */
    public String getFirstName(){ return firstName;}
    public String getLastName(){return lastName;}
    public int getStudentID(){return studentID;}
    public ArrayList<Project> getStudentProject(){return theProjectList;}
    
    
}
