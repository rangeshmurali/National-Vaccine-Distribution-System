/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package UserInterface.PublicHealthDepartmentWorkArea;

import Business.EcoSystem;
import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Enterprise.PublicHealthEnterprise;
import Business.Network.Network;
import Business.Order.Order;
import Business.Order.OrderItem;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.VaccineRequest;
import Business.WorkQueue.WorkRequest;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rangeshmurali
 */
public class ManageVaccineOrderJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private UserAccount userAccount;
    private EcoSystem ecoSystem;
    private PublicHealthEnterprise publicHealthEnterprise;
    
    public ManageVaccineOrderJPanel(JPanel userProcessContainer, UserAccount userAccount, EcoSystem ecoSystem, PublicHealthEnterprise publicHealthEnterprise) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.userAccount = userAccount;
        this.ecoSystem = ecoSystem;
        this.publicHealthEnterprise = publicHealthEnterprise;
        populateProviderComboBox();
    }
    
    public void populateProviderComboBox(){
        providerJComboBox.removeAllItems();
        providerJComboBox.addItem("Hospital");
        providerJComboBox.addItem("Pharmacy");
    }
    
    public void populateHospitalVaccineTable(){
        DefaultTableModel dtm = (DefaultTableModel) vaccineRequestJTable.getModel();
        dtm.setRowCount(0);
        
        for(WorkRequest request : publicHealthEnterprise.getWorkQueue().getWorkRequestList()){
            if(request.getRequestType().equalsIgnoreCase("Hospital Vaccine Request")){
                Object[] row = new Object[5];
                row[0] = request;
                row[1] = request.getSender().getEmployee().getHospital().getHospitalName();
                row[2] = request.getSender();
                row[3] = request.getReceiver() == null? null : request.getReceiver();
                row[4] = request.getStatus();
                dtm.addRow(row);
            }
        }
    }
    
    public void populatePharmacyVaccineTable(){
        DefaultTableModel dtm = (DefaultTableModel) vaccineRequestJTable.getModel();
        dtm.setRowCount(0);
        
        for(WorkRequest request : publicHealthEnterprise.getWorkQueue().getWorkRequestList()){
            if(request.getRequestType().equalsIgnoreCase("Pharmacy Vaccine Request")){
                Object[] row = new Object[5];
                row[0] = request;
                row[1] = request.getSender().getEmployee().getPharmacy().getPharmacyName();
                row[2] = request.getSender();
                row[3] = request.getReceiver() == null? null : request.getReceiver();
                row[4] = request.getStatus();
                dtm.addRow(row);
            }
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

        assignJButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        vaccineRequestJTable = new javax.swing.JTable();
        viewJButton = new javax.swing.JButton();
        forwardJButton = new javax.swing.JButton();
        rejectJButton = new javax.swing.JButton();
        backJButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        vaccineTableJTable = new javax.swing.JTable();
        providerJComboBox = new javax.swing.JComboBox();

        assignJButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        assignJButton.setText("Assign to me");
        assignJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignJButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Manage Vaccine Order");

        vaccineRequestJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Request Type", "Provider Name", "Employee Name", "Sales Specialist Name", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(vaccineRequestJTable);
        if (vaccineRequestJTable.getColumnModel().getColumnCount() > 0) {
            vaccineRequestJTable.getColumnModel().getColumn(0).setResizable(false);
            vaccineRequestJTable.getColumnModel().getColumn(1).setResizable(false);
            vaccineRequestJTable.getColumnModel().getColumn(2).setResizable(false);
            vaccineRequestJTable.getColumnModel().getColumn(3).setResizable(false);
            vaccineRequestJTable.getColumnModel().getColumn(4).setResizable(false);
        }

        viewJButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        viewJButton.setText("View Order");
        viewJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewJButtonActionPerformed(evt);
            }
        });

        forwardJButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        forwardJButton.setText("Forward to CDC");
        forwardJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                forwardJButtonActionPerformed(evt);
            }
        });

        rejectJButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        rejectJButton.setText("Reject");
        rejectJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rejectJButtonActionPerformed(evt);
            }
        });

        backJButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        backJButton.setText("<< Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });

        vaccineTableJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Vaccine Name", "Quantity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(vaccineTableJTable);
        if (vaccineTableJTable.getColumnModel().getColumnCount() > 0) {
            vaccineTableJTable.getColumnModel().getColumn(0).setResizable(false);
            vaccineTableJTable.getColumnModel().getColumn(1).setResizable(false);
        }

        providerJComboBox.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        providerJComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                providerJComboBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(169, 169, 169)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(providerJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(viewJButton)
                                    .addGap(28, 28, 28)
                                    .addComponent(assignJButton)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(forwardJButton)
                                    .addGap(18, 18, 18)
                                    .addComponent(rejectJButton))
                                .addComponent(backJButton)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 591, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(330, 330, 330)
                        .addComponent(jLabel1)))
                .addContainerGap(182, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(providerJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(viewJButton)
                    .addComponent(forwardJButton)
                    .addComponent(rejectJButton)
                    .addComponent(assignJButton))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66)
                .addComponent(backJButton)
                .addContainerGap(70, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void assignJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignJButtonActionPerformed
        int selectedRow = vaccineRequestJTable.getSelectedRow();

        if(selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Please select a row from the table.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if(vaccineRequestJTable.getValueAt(selectedRow, 3) != null){
            JOptionPane.showMessageDialog(null, "The request is already assigned", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        VaccineRequest request = (VaccineRequest) vaccineRequestJTable.getValueAt(selectedRow, 0);
        request.setReceiver(userAccount);
        request.setStatus("Pending");
        UserAccount userAccount = (UserAccount) request.getSender();
        Employee employee = (Employee) userAccount.getEmployee();
        for(Order order : employee.getMasterOrderCatalog().getMasterOrderList()){
            if(request.getOrderId() == order.getOrderId()){
                order.setOrderStatus("Waiting for Approval");
            }
        }
        if(request.getSender().getEmployee().getCheck().equalsIgnoreCase("Hospital")){
            populateHospitalVaccineTable();
        } else if(request.getSender().getEmployee().getCheck().equalsIgnoreCase("Pharmacy")){
            populatePharmacyVaccineTable();
        }
        JOptionPane.showMessageDialog(null, "The request is assigned to " + request.getReceiver());
    }//GEN-LAST:event_assignJButtonActionPerformed

    private void viewJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewJButtonActionPerformed
        int selectedRow = vaccineRequestJTable.getSelectedRow();
        if(selectedRow >= 0){
            VaccineRequest request = (VaccineRequest) vaccineRequestJTable.getValueAt(selectedRow, 0);
            DefaultTableModel dtm = (DefaultTableModel) vaccineTableJTable.getModel();
            dtm.setRowCount(0);
            UserAccount userAccount = (UserAccount) request.getSender();
            Employee employee = (Employee) userAccount.getEmployee();
            Order orderI = null;
            for(Order order : employee.getMasterOrderCatalog().getMasterOrderList()){
                if(request.getOrderId() == order.getOrderId()){
                    orderI = order;
                }
            }
            for(OrderItem orderItem : orderI.getOrderItemList()){
                Object[] row = new Object[2];
                row[0] = orderItem;
                row[1] = orderItem.getQuantity();
                dtm.addRow(row);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please select a row first", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
    }//GEN-LAST:event_viewJButtonActionPerformed

    private void forwardJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_forwardJButtonActionPerformed
        int selectedRow = vaccineRequestJTable.getSelectedRow();

        if(selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Please select a row from the table.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if(vaccineRequestJTable.getValueAt(selectedRow, 4) == "Approved"){
            JOptionPane.showMessageDialog(null, "The request is already sent to CDC", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if(vaccineRequestJTable.getValueAt(selectedRow, 4) == "Rejected"){
            JOptionPane.showMessageDialog(null, "The request is already rejected", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        VaccineRequest request = (VaccineRequest) vaccineRequestJTable.getValueAt(selectedRow, 0);
        if(vaccineRequestJTable.getValueAt(selectedRow, 3) == null){
            JOptionPane.showMessageDialog(null, "The request is yet to be assigned to a State Public Health Department", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        request.setStatus("Approved");
        request.setVaccineRequest("Approved");
        UserAccount userAccount = (UserAccount) request.getSender();
        Employee person = (Employee) userAccount.getEmployee();
        for(Order order : person.getMasterOrderCatalog().getMasterOrderList()){
            if(request.getOrderId() == order.getOrderId()){
                order.setOrderStatus("Approved by State public health department");
            }
        }
        VaccineRequest vaccineRequest = new VaccineRequest();
        if(person.getCheck().equalsIgnoreCase("Hospital")){
            vaccineRequest.setRequestType("Hospital Vaccine Request");
        } else if(person.getCheck().equalsIgnoreCase("Pharmacy")){
            vaccineRequest.setRequestType("Pharmacy Vaccine Request");
        }
        vaccineRequest.setStatus("waiting");
        vaccineRequest.setSender(request.getSender());
        vaccineRequest.setOrderId(request.getOrderId());
        vaccineRequest.setReceiver(null);
        ecoSystem.getWorkQueue().getWorkRequestList().add(vaccineRequest);
        userAccount.getWorkQueue().getWorkRequestList().add(vaccineRequest);
        
        if(request.getSender().getEmployee().getCheck().equalsIgnoreCase("Hospital")){
            populateHospitalVaccineTable();
        } else if(request.getSender().getEmployee().getCheck().equalsIgnoreCase("Pharmacy")){
            populatePharmacyVaccineTable();
        }
    }//GEN-LAST:event_forwardJButtonActionPerformed

    private void rejectJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rejectJButtonActionPerformed
        int selectedRow = vaccineRequestJTable.getSelectedRow();
        int quantity = 0;
        int orginalQuantity = 0;

        if(selectedRow < 0){
            JOptionPane.showMessageDialog(null, "Please select a row from the table.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if(vaccineRequestJTable.getValueAt(selectedRow, 4) == "Rejected"){
            JOptionPane.showMessageDialog(null, "The request is already rejected", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if(vaccineRequestJTable.getValueAt(selectedRow, 4) == "Approved"){
            JOptionPane.showMessageDialog(null, "The request is already Approved", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        VaccineRequest request = (VaccineRequest) vaccineRequestJTable.getValueAt(selectedRow, 0);
        if(vaccineRequestJTable.getValueAt(selectedRow, 3) == null){
            JOptionPane.showMessageDialog(null, "The request is yet to be assigned to a State public health department", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        int dialogButton = JOptionPane.YES_NO_OPTION;
        int result = JOptionPane.showConfirmDialog(null, "Are you sure if you want to Reject?", "warning", dialogButton);
        if(result == JOptionPane.YES_OPTION){
            UserAccount userAccount = (UserAccount) request.getSender();
            Employee employee = (Employee) userAccount.getEmployee();
            for(Order order : employee.getMasterOrderCatalog().getMasterOrderList()){
                if(request.getOrderId() == order.getOrderId()){
                    order.setOrderStatus("Order rejected by State public health department");
                    request.setStatus("Rejected");
                    request.setVaccineRequest("Rejected");
                    for (OrderItem oi : order.getOrderItemList()) {
                        quantity = oi.getVaccine().getAvailablity();
                        orginalQuantity = quantity + oi.getQuantity();
                        oi.getVaccine().setAvailablity(orginalQuantity);
                    }
                }
            }
        }
        if(request.getSender().getEmployee().getCheck().equalsIgnoreCase("Hospital")){
            populateHospitalVaccineTable();
        } else if(request.getSender().getEmployee().getCheck().equalsIgnoreCase("Pharmacy")){
            populatePharmacyVaccineTable();
        }
        JOptionPane.showMessageDialog(null, "The request is rejected", "Shipping Request", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_rejectJButtonActionPerformed

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        userProcessContainer.remove(this);
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void providerJComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_providerJComboBoxActionPerformed
        String provider = (String) providerJComboBox.getSelectedItem();
        if(provider != null){
            if(provider.equalsIgnoreCase("Hospital")){
                populateHospitalVaccineTable();
            } else if(provider.equalsIgnoreCase("Pharmacy")){
                populatePharmacyVaccineTable();
            }
        }
    }//GEN-LAST:event_providerJComboBoxActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton assignJButton;
    private javax.swing.JButton backJButton;
    private javax.swing.JButton forwardJButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox providerJComboBox;
    private javax.swing.JButton rejectJButton;
    private javax.swing.JTable vaccineRequestJTable;
    private javax.swing.JTable vaccineTableJTable;
    private javax.swing.JButton viewJButton;
    // End of variables declaration//GEN-END:variables
}
