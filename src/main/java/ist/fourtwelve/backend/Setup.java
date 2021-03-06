package ist.fourtwelve.backend;

import ist.fourtwelve.models.Project;
import ist.fourtwelve.views.TestProjectGenerationView;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Steve on 10/19/2014.
 */
/**
 * Creates a new, or using existing information, to run and compile projects.
 * @author Steve
 */
public class Setup {
    /** Compiler used to compile the java code */
    private Compiler compiler;
    /** RunJava object used to run the compiled java code */
    private RunJava runner;
    /** Object used to store information related to running and compiling the code */
    private RunInfo info;
    /** Current project being used in the setup. Usually related to a single project sent to be setup/compiled/run */
    private Project project;
    /** Typical arraylist of all project sent from the GUI, main usage of this program goes through all projects and compiles/runs all code.*/
    private ArrayList<Project> projects;
    /** Experimental frame used to show output */
    private JFrame frame;
    /** Experiemental output object which holds all ouput information in the runs*/
    private Output output = new Output();
    /** The run number that is currently going on */
    private int runNumber = 0;
    /** The current compiled/running project */
    private int projectNumber = 0;
    public Setup(){

    }
    /**
     * Used to specify multiple projects from the GUI
     * @param projects Arraylist containing information to be run and how.
     */
    public Setup(ArrayList<Project> projects){
        this.projects = projects;
        info = new RunInfo();
    }

    /**
     * Used to specify only one project to be run from the GUI
     * @param project A single project from the GUI, to save memory/space/time.
     */
    public Setup(Project project){this.project = project;}

    /**
     * Runs a single project in the current setup object. Does not Compile. UNTESTED NOT FINISHED, OUT OF DATE.
     */
    public void runProject(){
        ArrayList<String> test = new ArrayList();
        test.add("5");
        test.add("10");
        test.add("15");
        info.setClassList(project.getMainClassName());
        for (int j = 0; j < project.getTestRuns().size(); j++) {
            info.setStudentPath(project.getSrcDir());
            info.setClassPath(project.getSrcDir());
            info.setZipFile(project.getSrcDir());//TODO: Replace this with something more concrete.
            info.setArgs(test);
            info.setScannerInputs(project.getTestRuns().get(j).getScannerInputs());
            info.setInputFileStub(info.getStudentPath());
            info.setFrame(this.frame);
            if(project.getTestRuns().size() > 1){
                //IF there more than one test run for a project... do more stuff... else...
                //TODO: If there are more args for the file? Not sure what to do here.
            }
            System.out.println("Path where the files should be located is... also unzipped to" + info.getStudentPath());
            info.setOutputFileName(info.getStudentPath() + "/output-" + info.getStudentName()+ ".txt");
            compiler = new Compiler(info);

            //Synchronized is probably not needed, but could work? Someone should understand why i am doing this.
            runner = new RunJava(info);
            synchronized (runner) {
                int x = runner.runJava();
                boolean y;
                if (x == 0){
                    y = true;

                }
                else {
                    y = false;
                }
                System.out.println("Run fail (false) or not (true) " + y);
                output.setDidRun(y);
                project.getTestRuns().get(j).reportRunSuccess(y); //Untested
            }
            setGuiOutput();
        }
    }

    /**
     * Compiles then runs a single project in the current setup. UNTESTED NOT FINISHED, OUT OF DATE.
     */
    public void compileRunProject(){
        ArrayList<String> test = new ArrayList();
        test.add("5");
        test.add("10");
        test.add("15");
        info.setClassList(project.getMainClassName());
        for (int j = 0; j < project.getTestRuns().size(); j++) {
            info.setStudentPath(project.getSrcDir());
            info.setClassPath(project.getSrcDir());
            info.setZipFile(project.getSrcDir());//TODO: Replace this with something more concrete.
            info.setArgs(test);
            info.setScannerInputs(project.getTestRuns().get(j).getScannerInputs());
            info.setInputFileStub(info.getStudentPath());
            info.setFrame(this.frame);
            if(project.getTestRuns().size() > 1){
                //IF there more than one test run for a project... do more stuff... else...
                //TODO: If there are more args for the file? Not sure what to do here.
            }
            System.out.println("Path where the files should be located is... also unzipped to" + info.getStudentPath());
            info.setOutputFileName(info.getStudentPath() + "/output-" + info.getStudentName()+ ".txt");
            compiler = new Compiler(info);

            //Synchronized is probably not needed, but could work? Someone should understand why i am doing this.
            synchronized (compiler) {
                int x = compiler.compileJava();
                boolean y;
                if(x == 0){
                    y = true;
                }
                else {
                    y = false;
                }
                System.out.println("Run fail (false) or not (true) " + y);
                output.setDidCompile(y);
                project.reportCompileSuccess(y); //Untested
            }
            runner = new RunJava(info);
            synchronized (runner) {
                int x = runner.runJava();
                boolean y;
                if (x == 0){
                    y = true;

                }
                else {
                    y = false;
                }
                System.out.println("Run fail (false) or not (true) " + y);
                output.setDidRun(y);
                project.getTestRuns().get(j).reportRunSuccess(y); //Untested
            }
            setGuiOutput();
        }
    }

