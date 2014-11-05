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
    /**@field studentID A number the student can be identified by*/
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
     * Access field {@link #firstName}
     * @return Returns {@link #firstName},the current first name of the student.
     */
    public String getFirstName(){ return firstName;}
    /**
     * Access field {@link #lastName}
     * @return Returns {@link #firstName},the current last name of the student.
     */
    public String getLastName(){return lastName;}
    /**
     * Access field {@link #studentID}
     * @return Returns {@link #studentID} the unique identifier for the student.
     */
    public int getStudentID(){return studentID;}
    /**
     * Access field {@link #theProjectList}
     * @return Returns {@link #theProjectList}, a list of projects the student is currently a part of.
     */
    public ArrayList<Project> getStudentProject(){return theProjectList;}
    
    
}
