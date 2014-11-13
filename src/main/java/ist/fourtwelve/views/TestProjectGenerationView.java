/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ist.fourtwelve.views;

import ist.fourtwelve.backend.Setup;
import ist.fourtwelve.models.Project;
import ist.fourtwelve.models.ProjectGenerator;
import ist.fourtwelve.models.TestRun;

/**
 *
 * @author SickRebelSoul
 */
public class TestProjectGenerationView extends javax.swing.JFrame {

    private ProjectGenerator generator;
    /**
     * Creates new form TestProjectGenerationView
     */
    public TestProjectGenerationView(ProjectGenerator generator) {
        this.generator = generator;
        initComponents();
        this.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        projectNameLabel = new javax.swing.JLabel();
        projNameField = new javax.swing.JTextField();
        srcDirLabel = new javax.swing.JLabel();
        srcDirField = new javax.swing.JTextField();
        numRunsDesc1 = new javax.swing.JLabel();
        numRunsLabel = new javax.swing.JLabel();
        numRunsDesc2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        testRunPaneLabel = new javax.swing.JLabel();
        testRunNameLabel = new javax.swing.JLabel();
        testNameField = new javax.swing.JTextField();
        numInputsDesc1 = new javax.swing.JLabel();
        numInputsLabel = new javax.swing.JLabel();
        numInputsDesc2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        inputPaneLabel = new javax.swing.JLabel();
        nextInputLabel = new javax.swing.JLabel();
        nextInputField = new javax.swing.JTextField();
        addInputButton = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        addTestLabel = new javax.swing.JLabel();
        addTestButton = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        expectOutField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        projListTextArea = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        refreshButton = new javax.swing.JButton();
        addProjectLabel = new javax.swing.JLabel();
        addProjectButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        numProjLabel = new javax.swing.JLabel();
        CompileButton = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        mainClassField = new javax.swing.JTextField();
        srcDirLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        outputArea = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Project List Generator Rough Working Prototype");

        projectNameLabel.setText("Project Name:");

        projNameField.setText("ProjectNameTemplate");
        projNameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                projNameFieldActionPerformed(evt);
            }
        });

        srcDirLabel.setText("Project Source Dir:");

        srcDirField.setText("studentFiles");
        srcDirField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                srcDirFieldActionPerformed(evt);
            }
        });

        numRunsDesc1.setText("This project contains");

        numRunsLabel.setText("0");

        numRunsDesc2.setText("queued test runs.");

        testRunPaneLabel.setText("Add Test Runs Here:");

        testRunNameLabel.setText("Test Name: ");

        testNameField.setText("enter name of this test");

        numInputsDesc1.setText("This test contains");

        numInputsLabel.setText("0");

        numInputsDesc2.setText("queued input parameters.");

        inputPaneLabel.setText("Add Input Parameters to this Test Here:");

        nextInputLabel.setText("Next Input:");

        nextInputField.setText("enter next input parameter here");
        nextInputField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextInputFieldActionPerformed(evt);
            }
        });

        addInputButton.setText("Add Input");
        addInputButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addInputButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jSeparator4)
                                        .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(inputPaneLabel)
                                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                                                .addComponent(nextInputLabel)
                                                                .addGap(47, 47, 47)
                                                                .addComponent(nextInputField, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(4, 4, 4)
                                                                .addComponent(addInputButton)))
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(inputPaneLabel)
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(nextInputLabel)
                                        .addComponent(nextInputField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(addInputButton))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jSeparator4, javax.swing.GroupLayout.DEFAULT_SIZE, 10, Short.MAX_VALUE)
                                .addGap(10, 10, 10))
        );

        addTestLabel.setText("To finalize this test and add it to the project queue, click:");

        addTestButton.setText("Add Test");
        addTestButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addTestButtonActionPerformed(evt);
            }
        });

        expectOutField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                expectOutFieldActionPerformed(evt);
            }
        });

        jLabel2.setText("Expected Output (Optional):");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(numInputsDesc1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(numInputsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(numInputsDesc2)
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(testRunPaneLabel)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jSeparator3, javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addComponent(testRunNameLabel)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(testNameField))
                                                        .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                                .addGap(0, 0, Short.MAX_VALUE)
                                                                .addComponent(addTestLabel)
                                                                .addGap(79, 79, 79)
                                                                .addComponent(addTestButton, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                                                .addComponent(jLabel2)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(expectOutField)))
                                                .addGap(54, 54, 54))))
        );
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(testRunPaneLabel)
                                .addGap(5, 5, 5)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(testRunNameLabel)
                                        .addComponent(testNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(numInputsDesc1)
                                        .addComponent(numInputsLabel)
                                        .addComponent(numInputsDesc2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(expectOutField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(addTestButton, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(addTestLabel))
                                .addGap(3, 3, 3)
                                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        projListTextArea.setColumns(20);
        projListTextArea.setRows(5);
        jScrollPane1.setViewportView(projListTextArea);

        jLabel3.setText("Running List of Projects in ArrayList");

        refreshButton.setText("Refresh");
        refreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonActionPerformed(evt);
            }
        });

        addProjectLabel.setText("To finalize this project and add it to the arraylist of projects, click:");

        addProjectButton.setText("Add Project");
        addProjectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addProjectButtonActionPerformed(evt);
            }
        });

        jLabel4.setText("Number of Projects in ArrayLIst:");

        numProjLabel.setText("0");

        CompileButton.setText("Compile All");
        CompileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CompileButtonActionPerformed(evt);
            }
        });

        jLabel5.setText("To Run All Projects in ArrayList click:");

        mainClassField.setText("enter main class file name");
        mainClassField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mainClassFieldActionPerformed(evt);
            }
        });

        srcDirLabel1.setText("Project Main Class:");

        outputArea.setEditable(false);
        outputArea.setColumns(20);
        outputArea.setRows(25);
        jScrollPane2.setViewportView(outputArea);

        jLabel6.setText("Output Field:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                .addComponent(addProjectLabel)
                                                                                .addGap(18, 18, 18)
                                                                                .addComponent(addProjectButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                                                .addComponent(numRunsDesc1)
                                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(numRunsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(numRunsDesc2))
                                                                                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addGap(0, 0, Short.MAX_VALUE))))
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(srcDirLabel)
                                                                        .addComponent(projectNameLabel))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(projNameField)
                                                                        .addComponent(srcDirField)))
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(jLabel4)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(numProjLabel)
                                                                .addGap(0, 0, Short.MAX_VALUE))
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(srcDirLabel1)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(mainClassField)))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addComponent(jLabel5)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(CompileButton, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                        .addComponent(jLabel3)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                        .addComponent(refreshButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(31, 31, 31))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane2)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel6)
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(numProjLabel)
                                        .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(projectNameLabel)
                                        .addComponent(projNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3)
                                        .addComponent(refreshButton))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(srcDirLabel)
                                                        .addComponent(srcDirField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(srcDirLabel1)
                                                        .addComponent(mainClassField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(numRunsDesc1)
                                                        .addComponent(numRunsLabel)
                                                        .addComponent(numRunsDesc2))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(addProjectLabel)
                                                        .addComponent(addProjectButton)))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(CompileButton)
                                                        .addComponent(jLabel5))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void projNameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_projNameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_projNameFieldActionPerformed

    private void srcDirFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_srcDirFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_srcDirFieldActionPerformed

    private void addInputButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addInputButtonActionPerformed
        this.generator.getParamList().add(nextInputField.getText());
        numInputsLabel.setText(""+this.generator.getParamList().size());
        nextInputField.setText("");
    }//GEN-LAST:event_addInputButtonActionPerformed
    public void setOutputArea(String x){
        outputAreaText = x;
        outputArea.setText(x);
    }
    public void concatOutputArea(String x){
        if(outputAreaText.equals(null)){
            setOutputArea(x);
        }
        outputArea.setText(outputAreaText + x);
    }
    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        printProjList();
    }//GEN-LAST:event_refreshButtonActionPerformed

    private void nextInputFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextInputFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nextInputFieldActionPerformed

    private void addTestButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addTestButtonActionPerformed

        TestRun thisRun;
        if(expectOutField.getText().equals("")){
            thisRun = new TestRun(testNameField.getText(),this.generator.getParamList(),true);
        }
        else{
            thisRun = new TestRun(testNameField.getText(),this.generator.getParamList(),true);
        }
        expectOutField.setText("");
        this.generator.getTestRunsList().add(thisRun);
        numRunsLabel.setText(""+this.generator.getTestRunsList().size());
        testNameField.setText("");
        nextInputField.setText("");
        numInputsLabel.setText("0");
        this.generator.resetParams();

    }//GEN-LAST:event_addTestButtonActionPerformed

    private void expectOutFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_expectOutFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_expectOutFieldActionPerformed

    private void CompileButtonActionPerformed(java.awt.event.ActionEvent evt) {
        Setup s = new Setup(generator.getProjList());
        s.setFrame(this);
        s.compileRunProjects();
    }

    private void addProjectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addProjectButtonActionPerformed
        Project thisProject = new Project(projNameField.getText(),srcDirField.getText(),mainClassField.getText(),this.generator.getTestRunsList());

        this.generator.getProjList().add(thisProject);

        projNameField.setText("");
        srcDirField.setText("");
        mainClassField.setText("");
        expectOutField.setText("");
        numRunsLabel.setText("0");
        testNameField.setText("");
        nextInputField.setText("");
        numInputsLabel.setText("0");
        numProjLabel.setText(""+this.generator.getProjList().size());
        this.generator.resetParams();
        this.generator.resetTestRuns();
    }//GEN-LAST:event_addProjectButtonActionPerformed

    private void mainClassFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mainClassFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mainClassFieldActionPerformed

    private void printProjList(){
        projListTextArea.setText("");
        for(int i = 0; i < this.generator.getProjList().size(); i++){
            projListTextArea.append("\nProject Name: "+generator.getProjList().get(i).getName()
                    +"\nProject Src: "+generator.getProjList().get(i).getSrcDir()
                    +"\nMain Class: "+generator.getProjList().get(i).getMainClassName()
                    +"\n\n    Tests To Run: \n" );
            for(int j = 0; j < this.generator.getProjList().get(i).getTestRuns().size(); j++){
                projListTextArea.append("Test Name: " +this.generator.getProjList().get(i).getTestRuns().get(j).getName());

                projListTextArea.append("\nInput(s): \n");
                for(int k = 0; k < this.generator.getProjList().get(i).getTestRuns().get(j).getScannerInputs().size(); k++){
                    projListTextArea.append(this.generator.getProjList().get(i).getTestRuns().get(j).getScannerInputs().get(k)+"\n");
                }

            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CompileButton;
    private javax.swing.JButton addInputButton;
    private javax.swing.JButton addProjectButton;
    private javax.swing.JLabel addProjectLabel;
    private javax.swing.JButton addTestButton;
    private javax.swing.JLabel addTestLabel;
    private javax.swing.JTextField expectOutField;
    private javax.swing.JLabel inputPaneLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTextField mainClassField;
    private javax.swing.JTextField nextInputField;
    private javax.swing.JLabel nextInputLabel;
    private javax.swing.JLabel numInputsDesc1;
    private javax.swing.JLabel numInputsDesc2;
    private javax.swing.JLabel numInputsLabel;
    private javax.swing.JLabel numProjLabel;
    private javax.swing.JLabel numRunsDesc1;
    private javax.swing.JLabel numRunsDesc2;
    private javax.swing.JLabel numRunsLabel;
    private javax.swing.JTextArea outputArea;
    private String outputAreaText;
    private javax.swing.JTextArea projListTextArea;
    private javax.swing.JTextField projNameField;
    private javax.swing.JLabel projectNameLabel;
    private javax.swing.JButton refreshButton;
    private javax.swing.JTextField srcDirField;
    private javax.swing.JLabel srcDirLabel;
    private javax.swing.JLabel srcDirLabel1;
    private javax.swing.JTextField testNameField;
    private javax.swing.JLabel testRunNameLabel;
    private javax.swing.JLabel testRunPaneLabel;
    // End of variables declaration//GEN-END:variables
}
