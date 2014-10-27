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
/*
    Creates a new, or using existing information, to run and compile projects.
 */
public class Setup {
    private Compiler compiler;
    private RunJava runner;
    private RunInfo info;
    private Project project;
    private ArrayList<Project> projects;
    private JFrame frame;
    private Output output = new Output();
    /*
    Original Setup, Do not use if methods are called inside
    TODO: Change this method to something concrete and not using test methods.
     */
    public Setup(){

    }

    public Setup(ArrayList<Project> projects){
        this.projects = projects;
        info = new RunInfo();
    }
    public Setup(Project project){this.project = project;}
    /*
    Runs the project without compiling
     */
    public void runProject(){
        info.setClassList(project.getMainClassName());
        for (int j = 0; j < project.getTestRuns().size(); j++) {
            info.setStudentPath(project.getSrcDir());
            info.setClassPath(project.getSrcDir());
            info.setZipFile(project.getSrcDir());//TODO: Replace this with something more concrete.
            info.setArgs(project.getTestRuns().get(j).getInputs());//A reminder that this is the setup of the scanner inputs not run arguments.
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
    /*
    Compiles then runs the project
     */
    public void compileRunProject(){
        info.setClassList(project.getMainClassName());
        for (int j = 0; j < project.getTestRuns().size(); j++) {
            info.setStudentPath(project.getSrcDir());
            info.setClassPath(project.getSrcDir());
            info.setZipFile(project.getSrcDir());//TODO: Replace this with something more concrete.
            info.setArgs(project.getTestRuns().get(j).getInputs());//A reminder that this is the setup of the scanner inputs not run arguments.
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
    /*
    Runs multiple projects without compiling.
     */
    public void runProjects(){
        for(int i = 0; i < projects.size(); i++) {
            Project temp = projects.get(i);
            info.setClassList(temp.getMainClassName());
            //For each test Run....
            for (int j = 0; j < temp.getTestRuns().size(); j++) {
                //Setup RunInfo object.
                info.setStudentPath(temp.getSrcDir());
                info.setClassPath(temp.getSrcDir());
                info.setZipFile(temp.getSrcDir());//TODO: Replace this with something more concrete.
                info.setArgs(temp.getTestRuns().get(j).getInputs());//A reminder that this is the setup of the scanner inputs not run arguments.
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
    /*
    Compiles then runs mulitiple projects
     */
    public void compileRunProjects(){
        //For each project....
        for(int i = 0; i < projects.size(); i++) {
            Project temp = projects.get(i);
            info.setClassList(temp.getMainClassName());
            //For each test Run....
            for(int j = 0; j < temp.getTestRuns().size(); j++){
                //Setup RunInfo object.
                info.setStudentPath(temp.getSrcDir());
                info.setClassPath(temp.getSrcDir());
                info.setZipFile(temp.getSrcDir());//TODO: Replace this with something more concrete.
                info.setArgs(temp.getTestRuns().get(j).getInputs());//A reminder that this is the setup of the scanner inputs not run arguments.
                info.setInputFileStub(info.getStudentPath());
                info.setFrame(this.frame);
                if(temp.getTestRuns().size() > 1){
                    //IF there more than one test run for a project... do more stuff... else...
                    //TODO: If there are more args for the file? Not sure what to do here.
                }
                System.out.println("Path where the files should be located is... also unzipped to" + info.getStudentPath());
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
                    System.out.println("Run fail (false) or not (true) " + y);
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
                setGuiOutput();

            }

        }
    }
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
        x.setOutputArea(tempString);
        output.setOutputString(tempString);
    }
    public void setOutput(Output x){this.output = x;}
    public void setFrame(JFrame x){frame = x;}
    public Output getOutput(){return this.output;}

}
