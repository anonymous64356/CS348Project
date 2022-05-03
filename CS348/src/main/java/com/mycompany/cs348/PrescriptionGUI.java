/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.cs348;

import static com.mycompany.cs348.CS348.getResultFromQuery;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;

import static com.mycompany.cs348.CS348.getResultFromQuery;
import com.mycompany.cs348.PrescriptionUpdate;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;

import static com.mycompany.cs348.CS348.getResultFromQuery;
import com.mycompany.cs348.PrescriptionUpdate;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Joseph Murphy
 */
public class PrescriptionGUI extends javax.swing.JFrame {

    /**
     * Creates new form PerscriptionGUI
     */
    /*
        patientResult format:
        resultArray[0] = prescriptionID (string)
        resultArray[1] = patientID (string)
        resultArray[2] = employeeID (string)
        resultArray[3] = medicineID (string)
        resultArray[4] = quantity (int)
        resultArray[5] = cost (double)
        resultArray[6] = frequency (int)
        resultArray[7] = lastFilled (date)
        resultArray[8] = nextFill (date)
    */
    private ArrayList<Object[]> patientResult = new ArrayList<>();
    private ArrayList<String> prescriptionIDs = new ArrayList<>();
    private String patientName = "";
    private String patientID = "";
    private String doctorID = "";
    private String medicineName = "";
    
