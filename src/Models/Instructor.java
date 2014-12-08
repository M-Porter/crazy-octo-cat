package Models;
import Controllers.PersistentDataModelCntl;
import Models.Course;
import java.util.ArrayList;
import java.io.Serializable;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * @author cmb5837
 */
public class Instructor implements Serializable{
    //Login Credentials
    private String username;
    private char[] password;
    
    //Contact information\Password Confirmation
    private String email;
    
    //List of courses the Instructor is responsible for grading
    private ArrayList<Course> courseList;
    
    //init with just username and password fields
    public Instructor(String username, char[] password){
        this.username = username;
        this.password = password;
        this.courseList = new ArrayList();
    }
    
    //init with the additional email field
    public Instructor(String username, char[] password, String email){
        this.username = username;
        this.password = password;
        this.email    = email;
    }
    
    //GET/SET Username
    public String getUsername(){
        return this.username;
    }
    public void setUsername(String username){
        this.username = username;
    }
    
    
    //GET/SET Password
    public char[] getPassword(){
        return this.password;   
    }
    public void setPassword(char[] password){
        this.password = password;
    }
    
    //GET/SET Email
    public String getEmail(){
        return this.email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    
    public String[] getCourseIds(ArrayList<Course> courseList){
        String[] theIdList = new String[courseList.size()];        
        for (int i = 0; i <= courseList.size()-1; i++){
            theIdList[i] = (courseList.get(i).getCourseID());
        }
        return theIdList;
    }
    
    //GET courseList
    public ArrayList<Course> getCourseList(){
        return this.courseList;
    }
    
    public void createTestCourseList(){
        courseList.add(new Course(this, "IST 412"));
        courseList.add(new Course(this, "IST 140"));
        courseList.add(new Course(this, "IST 297J"));
    }
    
    public Course getCourseById(String courseId){
        ArrayList<Course> theCourseList = PersistentDataModelCntl.getPDMCntl().getPDM().getInstructor().getCourseList();
        for(int i = 0; i < theCourseList.size(); i++){
            if(theCourseList.get(i).getCourseID() == courseId){
                return theCourseList.get(i);
            }
        }
        System.out.println("Did not find the selected course in the PDM");
        return theCourseList.get(0);
    }
}
