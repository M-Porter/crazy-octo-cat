/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Controllers.MainMenuCntl;
import Views.ProjectTemplateManagerUI;
import Controllers.*;
import Models.*;
import Views.CourseCreationUI;
import java.awt.BorderLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;


/**
 *
 * @author Jeralyn Tseng
 */
public class MainMenuUI extends javax.swing.JFrame {
    private MainMenuCntl theMainMenuCntl;
    private JTree tree;
    private JLabel selectedLabel;
    private ArrayList<Course> theCourseList;
    private ArrayList<Student> theStudentList;
    private ArrayList<Project> theProjectList;
    /**
     * Creates new form Management
     */
    public MainMenuUI(MainMenuCntl theMainMenuCntl) {
        this.theMainMenuCntl = theMainMenuCntl;
        
        customComponent();
        initComponents();
        this.setVisible(true);
        jScrollPane1.setViewportView(tree);
        populateTree();
       
        selectedLabel = new JLabel();
        add(selectedLabel, BorderLayout.SOUTH);
 
        tree.getSelectionModel().addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
                selectedLabel.setText(selectedNode.getUserObject().toString());
            }
        });

        //this.jScrollPane1.repaint();
        this.setVisible(true);
        this.tree.setVisible(true);
    }
    public void populateCourseTree(){
        DefaultMutableTreeNode courses = new DefaultMutableTreeNode("Courses");
        for (int i = 0; i < theCourseList.size(); i++){
            // Add the courses to the root node
            CourseNode courseToAdd = new CourseNode(theCourseList.get(i));
            courses.add(courseToAdd);
        }
    }
    public void populateTree(){
        DefaultMutableTreeNode courses = new DefaultMutableTreeNode("Courses");
        for (int i = 0; i < theCourseList.size(); i++){
            // Add the courses to the root node
            CourseNode courseToAdd = new CourseNode(theCourseList.get(i));
            courses.add(courseToAdd);
            // Add the students to each course    
            ArrayList<Student> theStudentList = PersistentDataModelCntl.getPDMCntl().getPDM().theInstructor.getCourseList().get(i).getStudentList();
            
            for (int j = 0; j < theStudentList.size(); j++){
                Student test = theStudentList.get(j);
                StudentNode studentToAdd = new StudentNode(test);
                System.out.println("Student Node: "+studentToAdd.toString());
                courseToAdd.add(studentToAdd);
                
                // Add the projects to each student
                ArrayList<Project> theProjectList = PersistentDataModelCntl.getPDMCntl().getPDM().getInstructor().getCourseList().get(i).getStudentList().get(j).getProjectList();
                for (int k = 0; k < theProjectList.size(); k++){
                    ProjectNode projectToAdd = new ProjectNode(theProjectList.get(k));
                    System.out.println("Project Node: "+projectToAdd.toString());
                    studentToAdd.add(projectToAdd);
                }
            }
        }
        tree = new JTree(courses);
        tree.setShowsRootHandles(true);
        tree.setRootVisible(true);
        jScrollPane1.setViewportView(tree);
    }
    
    public void customComponent(){
        theCourseList = PersistentDataModelCntl.getPDMCntl().getPDM().getInstructor().getCourseList();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        mainPanel = new javax.swing.JPanel();
        runsSeparator = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        prevRunPane = new javax.swing.JTextPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        currentRunPane = new javax.swing.JTextPane();
        projectsComboBox = new javax.swing.JComboBox();
        applyProjectBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        runBtn = new javax.swing.JButton();
        pauseBtn = new javax.swing.JButton();
        stopBtn = new javax.swing.JButton();
        addCourseBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        projectTemplatesBtn = new javax.swing.JButton();
        addStudentBtn = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        editMenu = new javax.swing.JMenu();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        prevRunPane.setText("This area will contain a *table* outling the previously ran projects associated with either a course or student.\n\n\t-Selecting a *course and project* will show all of the run results for that *project* in that course\n\n\t-Selecting a *student* will show the run results of *all projects* of that particular student.");
        jScrollPane2.setViewportView(prevRunPane);

        currentRunPane.setText("This area will contain the progress and results of the current run.\n\tInfo like:\n\t- Current Project/Test Run\n\t-  Final Tally of Run Results:\n\t\t- # of projects compiled\n\t\t- # failed to compile\n\t\t- time running\n\t\t- etc.");
        jScrollPane3.setViewportView(currentRunPane);
        currentRunPane.getAccessibleContext().setAccessibleName("");

        projectsComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Project 1", "Project 2", "Project 3", "Project 4" }));
        projectsComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                projectsComboBoxActionPerformed(evt);
            }
        });

        applyProjectBtn.setText("Apply Project To Selected");
        applyProjectBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                applyProjectBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(projectsComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(applyProjectBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)))
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(runsSeparator)
                    .addComponent(jScrollPane3)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(runsSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(projectsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(applyProjectBtn)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        runBtn.setText("Run");
        runBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                runBtnActionPerformed(evt);
            }
        });

        pauseBtn.setText("Pause");
        pauseBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pauseBtnActionPerformed(evt);
            }
        });

        stopBtn.setText("Stop");

        addCourseBtn.setText("Add Course");
        addCourseBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addCourseBtnActionPerformed(evt);
            }
        });

        deleteBtn.setText("Delete");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        projectTemplatesBtn.setText("Project Templates");
        projectTemplatesBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                projectTemplatesBtnActionPerformed(evt);
            }
        });

        addStudentBtn.setText("Add Student");
        addStudentBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addStudentBtnActionPerformed(evt);
            }
        });

        fileMenu.setText("File");
        menuBar.add(fileMenu);

        editMenu.setText("Edit");
        menuBar.add(editMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addCourseBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addStudentBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(projectTemplatesBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(runBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pauseBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(stopBtn)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addCourseBtn)
                    .addComponent(deleteBtn)
                    .addComponent(runBtn)
                    .addComponent(pauseBtn)
                    .addComponent(stopBtn)
                    .addComponent(projectTemplatesBtn)
                    .addComponent(addStudentBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addCourseBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addCourseBtnActionPerformed
        theMainMenuCntl.getCourseCreationUI();
    }//GEN-LAST:event_addCourseBtnActionPerformed

    private void pauseBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pauseBtnActionPerformed

    }//GEN-LAST:event_pauseBtnActionPerformed

    private void runBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_runBtnActionPerformed
        theMainMenuCntl.getRunSetupUI(tree);
    }//GEN-LAST:event_runBtnActionPerformed

    private void projectTemplatesBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_projectTemplatesBtnActionPerformed
        theMainMenuCntl.getProjectTemplateUI();
    }//GEN-LAST:event_projectTemplatesBtnActionPerformed

    private void addStudentBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addStudentBtnActionPerformed
        theMainMenuCntl.getStudentUI();
    }//GEN-LAST:event_addStudentBtnActionPerformed

    private void projectsComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_projectsComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_projectsComboBoxActionPerformed

    private void applyProjectBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_applyProjectBtnActionPerformed
        DefaultTreeModel model = (DefaultTreeModel) tree.getModel();
        DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
        String value = projectsComboBox.getSelectedItem().toString();
        DefaultMutableTreeNode newProject = new DefaultMutableTreeNode(value);
        model.insertNodeInto(newProject, selectedNode, WIDTH); 

    }//GEN-LAST:event_applyProjectBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
       if(JOptionPane.showConfirmDialog(null, "Are you sure you want to delete this?", 
            "Delete This File? ",
            JOptionPane.YES_NO_OPTION)== JOptionPane.YES_OPTION ){
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
            if (node == null){
                return;
            }
            else if (node instanceof CourseNode){
                System.out.println("The Full Course List: ");
                for (int i = 0; i < theCourseList.size(); i++){
                    System.out.println(theCourseList.get(i).getCourseID());
                }
                System.out.println("The node as a string: " + node.toString());
                theCourseList.remove(node);
                this.populateCourseTree();
                this.repaint();
                PersistentDataModelCntl.getPDMCntl().writePDMFile();
            }
            else if (node instanceof StudentNode){
                theStudentList.remove(node);
                this.populateTree();
                this.repaint();
            }
            else if (node instanceof ProjectNode){
                theProjectList.remove(node);
            }       
        }
    }//GEN-LAST:event_deleteBtnActionPerformed

    /**
     * @param args the command line arguments
     */
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addCourseBtn;
    private javax.swing.JButton addStudentBtn;
    private javax.swing.JButton applyProjectBtn;
    private javax.swing.JTextPane currentRunPane;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JButton pauseBtn;
    private javax.swing.JTextPane prevRunPane;
    private javax.swing.JButton projectTemplatesBtn;
    private javax.swing.JComboBox projectsComboBox;
    private javax.swing.JButton runBtn;
    private javax.swing.JSeparator runsSeparator;
    private javax.swing.JButton stopBtn;
    // End of variables declaration//GEN-END:variables
}
