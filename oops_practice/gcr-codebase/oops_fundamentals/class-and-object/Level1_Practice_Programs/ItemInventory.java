class Item {

    int itemCode;
    String itemName;
    double price;

    Item(int itemCode, String itemName, double price) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.price = price;
    }

    double totalCost(int quantity) {
        return price * quantity;
    }

    void display(int quantity) {
        System.out.println("Item: " + itemName +
                " | Code: " + itemCode +
                " | Price: " + price +
                " | Quantity: " + quantity +
                " | Total Cost: " + totalCost(quantity));
    }
}

public class ItemInventory {

    public static void main(String[] args) {

        Item i1 = new Item(1, "Pen", 10);
        i1.display(5);
    }
}