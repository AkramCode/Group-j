public class Product {
    private int productID;
    private String name;
    private String category;
    private double price;
    private int quantity;

    // Constructor
    public Product(int productID, String name, String category, double price, int quantity) {
        this.productID = productID;
        this.name = name;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
    }

    // Getters and Setters
    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Display product details
    @Override
    public String toString() {
        return "ProductID: " + productID + ", Name: " + name + ", Category: " + category +
                ", Price: " + price + ", Quantity: " + quantity;
    }

    // Search products by name
public void searchByName(String name) {
    for (Product product : products) {
        if (product.getName().equalsIgnoreCase(name)) {
            System.out.println("Product found: " + product);
            return;
        }
    }
    System.out.println("No product found with the name: " + name);
}

// Search products by category
public void searchByCategory(String category) {
    for (Product product : products) {
        if (product.getCategory().equalsIgnoreCase(category)) {
            System.out.println("Product found: " + product);
        }
    }
}
}
