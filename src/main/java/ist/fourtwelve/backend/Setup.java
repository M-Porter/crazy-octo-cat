package ist.fourtwelve.backend;

import ist.fourtwelve.models.Project;

import java.util.ArrayList;

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
    /*
    Original Setup, Do not use if methods are called inside
    TODO: Change this method to something concrete and not using test methods.
     */
    public Setup(){
        info = new RunInfo();
        info.singleSetup(); //important?
        compiler = new Compiler(info);
        runner = new RunJava(info);
        int success = compiler.compileJava();
//	    Print whether or not compile successful
        if(success == 0){System.out.println("Compiled Successfully");}
        else{System.out.println("Compile Failed");}
        runner.runJava();
    }

    public Setup(ArrayList<Project> projects){
        this.projects = projects;
    }
    public Setup(Project project){
        this.project = project;
    }
    /*
    Runs the project without compiling
     */
    public void runProject(){

    }
    /*
    Compiles then runs the project
     */
    public void compileRunProject(){

    }
    /*
    Runs multiple projects without compiling.
     */
    public void runProjects(){

    }
    /*
    Compiles then runs mulitiple projects
     */
    public void compileRunProjects(){

    }


}
