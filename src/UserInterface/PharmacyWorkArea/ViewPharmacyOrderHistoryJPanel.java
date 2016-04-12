/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package UserInterface.PharmacyWorkArea;

import Business.Order.Order;
import Business.Order.OrderItem;
import Business.UserAccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rangeshmurali
 */
public class ViewPharmacyOrderHistoryJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private UserAccount userAccount;
    
    public ViewPharmacyOrderHistoryJPanel(JPanel userProcessContainer, UserAccount userAccount) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.userAccount = userAccount;
        populateOrderTable();
    }
    
    public void populateOrderTable(){
        DefaultTableModel dtm = (DefaultTableModel) orderIDJTable.getModel();
        dtm.setRowCount(0);
        
        for(Order order : userAccount.getEmployee().getMasterOrderCatalog().getMasterOrderList()){
            if(userAccount.getEmployee().getCheck().equalsIgnoreCase("Pharmacy")){
                Object[] row = new Object[2];
                row[0] = order.getOrderId();
                row[1] = order.getOrderStatus();
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

        backJButton = new javax.swing.JButton();
        titleJLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        orderIDJTable = new javax.swing.JTable();
        viewJButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        vaccineJTable = new javax.swing.JTable();

        backJButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        backJButton.setText("<< Back");
        backJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backJButtonActionPerformed(evt);
            }
        });

        titleJLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        titleJLabel.setText("View Pharmacy Order History");

        orderIDJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Order ID", "Order Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(orderIDJTable);

        viewJButton.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        viewJButton.setText("View");
        viewJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewJButtonActionPerformed(evt);
            }
        });

        vaccineJTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(vaccineJTable);
        if (vaccineJTable.getColumnModel().getColumnCount() > 0) {
            vaccineJTable.getColumnModel().getColumn(0).setResizable(false);
            vaccineJTable.getColumnModel().getColumn(1).setResizable(false);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(179, 179, 179)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(60, 60, 60)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(backJButton)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(220, 220, 220)
                                .addComponent(viewJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(277, 277, 277)
                        .addComponent(titleJLabel)))
                .addContainerGap(251, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(titleJLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(viewJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(backJButton)
                .addGap(23, 23, 23))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void backJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backJButtonActionPerformed
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_backJButtonActionPerformed

    private void viewJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewJButtonActionPerformed
        int selectedRow = orderIDJTable.getSelectedRow();
        if(selectedRow >= 0){
            int orderId = (Integer) orderIDJTable.getValueAt(selectedRow, 0);
            DefaultTableModel dtm = (DefaultTableModel) vaccineJTable.getModel();
            dtm.setRowCount(0);
            Order orderI = null;
            for(Order order : userAccount.getEmployee().getMasterOrderCatalog().getMasterOrderList()){
                if(orderId == order.getOrderId()){
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
            JOptionPane.showMessageDialog(null, "Please select a row first", "View Order", JOptionPane.WARNING_MESSAGE);
            return;
        }
    }//GEN-LAST:event_viewJButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backJButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable orderIDJTable;
    private javax.swing.JLabel titleJLabel;
    private javax.swing.JTable vaccineJTable;
    private javax.swing.JButton viewJButton;
    // End of variables declaration//GEN-END:variables
}