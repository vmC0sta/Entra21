package product;

import manageFile.ManageFile;

import java.util.ArrayList;

public class ManageProduct {
    private ArrayList<Product> listProduct = new ArrayList<Product>();
    private int nextID = 1;
    ManageFile manageFile = new ManageFile();

    public void createProduct(String description, double quantity, double value) {
        Product product = new Product();
        product.setId(this.nextID);
        product.setDescription(description);
        product.setQuantity(quantity);
        product.setValue(value);
        listProduct.add(product);
        System.out.println(product.toString());
        nextID++;
        refreshFile();
    }

    public void updateProduct(int id, String description, double value, double quantity) {
        if (id >= 1 && id <= listProduct.size()) {
            Product product = listProduct.get(id - 1);
            product.alter(id, description, value, quantity);
            refreshFile();
        } else {
            System.out.println("Esse produto não existe");
        }
    }

    public void deleteProduct(int id) {
        if (id >= 1 && id <= listProduct.size()) {
            listProduct.remove(id - 1);
            System.out.println("Produto excluído com sucesso");
            for (Product product : listProduct) {
                System.out.println(product.toString());
            }
            refreshFile();
        } else {
            System.out.println("Esse produto não existe");
        }
    }

    public void display(int id){
        if (id >= 1 && id <= listProduct.size()) {
            Product product = listProduct.get(id - 1);
            System.out.println(product.toString());
        }
    }

    public void displayAll(){
        for (Product product : listProduct){
            System.out.println(product.toString());
        }
    }

    public void refreshFile() {
        manageFile.writeFile("file", listProduct);
    }

}
