import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductInventorySystem {
    int id;
    String name;
    double price;
    int quantity;
    static int count;
    ProductInventorySystem(String name , double price , int quantity ){
        this.name=name;
        this.quantity=quantity;
        this.price=price;
        this.id= ++count;
    }
    void showDetails(){
            System.out.println("ID: " + id + " | Name: " + name + " | Price: " + price + " | Quantity: " + quantity);
        }


    public static void main(String[] args) {
        ArrayList<ProductInventorySystem> product = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of objects : ");
        int n = sc.nextInt();

        for (int i=0; i<n; i++){
            System.out.println("Enter name:");
            String name = sc.next();
            sc.nextLine();
            System.out.println("enter price : ");
            double price = sc.nextDouble();
            sc.nextLine();
            System.out.println("Enter quantity : ");
            int quantity = sc.nextInt();
            ProductInventorySystem p = new ProductInventorySystem(name , price , quantity);
            product.add(p);
        }

        while (true){
            System.out.println("Choice selection :");
            System.out.println("1 . Add ");
            System.out.println("2 . Delete");
            System.out.println("3 . Update");
            System.out.println("4 . View All");
            System.out.println("5 . Exit ");
            System.out.println("Enter you're choice ");
            int choice = sc.nextInt();

            switch (choice){
                case 1 :
                    System.out.println("Enter name : ");
                    String name = sc.next();
                    System.out.println("Enter price : ");
                    double price = sc.nextDouble();
                    System.out.println("Enter quantity :");
                    int quantity = sc.nextInt();
                    ProductInventorySystem p = new ProductInventorySystem(name , price ,quantity);
                    System.out.println("Product added successfullu !!");
                    break;

                case 2 :
                    System.out.println("Enter product Id to delete ");
                    int idToDelete = sc.nextInt();
                    for (int i=0 ; i<product.size(); i++){
                        if (product.get(i).id==idToDelete){
                            product.remove(i);
                        }else {
                            System.out.println("incorrect ID");
                        }

                    }
                    break;

                case 3 :
                    System.out.println("Enter product ID to update : ");
                    int idToUpdate = sc.nextInt();
                    for (int i=0;i<product.size();i++){
                        if (product.get(i).id==idToUpdate){
                            System.out.println("Enter name :");
                            String updatedName = sc.next();
                            product.get(i).name=updatedName;
                            System.out.println("Update done ");
                        }
                    }
                    break;

                case 4:
                    for (int i=0;i<product.size();i++){
                        product.get(i).showDetails();
                    }
                    break;

                case 5:
                    System.out.println("Exiting program");
                    sc.close();
                    System.exit(0);
                    break;

            }
        }
    }
}
