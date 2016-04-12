/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Enterprise;

import Business.Organization.Organization;
import Business.Organization.OrganizationDriectory;

/**
 *
 * @author rangeshmurali
 */
public abstract class Enterprise extends Organization{
    
    private EnterpriseType enterpriseType;
    private OrganizationDriectory organizationDriectory;
    
    public Enterprise(String name, EnterpriseType enterpriseType){
        super(name);
        this.enterpriseType = enterpriseType;
        this.organizationDriectory = new OrganizationDriectory();
    }
    
    public enum EnterpriseType{
        Distributor("Distributor"),
        Provider("Provider"),
        PublicHealth("PublicHealth"),
        VaccineManufactures("VaccineManufactures");
        
        private String value;
        
        private EnterpriseType(String value){
            this.value = value;
        }

        public String getValue() {
            return value;
        }
        
        @Override
        public String toString(){
            return value;
        }
    }

    public EnterpriseType getEnterpriseType() {
        return enterpriseType;
    }

    public OrganizationDriectory getOrganizationDriectory() {
        return organizationDriectory;
    }
    
    
}
