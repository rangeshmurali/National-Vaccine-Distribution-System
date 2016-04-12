/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Organization;

import Business.Organization.Organization.OrganizationType;
import Business.Role.DistributorAdminRole;
import Business.Role.HospitalAdminRole;
import Business.Role.ManufactureAdminRole;
import Business.Role.PharmacyAdminRole;
import Business.Role.ProviderAdminRole;
import Business.Role.PublicHealthAdmin;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author rangeshmurali
 */
public class AdminOrganization extends Organization{
    
    public AdminOrganization(){
        super(OrganizationType.Admin.getValue());
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new DistributorAdminRole());
        roles.add(new ManufactureAdminRole());
        roles.add(new ProviderAdminRole());
        roles.add(new PublicHealthAdmin());
        roles.add(new HospitalAdminRole());
        roles.add(new PharmacyAdminRole());
        return roles;
    }
    
}
