/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Enterprise;

import Business.Role.DistributorAdminRole;
import Business.Role.ManufactureAdminRole;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author rangeshmurali
 */
public class VaccineManufacturesEnterprise extends Enterprise{
    
    public VaccineManufacturesEnterprise(String name){
        super(name, EnterpriseType.VaccineManufactures);
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new ManufactureAdminRole());
        return roles;
    }
    
    
    
}
