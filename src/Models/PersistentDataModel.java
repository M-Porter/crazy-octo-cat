/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Models;
import java.util.ArrayList;
import java.io.Serializable;
/**
 *
 * @author tpzap_000
 */
public class PersistentDataModel implements Serializable{
    
    
   public Instructor theInstructor;
   Project theProjectTemplates;
    
    public PersistentDataModel(){
        
    }
    public Instructor getInstructor(){
        return theInstructor;
    }
    
}
