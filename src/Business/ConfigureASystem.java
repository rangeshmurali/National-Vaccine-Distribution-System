/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business;

import Business.Employee.Employee;
import Business.Enterprise.DistributorEnterprise;
import Business.Enterprise.Enterprise;
import Business.Inventory.Inventory;
import Business.NationalDistributor.NationalDistributor;
import Business.Network.Network;
import Business.Organization.InventoryOrganization;
import Business.Organization.Organization;
import Business.Role.NationalDistributorAdminRole;
import Business.Role.SysAdminRole;
import Business.UserAccount.UserAccount;
import Business.Vaccine.Vaccine;

/**
 *
 * @author rangeshmurali
 */
public class ConfigureASystem {
    
    public static EcoSystem configureEcoSystem(){
        EcoSystem ecoSystem = EcoSystem.getInstance();
        
        
        Network network = ecoSystem.createAndAddNetwork("Newyork");
        ecoSystem.createAndAddNetwork("Texas");
        Employee employee = ecoSystem.getEmployeeDirectory().createEmployee("CDC");
        UserAccount userAccount = ecoSystem.getUserAccountDirectory().createUserAccount("sysadmin", "sysadmin", employee, new SysAdminRole());
        
        Employee employee1 = ecoSystem.getEmployeeDirectory().createEmployee("NationalDistributor");
        ecoSystem.getUserAccountDirectory().createUserAccount("national", "national", employee1, new NationalDistributorAdminRole());
        
        Vaccine vaccine = ecoSystem.getVaccineDirectory().createVaccine();
        vaccine.setVaccineName("Influenza");
        vaccine.setDiseasesName("Flu");
        
        Vaccine vaccine1 = ecoSystem.getVaccineDirectory().createVaccine();
        vaccine1.setVaccineName("MMR");
        vaccine1.setDiseasesName("Mumps");
        
        DistributorEnterprise distributorEnterprise = (DistributorEnterprise) network.getEnterpriseDirectory().createAndAddEnterprise("d", Enterprise.EnterpriseType.Distributor);
        InventoryOrganization organization = (InventoryOrganization)distributorEnterprise.getOrganizationDriectory().createOrganization(Organization.OrganizationType.Inventory);
        Inventory inventory2 = organization.getInventoryDirectory().createInventory(vaccine);
        
        if (inventory2.getVaccine().getVaccineId() == vaccine.getVaccineId()) {
            inventory2.getVaccine().setPrice(10);
            inventory2.getVaccine().setManufactureDate("30-May-2014");
            inventory2.getVaccine().setExpiryDate("12-May-2016");
            inventory2.getVaccine().setAvailablity(20);
        }
        
        Inventory inventory3 = organization.getInventoryDirectory().createInventory(vaccine1);
        
        if (inventory3.getVaccine().getVaccineId() == vaccine1.getVaccineId()) {
            inventory3.getVaccine().setPrice(10);
            inventory3.getVaccine().setManufactureDate("12-May-2014");
            inventory3.getVaccine().setExpiryDate("12-May-2016");
            inventory3.getVaccine().setAvailablity(20);
        }
        
//        Inventory inventory = ecoSystem.getInventoryDirectory().createInventory(vaccine);
////        inventory.setVaccine(vaccine);
//                                   
//        if (inventory.getVaccine().getVaccineId() == vaccine.getVaccineId()) {
//            inventory.getVaccine().setPrice(10);
//            inventory.getVaccine().setManufactureDate("12-May-2014");
//            inventory.getVaccine().setExpiryDate("12-May-2016");
//            inventory.getVaccine().setAvailablity(20);
//        }
//        
//        
//        
//        Inventory inventory1 = ecoSystem.getInventoryDirectory().createInventory(vaccine1);
////        inventory1.setVaccine(vaccine1);
//                                   
//        if (inventory1.getVaccine().getVaccineId() == vaccine1.getVaccineId()) {
//            inventory1.getVaccine().setPrice(10);
//            inventory1.getVaccine().setManufactureDate("12-May-2014");
//            inventory1.getVaccine().setExpiryDate("12-May-2016");
//            inventory1.getVaccine().setAvailablity(20);
//        }
        
        
        return ecoSystem;
        
    }
}
