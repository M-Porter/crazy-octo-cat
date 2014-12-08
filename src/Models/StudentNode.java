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
    
    public StudentNode(){
        
    }
    
    public Student getStudent(){
        return theStudent;
    }
    
}
