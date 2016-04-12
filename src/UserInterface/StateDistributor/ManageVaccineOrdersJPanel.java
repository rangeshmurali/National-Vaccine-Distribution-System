/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.StateDistributor;

import Business.EcoSystem;
import Business.Employee.Employee;
import Business.Enterprise.DistributorEnterprise;
import Business.Enterprise.Enterprise;
import Business.Enterprise.ProviderEnterprise;
import Business.Enterprise.VaccineManufacturesEnterprise;
import Business.Inventory.Inventory;
import Business.Network.Network;
import Business.Order.Order;
import Business.Order.OrderItem;
import Business.Organization.FinanceOrganization;
import Business.Organization.InventoryOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.ManufactureRequest;
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
public class ManageVaccineOrdersJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private EcoSystem ecoSystem;
    private UserAccount userAccount;
    private DistributorEnterprise distributorEnterprise;
    private boolean isCheck = true;

    public ManageVaccineOrdersJPanel(JPanel userProcessContainer, EcoSystem ecoSystem, UserAccount userAccount, DistributorEnterprise distributorEnterprise) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.ecoSystem = ecoSystem;
        this.userAccount = userAccount;
        this.distributorEnterprise = distributorEnterprise;

        populateVaccineTable();
        populateVaccineOrderTable();
        populateManufactureTable();
    }

    public void populateVaccineTable() {
        DefaultTableModel dtm = (DefaultTableModel) vaccineJTable.getModel();
        dtm.setRowCount(0);

        for (Organization organization : distributorEnterprise.getOrganizationDriectory().getOrganizationDirectory()) {
            for (Inventory inventory : organization.getInventoryDirectory().getInventoryDirectory()) {
                Object[] row = new Object[7];
                row[0] = inventory.getVaccine();
                row[1] = inventory.getVaccine().getVaccineId();
                row[2] = inventory.getVaccine().getDiseasesName();
                row[3] = inventory.getVaccine().getPrice();
                row[4] = inventory.getVaccine().getManufactureDate();
                row[5] = inventory.getVaccine().getExpiryDate();
                row[6] = inventory.getVaccine().getAvailablity();
                dtm.addRow(row);
            }
        }
    }

    public void populateVaccineOrderTable() {
        DefaultTableModel dtm = (DefaultTableModel) vaccineOrderJTable.getModel();
        dtm.setRowCount(0);

        for (WorkRequest request : distributorEnterprise.getWorkQueue().getWorkRequestList()) {
            if (request.getRequestType().equalsIgnoreCase("Hospital Vaccine request") || request.getRequestType().equalsIgnoreCase("Pharmacy Vaccine request")) {
                Object[] row = new Object[5];
                row[0] = request;
                if (request.getRequestType().equalsIgnoreCase("Hospital Vaccine request")) {
                    row[1] = request.getSender().getEmployee().getHospital().getHospitalName();
                } else if (request.getRequestType().equalsIgnoreCase("Pharmacy Vaccine request")) {
                    row[1] = request.getSender().getEmployee().getPharmacy().getPharmacyName();
                }
                row[2] = request.getSender();
                row[3] = request.getReceiver() == null ? null : request.getReceiver();
                row[4] = request.getStatus();
                dtm.addRow(row);
            }
        }
    }

    public void manufactureRequest() {
        int selectedRow = vaccineOrderJTable.getSelectedRow();
        VaccineRequest request = (VaccineRequest) vaccineOrderJTable.getValueAt(selectedRow, 0);
        UserAccount user = (UserAccount) request.getSender();
        for (Order order : user.getEmployee().getMasterOrderCatalog().getMasterOrderList()) {
            if (order.getOrderId() == request.getOrderId()) {
                for (OrderItem orderItem : order.getOrderItemList()) {
                    for (Organization organization : distributorEnterprise.getOrganizationDriectory().getOrganizationDirectory()) {
                        for (Inventory inventory : organization.getInventoryDirectory().getInventoryDirectory()) {
                            if (orderItem.getVaccine() == inventory.getVaccine()) {
                                if (orderItem.getQuantity() > inventory.getVaccine().getAvailablity()) {
                                    isCheck = false;
                                    int quant = orderItem.getQuantity() - inventory.getVaccine().getAvailablity();
                                    ManufactureRequest manufactureRequest = new ManufactureRequest();
                                    manufactureRequest.setRequestedQuantity(quant);
                                    manufactureRequest.setRequestType("Manufacture Vaccine request");
                                    manufactureRequest.setStatus("Sent");
                                    manufactureRequest.setSender(userAccount);
                                    manufactureRequest.setOrderId(inventory.getVaccine().getVaccineId());
                                    order.setOrderStatus("Processing");
                                    Enterprise enterprise = null;
                                    Network net = null;
                                    for (Network network : ecoSystem.getNetworkDirectory()) {
                                        for (Enterprise ent : network.getEnterpriseDirectory().getEnterprisesDirectory()) {
                                            if (ent == distributorEnterprise) {
                                                net = network;
                                            }
                                        }
                                    }
                                    for (Enterprise ent : net.getEnterpriseDirectory().getEnterprisesDirectory()) {
                                        if (ent instanceof VaccineManufacturesEnterprise) {
                                            enterprise = ent;
                                            break;
                                        }
                                    }
                                    if (enterprise != null) {
                                        enterprise.getWorkQueue().getWorkRequestList().add(manufactureRequest);

                                        userAccount.getWorkQueue().getWorkRequestList().add(manufactureRequest);
                                        populateManufactureTable();
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

    }

    public void populateManufactureTable() {
        DefaultTableModel dtm = (DefaultTableModel) manufactureOrderJTable1.getModel();
        dtm.setRowCount(0);

        for (WorkRequest request : userAccount.getWorkQueue().getWorkRequestList()) {
            if (request.getRequestType().equalsIgnoreCase("Manufacture Vaccine Request")) {
                Object[] row = new Object[5];
                row[0] = request;
                row[1] = request.getSender();
                row[2] = request.getReceiver() == null ? null : request.getReceiver();
                row[3] = request.getRequestedQuantity();
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

        titleJLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        vaccineJTable = new javax.swing.JTable();
        forwardJButton = new javax.swing.JButton();
        assignJButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        vaccineOrderJTable = new javax.swing.JTable();
        viewOrderJButton = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        orderJTable = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        manufactureOrderJTable1 = new javax.swing.JTable();
        backJButton = new javax.swing.JButton();

        titleJLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        titleJLabel.setText("Manage Vaccine Order Request");

        vaccineJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Vaccine Name", "Vaccine ID", "Disease Name", "Price", "Manufactore Date", "Expiry Date", "Availablity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(vaccineJTable);
        if (vaccineJTable.getColumnModel().getColumnCount() > 0) {
            vaccineJTable.getColumnModel().getColumn(0).setResizable(false);
            vaccineJTable.getColumnModel().getColumn(1).setResizable(false);
            vaccineJTable.getColumnModel().getColumn(2).setResizable(false);
            vaccineJTable.getColumnModel().getColumn(3).setResizable(false);
            vaccineJTable.getColumnModel().getColumn(4).setResizable(false);
            vaccineJTable.getColumnModel().getColumn(5).setResizable(false);
            vaccineJTable.getColumnModel().getColumn(6).setResizable(false);
        }

        forwardJButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        forwardJButton.setText("Forward to Distributor Finance");
        forwardJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                forwardJButtonActionPerformed(evt);
            }
        });

        assignJButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        assignJButton.setText("Assign to me");
        assignJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignJButtonActionPerformed(evt);
            }
        });

        vaccineOrderJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Request Type", "Provider Name", "Employee Name", "Receiver", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(vaccineOrderJTable);

        viewOrderJButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        viewOrderJButton.setText("View Order");
        viewOrderJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewOrderJButtonActionPerformed(evt);
            }
        });

        orderJTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(orderJTable);

        manufactureOrderJTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Request Type", "Employee Name", "Receiver", "Quantity", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(manufactureOrderJTable1);

        backJButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        backJButton.setText("<< back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(283, 283, 283)
                        .addComponent(titleJLabel))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(viewOrderJButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(assignJButton)
                                .addGap(69, 69, 69)
                                .addComponent(forwardJButton))
                            .addComponent(jScrollPane2)
                            .addComponent(jScrollPane3)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 748, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane4)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addComponent(backJButton)))
                .addContainerGap(396, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(titleJLabel)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(viewOrderJButton)
                    .addComponent(assignJButton)
                    .addComponent(forwardJButton))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(backJButton)
                .addContainerGap(130, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void forwardJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_forwardJButtonActionPerformed

        int selectedRow = vaccineOrderJTable.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a row from the table.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (vaccineOrderJTable.getValueAt(selectedRow, 3) == null) {
            JOptionPane.showMessageDialog(null, "The request is yet to be assigned to CDC", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (vaccineOrderJTable.getValueAt(selectedRow, 4) == "Approved") {
            JOptionPane.showMessageDialog(null, "The request is already sent to National Distributor", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (vaccineOrderJTable.getValueAt(selectedRow, 4) == "Rejected") {
            JOptionPane.showMessageDialog(null, "The request is already rejected", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

//        if (vaccineOrderJTable.getValueAt(selectedRow, 4) == "Pending") {
//            JOptionPane.showMessageDialog(null, "The request is already sent to Manufacturer for production!", "Warning", JOptionPane.WARNING_MESSAGE);
//            return;
//        }
        manufactureRequest();
        if (isCheck) {
            VaccineRequest work = (VaccineRequest) vaccineOrderJTable.getValueAt(selectedRow, 0);
            if (work.getRequestType().equalsIgnoreCase("Hospital Vaccine request") || work.getRequestType().equalsIgnoreCase("Pharmacy Vaccine request")) {
                UserAccount user = (UserAccount) work.getSender();
                for (Order order1 : user.getEmployee().getMasterOrderCatalog().getMasterOrderList()) {
                    if (order1.getOrderId() == work.getOrderId()) {
                        for (OrderItem orderItem : order1.getOrderItemList()) {
                            for (Organization organization : distributorEnterprise.getOrganizationDriectory().getOrganizationDirectory()) {
                                for (Inventory inventory : organization.getInventoryDirectory().getInventoryDirectory()) {
                                    if (orderItem.getVaccine() == inventory.getVaccine()) {
                                        if (orderItem.getQuantity() <= inventory.getVaccine().getAvailablity()) {

                                            int quantity = inventory.getVaccine().getAvailablity() - orderItem.getQuantity();
                                            inventory.getVaccine().setAvailablity(quantity);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            work.setStatus("Approved");
            work.setVaccineRequest("Approved");
            UserAccount userAccount1 = (UserAccount) work.getSender();
            Employee employee = (Employee) userAccount1.getEmployee();
            for (Order order : employee.getMasterOrderCatalog().getMasterOrderList()) {
                if (work.getOrderId() == order.getOrderId()) {
                    order.setOrderStatus("Approved by CDC");
                }
            }
            VaccineRequest vaccineRequest = new VaccineRequest();
            vaccineRequest.setRequestType("Provider Payment Request");
            vaccineRequest.setStatus("waiting");
            vaccineRequest.setSender(work.getSender());
            vaccineRequest.setOrderId(work.getOrderId());
            vaccineRequest.setReceiver(null);
            Enterprise enterprise = null;
            Network net = null;
            Organization org = null;
            UserAccount us = null;
            for (Network network : ecoSystem.getNetworkDirectory()) {
                for (Enterprise ent : network.getEnterpriseDirectory().getEnterprisesDirectory()) {
                    for (UserAccount userAccount2 : ent.getUserAccountDirectory().getUserAccountDirectory()) {
                        if (userAccount2 == userAccount) {
                            net = network;
                        }
                    }
                }
            }
            for (Enterprise ent : net.getEnterpriseDirectory().getEnterprisesDirectory()) {
                if (ent instanceof DistributorEnterprise) {
                    enterprise = ent;
                    break;
                }
            }
            for (Organization organization1 : enterprise.getOrganizationDriectory().getOrganizationDirectory()) {
                if (organization1 instanceof FinanceOrganization) {
                    org = organization1;
                }
            }
            
            if (org != null) {
                org.getWorkQueue().getWorkRequestList().add(vaccineRequest);
                userAccount.getWorkQueue().getWorkRequestList().add(vaccineRequest);

            }
            populateVaccineOrderTable();
            populateVaccineTable();
        }

    }//GEN-LAST:event_forwardJButtonActionPerformed

    private void assignJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignJButtonActionPerformed
        int selectedRow = vaccineOrderJTable.getSelectedRow();

        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a row from the table.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (vaccineOrderJTable.getValueAt(selectedRow, 3) != null) {
            JOptionPane.showMessageDialog(null, "The request is already assigned", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        VaccineRequest request = (VaccineRequest) vaccineOrderJTable.getValueAt(selectedRow, 0);
        request.setReceiver(userAccount);
        request.setStatus("Pending");
        UserAccount userAccount = (UserAccount) request.getSender();
        Employee person = (Employee) userAccount.getEmployee();
        for (Order order : person.getMasterOrderCatalog().getMasterOrderList()) {
            if (request.getOrderId() == order.getOrderId()) {
                order.setOrderStatus("Waiting to be approved by CDC");
            }
        }
        populateVaccineOrderTable();
        JOptionPane.showMessageDialog(null, "The request is assigned to " + request.getReceiver());
    }//GEN-LAST:event_assignJButtonActionPerformed

    private void viewOrderJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewOrderJButtonActionPerformed
        int selectedRow = vaccineOrderJTable.getSelectedRow();
        if (selectedRow >= 0) {
            VaccineRequest request = (VaccineRequest) vaccineOrderJTable.getValueAt(selectedRow, 0);
            DefaultTableModel dtm = (DefaultTableModel) orderJTable.getModel();
            dtm.setRowCount(0);

            UserAccount userAccount = (UserAccount) request.getSender();
            Employee employee = (Employee) userAccount.getEmployee();
            Order orderI = null;
            for (Order order : employee.getMasterOrderCatalog().getMasterOrderList()) {
                if (request.getOrderId() == order.getOrderId()) {
                    orderI = order;
                }
            }
            for (OrderItem orderItem : orderI.getOrderItemList()) {
                Object[] row = new Object[2];
                row[0] = orderItem;
                row[1] = orderItem.getQuantity();
                dtm.addRow(row);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please select a row first", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
    }//GEN-LAST:event_viewOrderJButtonActionPerformed

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        userProcessContainer.remove(this);
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton assignJButton;
    private javax.swing.JButton backJButton;
    private javax.swing.JButton forwardJButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable manufactureOrderJTable1;
    private javax.swing.JTable orderJTable;
    private javax.swing.JLabel titleJLabel;
    private javax.swing.JTable vaccineJTable;
    private javax.swing.JTable vaccineOrderJTable;
    private javax.swing.JButton viewOrderJButton;
    // End of variables declaration//GEN-END:variables
}
