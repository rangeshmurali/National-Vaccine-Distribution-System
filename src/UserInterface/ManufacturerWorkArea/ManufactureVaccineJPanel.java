/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package UserInterface.ManufacturerWorkArea;

import Business.Enterprise.Enterprise;
import Business.Inventory.Inventory;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author rangeshmurali
 */
public class ManufactureVaccineJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private Inventory inventory;
    private int requestedQuantity;
    
    public ManufactureVaccineJPanel(JPanel userProcessContainer, Inventory inventory, int requestedQuantity) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.requestedQuantity = requestedQuantity;
        this.inventory = inventory;
        vaccineIdJTextField.setText(String.valueOf(inventory.getVaccine().getVaccineId()));
        vaccineNameJTextField.setText(inventory.getVaccine().getVaccineName());
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
        manufactureDateJLabel = new javax.swing.JLabel();
        expiryDateJLabel = new javax.swing.JLabel();
        priceJLabel = new javax.swing.JLabel();
        manufactureDateJTextField = new javax.swing.JTextField();
        expiryDateJTextField = new javax.swing.JTextField();
        priceJTextField = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        backJButton = new javax.swing.JButton();
        vaccineIdJLabel = new javax.swing.JLabel();
        vaccineNameJLabel = new javax.swing.JLabel();
        vaccineIdJTextField = new javax.swing.JTextField();
        vaccineNameJTextField = new javax.swing.JTextField();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Manufacture Vaccine");

        manufactureDateJLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        manufactureDateJLabel.setText("Manufacture Date:");

        expiryDateJLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        expiryDateJLabel.setText("Expiry Date :");

        priceJLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        priceJLabel.setText("Price :");

        manufactureDateJTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        expiryDateJTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        priceJTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setText("Submit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        backJButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        backJButton.setText("<< Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });

        vaccineIdJLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        vaccineIdJLabel.setText("Vaccine ID :");

        vaccineNameJLabel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        vaccineNameJLabel.setText("Vaccine Name :");

        vaccineIdJTextField.setEditable(false);
        vaccineIdJTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        vaccineNameJTextField.setEditable(false);
        vaccineNameJTextField.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(359, 359, 359)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(manufactureDateJLabel)
                                    .addComponent(expiryDateJLabel)
                                    .addComponent(priceJLabel)
                                    .addComponent(vaccineIdJLabel)
                                    .addComponent(vaccineNameJLabel))
                                .addGap(156, 156, 156)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(manufactureDateJTextField)
                                    .addComponent(expiryDateJTextField)
                                    .addComponent(priceJTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                                    .addComponent(vaccineIdJTextField)
                                    .addComponent(vaccineNameJTextField)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(279, 279, 279)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(backJButton))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(197, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(vaccineIdJLabel)
                    .addComponent(vaccineIdJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(vaccineNameJLabel)
                    .addComponent(vaccineNameJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(manufactureDateJLabel)
                    .addComponent(manufactureDateJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(expiryDateJLabel)
                    .addComponent(expiryDateJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(priceJLabel)
                    .addComponent(priceJTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(backJButton)
                .addGap(84, 84, 84))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        userProcessContainer.remove(this);
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String manufactureDate = manufactureDateJTextField.getText();
        String expiryDate = expiryDateJTextField.getText();
        float price = Float.parseFloat(priceJTextField.getText());
        
        inventory.getVaccine().setManufactureDate(manufactureDate);
        inventory.getVaccine().setExpiryDate(expiryDate);
        inventory.getVaccine().setPrice(price);
        inventory.getVaccine().setAvailablity(inventory.getVaccine().getAvailablity() + requestedQuantity);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JLabel expiryDateJLabel;
    private javax.swing.JTextField expiryDateJTextField;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel manufactureDateJLabel;
    private javax.swing.JTextField manufactureDateJTextField;
    private javax.swing.JLabel priceJLabel;
    private javax.swing.JTextField priceJTextField;
    private javax.swing.JLabel vaccineIdJLabel;
    private javax.swing.JTextField vaccineIdJTextField;
    private javax.swing.JLabel vaccineNameJLabel;
    private javax.swing.JTextField vaccineNameJTextField;
    // End of variables declaration//GEN-END:variables
}
