/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import ChatGPT.*;
import Log.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hoaht
 */
public class HomeForm extends javax.swing.JFrame {
    /**
     * Creates new form HomeForm
     */
    public HomeForm() {
        this.setTitle("Analyze System");
        initComponents();
        
        // resize the format of form
        resizeFormatForm();
        
        // addOptionToComboBox
        String[] options = {"Analyzing nouns","Analyzing verb","Analyzing adjectives"};
        addOptionToComboBox(combo_analyze, options);
    }
    
    void resizeFormatForm() {
        this.setBounds(500, 250, this.getBounds().width, this.getBounds().height);
    }
    
    void addOptionToComboBox(JComboBox xJComboBox, String[] options) {
        for (String option : options) {
            xJComboBox.addItem(option);
        }
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
        combo_analyze = new javax.swing.JComboBox<>();
        text_topic = new javax.swing.JTextField();
        check_analyzeByTopic = new javax.swing.JCheckBox();
        btn_analyze = new javax.swing.JButton();
        btn_clear = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        text_input = new javax.swing.JEditorPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        text_output = new javax.swing.JEditorPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Analysis Options");

        text_topic.setEditable(false);
        text_topic.setText("Click check analyze by topic to enter your topic");
        text_topic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                text_topicActionPerformed(evt);
            }
        });

        check_analyzeByTopic.setText("Analyze by topic");
        check_analyzeByTopic.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                check_analyzeByTopicItemStateChanged(evt);
            }
        });
        check_analyzeByTopic.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check_analyzeByTopicActionPerformed(evt);
            }
        });

        btn_analyze.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_analyze.setText("Analyze");
        btn_analyze.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_analyzeActionPerformed(evt);
            }
        });

        btn_clear.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btn_clear.setText("Clear");
        btn_clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clearActionPerformed(evt);
            }
        });

        jScrollPane3.setViewportView(text_input);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btn_clear, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_analyze, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(combo_analyze, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(check_analyzeByTopic)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 189, Short.MAX_VALUE)
                        .addComponent(text_topic, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(check_analyzeByTopic, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(combo_analyze, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(text_topic, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_analyze, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_clear, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Result");

        jScrollPane1.setViewportView(text_output);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void text_topicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_text_topicActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_text_topicActionPerformed

    private void check_analyzeByTopicActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check_analyzeByTopicActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_check_analyzeByTopicActionPerformed

    private void check_analyzeByTopicItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_check_analyzeByTopicItemStateChanged
        if (check_analyzeByTopic.isSelected()) {
            combo_analyze.setEnabled(false);
            text_topic.setEditable(true);
            text_topic.setText("");
        } else {
            combo_analyze.setEnabled(true);
            text_topic.setEditable(false);
            text_topic.setText("Click check analyze by topic to enter your topic");
        }
    }//GEN-LAST:event_check_analyzeByTopicItemStateChanged

    private void btn_clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clearActionPerformed
        text_input.setText("");
        text_output.setText("");
        
        if (check_analyzeByTopic.isSelected()) {
            text_topic.setText("");
        }
    }//GEN-LAST:event_btn_clearActionPerformed

    private void btn_analyzeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_analyzeActionPerformed
        if (check_analyzeByTopic.isSelected()) {
            if (text_topic.getText().length() == 0 || text_input.getText().length() == 0) {
                showAlert("You must be input topic and paragraph you want to analyze!");
            } else {
                if (ListLog.isContainInput(text_input.getText().trim(), text_topic.getText().trim())) {
                    text_output.setText(ListLog.getOutputByInput(text_input.getText().trim(), text_topic.getText().trim()));
                    System.out.println("Duplicate input");
                } else {
                    System.out.println("Not Duplicate");
                    boolean isRespond;
                    try {
                        String output = ChatGPT.analyzeByTopic(text_topic.getText().trim(), text_input.getText().trim());
                        text_output.setText(output);
                        isRespond = true;
                    } catch (IOException ex) {
                        System.out.println("Error with chat gpt connect");
                        isRespond = false;
                    }

                    if (isRespond) {
                        Log log = new Log(text_input.getText(), -1, text_output.getText(), text_topic.getText().trim());
                        ListLog.writeLog(log);
                    }
                }
                ListLog.printLog();
            }
        } else {
            if (text_input.getText().length() == 0) {
                showAlert("You must be input paragraph you want to analyze!");
            } else {
                int typeAnalyze = combo_analyze.getSelectedIndex();
                
                typeAnalyze += 1;
                switch (typeAnalyze) {
                    case 1: 
                    {
                        if (ListLog.isContainInput(text_input.getText().trim(), typeAnalyze)) {
                            text_output.setText(ListLog.getOutputByInput(text_input.getText().trim(), typeAnalyze));
                            System.out.println("Duplicate input");
                        } else {
                            boolean isRespond;
                            try {
                                String output = ChatGPT.listNouns(text_input.getText().trim());
                                text_output.setText(output);
                                isRespond = true;
                            } catch (IOException ex) {
                                System.out.println("Error with chat gpt connect!");
                                isRespond = false;
                            }

                            if (isRespond) {
                                Log log = new Log(text_input.getText(), typeAnalyze, text_output.getText(), "");
                                ListLog.writeLog(log);
                            }
                        }
                        
                        break; 
                    } 
                    case 2: 
                    {
                        if (ListLog.isContainInput(text_input.getText().trim(), typeAnalyze)) {
                            text_output.setText(ListLog.getOutputByInput(text_input.getText().trim(), typeAnalyze));
                            System.out.println("Duplicate input");
                        } else {
                            String output = "";
                            boolean isRespondSuccess;
                            try {
                                output = ChatGPT.listVerbs(text_input.getText().trim());
                                text_output.setText(output);
                                isRespondSuccess = true;
                            } catch (IOException ex) {
                                System.out.println("Error with chat gpt connect!");
                                isRespondSuccess = false;
                            }

                            if (isRespondSuccess) {
                                Log log = new Log(text_input.getText(), typeAnalyze, text_output.getText(), "");
                                ListLog.writeLog(log);
                            }
                        }
                        
                        break; 
                    }
                    case 3: 
                    {
                        if (ListLog.isContainInput(text_input.getText().trim(), typeAnalyze)) {
                            text_output.setText(ListLog.getOutputByInput(text_input.getText().trim(), typeAnalyze));
                            System.out.println("Duplicate input");
                        } else {
                            String output = "";
                            boolean isRespondSuccess;
                            try {
                                output = ChatGPT.listAdjectives(text_input.getText().trim());
                                text_output.setText(output);
                                isRespondSuccess = true;
                            } catch (IOException ex) {
                                System.out.println("Error with chat gpt connect!");
                                isRespondSuccess = false;
                            }

                            if (isRespondSuccess) { 
                                Log log = new Log(text_input.getText(), typeAnalyze, text_output.getText(), "");
                                ListLog.writeLog(log);
                            }
                        }
                        
                        break; 
                    }
                    default: break;
                }
                
                ListLog.printLog();
            }
        }
    }//GEN-LAST:event_btn_analyzeActionPerformed
        
    void showAlert(String msg) {
        JOptionPane.showMessageDialog(null, msg);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HomeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomeForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_analyze;
    private javax.swing.JButton btn_clear;
    private javax.swing.JCheckBox check_analyzeByTopic;
    private javax.swing.JComboBox<String> combo_analyze;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JEditorPane text_input;
    private javax.swing.JEditorPane text_output;
    private javax.swing.JTextField text_topic;
    // End of variables declaration//GEN-END:variables
}
