/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ist412guiproject;

import Controllers.MainMenuCntl;
import Controllers.PersistentDataModelCntl;
import Models.Instructor;

/**
 *
 * @author SickRebelSoul
 */
public class IST412GUIProject {

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Create a default list of courses
       // PersistentDataModelCntl.getPDMCntl().getPDM().getInstructor().createTestCourseList();
        
        // Create test students for each course
//        for (int i = 0; i < PersistentDataModelCntl.getPDMCntl().getPDM().getInstructor().getCourseList().size(); i++){
//            PersistentDataModelCntl.getPDMCntl().getPDM().getInstructor().getCourseList().get(i).createTestStudentList();
//            
//            // Create test projects for each student
//            for (int j = 0; j < PersistentDataModelCntl.getPDMCntl().getPDM().getInstructor().getCourseList().get(i).getStudentList().size(); j++){
//                PersistentDataModelCntl.getPDMCntl().getPDM().getInstructor().getCourseList().get(i).getStudentList().get(j).createTestProjectList();
//            }
//        }
        PersistentDataModelCntl.getPDMCntl().readPDMFile();

        MainMenuCntl mainMenu = new MainMenuCntl();
    }
    
}
