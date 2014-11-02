/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ist.fourtwelve.models;

import ist.fourtwelve.views.TestProjectGenerationView;

import java.util.ArrayList;

/**
 * Generates certain information related to the project being handled by the gui.
 */
public class ProjectGenerator {
    /**View generated from the class that to be updated and used*/
    private final TestProjectGenerationView genView;
    /**ArrayList of projects being held by the class*/
    private ArrayList<Project> projectsList;
    /**ArrayList of test runs related to the projects*/
    private ArrayList<TestRun> testRunsToAdd;
    /**ArrayList of params that are used in the test runs*/
    private ArrayList<String> paramsToAdd;
    /**
     * Default Constructor. Sets up the attributes of the class with instances of the variables
     */
    public ProjectGenerator(){
        projectsList    = new ArrayList<Project>();
        testRunsToAdd   = new ArrayList<TestRun>();
        paramsToAdd     = new ArrayList<String>();
        genView = new TestProjectGenerationView(this);
    }
    /**
     * Gets the current project list for the session
     * @return Returns the project list that is currently generated.
     */
    public ArrayList<Project> getProjList(){return this.projectsList;}
    /**
     * Gets the current set of test run lists during this session.
     * @return Returns the test run list that is currently generated.
     */
    public ArrayList<TestRun> getTestRunsList(){return this.testRunsToAdd;}
    /**
     * Gets the current set of parameters that was generated in this session
     * @return Returns the parameter list that is currently generated.
     */
    public ArrayList<String> getParamList(){return paramsToAdd;}
    /**Resets the test runs that are currently generated.*/
    public void resetTestRuns(){
        this.testRunsToAdd.clear();
    }
    /** Resets the paramters tha tare currently generated. */
    public void resetParams(){
        this.paramsToAdd.clear();
    }
    
    
    
    
}
