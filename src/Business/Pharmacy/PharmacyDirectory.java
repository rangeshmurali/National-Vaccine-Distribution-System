/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Pharmacy;

import java.util.ArrayList;

/**
 *
 * @author rangeshmurali
 */
public class PharmacyDirectory {
    
    private ArrayList<Pharmacy> pharmacyDirectory;
    
    public PharmacyDirectory(){
        pharmacyDirectory = new ArrayList<>();
    }

    public ArrayList<Pharmacy> getPharmacyDirectory() {
        return pharmacyDirectory;
    }
    
    public Pharmacy createPharmacy(){
        Pharmacy pharmacy = new Pharmacy();
        pharmacyDirectory.add(pharmacy);
        return pharmacy;
    }
    
    public void removePharmacy(Pharmacy pharmacy){
        pharmacyDirectory.remove(pharmacy);
    }
}
