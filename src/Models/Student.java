/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Models;
import java.util.ArrayList;
import java.io.Serializable;
//Author Tom Paz

public class Student implements Serializable{

    private ArrayList<Project> theProjectList;
    private String studentID;
    private String firstName;
    private String lastName;
    //Reference back to the course the student is a part of. 
    public Student(String fName, String lName, String ID, ArrayList<Project> projects){
        firstName = fName;
        lastName = lName;
        studentID = ID;
        theProjectList = projects;
    }
    public Student(String fName, String lName, String ID){
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
    public String getStudentID(){
        return studentID;
    }
    public ArrayList<Project> getProjectList(){
        return theProjectList;
    }
    public void createTestProjectList(){
        theProjectList.add(new Project("testProject1"));
        theProjectList.add(new Project("testProject2"));
        theProjectList.add(new Project("testProject3"));
        
        // Print the list of the test projects to the console
        System.out.println("You've added the projects: ");
        for (int i = 0; i < theProjectList.size(); i++){
            System.out.println(theProjectList.get(i).getName());
        }
    }
    
}
