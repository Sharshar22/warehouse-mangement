package model.inventory;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


public class Receipts {
   //private int receiptNumber ;
    //private ArrayList<Map<Integer,Integer>> receiptItems; // We will think later on to create a something else or
    // modify The receipts class
    public static final String receiptPath = "assets/receipts.txt";
    Product product = new Product();
    Scanner scanner = new Scanner(System.in);



    public int searchReceiptByNumber(String receiptNumber) throws FileNotFoundException {
        Scanner userFileReader = new Scanner(receiptNumber);
        while (userFileReader.hasNextLine()) {
            String data = userFileReader.nextLine();
            String[] splitData = data.split(",");
            if(splitData[0].equals(receiptNumber)){
                return Integer.parseInt(splitData[0]);
            }
        }
        userFileReader.close();
        return -1;
    }


    public String addReceipt() throws InputMismatchException, IOException {

        Scanner sc = new Scanner(System.in);
        int choice = 0;
        int quantity = 0;
        String toWriteInFile = "";

        System.out.println("Enter the receipt number");
        String receiptNum = scanner.nextLine();

        do {
            toWriteInFile += receiptNum;
            System.out.println("Enter your product name");
            String productName = sc.nextLine();
            int productId =  product.searchProductByName(productName);

            if(productId != -1){
                System.out.println("Enter quatity of the product");
                quantity = sc.nextInt();
                toWriteInFile += ","+ productName + "," + quantity + "\n";
            }else{
                System.out.println("Product is not existed ");
            }

            System.out.println("Do you need to add more products?\n" +
                    "[1] Yes\n" +
                    "[2] No");
            choice = sc.nextInt();

        } while (choice == 1);

        return  toWriteInFile;
    }

    public void addReceiptToReceiptFile () throws IOException {
        File myFile = new File(receiptPath);
        FileWriter myWriter = new FileWriter(myFile, true);
        myWriter.append(addReceipt());
        myWriter.close();
    }

    public void viewAllReceipt () throws FileNotFoundException {
            File receiptFile = new File(receiptPath);
            Scanner myReader = new Scanner(receiptFile);

            while (myReader.hasNextLine()) {
                System.out.println(myReader.nextLine());
            }
            myReader.close();
    }
}
