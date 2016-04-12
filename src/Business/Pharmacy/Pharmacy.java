/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Pharmacy;

import Business.Patient.PatientDirectory;

/**
 *
 * @author rangeshmurali
 */
public class Pharmacy {
    
    private String pharmacyName;
    private int pharmacyId;
    private static int counter = 1001;
    private String pharmacyAddress;
    private PatientDirectory patientDirectory;
    private String pharmacyStatus;
    
    public Pharmacy(){
        pharmacyId = counter;
        ++counter;
        patientDirectory = new PatientDirectory();
    }

    public String getPharmacyName() {
        return pharmacyName;
    }

    public void setPharmacyName(String pharmacyName) {
        this.pharmacyName = pharmacyName;
    }

    public int getPharmacyId() {
        return pharmacyId;
    }

    public void setPharmacyId(int pharmacyId) {
        this.pharmacyId = pharmacyId;
    }

    public String getPharmacyAddress() {
        return pharmacyAddress;
    }

    public void setPharmacyAddress(String pharmacyAddress) {
        this.pharmacyAddress = pharmacyAddress;
    }

    public String getPharmacyStatus() {
        return pharmacyStatus;
    }

    public void setPharmacyStatus(String pharmacyStatus) {
        this.pharmacyStatus = pharmacyStatus;
    }
    
    @Override
    public String toString(){
        return pharmacyName;
    }
}
