/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Patient;

import java.util.ArrayList;

/**
 *
 * @author rangeshmurali
 */
public class PatientDirectory {
    
    private ArrayList<Patient> patientDirectory;
    
    public PatientDirectory(){
        patientDirectory = new ArrayList<>();
    }

    public ArrayList<Patient> getPatientDirectory() {
        return patientDirectory;
    }
    
    public Patient createPatient(){
        Patient patient = new Patient();
        patientDirectory.add(patient);
        return patient;
    }
    
    public void removePatient(Patient patient){
        patientDirectory.remove(patient);
    }
}
