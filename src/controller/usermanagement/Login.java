package controller.usermanagement;


import controller.FileHandler;
import model.users.User;
import view.AdminMenu;
import view.CashierMenu;
import view.ManagerMenu;

import java.util.Scanner;

import static controller.FileHandler.getUsernamesFromFile;



public class Login {

    Scanner sc = new Scanner(System.in);

    public void loginDetails() throws Exception {

        System.out.println("Enter your username");

        String username = sc.nextLine();
        while(! User.checkIfUserExists(getUsernamesFromFile(), username)){
            System.out.println("the username is not existed. Enter another username.");
            username = sc.nextLine();
        }

        System.out.println("Enter your password");
        String password = sc.nextLine();

        boolean isCorrectPassword =PasswordHashing.checkPassword(FileHandler.getPasswordByUsername(username), password);

        if(isCorrectPassword){
            System.out.println("Welcome to System");

            String Role = FileHandler.getRoleByUsername(username);
            switch (Role){
                case "ADMIN" :
                    AdminMenu adminMenu = new AdminMenu();
                    adminMenu.printAdminMenu();
                    break;
                case "MANAGER" :
                    ManagerMenu managerMenu = new ManagerMenu();
                    managerMenu.printManagerMenu();
                    break;
                case "CASHIER" :
                    CashierMenu cashierMenu = new CashierMenu();
                    cashierMenu.printCashierMenu();
                    break;
                default:

            }

            //check role
            //print corresponding menu
        } else {
            System.out.println("Wrong password");
            System.exit(0);
        }

    }
}
