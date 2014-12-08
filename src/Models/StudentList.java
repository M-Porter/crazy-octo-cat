/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;
import java.util.ArrayList;
/**
 *
 * @author Shane
 */
public class StudentList {
    private ArrayList<Student> theStudentList = new ArrayList<>();
    
    public StudentList(){
        // Get student list from external file
        
    }
    
    public void addStudent(Student newStudent){
        theStudentList.add(newStudent);
    }
    
    public void readStudentListFromFile(){
        
    }
    
    public void writeToUserListFile(){
        
    }
    
    public ArrayList<Student> getStudentList(){
        return theStudentList;
    }
    
}
