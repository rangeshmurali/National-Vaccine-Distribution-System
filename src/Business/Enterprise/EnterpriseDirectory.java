/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Enterprise;

import java.util.ArrayList;

/**
 *
 * @author rangeshmurali
 */
public class EnterpriseDirectory {
    
    private ArrayList<Enterprise> enterprisesDirectory;
    
    public EnterpriseDirectory(){
        enterprisesDirectory = new ArrayList<>();
    }

    public ArrayList<Enterprise> getEnterprisesDirectory() {
        return enterprisesDirectory;
    }
    
    public Enterprise createAndAddEnterprise(String enterpriseName, Enterprise.EnterpriseType type){
        Enterprise enterprise = null;
        if (type == Enterprise.EnterpriseType.Distributor){
            enterprise = new DistributorEnterprise(enterpriseName);
            enterprisesDirectory.add(enterprise);
        } else if (type == Enterprise.EnterpriseType.Provider){
            enterprise = new ProviderEnterprise(enterpriseName);
            enterprisesDirectory.add(enterprise);
        } else if (type == Enterprise.EnterpriseType.PublicHealth){
            enterprise = new PublicHealthEnterprise(enterpriseName);
            enterprisesDirectory.add(enterprise);
        } else if (type == Enterprise.EnterpriseType.VaccineManufactures){
            enterprise = new VaccineManufacturesEnterprise(enterpriseName);
            enterprisesDirectory.add(enterprise);
        }
        
        return enterprise;
    }
    
}
