import java.util.ArrayList;
import java.util.List;

public class ProductInventoryUpdater {

    public static void main(String[] args) {

        List<Product> products = new ArrayList<>();

        addProducts(products);

        System.out.println("Product List:");

        for (Product product : products) {
            System.out.println(product);
        }
    }

    public static void addProducts(List<? super Product> list) {

        list.add(new Product(1, "Laptop"));
        list.add(new Product(2, "Mobile"));
        list.add(new Product(3, "Keyboard"));
    }
}

class Product {

    int id;
    String name;

    public Product(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "ID: " + id + " Name: " + name;
    }
}