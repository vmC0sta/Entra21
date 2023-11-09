package product;

public class Product {
    private int id;
    private String description;
    private double quantity;
    private double value;

    public Product(){
        //
    }

    public Product(int id, String description, double quantity, double value){
        this.id = id;
        this.description = description;
        this.quantity = quantity;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ID: " + this.id + "\tDescription: " + this.description + "\tQuantity: " + this.quantity + "\tValue: " + this.value;
    }

    public void alter(int id,String description,double quantity,double value){
        this.id = id;
        this.description = description;
        this.quantity = quantity;
        this.value = value;
    }
}
