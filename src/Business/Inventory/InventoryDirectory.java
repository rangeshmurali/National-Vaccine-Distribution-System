/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Inventory;

import Business.Vaccine.Vaccine;
import java.util.ArrayList;

/**
 *
 * @author rangeshmurali
 */
public class InventoryDirectory {
    
    private ArrayList<Inventory> inventoryDirectory;
    
    public InventoryDirectory(){
        inventoryDirectory = new ArrayList<>();
    }

    public ArrayList<Inventory> getInventoryDirectory() {
        return inventoryDirectory;
    }
    
    public Inventory createInventory(Vaccine vaccine){
        Inventory inventory = new Inventory();
        inventoryDirectory.add(inventory);
        inventory.setVaccine(vaccine);
        return inventory;
    }
    
    public void removeInventory(Inventory inventory){
        inventoryDirectory.remove(inventory);
    }
}
