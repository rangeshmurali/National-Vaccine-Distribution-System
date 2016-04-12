/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Organization;

import Business.Inventory.InventoryDirectory;
import Business.Order.Order;
import Business.Role.DistributorFinanceRole;
import Business.Role.DistributorInventoryRole;
import Business.Role.ProviderFinanceRole;
import Business.Role.ProviderInventoryRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author rangeshmurali
 */
public class InventoryOrganization extends Organization{
    
    private InventoryDirectory inventoryDirectory;
    private Order order;
    
    public InventoryOrganization(){
        super(OrganizationType.Inventory.getValue());
        inventoryDirectory = new InventoryDirectory();
        order = new Order();
    }

    public InventoryDirectory getInventoryDirectory() {
        return inventoryDirectory;
    }

    public Order getOrder() {
        return order;
    }
    
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new DistributorInventoryRole());
        roles.add(new ProviderInventoryRole());
        return roles;
    }
    
}
