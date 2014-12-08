/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import javax.swing.tree.DefaultMutableTreeNode;
/**
 *
 * @author Jeralyn Tseng
 */

public class CourseNode extends DefaultMutableTreeNode{
    
    private StudentNodeList theStudentNodeList;
    protected Course theCourse;
    
    public CourseNode(){
        
    }
    
    public StudentNodeList getStudentNodes(){
        return theStudentNodeList;
    }
}
