/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Role;

import Business.EcoSystem;
import Business.Enterprise.DistributorEnterprise;
import Business.Enterprise.Enterprise;
import Business.NationalDistributor.NationalDistributor;
import Business.Organization.Organization;
import Business.UserAccount.UserAccount;
import UserInterface.StateDistributor.DistributorFinanceWorkAreaJPanel;
import javax.swing.JPanel;

/**
 *
 * @author rangeshmurali
 */
public class DistributorFinanceRole extends Role{

    @Override
    public JPanel createWorkArea(JPanel userProcessContainer, UserAccount account, Organization organization, Enterprise enterprise, EcoSystem business) {
        return new DistributorFinanceWorkAreaJPanel(userProcessContainer, business, account, (DistributorEnterprise)enterprise);
    }
    
}
