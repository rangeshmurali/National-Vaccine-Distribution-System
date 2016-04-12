/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.VaccineManufacturesEnterprise;
import Business.NationalDistributor.NationalDistributor;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import UserInterface.ManufacturerWorkArea.ManufacturerWorkArea;
import javax.swing.JPanel;

/**
 *
 * @author rangeshmurali
 */
public class ManufactureAdminRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        return new ManufacturerWorkArea(userProcessContainer, business, account, (VaccineManufacturesEnterprise)enterprise);
    }
    
}
