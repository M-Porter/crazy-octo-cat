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
import Models.*;
import java.io.*;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.StaxDriver;
import com.thoughtworks.xstream.persistence.FilePersistenceStrategy;
import com.thoughtworks.xstream.persistence.PersistenceStrategy;
import com.thoughtworks.xstream.persistence.XmlArrayList;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class PersistentDataModelCntl implements Serializable{
     
    private File theFile = new File("PDM.txt");
    private XStream xstream = new XStream(new StaxDriver());
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
        try
        {
            System.out.println("in read file");
            StringBuilder fileContents =  new StringBuilder();
            Scanner in = new Scanner(theFile);
            String tempXML;
            boolean test = in.hasNextLine();
            System.out.println(test);
                while(in.hasNextLine()){
                    fileContents.append(in.nextLine());
                    System.out.println("reading file contents");
                }
                 tempXML = fileContents.toString();
                 
                 thePDM = (PersistentDataModel)xstream.fromXML(tempXML);
        }
        
        //If the file does not exist, thePDM is instantiated to be a new, empty, PDM file. The file is then written to disk, and then read from disk
        // using some recursive stuff. Also creates a test UserList so that I don't get a NullPointerException in the LoginCntl.
        catch(FileNotFoundException ex){
            System.out.println("FileNotFound");
            thePDM = new PersistentDataModel();
            String a = "Tom";
            String b = "Paz";
            char [] c = b.toCharArray();
            ArrayList<Student> d = new ArrayList();
            Student testStudent = new Student("Tom", "Paz", "test");
            d.add(testStudent);
            thePDM.theInstructor = new Instructor(a, c);
            thePDM.theInstructor.createTestCourseList();
            thePDM.theInstructor.getCourseList().get(0).setStudentList(d);
            //Creates new attributes if things are null. 
            this.writePDMFile();
            this.readPDMFile();
            System.out.println("FileNotFound Exception");
            
        }
        catch(IOException ex){
            System.out.println("IO Exception");
            ex.printStackTrace();
            
        }
        
    } 
    public void writePDMFile(){
        
        try{
            String xml = xstream.toXML(thePDM);
            PrintWriter writer = new PrintWriter(theFile);
            System.out.println(xml);
            writer.println(xml);
            writer.close();
            
        }
        catch(Exception ex){
            System.out.println("There was a problem writing the file.");
        }
    }
    public PersistentDataModel getPDM(){
        return thePDM;
    }
    
}
    


