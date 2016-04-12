/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package UserInterface.ProviderWorkArea;

import Business.EcoSystem;
import Business.Enterprise.ProviderEnterprise;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author rangeshmurali
 */
public class ManageHospitalWorkAreaJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private ProviderEnterprise providerEnterprise;
    
    public ManageHospitalWorkAreaJPanel(JPanel userProcessContainer, ProviderEnterprise providerEnterprise) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.providerEnterprise = providerEnterprise;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        addHospitalJButton1 = new javax.swing.JButton();
        manageEmployeeJButton1 = new javax.swing.JButton();
        manageUserAccountJButton = new javax.swing.JButton();
        backjButton1 = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Manage Hospital Work Area");

        addHospitalJButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        addHospitalJButton1.setText("Add Hospital >>");
        addHospitalJButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addHospitalJButton1ActionPerformed(evt);
            }
        });

        manageEmployeeJButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        manageEmployeeJButton1.setText("Manage Hospital Employee >>");
        manageEmployeeJButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageEmployeeJButton1ActionPerformed(evt);
            }
        });

        manageUserAccountJButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        manageUserAccountJButton.setText("Manage Hospital UserAccount >>");
        manageUserAccountJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageUserAccountJButtonActionPerformed(evt);
            }
        });

        backjButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        backjButton1.setText("<< Back");
        backjButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backjButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(269, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(258, 258, 258))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(manageUserAccountJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(manageEmployeeJButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addHospitalJButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(272, 272, 272))))
            .addGroup(layout.createSequentialGroup()
                .addGap(203, 203, 203)
                .addComponent(backjButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(64, 64, 64)
                .addComponent(manageEmployeeJButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(manageUserAccountJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(addHospitalJButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59)
                .addComponent(backjButton1)
                .addContainerGap(253, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addHospitalJButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addHospitalJButton1ActionPerformed
        AddHospitalJPanel addHospitalJPanel = new AddHospitalJPanel(userProcessContainer, providerEnterprise);
        userProcessContainer.add("AddHospitalJPanel", addHospitalJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_addHospitalJButton1ActionPerformed

    private void manageEmployeeJButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageEmployeeJButton1ActionPerformed
        ManageHospitalEmploeeJPanel manageEmploeeJPanel = new ManageHospitalEmploeeJPanel(userProcessContainer, providerEnterprise);
        userProcessContainer.add("ManageEmploeeJPanel", manageEmploeeJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_manageEmployeeJButton1ActionPerformed

    private void manageUserAccountJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageUserAccountJButtonActionPerformed
        ManageHospitalUserAccountJPanel manageManageUserAccountJPanel = new ManageHospitalUserAccountJPanel(userProcessContainer, providerEnterprise);
        userProcessContainer.add("ManageUserAccountJPanel", manageManageUserAccountJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_manageUserAccountJButtonActionPerformed

    private void backjButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backjButton1ActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backjButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addHospitalJButton1;
    private javax.swing.JButton backjButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton manageEmployeeJButton1;
    private javax.swing.JButton manageUserAccountJButton;
    // End of variables declaration//GEN-END:variables
}