    public PrescriptionGUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        patientText = new javax.swing.JTextField();
        employeeText = new javax.swing.JTextField();
        getPrescriptions = new javax.swing.JButton();
        prescriptionInfoPane = new javax.swing.JScrollPane();
        prescriptionInfo = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        prescriptionSelect = new javax.swing.JComboBox<>();
        refillButton = new javax.swing.JButton();
        prescriptionText = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        employeeSSNText = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        patientText.setToolTipText("Enter Employee ID");
        patientText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                patientTextKeyPressed(evt);
            }
        });

        employeeText.setToolTipText("Enter Employee ID");

        getPrescriptions.setText("Get Prescriptions");
        getPrescriptions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getPrescriptionsActionPerformed(evt);
            }
        });

        prescriptionInfo.setVisible(false);
        prescriptionInfo.setColumns(20);
        prescriptionInfo.setEditable(false);
        prescriptionInfo.setRows(5);
        prescriptionInfoPane.setViewportView(prescriptionInfo);

        jLabel1.setText("Employee ID:");

        jLabel2.setText("Patient ID:");

        prescriptionSelect.setVisible(false);
        prescriptionSelect.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0" }));
        prescriptionSelect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                prescriptionSelectActionPerformed(evt);
            }
        });

        refillButton.setVisible(false);
        refillButton.setText("Refill Prescription");
        refillButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refillButtonActionPerformed(evt);
            }
        });

        prescriptionText.setText("Select Prescription:");

        jLabel3.setText("Employee SSN:");

        employeeSSNText.setText("jPasswordField1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(prescriptionSelect, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(prescriptionText, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(refillButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(employeeText))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(employeeSSNText, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(prescriptionInfoPane, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(patientText, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(getPrescriptions)))
                .addGap(13, 13, 13))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(employeeText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(patientText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(getPrescriptions)
                            .addComponent(employeeSSNText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(28, 28, 28)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(prescriptionInfoPane, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(prescriptionText)
                        .addGap(12, 12, 12)
                        .addComponent(prescriptionSelect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(refillButton)))
                .addContainerGap(74, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
 
    private void getPrescriptionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getPrescriptionsActionPerformed
        prescriptionInfo.setText("");
        patientID = patientText.getText();
        doctorID = employeeText.getText();
        String doctorSSN = employeeSSNText.getText();
        ResultSet result = getResultFromQuery(String.format("SELECT * FROM Patients WHERE Patient_ID = %s", patientID));
        if (result != null) {
            try {
                result.next();
                patientName = result.getString("Name");
                prescriptionInfo.append("Patient Name: " + patientName);
            } catch (SQLException ex) {
                Logger.getLogger(PrescriptionGUI.class.getName()).log(Level.SEVERE, null, ex);
                prescriptionInfo.setVisible(true);
                prescriptionInfo.append("Patient with ID " + patientID + " does not exist in our system");
                return;
            }
        } else {
            prescriptionInfo.setVisible(true);
            prescriptionInfo.append("Patient with ID " + patientID + " does not exist in our system");
            return;
        }
        result = getResultFromQuery(String.format("CALL getPatientPrescriptions(%s, %s, %s)", patientID, doctorID, doctorSSN));
        try {
            prescriptionIDs.clear();
            patientResult.clear();
            while (result.next()) {
                Object[] resultArray = new Object[9];
                prescriptionIDs.add(result.getString("prescriptionID"));
                resultArray[0] = result.getString("prescriptionID");
                resultArray[1] = patientID;
                resultArray[2] = doctorID;
                resultArray[3] = result.getString("medicineID");
                resultArray[4] = result.getInt("quantity");
                resultArray[5] = result.getDouble("cost");
                resultArray[6] = result.getInt("frequency");
                resultArray[7] = result.getDate("lastFilled");
                resultArray[8] = result.getDate("nextFill");
                patientResult.add(resultArray);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PrescriptionGUI.class.getName()).log(Level.SEVERE, null, ex);
            try {
                String error = result.getString(1);
                JOptionPane.showMessageDialog(rootPane, error, "ERROR", JOptionPane.ERROR_MESSAGE);
                return;
            } catch (SQLException ex2) {
                Logger.getLogger(PrescriptionGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        prescriptionIDs.add("Create New..."); //select this on wheel to create new prescription
        if (patientResult.isEmpty()) {
            refillButton.setText("Create Prescription");
            prescriptionInfo.append("\n\nNo prescriptions in system");
        } else
            refillButton.setText("Refill Prescription");
        prescriptionSelect.setModel(new DefaultComboBoxModel(prescriptionIDs.toArray()));
        prescriptionSelect.setVisible(true);
        prescriptionInfo.setVisible(true);
        prescriptionText.setVisible(true);
        refillButton.setVisible(true);
        prescriptionSelectActionPerformed(null);
    }//GEN-LAST:event_getPrescriptionsActionPerformed

    private void prescriptionSelectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_prescriptionSelectActionPerformed
            // TODO add your handling code here:
        int i = prescriptionSelect.getSelectedIndex(); //shift everything by one because SQL starts at 1
        if (i == prescriptionIDs.size() - 1) {//if last item is selected, new prescription is created
            if (!patientResult.isEmpty()) {
                Object[] newPrescription = new Object[] {"", patientID, doctorID, "", 0, 0.0, 0, null, null};
                new PrescriptionUpdate(newPrescription, false, "", patientResult).setVisible(true);
                getPrescriptions.doClick();
            }
            return;
        }
        
        try {
            Object[] result = patientResult.get(i);
            prescriptionInfo.setText("Patient Name: " + patientName);
            prescriptionInfo.append("\nPrescription ID: " + result[0]);
            ResultSet medicineName = getResultFromQuery(String.format("SELECT * FROM medicine WHERE medicineID = %s", result[3]));
            medicineName.next();
            this.medicineName = medicineName.getString("name");
            prescriptionInfo.append("\nMedicine: " + this.medicineName);
            prescriptionInfo.append("\nQuantity: " + result[4]);
            prescriptionInfo.append("\nCost: $" + result[5]);
            prescriptionInfo.append("\nFrequency: Every " + result[6] + " Days");
            prescriptionInfo.append("\nLast Filled: " + result[7].toString());
            prescriptionInfo.append("\nNext Fill: ");
            if (result[8] == null)
                prescriptionInfo.append("No more refills");
            else
                prescriptionInfo.append(result[8].toString());
        } catch (SQLException ex) {
            Logger.getLogger(PrescriptionGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_prescriptionSelectActionPerformed

    private void patientTextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_patientTextKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER)
            getPrescriptions.doClick();
    }//GEN-LAST:event_patientTextKeyPressed

    private void refillButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refillButtonActionPerformed
        // TODO add your handling code here:
        if (patientResult.isEmpty()) {
            Object[] newPrescription = new Object[] {"", patientID, doctorID, "", 0, 0.0, 0, null, null};
            new PrescriptionUpdate(newPrescription, false, "", patientResult).setVisible(true);
        } else {
            new PrescriptionUpdate(patientResult.get(prescriptionSelect.getSelectedIndex()), true, medicineName, patientResult).setVisible(true);
        }
        getPrescriptions.doClick();
    }//GEN-LAST:event_refillButtonActionPerformed
               

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
            java.util.logging.Logger.getLogger(PrescriptionGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PrescriptionGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PrescriptionGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PrescriptionGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PrescriptionGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField employeeSSNText;
    private javax.swing.JTextField employeeText;
    private javax.swing.JButton getPrescriptions;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField patientText;
    private javax.swing.JTextArea prescriptionInfo;
    private javax.swing.JScrollPane prescriptionInfoPane;
    private javax.swing.JComboBox<String> prescriptionSelect;
    private javax.swing.JLabel prescriptionText;
    private javax.swing.JButton refillButton;
    // End of variables declaration//GEN-END:variables
}
