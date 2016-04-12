/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Organization;

import Business.Role.DistributorAdminRole;
import Business.Role.DistributorFinanceRole;
import Business.Role.HospitalFinanceRole;
import Business.Role.ManufactureAdminRole;
import Business.Role.ManufactureFinanceRole;
import Business.Role.ProviderAdminRole;
import Business.Role.ProviderFinanceRole;
import Business.Role.PublicHealthAdmin;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author rangeshmurali
 */
public class FinanceOrganization extends Organization{
    
    public FinanceOrganization(){
        super(OrganizationType.Finance.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new DistributorFinanceRole());
        roles.add(new ProviderFinanceRole());
        roles.add(new ManufactureFinanceRole());
        roles.add(new HospitalFinanceRole());
        return roles;
    }
    
}
