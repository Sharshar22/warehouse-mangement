package view;

import controller.users.CashierController;
import model.inventory.Receipts;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CashierMenu {
    Receipts receipts = new Receipts();
    CashierController cashierController = new CashierController();
    public void printCashierMenu () throws Exception {
        System.out.println("Choose one of the following Options: \n" +
                "[1] Remove the sold item from inventory\n" +
                "[2] Check items in the Stock \n" +
                "[3] Delete the returned item's transaction\n" +
                "[4] Create a Receipt for customer\n" +
                "[5] Back to Main Menu\n" +
                "[q] Quit\n");
        cashierChoice();

    }

    private void cashierChoice () throws Exception {
        Scanner sc = new Scanner(System.in);
        char choice = sc.next().toLowerCase().charAt(0);
        switch (choice) {
            case '1':
                System.out.println("Enter sold item");
                String removedItem = sc.nextLine();
                cashierController.removeProductByName(removedItem);
                System.out.println("Remove the sold item");
                break;
            case '2':
                cashierController.viewAllProduct();
                break;
            case '3':
                System.out.println("Please enter the product name which you want to delete ");
                Scanner scan =  new Scanner(System.in);
                String productName =scan.nextLine();
                cashierController.removeProductByName(productName);
                break;
            case '4':
                receipts.addReceiptToReceiptFile();
                break;
            case '5':
                MainMenu.printMainMenu();
                break;
            case 'q':
                System.exit(0);
            default:
                System.out.println("Invalid Option! Try again\n");
                printCashierMenu();

        }
    }
}
