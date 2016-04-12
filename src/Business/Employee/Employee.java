/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Employee;

import Business.Hospital.Hospital;
import Business.Order.MasterOrderCatalog;
import Business.Order.Order;
import Business.Pharmacy.Pharmacy;

/**
 *
 * @author rangeshmurali
 */
public class Employee {
    private String employeeName;
    private int employeeId;
    private static int counter = 0;
    private String enrollmentStatus;
    private Hospital hospital;
    private Pharmacy pharmacy;
    private MasterOrderCatalog masterOrderCatalog;
    private String check;
    
    public Employee(){
        employeeId = counter;
        ++counter;
        masterOrderCatalog = new MasterOrderCatalog();
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEnrollmentStatus() {
        return enrollmentStatus;
    }

    public void setEnrollmentStatus(String enrollmentStatus) {
        this.enrollmentStatus = enrollmentStatus;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public Pharmacy getPharmacy() {
        return pharmacy;
    }

    public void setPharmacy(Pharmacy pharmacy) {
        this.pharmacy = pharmacy;
    }

    public MasterOrderCatalog getMasterOrderCatalog() {
        return masterOrderCatalog;
    }

    public String getCheck() {
        return check;
    }

    public void setCheck(String check) {
        this.check = check;
    }
    
    @Override
    public String toString(){
        return employeeName; 
    }
}
