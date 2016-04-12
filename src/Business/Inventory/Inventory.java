/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Inventory;

import Business.Vaccine.Vaccine;

/**
 *
 * @author rangeshmurali
 */
public class Inventory {
    private Vaccine vaccine;
    
    public Inventory(){
        vaccine = new Vaccine();
    }

    public Vaccine getVaccine() {
        return vaccine;
    }

    public void setVaccine(Vaccine vaccine) {
        this.vaccine = vaccine;
    }
    
    
}
