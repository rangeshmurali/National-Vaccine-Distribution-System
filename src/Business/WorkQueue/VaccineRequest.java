/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.WorkQueue;

/**
 *
 * @author rangeshmurali
 */
public class VaccineRequest extends WorkRequest{
    
    private String vaccineRequest;

    public String getVaccineRequest() {
        return vaccineRequest;
    }

    public void setVaccineRequest(String vaccineRequest) {
        this.vaccineRequest = vaccineRequest;
    }
    
    
}
