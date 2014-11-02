/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ist.fourtwelve.models;

import java.util.ArrayList;

/**
 * Course contains an instructor, a studentList and a courseID, simply contains this information
 */
public class Course {
    /** the studentList is the arrayList of students*/
    private ArrayList<Student> theStudentList;
    /** theInstructor is the instructor of the course*/
    private Instructor theInstructor;
    /** courseID is the identity number of the course*/
    private int courseID;

    /**
     * this course constructor creates a course with an instructor, a list of students and a courseID
     * @param whoIsTeaching is the instructor object
     * @param studentList is the arrayList of students
     * @param ID is the courseID integer
     */
    public Course(Instructor whoIsTeaching, ArrayList<Student> studentList, int ID){
        theInstructor = whoIsTeaching;
        theStudentList = studentList;
        courseID = ID;
    }

    /**
     * this course constructor creates a course with an instructor and a courseID
     * @param whoIsTeaching is the instructor object
     * @param ID is the coureID integer
     */
    public Course(Instructor whoIsTeaching, int ID){
        theInstructor = whoIsTeaching;
        courseID = ID;
        theStudentList = new ArrayList();
    }

    /**
     * getStudentList returns the arrayList of students
     * @return the current arrayList of students in the course
     */
    public ArrayList<Student> getStudentList(){
        return theStudentList;
    }

    /**
     * getCourseID returns the courseID integer
     * @return the current courseID integer
     */
    public int getCourseID(){
        return courseID;
    }

    /**
     * getInstructor returns the instructor object
     * @return the current instructor object
     */
    public Instructor getInstructor(){
        return theInstructor;
    }

    /**
     * setStudentList sets the arrayList of students
     * @param newStudentList is the new arrayList of students
     */
    public void setStudentList(ArrayList<Student> newStudentList){
        theStudentList = newStudentList;
    }

    /**
     * setCourseID sets the course ID number for the course.
     * @param newID Relates to the given ID number you want the course to be.
     */
    public void setCourseID(int newID){
        courseID = newID;
    }

    /**
     * setInstructor Sets/updates the course with a given instructor
     * @param newInstructor The given instructor you want the course to have
     */
    public void setInstructor(Instructor newInstructor){
        theInstructor = newInstructor;
    }

    /**
     * studentToAdd Adds the student to the list of the students.
     * @param studentToAdd The given student you want added to the course
     */
    public void addStudentToList(Student studentToAdd){
        theStudentList.add(studentToAdd);
    }

    /**
     * 
     * @param studentID The given ID you want the student to have, or the given ID of a student in the course.
     */
    public void removeStudentFromList(int studentID){
        theStudentList.remove(studentID);
    }
    
    
    

}
