/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controllers;

/**
 *
 * @author tpzap_000
 */
import Models.Instructor;
import Models.PersistentDataModel;
import java.io.*;
import java.util.*;
public class PersistentDataModelCntl implements Serializable{
    
    public final String fileName = "PDMFile.ser";
    public static PersistentDataModelCntl thePDMCntl;
    private PersistentDataModel thePDM;
    public PersistentDataModelCntl(){
        this.readPDMFile();
    }
    public static PersistentDataModelCntl getPDMCntl(){
        if(thePDMCntl == null){
            thePDMCntl = new PersistentDataModelCntl();
        }
        return thePDMCntl;
    }   
    public void readPDMFile(){
        FileInputStream input = null;
        ObjectInputStream obInput = null;
        try
        {
            input = new FileInputStream(fileName);
            obInput = new ObjectInputStream(input);
            thePDM = (PersistentDataModel)obInput.readObject();
            if(thePDM == null){
                System.out.println("thePDM is null");
            }
            obInput.close();
        }
        //If the file does not exist, thePDM is instantiated to be a new, empty, PDM file. The file is then written to disk, and then read from disk
        // using some recursive stuff. Also creates a test UserList so that I don't get a NullPointerException in the LoginCntl.
        catch(FileNotFoundException ex){
            thePDM = new PersistentDataModel();
            String thing = "Pazamickas";
            char [] thing2 = thing.toCharArray();
            thePDM.theInstructor = new Instructor("Tom", thing2);
            //Creates new attributes if things are null. 
            this.writePDMFile();
            this.readPDMFile();
            System.out.println("FileNotFound Exception");
            
        }
        catch(IOException ex){
            System.out.println("IO Exception");
            ex.printStackTrace();
            
        }
        catch(ClassNotFoundException ex){
            System.out.println("ClassNotFound Exception");            
        }
        
    } 
    public void writePDMFile(){
        FileOutputStream fileOutput = null;
        ObjectOutputStream obOutput = null;
        try{
            fileOutput = new FileOutputStream(fileName);
            obOutput = new ObjectOutputStream(fileOutput);
            obOutput.writeObject(thePDM);
            obOutput.close();
        }
        catch(IOException ex){
            System.out.println("There was a problem writing the file.");
        }
    }
    public PersistentDataModel getPDM(){
        return thePDM;
    }
    
}
    

