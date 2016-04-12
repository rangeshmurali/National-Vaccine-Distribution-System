/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Organization;

import Business.Organization.Organization.OrganizationType;
import java.util.ArrayList;

/**
 *
 * @author rangeshmurali
 */
public class OrganizationDriectory {
    
    private ArrayList<Organization> organizationDirectory;
    
    public OrganizationDriectory(){
        organizationDirectory = new ArrayList<>();
    }

    public ArrayList<Organization> getOrganizationDirectory() {
        return organizationDirectory;
    }
    
    public Organization createOrganization(OrganizationType type){
        Organization organization = null;
        if(type.getValue().equalsIgnoreCase(OrganizationType.Admin.getValue())){
            organization = new AdminOrganization();
            organizationDirectory.add(organization);
        } else if (type.getValue().equalsIgnoreCase(OrganizationType.Finance.getValue())){
            organization = new FinanceOrganization();
            organizationDirectory.add(organization);
        } else if(type.getValue().equalsIgnoreCase(OrganizationType.Inventory.getValue())){
            organization = new InventoryOrganization();
            organizationDirectory.add(organization);
        } else if(type.getValue().equalsIgnoreCase(OrganizationType.Order.getValue())){
            organization = new OrderOrganization();
            organizationDirectory.add(organization);
        }
        
        return organization;
    }
    
}
