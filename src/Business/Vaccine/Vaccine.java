/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Vaccine;

/**
 *
 * @author rangeshmurali
 */
public class Vaccine {
    
    private int vaccineId;
    private static int counter = 100;
    private String vaccineName;
    private int availablity;
    private String diseasesName;
    private String manufactureDate;
    private String expiryDate;
    private float price;
    private int orginatQuantity;
    
    public Vaccine(){
        vaccineId = counter;
        ++counter;
    }

    public int getVaccineId() {
        return vaccineId;
    }

    public void setVaccineId(int vaccineId) {
        this.vaccineId = vaccineId;
    }

    public String getVaccineName() {
        return vaccineName;
    }

    public void setVaccineName(String vaccineName) {
        this.vaccineName = vaccineName;
    }

    public int getAvailablity() {
        return availablity;
    }

    public void setAvailablity(int availablity) {
        this.availablity = availablity;
    }

    public String getDiseasesName() {
        return diseasesName;
    }

    public void setDiseasesName(String diseasesName) {
        this.diseasesName = diseasesName;
    }

    public String getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(String manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getOrginatQuantity() {
        return orginatQuantity;
    }

    public void setOrginatQuantity(int orginatQuantity) {
        this.orginatQuantity = orginatQuantity;
    }
    
    @Override
    public String toString(){
        return vaccineName;
    }
    
    
}
