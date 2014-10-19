package ist.fourtwelve.backend;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by mporter on 10/12/14.
 */
public class ClassChecker {

    private ArrayList<String> file;
    private boolean isGtg = true;
    private String fileName;

    public ClassChecker(File sourceFile) throws FileNotFoundException {
        Scanner s = new Scanner(sourceFile);
        file = new ArrayList<String>();
        while (s.hasNext()){
            file.add(s.next());
        }
        s.close();
        fileName = sourceFile.toString();
    }

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
