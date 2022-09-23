package controller.users;

import model.inventory.Product;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ManagerController {
    public final static String inventoryPath = "assets/inventory.txt";
    public final static String orderItemPath= "assets/orderItems.txt";
    Product product = new Product();
    Scanner sc = new Scanner(System.in);

    public String addProduct() throws InputMismatchException, IOException {
        int productID =  getLastID()+1;
        System.out.println("Enter the product name");
        String productName = sc.nextLine();
        System.out.println("Enter the quantity of the product");
         int quantity = sc.nextInt();
        System.out.println("Enter the price for the product");
         double price = sc.nextDouble();
        return  productID+ "," +productName + "," + quantity + ","+price +"\n";
    }

    private int getLastID() throws FileNotFoundException {
        ArrayList<Product> products = product.getAllProduct();
        return products.get(products.size()-1).getId();
    }
    public void viewAllProduct () throws FileNotFoundException {

        File inventoryFile = new File(inventoryPath);
        Scanner myReader = new Scanner(inventoryFile);
        while (myReader.hasNextLine()) {
            System.out.println(myReader.nextLine());
        }
        myReader.close();
    }

    public String addOrderItem() throws InputMismatchException, IOException {
        System.out.println("Enter the product name");
        String productName = sc.nextLine();
        if(product.searchProductByName(productName)>0){
            System.out.println("WARNING: product does not exist in the inventory");
        }

        System.out.println("Enter the quantity of the product");
        int quantity = sc.nextInt();
        System.out.println("Enter the price for the product");
        double price = sc.nextDouble();
        return  productName + "," + quantity + ","+price +"\n";
    }

    public  void addProductToOrderItemsFile() throws IOException {
        File myFile = new File(orderItemPath);
        FileWriter myWriter = new FileWriter(myFile,true);
        myWriter.append(addOrderItem());
        myWriter.close();
    }
}
