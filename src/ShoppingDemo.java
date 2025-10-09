abstract class Product {
    private String name;
    private int id;
    private int quantity;
    private double price;

    public Product(String name, int id , int quantity , double price){
        this.id=id;
        this.name=name;
        this.quantity=quantity;
        this.price=price;
    }

    public String getName(){
        return name;
    }

    public int getId(){
        return id;
    }

    public int getQuantity(){
        return quantity;
    }

    public double getPrice(){
        return price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public abstract void showDetails();
}

class Electronics extends Product {
    private String warranty;

    public Electronics(String name, int id, int quantity, double price, String warranty) {
        super(name, id, quantity, price);
        this.warranty = warranty;
    }

    public String getWarranty() {
        return warranty;
    }

    @Override
    public void showDetails() {
        System.out.println("Electronics [ID: " + getId() + ", Name: " + getName() +
                ", Quantity: " + getQuantity() + ", Price: " + getPrice() +
                ", Warranty: " + warranty + "]");
    }
}

class Clothing extends Product {
    private String size;

    public Clothing(String name, int id, int quantity, double price, String size) {
        super(name, id, quantity, price);
        this.size = size;
    }

    public String getSize() {
        return size;
    }

    @Override
    public void showDetails() {
        System.out.println("Clothing [ID: " + getId() + ", Name: " + getName() +
                ", Quantity: " + getQuantity() + ", Price: " + getPrice() +
                ", Size: " + size + "]");
    }
}

class Grocery extends Product {
    private String expiryDate;

    public Grocery(String name, int id, int quantity, double price, String expiryDate) {
        super(name, id, quantity, price);
        this.expiryDate = expiryDate;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    @Override
    public void showDetails() {
        System.out.println("Grocery [ID: " + getId() + ", Name: " + getName() +
                ", Quantity: " + getQuantity() + ", Price: " + getPrice() +
                ", Expiry: " + expiryDate + "]");
    }
}

// ---------------------------
public class ShoppingDemo {
    public static void main(String[] args) {
        Product p1 = new Electronics("Laptop", 101, 2, 50000, "2 Years");
        Product p2 = new Clothing("Shirt", 201, 3, 1200, "L");
        Product p3 = new Grocery("Milk", 301, 5, 50, "10-10-2025");

        // Show details
        p1.showDetails();
        p2.showDetails();
        p3.showDetails();
    }
}
