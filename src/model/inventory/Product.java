package model.inventory;

import controller.users.CashierController;
import controller.users.ManagerController;
import model.users.Cashier;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import static controller.users.CashierController.inventoryFile;

public class Product {
    private int id ;
    private String name;
    private int quantity = 2;
    private double price ;
    private boolean existed = true;
    public final static String inventoryPath = "assets/inventory.txt";


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public ArrayList<Product> getAllProduct () throws FileNotFoundException {
        ArrayList <Product> result = new ArrayList<>();
         File inventoryFile = new File(inventoryPath);
        Scanner myReader = new Scanner(inventoryFile);
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            Product temp = new Product();
            String[] spiltData = data.split(",");

            temp.setId(Integer.parseInt(spiltData[0]));
            temp.setName(spiltData[1]);
            temp.setQuantity(Integer.parseInt(spiltData[2]));
            temp.setPrice(Double.parseDouble(spiltData[3]));

            result.add(temp);
        }
        myReader.close();
        return result;
    }

    public int searchProductByName(String productName) throws FileNotFoundException {
        Scanner userFileReader = new Scanner(inventoryFile);

        while (userFileReader.hasNextLine()) {
            String data = userFileReader.nextLine();
            String[] splitData = data.split(",");
            if(splitData[1].equals(productName)){
                return Integer.parseInt(splitData[0]);
            }
        }
        userFileReader.close();
        return -1;
    }

}
