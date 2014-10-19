package ist.fourtwelve;

import ist.fourtwelve.backend.RunInfo;
import ist.fourtwelve.backend.TestRunner;
import ist.fourtwelve.backend.Compiler;
import ist.fourtwelve.backend.Unzipper;

import java.io.IOException;
import java.lang.*;

/**
 * Created by Steven on 9/28/2014.
 */
public class Main {

    public static void main(String args[]){

        RunInfo testInfo = new RunInfo();
        testInfo.singleSetup();
        Compiler c = new Compiler(testInfo);
        int success = c.compileJava();

//	    Print whether or not compile successful
        if(success == 0)
        {
            System.out.println("Compiled Successfully");
        }
        else
        {
            System.out.println("Compile Failed");
        }

//	    Run the test cases

        TestRunner r = new TestRunner(testInfo);
        r.runJava();
        //testInfo.runNumber++;
    }

}
