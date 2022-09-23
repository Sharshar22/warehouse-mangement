package view;

import controller.users.ManagerController;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ManagerMenu {
    ManagerController managerController = new ManagerController();
    public void printManagerMenu() throws Exception {
        System.out.println("Choose one of the following Options: \n" +
                "[1] View the order list\n" +
                "[2] Review the inventory \n" +
                "[3] Order Items to inventory\n" +
                "[4] Review details from transactions and orders\n" +
                "[5] Back to the Main menu\n" +
                "[q] Quit\n");
        managerChoice();

    }
    private void managerChoice() throws Exception {
        Scanner sc = new Scanner(System.in);
        char choice = sc.next().toLowerCase().charAt(0);
        switch (choice) {
            case '1':
                // view the order list
                printManagerMenu();
                break;
            case '2':
                managerController.viewAllProduct();
                printManagerMenu();
                break;
            case '3':
                managerController.addProductToOrderItemsFile();
                printManagerMenu();
                break;
            case '4':
                // Review details from transactions and orders
                System.out.println("Review the system");
                printManagerMenu();
                break;
            case '5':
                MainMenu.printMainMenu();
                break;
            case 'q':
                System.exit(0);
            default:
                System.out.println("Invalid Option! Try again\n");
                printManagerMenu();

        }
    }
}
