package manageFile;

import product.Product;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class ManageFile {
    LocalDateTime myDateObj = LocalDateTime.now();
    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    String formattedDate = myDateObj.format(myFormatObj);

    public void createFile(String pathName) {
        File file = new File(pathName);
        try {
            if (file.createNewFile()) {
                System.out.println("Arquivo criado");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeFile(String pathName, ArrayList<Product> productsList) {

        double totalQuantity = 0;
        double totalValue = 0;

        try {
            FileWriter writer = new FileWriter(pathName);
            writer.write("THE REPORT WAS ISSUED AT " + formattedDate + "\n\n");
            for (Product product : productsList) {
                writer.write(String.valueOf(product) + "\n");
                totalQuantity += product.getQuantity();
                totalValue += product.getValue();
            }
            writer.write("\nTotal products: " + productsList.size() + "\t Total quantity: " + totalQuantity + "\tTotal value: " + totalValue * totalQuantity);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
