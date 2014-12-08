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
        //ProjectGenerator generator = new ProjectGenerator();
        MainMenuCntl mainMenu = new MainMenuCntl();
        String instructorPassword = "testpassword";
        PersistentDataModelCntl.getPDMCntl().getPDM().theInstructor = new Instructor("Shane", instructorPassword.toCharArray());
        PersistentDataModelCntl.getPDMCntl().getPDM().theInstructor.createTestCourseList();
    }
    
}
