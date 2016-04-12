/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Hospital;

import Business.Patient.PatientDirectory;

/**
 *
 * @author rangeshmurali
 */
public class Hospital {
    private String hospitalName;
    private int hospitalId;
    private String hospitalAddress;
    private static int counter = 1001;
    private PatientDirectory patientDirectory;
    private String hospitalStatus;
    
    public Hospital(){
        hospitalId = counter;
        ++counter;
        patientDirectory = new PatientDirectory();
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public int getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(int hospitalId) {
        this.hospitalId = hospitalId;
    }

    public String getHospitalAddress() {
        return hospitalAddress;
    }

    public void setHospitalAddress(String hospitalAddress) {
        this.hospitalAddress = hospitalAddress;
    }

    public String getHospitalStatus() {
        return hospitalStatus;
    }

    public void setHospitalStatus(String hospitalStatus) {
        this.hospitalStatus = hospitalStatus;
    }
    
    @Override
    public String toString(){
        return hospitalName;
    }
    
}
