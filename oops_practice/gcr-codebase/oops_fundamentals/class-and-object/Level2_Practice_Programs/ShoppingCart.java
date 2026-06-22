class CartItem {

    String itemName;
    double price;
    int quantity;

    void addItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    void removeItem() {
        this.quantity = 0;
    }

    double totalCost() {
        return price * quantity;
    }

    void display() {
        System.out.println("Item: " + itemName +
                " | Quantity: " + quantity +
                " | Total Cost: " + totalCost());
    }
}

public class ShoppingCart {

    public static void main(String[] args) {

        CartItem c = new CartItem();

        c.addItem("Laptop", 50000, 1);
        c.display();

        c.removeItem();
        c.display();
    }
}