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
}
