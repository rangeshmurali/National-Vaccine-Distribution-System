/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Hospital;

import java.util.ArrayList;

/**
 *
 * @author rangeshmurali
 */
public class HospitalDirectory {
    
    private ArrayList<Hospital> hospitalDirecotry;
    
    public HospitalDirectory(){
        hospitalDirecotry = new ArrayList<>();
    }

    public ArrayList<Hospital> getHospitalDirecotry() {
        return hospitalDirecotry;
    }
    
    public Hospital createHospital(){
        Hospital hospital = new Hospital();
        hospitalDirecotry.add(hospital);
        return hospital;
    }
    
    public void removeHospital(Hospital hospital){
        hospitalDirecotry.remove(hospital);
    }
    
}
