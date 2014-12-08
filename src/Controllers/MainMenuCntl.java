/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controllers;


import Models.Student;
import Models.StudentList;
import Views.StudentUI;
import Views.MainMenuUI;
import Views.CourseCreationUI;
import Views.ProjectTemplateManagerGUI;
import Views.RunSetupUI;
import javax.swing.JTree;

/**
 *
 * @author cbald6
 */
public class MainMenuCntl {
    
    // GUI variables
    private MainMenuUI theMainMenuUI;
    private CourseCreationUI theCourseCreationUI;
    private ProjectTemplateManagerGUI theProjectTemplateUI;
    private StudentUI theStudentUI;
    private RunSetupUI theRunSetupUI;
    
    private Student theStudent;
    private StudentList theStudentList;
    
    
    public MainMenuCntl(){  
        theMainMenuUI = new MainMenuUI(this);
        theStudentList = new StudentList();
        
        
    }
    
    public StudentList getStudentList(){
        return theStudentList;
    }
    
    // Funtion to refire the MainMenuGUI when there are updaets
    public void updateMainMenuUI(){
        theMainMenuUI.repaint();
    }
    
    // Functions to call the other UI's
    public void getCourseCreationUI(){
        theCourseCreationUI = new CourseCreationUI(this);
    }
    
    public void getRunSetupUI(JTree theCourseTree){
        theRunSetupUI = new RunSetupUI(this, theCourseTree);
        // Update later
    }
    
    public void getStudentUI(){
        theStudentUI = new StudentUI(this);
    }
   
}
