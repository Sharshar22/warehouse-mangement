package controller;

import controller.users.CashierController;
import controller.users.ManagerController;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Scanner;


public class FileHandler {
    // 5 functions: Add,view , search, update, delete (by name or id)
    private final static String userFilePath = "assets/users.txt";
    private final static File usersFile = new File(userFilePath);
    public final static String inventoryPath = "assets/inventory.txt";
    static ManagerController managerController = new ManagerController();

    public void printFileContent(File myFile) throws FileNotFoundException{
        Scanner myReader = new Scanner(myFile);
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            System.out.println(data);
        }
        myReader.close();
    }

    public static void appendData(String myFilePath, String myData) throws IOException {
        Files.write(Paths.get(myFilePath), myData.getBytes(), StandardOpenOption.APPEND);
    }

    public static ArrayList<String> getUsernamesFromFile() throws FileNotFoundException {
        ArrayList<String> usernames = new ArrayList<>();
        Scanner userFileReader = new Scanner(usersFile);

        while (userFileReader.hasNextLine()) {
            String data = userFileReader.nextLine();
            String[] splitData = data.split(",");
            usernames.add(splitData[1]);
        }
        userFileReader.close();

        return usernames;
    }

    public static String getPasswordByUsername(String enteredUsername) throws FileNotFoundException {
        Scanner userFileReader = new Scanner(usersFile);

        while (userFileReader.hasNextLine()) {
            String data = userFileReader.nextLine();
            String[] splitData = data.split(",");
            if(splitData[1].equals(enteredUsername)){
                return splitData[3];
            }
        }
        userFileReader.close();
        return "";
    }

    public static String getRoleByUsername(String enteredUsername) throws FileNotFoundException {
        Scanner userFileReader = new Scanner(usersFile);

        while (userFileReader.hasNextLine()) {
            String data = userFileReader.nextLine();
            String[] splitData = data.split(",");
            if(splitData[1].equals(enteredUsername)){
                return splitData[2];
            }
        }
        userFileReader.close();
        return "";
    }

    public static void addProductToInventoryFile() throws IOException {
        File myFile = new File(inventoryPath);
        FileWriter myWriter = new FileWriter(myFile,true);
        myWriter.append(managerController.addProduct());
        myWriter.close();
    }
}
