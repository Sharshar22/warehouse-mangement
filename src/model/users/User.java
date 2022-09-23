package model.users;



import controller.usermanagement.PasswordHashing;

import java.util.ArrayList;

public class User {
    private String fullName;
    private String username;
    private String password;
    private Roles role;
    private double salary;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) throws Exception {

        this.password = PasswordHashing.encryptedPassword(password);
//        this.password = password;
    }

    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }


    public static boolean checkIfUserExists(ArrayList<String> usernames, String newUsername){
        for (String user: usernames){
            if(user.equalsIgnoreCase(newUsername)) return true;
        }
        return false;
    }
}
