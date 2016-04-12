/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Business.UserAccount;

import Business.Employee.Employee;
import Business.Role.Role;
import java.util.ArrayList;

/**
 *
 * @author rangeshmurali
 */
public class UserAccountDirectory {
    
    private ArrayList<UserAccount> userAccountDirectory;
    
    public UserAccountDirectory(){
        userAccountDirectory = new ArrayList<>();
    }

    public ArrayList<UserAccount> getUserAccountDirectory() {
        return userAccountDirectory;
    }
    
    public UserAccount authenticateUserAccount(String userName, String password){
        for(UserAccount userAccount : userAccountDirectory){
            if(userAccount.getUserName().equalsIgnoreCase(userName) && userAccount.getPassword().equals(password)){
                return userAccount;
            }
        }
        return null;
    }
    
    public UserAccount createUserAccount(String userName, String password, Employee employee, Role role){
        UserAccount userAccount = new UserAccount();
        userAccount.setUserName(userName);
        userAccount.setPassword(password);
        userAccount.setEmployee(employee);
        userAccount.setRole(role); 
        userAccountDirectory.add(userAccount);
        return userAccount;
    }
    
    public boolean checkIfUsernameIsUnique(String username){
        for (UserAccount ua : userAccountDirectory){
            if (ua.getUserName().equals(username))
                return false;
        }
        return true;
    }
    
}
