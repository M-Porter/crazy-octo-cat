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
        info = new RunInfo();
    }
    public Setup(Project project){this.project = project;}
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
        //For each project....
        for(int i = 0; i < projects.size(); i++) {
            Project temp = projects.get(i);
            //For each test Run....
            for(int j = 0; j < temp.getTestRuns().size(); j++){
                //Setup of the paths
                info.setStudentPath(temp.getSrcDir());
                info.setClassPath(temp.getSrcDir());
                //Setup of run arguments
                info.setArgs(temp.getTestRuns().get(j).getInputs());
                if(temp.getTestRuns().size() > 1){
                    //TODO: If there are more args for the file? Not sure what to do here.
                }
                System.out.println("Path where the files should be located is... also unzipped to" + info.getStudentPath());
                //TODO: Unzip some stuff
                //TODO: Set the class path (where stuff compiles)
                //TODO: Add in a way to put test arguments not from the text file
                //TODO: Make runner arguments available as attributes of the RunJava class.
                //TODO: Look at how to extra arguments or generate some bs arguments for
                //TODO: Change the way RunJava handles the arguments. Should be something from the simple test case.
                compiler = new Compiler(info);
                //Synchronized is probably not needed, but could work?
                synchronized (compiler) {
                    compiler.compileJava();
                }
                runner = new RunJava(info);
                synchronized (runner) {
                    runner.runJava();
                }


            }

        }
    }


}
