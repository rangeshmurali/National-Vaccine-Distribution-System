/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UserInterface.HospitalWorkArea;

import Business.EcoSystem;
import Business.Employee.Employee;
import Business.Enterprise.Enterprise;
import Business.Enterprise.ProviderEnterprise;
import Business.Network.Network;
import Business.Order.Order;
import Business.Order.OrderItem;
import Business.Organization.OrderOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import Business.WorkQueue.PaymentRequest;
import Business.WorkQueue.WorkRequest;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rangeshmurali
 */
public class ManageDistributorPaymentJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private EcoSystem ecoSystem;
    private UserAccount userAccount;

    public ManageDistributorPaymentJPanel(JPanel userProcessContainer, EcoSystem ecoSystem, UserAccount userAccount) {
        initComponents();

        this.userProcessContainer = userProcessContainer;
        this.ecoSystem = ecoSystem;
        this.userAccount = userAccount;

        populateBillTable();
    }

    public void populateBillTable() {
        DefaultTableModel dtm = (DefaultTableModel) billJTable.getModel();
        dtm.setRowCount(0);

        for (WorkRequest request : userAccount.getWorkQueue().getWorkRequestList()) {
            Object[] row = new Object[6];
            row[0] = request;
            row[1] = request.getOrderId();
            float totalPrice = 0;
            Enterprise enterprise = null;
            Network net = null;
            for (Network network : ecoSystem.getNetworkDirectory()) {
                for (Enterprise ent : network.getEnterpriseDirectory().getEnterprisesDirectory()) {
                    for (Organization organization : ent.getOrganizationDriectory().getOrganizationDirectory()) {
                        for (UserAccount userAccount1 : organization.getUserAccountDirectory().getUserAccountDirectory()) {
                            if (userAccount1 == userAccount) {
                                net = network;
                            }
                        }
                    }
                }
            }
            for (Enterprise ent : net.getEnterpriseDirectory().getEnterprisesDirectory()) {
                if (ent instanceof ProviderEnterprise) {
                    enterprise = ent;
                    break;
                }
            }
            UserAccount uu = null;
            for (Organization o : enterprise.getOrganizationDriectory().getOrganizationDirectory()) {
                if (o instanceof OrderOrganization) {
                    for (UserAccount user : o.getUserAccountDirectory().getUserAccountDirectory()) {
                        uu = user;
                    }
                }
            }
            for (Order order : uu.getEmployee().getMasterOrderCatalog().getMasterOrderList()) {
                if (request.getOrderId() == order.getOrderId()) {
                    for (OrderItem orderItem : order.getOrderItemList()) {
                        float price = orderItem.getVaccine().getPrice() * orderItem.getQuantity();
                        totalPrice = totalPrice + price;
                    }

                }
            }
            row[2] = totalPrice;
            row[3] = request.getSender();
            row[4] = request.getReceiver();
            row[5] = request.getStatus();
            dtm.addRow(row);

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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        billJTable = new javax.swing.JTable();
        viewOrderJButton = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        orderJTable = new javax.swing.JTable();
        payBillJButton = new javax.swing.JButton();
        assignJButton = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Manage Distributor Payment");

        billJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Request Type", "Order ID", "Total Price", "Sender", "Receiver", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(billJTable);
        if (billJTable.getColumnModel().getColumnCount() > 0) {
            billJTable.getColumnModel().getColumn(0).setResizable(false);
            billJTable.getColumnModel().getColumn(1).setResizable(false);
            billJTable.getColumnModel().getColumn(2).setResizable(false);
            billJTable.getColumnModel().getColumn(3).setResizable(false);
            billJTable.getColumnModel().getColumn(4).setResizable(false);
            billJTable.getColumnModel().getColumn(5).setResizable(false);
        }

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

        payBillJButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        payBillJButton.setText("Pay bill");
        payBillJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payBillJButtonActionPerformed(evt);
            }
        });

        assignJButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        assignJButton.setText("Assign to me");
        assignJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignJButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(472, 472, 472)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(250, 250, 250)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 754, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(250, 250, 250)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 754, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(318, 318, 318)
                .addComponent(viewOrderJButton)
                .addGap(102, 102, 102)
                .addComponent(assignJButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(payBillJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(330, 330, 330))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addGap(35, 35, 35)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(payBillJButton)
                    .addComponent(viewOrderJButton)
                    .addComponent(assignJButton))
                .addGap(12, 12, 12)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void viewOrderJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewOrderJButtonActionPerformed
        int selectedRow = billJTable.getSelectedRow();
        if (selectedRow >= 0) {
            WorkRequest request = (WorkRequest) billJTable.getValueAt(selectedRow, 0);
            Enterprise enterprise = null;
            Network net = null;
            for (Network network : ecoSystem.getNetworkDirectory()) {
                for (Enterprise ent : network.getEnterpriseDirectory().getEnterprisesDirectory()) {
                    for (Organization organization : ent.getOrganizationDriectory().getOrganizationDirectory()) {
                        for (UserAccount userAccount1 : organization.getUserAccountDirectory().getUserAccountDirectory()) {
                            if (userAccount1 == userAccount) {
                                net = network;
                            }
                        }
                    }
                }
            }
            for (Enterprise ent : net.getEnterpriseDirectory().getEnterprisesDirectory()) {
                if (ent instanceof ProviderEnterprise) {
                    enterprise = ent;
                    break;
                }
            }
            UserAccount uu = null;
            for (Organization o : enterprise.getOrganizationDriectory().getOrganizationDirectory()) {
                if (o instanceof OrderOrganization) {
                    for (UserAccount user : o.getUserAccountDirectory().getUserAccountDirectory()) {
                        uu = user;
                    }
                }
            }
            DefaultTableModel dtm = (DefaultTableModel) orderJTable.getModel();
            dtm.setRowCount(0);

            Order orderI = null;
            for (Order order : uu.getEmployee().getMasterOrderCatalog().getMasterOrderList()) {
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

    private void payBillJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payBillJButtonActionPerformed
        int selectedRow = billJTable.getSelectedRow();

        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a row from the table.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (billJTable.getValueAt(selectedRow, 5) == "Paid") {
            JOptionPane.showMessageDialog(null, "The bill is already Paid", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (billJTable.getValueAt(selectedRow, 4) == null) {
            JOptionPane.showMessageDialog(null, "The request is yet to be assigned to the Distributor", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        PaymentRequest paymentRequest = (PaymentRequest) billJTable.getValueAt(selectedRow, 0);
        paymentRequest.setPaymentRequest("Paid");
        paymentRequest.setStatus("Paid");
        populateBillTable();
        JOptionPane.showMessageDialog(null, "Bill paid", "Payment Request", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_payBillJButtonActionPerformed

    private void assignJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignJButtonActionPerformed
        int selectedRow = billJTable.getSelectedRow();

        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a row from the table.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (billJTable.getValueAt(selectedRow, 4) != null) {
            JOptionPane.showMessageDialog(null, "The request is already assigned", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        PaymentRequest request = (PaymentRequest) billJTable.getValueAt(selectedRow, 0);
        request.setReceiver(userAccount);
        request.setStatus("Pending");
        UserAccount user = (UserAccount) request.getSender();
        Employee person = (Employee) user.getEmployee();
        for (Order order : person.getMasterOrderCatalog().getMasterOrderList()) {
            if (request.getOrderId() == order.getOrderId()) {
                order.setOrderStatus("Waiting to be approved by National Distributor");
            }
        }
        populateBillTable();
        JOptionPane.showMessageDialog(null, "The request is assigned to " + request.getReceiver());
    }//GEN-LAST:event_assignJButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton assignJButton;
    private javax.swing.JTable billJTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable orderJTable;
    private javax.swing.JButton payBillJButton;
    private javax.swing.JButton viewOrderJButton;
    // End of variables declaration//GEN-END:variables
}
