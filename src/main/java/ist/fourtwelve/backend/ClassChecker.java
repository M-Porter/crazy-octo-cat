package ist.fourtwelve.backend;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by mporter on 10/12/14.
 */

//TODO: Fix this from uh reading entire file to reading line by line.

/**
 * @author mporter
 * Scans in and checks student classes for errors
 */
public class ClassChecker {
    /** file holds the array list of strings that contain data from the files being read in */
    private ArrayList<String> file;
    /** boolean checks to see if the file has any errors */
    private boolean isGtg = true;
    /** is the location of the file on the PC */
    private String fileName;
/**
 * Full Constructor
 * @param sourceFile
 * @param s     s is the name of the scanner created to read in class files
 * @throws FileNotFoundException 
 */
    public ClassChecker(File sourceFile) throws FileNotFoundException {
        Scanner s = new Scanner(sourceFile);
        file = new ArrayList<String>();
        while (s.hasNext()){
            file.add(s.next());
        }
        s.close();
        fileName = sourceFile.toString();
    }
/**
 * checkForUsages checks a class for a certain sequence of code
 * @param params    params is the arraylist of parameters that are being checked
 * @param lineNo    lineNo is a counter for the line number in the class that is being checked
 * @param e         e is a string that holds the sequence of code that the method wants to scan for
 * @return          returns the boolean isGtg which checks if the file meets the parameters       
 */
    public boolean checkForUsages(ArrayList<String> params) {
        for(String e : params) {
            int lineNo = 1;
            for(String f : file) {
                if(f.contains(e)) {
                    if(isGtg) {
                        isGtg = false;
                    }
                    System.out.println("Character sequence " + e
                            + " found on line " + lineNo + " in file " + fileName);
                    System.out.println("\t-- " + f.toString());
                }
                lineNo++;
            }
        }
        return isGtg;
    }
/**
 * determineParameterFromLine figures out the type of parameter that needs to be set
 * @param singleLine            singleLine is a parameter that takes in a line of code from a class
 * @param parameterReturnCode   the parameterReturnCode is set to a value depending what type of parameter it is
 * @return                      the parameterReturnCode is returned at the end of the method 
 */
    public int determineParameterFromLine(String singleLine) {

        int parameterReturnCode = -1;

        //format of return codes is 3 digits
        //return code of 200 is no arraylist
        //return code of 201 is no strings

        if(singleLine.indexOf("NO") != -1) {
            //within the line that was read, there was a "NO" parameter found
            singleLine = singleLine.substring(singleLine.indexOf("NO")+3, singleLine.length());
            //singleLine should be changed to the word after "NO "

            if(singleLine.indexOf("ARRAYLIST") != -1) {
                //"ARRAYLIST or ARRAYLISTS was found within the remaining string
                parameterReturnCode = 200;
            }

            if(singleLine.indexOf("STRING") != -1) {
                parameterReturnCode = 201;
            }
            return parameterReturnCode;
        }

        if(singleLine.indexOf("ONLY") != -1) {
            singleLine = singleLine.substring(singleLine.indexOf("ONLY")+5, singleLine.length());

            if(singleLine.indexOf("STRING") != -1) {
                parameterReturnCode = 300;
            }
            return parameterReturnCode;

        }
        return parameterReturnCode;
    }

}
