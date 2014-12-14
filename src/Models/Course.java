/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Models;

import java.util.ArrayList;
public class Course {
    
    private ArrayList<Student> theStudentList;
    private Instructor theInstructor;
    private String courseID;
    private String semester;
    private String semesterYear;
    
    //Start Constructors.
    public Course(Instructor whoIsTeaching, ArrayList<Student> studentList, String ID){
        theInstructor = whoIsTeaching;
        theStudentList = studentList;
        courseID = ID;
    }
    public Course(Instructor whoIsTeaching, String ID){
        theInstructor = whoIsTeaching;
        courseID = ID;
        theStudentList = new ArrayList();
    }
    
    
        public Course(String courseID, String semester, String semesterYear) {
        this.courseID = courseID;
        this.semester = semester;
        this.semesterYear = semesterYear;
        this.theStudentList = new ArrayList();

    }
    
    //End Constructors.
    
    //Start Get Methods.
    public ArrayList<Student> getStudentList(){
        return theStudentList;
    }
    public String getCourseID(){
        return courseID;
    }
    public Instructor getInstructor(){
        return theInstructor;
    }
    //End Get Methods.
    
    //Start Set Methods.
    public void setStudentList(ArrayList<Student> newStudentList){
        theStudentList = newStudentList;
    }
    public void setCourseID(String newID){
        courseID = newID;
    }
    public void setInstructor(Instructor newInstructor){
        theInstructor = newInstructor;
    }
    //End Set Methods.
    
    //Start Miscellaneous Methods.
    public void addStudentToList(Student studentToAdd){
        theStudentList.add(studentToAdd);
    }
    public void removeStudentFromList(int studentID){
        theStudentList.remove(studentID);
    }
    
    public void createTestStudentList(){
        theStudentList.add(new Student("Test", "Student", "abc1"));
        theStudentList.add(new Student("Test", "Student", "abc2"));
        theStudentList.add(new Student("Test", "Student", "abc3"));
        
        // Print a list of test students to the console
        System.out.println("Test students added: ");
        for (int i = 0; i < theStudentList.size(); i++){
            System.out.println(theStudentList.get(i).getLastName());
        }
        
    }
    

}
