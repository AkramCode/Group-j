import java.util.ArrayList;
import java.util.List;

public class ProductCatalog {
    private List<Product> products = new ArrayList<>();

    // Add a new product
    public void addProduct(Product product) {
        products.add(product);
        System.out.println("Product added: " + product);
    }

    // List all products
public void listProducts() {
    if (products.isEmpty()) {
        System.out.println("No products available.");
    } else {
        for (Product product : products) {
            System.out.println(product);
        }
    }
}

// Update product details
public void updateProduct(int productID, String newName, double newPrice, int newQuantity) {
    for (Product product : products) {
        if (product.getProductID() == productID) {
            product.setName(newName);
            product.setPrice(newPrice);
            product.setQuantity(newQuantity);
            System.out.println("Product updated: " + product);
            return;
        }
    }
    System.out.println("Product not found.");
}

// Delete a product by productID
public void deleteProduct(int productID) {
    products.removeIf(product -> product.getProductID() == productID);
    System.out.println("Product with ID " + productID + " has been deleted.");
}
}