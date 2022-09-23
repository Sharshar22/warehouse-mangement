package controller.usermanagement;

import controller.FileHandler;

import model.users.Roles;
import model.users.User;
import view.AdminMenu;
import view.CashierMenu;
import view.ManagerMenu;

import java.util.Scanner;

import static controller.FileHandler.getUsernamesFromFile;


public class SignUp extends User {
    Scanner sc = new Scanner(System.in);
    String userFilePath = "assets/users.txt";

    public void userDetails() throws Exception {
        System.out.println("Enter your full name");
        setFullName(sc.nextLine());
        System.out.println("Enter your username");
        //check if username already exists

        String newUsername = sc.nextLine();
        while(checkIfUserExists(getUsernamesFromFile(), newUsername)){
            System.out.println("the username is already existed. Enter another username.");
            newUsername = sc.nextLine();
        }
        setUsername(newUsername);

        System.out.println("Choose your role from the following\n" +
                "[A] Admin\n" +
                "[M] Manager\n" +
                "[C] Cashier");
        roleChoice();
        System.out.println("Enter your password");

        String newPass = sc.nextLine();
        setPassword(newPass);

        FileHandler.appendData(userFilePath,getFullName()+","+getUsername()+","+getRole()+","+getPassword()+"\n");

        switch (getRole().toString()) {
            case "ADMIN":
                AdminMenu adminMenu = new AdminMenu();
                adminMenu.printAdminMenu();
                break;
            case "MANAGER":
                ManagerMenu managerMenu = new ManagerMenu();
                managerMenu.printManagerMenu();
                break;
            case "CASHIER":
                CashierMenu cashierMenu = new CashierMenu();
                cashierMenu.printCashierMenu();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + getRole());
        }
    }
    public void roleChoice (){
        char choice = sc.nextLine().toUpperCase().charAt(0);
        switch (choice) {
            case 'A' :
                setRole(Roles.ADMIN);
                break;
            case 'M' :
                setRole(Roles.MANAGER);
                break;
            case 'C' :
                setRole(Roles.CASHIER);
                break;
            default:
                System.out.println("Invalid Option");
                System.out.println("Choose your role from the following\n" +
                        "[A] Admin\n" +
                        "[M] Manager\n" +
                        "[C] Cashier");
                roleChoice();
        }
    }





}
