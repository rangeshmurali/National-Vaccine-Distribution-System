/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Vaccine;

import java.util.ArrayList;

/**
 *
 * @author rangeshmurali
 */
public class VaccineDirectory {
    
    private ArrayList<Vaccine> vaccineDirectory;
    
    public VaccineDirectory(){
        vaccineDirectory = new ArrayList<>();
    }

    public ArrayList<Vaccine> getVaccineDirectory() {
        return vaccineDirectory;
    }
    
    public Vaccine createVaccine(){
        Vaccine vaccine = new Vaccine();
        vaccineDirectory.add(vaccine);
        return vaccine;
    }
    
    public void removeVaccine(Vaccine vaccine){
        vaccineDirectory.remove(vaccine);
    }
    
    public Vaccine searchVaccine(int vaccineId){
        for(Vaccine vaccine : vaccineDirectory){
            if(vaccineId == vaccine.getVaccineId()){
                return vaccine;
            }
        }
        return null;
    }
    
}
