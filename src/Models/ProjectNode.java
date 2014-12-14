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
public class ProjectNode extends DefaultMutableTreeNode{
    
  
    protected Project theProject;  
    public ProjectNode(Project theProject){
        super(theProject.getName());
        this.theProject = theProject;
    }

}
