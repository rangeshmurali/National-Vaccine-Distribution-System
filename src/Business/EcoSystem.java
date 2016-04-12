/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business;

import Business.Inventory.InventoryDirectory;
import Business.NationalDistributor.NationalDistributor;
import Business.Network.Network;
import Business.Organization.Organization;
import Business.Role.Role;
import Business.Role.SysAdminRole;
import Business.Vaccine.VaccineDirectory;
import Business.WorkQueue.WorkQueue;
import Business.WorkQueue.WorkRequest;
import java.util.ArrayList;

/**
 *
 * @author rangeshmurali
 */
public class EcoSystem extends Organization{
    
    private static EcoSystem ecoSystem;
    private ArrayList<Network> networkDirectory;
    private VaccineDirectory vaccineDirectory;
    private InventoryDirectory inventoryDirectory;
    private NationalDistributor nationalDistributor;
    
    public static EcoSystem getInstance(){
        if(ecoSystem == null){
            ecoSystem = new EcoSystem();
        }
        return ecoSystem;
    }
    
    private EcoSystem(){
        super(null);
        networkDirectory = new ArrayList<>();
        vaccineDirectory = new VaccineDirectory();
        inventoryDirectory = new InventoryDirectory();
        nationalDistributor = new NationalDistributor();
    }
    
    public Network createAndAddNetwork(String networkName){
        Network network = new Network();
        network.setNetworkName(networkName);
        networkDirectory.add(network);
        return network;
    }
    
    

    public ArrayList<Network> getNetworkDirectory() {
        return networkDirectory;
    }

    public VaccineDirectory getVaccineDirectory() {
        return vaccineDirectory;
    }

    public InventoryDirectory getInventoryDirectory() {
        return inventoryDirectory;
    }

    public NationalDistributor getNationalDistributor() {
        return nationalDistributor;
    }

    public void setNationalDistributor(NationalDistributor nationalDistributor) {
        this.nationalDistributor = nationalDistributor;
    }
    
    
    @Override
    public ArrayList<Role> getSupportedRole() {
        ArrayList<Role> roles = new ArrayList<>();
        roles.add(new SysAdminRole());
        return roles;
    }
    
}
