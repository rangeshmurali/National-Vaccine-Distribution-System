/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package UserInterface.HospitalWorkArea;

import Business.Vaccine.Vaccine;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author rangeshmurali
 */
public class ViewVaccineDetailsJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private Vaccine vaccine;
    
    public ViewVaccineDetailsJPanel(JPanel userProcessContainer, Vaccine vaccine) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.vaccine = vaccine;
        populateForm();
    }
    
    public void populateForm(){
        vaccineNameJTextField.setText(vaccine.getVaccineName());
        vaccineIdJTextField.setText(String.valueOf(vaccine.getVaccineId()));
        diseasesNameJTextField.setText(vaccine.getDiseasesName());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        diseasesNameJLabel = new javax.swing.JLabel();
        quantityJLabel = new javax.swing.JLabel();
        vaccineNameJTextField = new javax.swing.JTextField();
        diseasesNameJTextField = new javax.swing.JTextField();
        vaccineIdJTextField = new javax.swing.JTextField();
        backJButton = new javax.swing.JButton();
        titleJLabel = new javax.swing.JLabel();
        vaccineNameJLabel = new javax.swing.JLabel();

        diseasesNameJLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        diseasesNameJLabel.setText("Diseases Name :");

        quantityJLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        quantityJLabel.setText("Vaccine ID :");

        vaccineNameJTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        diseasesNameJTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        vaccineIdJTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        backJButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        backJButton.setText("<< back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });

        titleJLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        titleJLabel.setText("View Vaccine Details");

        vaccineNameJLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        vaccineNameJLabel.setText("Vaccine Name :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(backJButton)
                        .addGap(761, 761, 761))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(diseasesNameJLabel)
                            .addComponent(quantityJLabel)
                            .addComponent(vaccineNameJLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 290, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(vaccineNameJTextField)
                            .addComponent(vaccineIdJTextField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(diseasesNameJTextField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(276, 276, 276))))
            .addGroup(layout.createSequentialGroup()
                .addGap(288, 288, 288)
                .addComponent(titleJLabel)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(titleJLabel)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(vaccineNameJLabel)
                            .addComponent(vaccineNameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50)
                        .addComponent(diseasesNameJLabel))
                    .addComponent(diseasesNameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(vaccineIdJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(quantityJLabel)))
                .addGap(142, 142, 142)
                .addComponent(backJButton)
                .addContainerGap(162, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JLabel diseasesNameJLabel;
    private javax.swing.JTextField diseasesNameJTextField;
    private javax.swing.JLabel quantityJLabel;
    private javax.swing.JLabel titleJLabel;
    private javax.swing.JTextField vaccineIdJTextField;
    private javax.swing.JLabel vaccineNameJLabel;
    private javax.swing.JTextField vaccineNameJTextField;
    // End of variables declaration//GEN-END:variables
}
