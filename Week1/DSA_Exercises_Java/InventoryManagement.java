import java.util.HashMap;

class Product {
    int productId;
    String productName;
    int quantity;
    double price;

    Product(int productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public String toString() {
        return productId + " " + productName + " Qty:" + quantity + " Price:" + price;
    }
}

public class InventoryManagement {
    HashMap<Integer, Product> inventory = new HashMap<>();

    public void addProduct(Product p) { inventory.put(p.productId, p); }
    public void updateProduct(int id, int qty, double price) {
        if (inventory.containsKey(id)) {
            Product p = inventory.get(id);
            p.quantity = qty;
            p.price = price;
        }
    }
    public void deleteProduct(int id) { inventory.remove(id); }

    public static void main(String[] args) {
        InventoryManagement ims = new InventoryManagement();
        ims.addProduct(new Product(1,"Laptop",10,50000));
        ims.addProduct(new Product(2,"Mouse",50,500));
        System.out.println(ims.inventory.values());
    }
}