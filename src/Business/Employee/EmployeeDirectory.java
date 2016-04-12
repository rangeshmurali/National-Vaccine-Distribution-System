/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.Employee;

import java.util.ArrayList;

/**
 *
 * @author rangeshmurali
 */
public class EmployeeDirectory {
    
    private ArrayList<Employee> employeeDirectory;
    
    public EmployeeDirectory(){
        employeeDirectory = new ArrayList<>();
    }

    public ArrayList<Employee> getEmployeeDirectory() {
        return employeeDirectory;
    }
    
    public Employee createEmployee(String employeeName){
        Employee employee = new Employee();
        employee.setEmployeeName(employeeName);
        employeeDirectory.add(employee);
        return employee;
    }
    
}
