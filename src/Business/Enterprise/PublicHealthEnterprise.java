/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Enterprise;

import Business.Role.DistributorAdminRole;
import Business.Role.PublicHealthAdmin;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author rangeshmurali
 */
public class PublicHealthEnterprise extends Enterprise{
    
    public PublicHealthEnterprise(String name){
        super(name, EnterpriseType.PublicHealth);
    }

    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new PublicHealthAdmin());
        return roles;
    }
    
}
