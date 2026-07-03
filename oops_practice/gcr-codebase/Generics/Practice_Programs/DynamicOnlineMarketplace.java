import java.util.ArrayList;

public class DynamicOnlineMarketplace {

    public static void main(String[] args) {

        ArrayList<Product<? extends Category>> catalog = new ArrayList<>();

        Product<BookCategory> book =
                new Product<>("Java Programming", 800, new BookCategory());

        Product<ClothingCategory> cloth =
                new Product<>("T-Shirt", 1200, new ClothingCategory());

        Product<GadgetCategory> gadget =
                new Product<>("Smart Watch", 5000, new GadgetCategory());

        catalog.add(book);
        catalog.add(cloth);
        catalog.add(gadget);

        applyDiscount(book, 10);
        applyDiscount(cloth, 20);
        applyDiscount(gadget, 15);

        System.out.println("Product Catalog:");

        for (Product<? extends Category> product : catalog) {
            System.out.println(product);
        }
    }

    public static <T extends Category> void applyDiscount(Product<T> product, double percentage) {

        double discount = product.getPrice() * percentage / 100;

        product.setPrice(product.getPrice() - discount);
    }
}

abstract class Category {

    public String getCategoryName() {
        return getClass().getSimpleName();
    }
}

class BookCategory extends Category {
}

class ClothingCategory extends Category {
}

class GadgetCategory extends Category {
}

class Product<T extends Category> {

    private String name;
    private double price;
    private T category;

    public Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String toString() {
        return name + " | " + category.getCategoryName() + " | ₹" + price;
    }
}