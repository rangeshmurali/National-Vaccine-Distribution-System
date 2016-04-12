/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Clinic;

import java.util.ArrayList;

/**
 *
 * @author rangeshmurali
 */
public class ClinicDirectory {
    
    private ArrayList<Clinic> clinicDirectory;
    
    public ClinicDirectory(){
        clinicDirectory = new ArrayList<>();
    }

    public ArrayList<Clinic> getClinicDirectory() {
        return clinicDirectory;
    }
    
    public Clinic createClinic(){
        Clinic clinic = new Clinic();
        clinicDirectory.add(clinic);
        return clinic;
    }
    
    public void removeClinic(Clinic clinic){
        clinicDirectory.remove(clinic);
    }
}
