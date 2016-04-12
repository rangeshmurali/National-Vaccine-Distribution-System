/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Order;

import java.util.ArrayList;

/**
 *
 * @author rangeshmurali
 */
public class Order {
    
    private ArrayList<OrderItem> orderItemList;
    private static int counter = 0;
    private int orderId;
    private String orderStatus;
    
    public Order(){
        counter++;
        orderId= counter;
        orderItemList = new ArrayList<OrderItem>();
    }

    public ArrayList<OrderItem> getOrderItemList() {
        return orderItemList;
    }

    public void setOrderItemList(ArrayList<OrderItem> orderItemList) {
        this.orderItemList = orderItemList;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
    
    public OrderItem addOrderItem(){
        OrderItem orderItem = new OrderItem();
        orderItemList.add(orderItem);
        return  orderItem;
    }
    
    public void removeOrderItem(OrderItem orderItem){
        orderItemList.remove(orderItem);
    }
    
    
}
