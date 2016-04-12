/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Enterprise;

import Business.Hospital.HospitalDirectory;
import Business.Pharmacy.PharmacyDirectory;
import Business.Role.DistributorAdminRole;
import Business.Role.ProviderAdminRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author rangeshmurali
 */
public class ProviderEnterprise extends Enterprise{
    
    private HospitalDirectory hospitalDirectory;
    private PharmacyDirectory pharmacyDirectory;
    
    public ProviderEnterprise(String name){
        super(name, EnterpriseType.Provider);
        hospitalDirectory = new HospitalDirectory();
        pharmacyDirectory = new PharmacyDirectory();
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new ProviderAdminRole());
        return roles;
    }

    public HospitalDirectory getHospitalDirectory() {
        return hospitalDirectory;
    }

    public PharmacyDirectory getPharmacyDirectory() {
        return pharmacyDirectory;
    }
    
    
    
    
    
}
