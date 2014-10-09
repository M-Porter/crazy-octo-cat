package ist.fourtwelve.models;

import java.util.ArrayList;


public class Student {

    private ArrayList<Project> theProjectList;
    private int studentID;
    private String firstName;
    private String lastName;
    //Reference back to the course the student is a part of.
    public Student(String fName, String lName, int ID, ArrayList<Project> projects){
        firstName = fName;
        lastName = lName;
        studentID = ID;
        theProjectList = projects;
    }
    public Student(String fName, String lName, int ID){
        firstName = fName;
        lastName = lName;
        studentID = ID;
        theProjectList = new ArrayList();
    }

    //Getters
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public int getStudentID(){
        return studentID;
    }
    public ArrayList<Project> getStudentProject(){
        return theProjectList;
    }

}
