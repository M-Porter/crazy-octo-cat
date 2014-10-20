/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ist.fourtwelve.models;

import ist.fourtwelve.views.TestProjectGenerationView;

import java.util.ArrayList;

/**
 *
 * @author SickRebelSoul
 */
public class ProjectGenerator {
    
    private final TestProjectGenerationView genView;
    private ArrayList<Project> projectsList;
    private ArrayList<TestRun> testRunsToAdd;
    private ArrayList<String> paramsToAdd;
    
    public ProjectGenerator(){
        projectsList    = new ArrayList<Project>();
        testRunsToAdd   = new ArrayList<TestRun>();
        paramsToAdd     = new ArrayList<String>();
        genView = new TestProjectGenerationView(this);
    }
    
    public ArrayList<Project> getProjList(){return this.projectsList;}
    
    public ArrayList<TestRun> getTestRunsList(){
        return this.testRunsToAdd;
    }
    public ArrayList<String> getParamList(){
        return paramsToAdd;
    }
    
    public void resetTestRuns(){
        this.testRunsToAdd.clear();
    }
    public void resetParams(){
        this.paramsToAdd.clear();
    }
    
    
    
    
}
