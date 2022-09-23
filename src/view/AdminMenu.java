package view;

import controller.users.AdminController;
import controller.users.CashierController;
import model.inventory.Receipts;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AdminMenu {
    public void printAdminMenu () throws Exception {
        System.out.println("Choose one of the following Options: \n" +
                "[1] Hire new employee\n" +
                "[2] View the inventory \n" +
                "[3] View all receipts\n" +
                "[4] Pay salaries\n" +
                "[5] Back to the Main menu\n" +
                "[q] Quit");
        adminChoice();
    }
    private void adminChoice () throws Exception {
        Scanner sc = new Scanner(System.in);
        char choice = sc.next().toLowerCase().charAt(0);
        AdminController  adminController = new AdminController();
        CashierController cashierController = new CashierController();
        Receipts receipts = new Receipts();

        switch (choice) {
            case '1' :
               adminController.registerUser();
               printAdminMenu();
                break;
            case '2' :
                cashierController.viewAllProduct();
                printAdminMenu();
                break;
            case '3' :
                receipts.viewAllReceipt();
                printAdminMenu();
                break;
            case '4' :
                System.out.println("In progress");
                printAdminMenu();
                break;
            case '5' :

                MainMenu.printMainMenu();
                break;
            case 'q' :
                System.exit(0);
            default:
                System.out.println("Invalid Option! Try again\n");
                printAdminMenu();
        }
    }
}
