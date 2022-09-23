package view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AdminMenu {
    public void printAdminMenu () throws Exception {
        System.out.println("Choose one of the following Options: \n" +
                "[1] Hire new employee\n" +
                "[2] Access to the system \n" +
                "[3] Pay salaries to employees\n" +
                "[4] Review the system\n" +
                "[5] Back to the Main menu\n" +
                "[q] Quit");
        adminChoice();
    }
    private void adminChoice () throws Exception {
        Scanner sc = new Scanner(System.in);
        char choice = sc.next().toLowerCase().charAt(0);
        switch (choice) {
            case '1' :
                // Hire
                System.out.println("Hire");
                break;
            case '2' :
                // Access
                System.out.println("Access");
                break;
            case '3' :
                //Pay salaries
                System.out.println("Pay salaries");
                break;
            case '4':
                // Review
                System.out.println("Review the system");
                break;
            case '5' :
                // back to the previous menu
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
