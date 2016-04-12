/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Clinic;

import Business.Patient.PatientDirectory;

/**
 *
 * @author rangeshmurali
 */
public class Clinic {
    
    private String clinicName;
    private int clinicId;
    private static int counter = 1001;
    private PatientDirectory patientDirectory;
    
    public Clinic(){
        clinicId = counter;
        ++counter;
        patientDirectory = new PatientDirectory();
    }

    public String getClinicName() {
        return clinicName;
    }

    public void setClinicName(String clinicName) {
        this.clinicName = clinicName;
    }

    public int getClinicId() {
        return clinicId;
    }

    public void setClinicId(int clinicId) {
        this.clinicId = clinicId;
    }
    
    @Override
    public String toString(){
        return clinicName;
    }
}
