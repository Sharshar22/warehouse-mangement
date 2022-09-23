package controller.users;
import model.inventory.Product;
import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CashierController {
    Scanner sc = new Scanner(System.in);
    Product product = new Product();
    public final static String inventoryPath = "assets/inventory.txt";
    public final static File inventoryFile = new File(inventoryPath);

//    public int searchProductByName(String productName) throws FileNotFoundException {
//        Scanner userFileReader = new Scanner(inventoryFile);
//
//        while (userFileReader.hasNextLine()) {
//            String data = userFileReader.nextLine();
//            String[] splitData = data.split(",");
//            if(splitData[1].equals(productName)){
//                return Integer.parseInt(splitData[0]);
//            }
//        }
//        userFileReader.close();
//        return -1;
//    }

    public void removeProductByName(String productName) throws IOException {
        // make sure that product exists (search)
        int productExists = product.searchProductByName(productName);

        if(productExists >0){
            String tempFile = "temp.txt";
            File oldFile = new File(inventoryPath);
            File newFile = new File(tempFile);
            String currentLine;
            String data[];

            FileWriter fileWriter = new FileWriter(tempFile,true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            PrintWriter printWriter = new PrintWriter(bufferedWriter);

            FileReader fileReader = new FileReader(inventoryPath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while((currentLine = bufferedReader.readLine()) != null) {
                data = currentLine.split(",");
                if(productExists != Integer.parseInt(data[0])){
                    printWriter.println(currentLine);
                }
            }


            printWriter.flush();
            printWriter.close();
            fileReader.close();
            bufferedReader.close();
            bufferedWriter.close();
            fileWriter.close();

            System.out.println(oldFile.delete());
            System.out.println(newFile.renameTo(new File(inventoryPath)));
        } else {
            System.out.println("Product does not exists.");

        }

    }

    public void viewAllProduct () throws FileNotFoundException {

        File inventoryFile = new File(inventoryPath);
        Scanner myReader = new Scanner(inventoryFile);
        while (myReader.hasNextLine()) {
            System.out.println(myReader.nextLine());
        }
        myReader.close();
    }

}



