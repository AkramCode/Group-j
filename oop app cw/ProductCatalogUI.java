

import java.util.Scanner;

public class ProductCatalogUI {
    public static void main(String[] args) {
        ProductCatalog catalog = new ProductCatalog();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Product\n2. List Products\n3. Update Product\n4. Delete Product\n5. Search Product by Name\n6. Exit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter product ID, name, category, price, and quantity:");
                    Product newProduct = new Product(scanner.nextInt(), scanner.next(), scanner.next(), scanner.nextDouble(), scanner.nextInt());
                    catalog.addProduct(newProduct);
                    break;
                case 2:
                    catalog.listProducts();
                    break;
                case 3:
                    System.out.println("Enter product ID, new name, new price, and new quantity:");
                    catalog.updateProduct(scanner.nextInt(), scanner.next(), scanner.nextDouble(), scanner.nextInt());
                    break;
                case case 5:
                System.out.println("Enter product name to search:");
                catalog.searchByName(scanner.next());
                break;4:
                    System.out.println("Enter product ID to delete:");
                    catalog.deleteProduct(scanner.nextInt());
                    break;
                case 5:
                    System.exit(0);
            }
            
        }
        scanner.close();
    }
}