    /**
     * Runs multiple projects without compiling. UNTESTED NOT FINISHED, OUT OF DATE.
     */
    public void runProjects(){
        ArrayList<String> test = new ArrayList();
        test.add("5");
        test.add("10");
        test.add("15");
        for(int i = 0; i < projects.size(); i++) {
            Project temp = projects.get(i);
            info.setClassList(temp.getMainClassName());
            //For each test Run....
            for (int j = 0; j < temp.getTestRuns().size(); j++) {
                //Setup RunInfo object.
                info.setStudentPath(temp.getSrcDir());
                info.setClassPath(temp.getSrcDir());
                info.setZipFile(temp.getSrcDir());//TODO: Replace this with something more concrete.
                info.setArgs(test);
                info.setScannerInputs(temp.getTestRuns().get(j).getScannerInputs());
                info.setInputFileStub(info.getStudentPath());
                info.setFrame(this.frame);
                if (temp.getTestRuns().size() > 1) {
                    //IF there more than one test run for a project... do more stuff... else...
                    //TODO: If there are more args for the file? Not sure what to do here.
                }
                System.out.println("Path where the files should be located is... also unzipped to" + info.getStudentPath());
                //TODO: Test Success output.
                //TODO: Handle args and scanner input separately when GUI gets the stuff here.
                //TODO: Make sure it doesnt contain a / in the front of the uh srcDir
                info.setOutputFileName(info.getStudentPath() + "/output-" + info.getStudentName() + ".txt");
                runner = new RunJava(info);
                synchronized (runner) {
                    int x = runner.runJava();
                    boolean y;
                    if (x == 0) {
                        y = true;

                    } else {
                        y = false;
                    }
                    System.out.println("Run fail (false) or not (true) " + y);
                    output.setDidRun(y);
                    projects.get(i).getTestRuns().get(j).reportRunSuccess(y); //Untested
                }
                setGuiOutput();
            }
        }
    }

    /**
     * Compiles then runs mulitiple projects. MAIN TESTED, Suggested use this even if running a single project.
     */
    public void compileRunProjects(){
        //Temporary arraylist to simulate argument inputs, the runJava needs an arraylist of arguments to run properly. Needs to match/be more than the amount of inputs.
        ArrayList<String> test = new ArrayList();
        test.add("5");
        test.add("10");
        test.add("15");
        test.add("15");
        test.add("15");
        test.add("15");

        for(int i = 0; i < projects.size(); i++) {

            projectNumber++;
            Project temp = projects.get(i);
            info.setClassList(temp.getMainClassName());
            //For each test Run....
            for(int j = 0; j < temp.getTestRuns().size(); j++){
                //Setup RunInfo object.
                //info.setJunit(true);//temp.getTestRuns().get(j).getIsJunit()
                info.setStudentPath(temp.getSrcDir());//TODO: See below it edit it accordingly.
                info.setClassPath(temp.getSrcDir()); //Todo: See below If the gui supports it, add in the class path handling and change in the runInfo to accept the path and not mutate it.
                info.setZipFile(temp.getSrcDir());//TODO: Replace this with something more concrete.
                //if(temp.getTestRuns().get(j) == null){ //Remove if statement if
                    info.setArgs(test);//temp.getTestRuns().get(j).getCmdArgs()
                //}
               // else{
              //      info.setArgs(temp.getTestRuns().get(j).getCmdArgs());
               // }
                info.setScannerInputs(temp.getTestRuns().get(j).getScannerInputs());
                info.setInputFileStub(info.getStudentPath());//TODO:See above, dynamic editing needs to be supported by the gui.
                info.setFrame(this.frame);
                if(temp.getTestRuns().size() > 1){
                    //IF there more than one test run for a project... do more stuff... else...
                    //TODO: If there are more args for the file? Not sure what to do here.
                }
                System.out.println("Zip File Loc " + info.getZipFile());
                //TODO: Test compile success.
                //TODO: Handle args and scanner input separately when GUI gets the stuff here.
                //TODO: Make sure it doesnt contain a / in the front of the uh srcDir
                info.setOutputFileName(info.getStudentPath() + "/output-" + info.getStudentName()+ ".txt");
                compiler = new Compiler(info);

                //Synchronized is probably not needed, but could work? Someone should understand why i am doing this.
                synchronized (compiler) {
                    int x = compiler.compileJava();
                    boolean y;
                    if(x == 0){
                        y = true;
                    }
                    else {
                        y = false;
                    }
                    System.out.println("Compile fail (false) or not (true) " + y);
                    output.setDidCompile(y);
                    projects.get(i).reportCompileSuccess(y); //Untested
                }
                runner = new RunJava(info);
                synchronized (runner) {
                    int x = runner.runJava();
                    boolean y;
                    if (x == 0){
                        y = true;

                    }
                    else {
                        y = false;
                    }
                    System.out.println("Run fail (false) or not (true) " + y);
                    output.setDidRun(y);
                    projects.get(i).getTestRuns().get(j).reportRunSuccess(y); //Untested
                }
                runNumber++;
                setGuiOutput();

            }

        }
    }
    /**
     * Sets the GUI Ouput, line by line, to the GUI.
     */
    private void setGuiOutput(){
        TestProjectGenerationView x = (TestProjectGenerationView) frame;
        File outputFile = new File(info.getOutputFileName());
        Scanner myScanner = null;
        try {
            myScanner = new Scanner(outputFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String tempString = "";
        while(myScanner.hasNextLine())
        {
            tempString += myScanner.nextLine() + "\n";
        }
        output.setOutputString(output.getOutputString() + "Run Number " + runNumber + " Project Numeber " + projectNumber + "\n ------------------------- \n" + tempString);
        x.setOutputArea(output.getOutputString());
    }

    /**
     *  Sets the output object for the setup
     * @param x Given output object for the output of setup to go to
     */
    public void setOutput(Output x){this.output = x;}

    /**
     * Sets the frame for the output to go somewhere
     * @param x Given Frame for the ouput of the compiling/running to go to.
     */
    public void setFrame(JFrame x){frame = x;}

    /**
     * Gets the output object of the current setup.
     * @return {@link #output} returns the output
     */
    public Output getOutput(){return this.output;}

}
