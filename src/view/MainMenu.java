package view;

import controller.usermanagement.Login;
import controller.usermanagement.SignUp;


import java.util.Scanner;

public class MainMenu {

    public static void printMainMenu () throws Exception {
        System.out.println("Welcome to MINET !!\n" +
                "Please choose one of the following options\n" +
                "[1] Register\n" +
                "[2] Login\n" +
                "[q] Quit");
        userChoice();
    }
    private static void userChoice () throws Exception {
        Scanner sc = new Scanner(System.in);
        char choice = sc.next().toLowerCase().charAt(0);
        switch (choice) {
            case '1' :
                System.out.println("================");
                SignUp signup = new SignUp();
                signup.userDetails();
                break;
            case '2' :
                System.out.println("================");
                Login login = new Login();
                login.loginDetails();
                break;
            case 'q' :
                System.out.println("Thank you !1");
                System.exit(0);
            default:
                System.out.println("Invalid Option! Try again\n");
                printMainMenu();
        }
    }
}
