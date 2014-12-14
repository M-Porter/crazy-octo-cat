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
public class StudentNode extends DefaultMutableTreeNode{
    
    protected Student theStudent;
    
    public StudentNode(Student theStudent){
        super(theStudent.getFirstName().charAt(0)+theStudent.getLastName());
        this.theStudent = theStudent;
    }
    
    public Student getStudent(){
        return theStudent;
    }
    
}
