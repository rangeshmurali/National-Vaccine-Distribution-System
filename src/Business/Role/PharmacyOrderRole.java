/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.Enterprise;
import Business.Enterprise.ProviderEnterprise;
import Business.NationalDistributor.NationalDistributor;
import Business.Organization.OrderOrganization;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import UserInterface.HospitalWorkArea.HospitalOrderOrganizationWorkAreaJPanel;
import UserInterface.PharmacyWorkArea.PharmacyOrderOrganiationWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author rangeshmurali
 */
public class PharmacyOrderRole extends Role{
    
    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        return new PharmacyOrderOrganiationWorkAreaJPanel(userProcessContainer, business, account, (OrderOrganization)organization, (ProviderEnterprise)enterprise);
    }
    
}
