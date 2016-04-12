/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Organization;

import Business.Employee.EmployeeDirectory;
import Business.Inventory.Inventory;
import Business.Inventory.InventoryDirectory;
import Business.Role.Role;
import Business.UserAccount.UserAccountDirectory;
import Business.WorkQueue.WorkQueue;
import java.util.ArrayList;

/**
 *
 * @author rangeshmurali
 */
public abstract class Organization {
    
    private String orgnizationName;
    private int organizationID;
    private static int counter = 0;
    private EmployeeDirectory employeeDirectory;
    private UserAccountDirectory userAccountDirectory;
    private WorkQueue workQueue;
    private InventoryDirectory inventoryDirectory;
    
    public enum OrganizationType{
        Admin("Admin Organization"),
        Finance("Finance Organization"),
        Inventory("Inventory Organization"),
        Order("Order Organization");
        
        private String value;
        
        private OrganizationType(String value){
            this.value = value;
        }

        public String getValue() {
            return value;
        }
        
    }
    
    public Organization(String organizationName){
            this.orgnizationName = organizationName;
            employeeDirectory = new EmployeeDirectory();
            userAccountDirectory = new UserAccountDirectory();
            inventoryDirectory = new InventoryDirectory();
            workQueue = new WorkQueue();
            organizationID = counter;
            ++counter;
        }
    
    public abstract ArrayList<Role> getSupportedRole();

    public int getOrganizationID() {
        return organizationID;
    }

    public String getOrgnizationName() {
        return orgnizationName;
    }

    public void setOrgnizationName(String orgnizationName) {
        this.orgnizationName = orgnizationName;
    }

    public EmployeeDirectory getEmployeeDirectory() {
        return employeeDirectory;
    }

    public UserAccountDirectory getUserAccountDirectory() {
        return userAccountDirectory;
    }

    public WorkQueue getWorkQueue() {
        return workQueue;
    }

    public InventoryDirectory getInventoryDirectory() {
        return inventoryDirectory;
    }
    
    
    @Override
    public String toString(){
        return orgnizationName;
    }
    
}
