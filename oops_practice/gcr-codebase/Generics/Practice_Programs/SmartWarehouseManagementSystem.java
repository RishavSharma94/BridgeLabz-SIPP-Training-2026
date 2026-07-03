import java.util.ArrayList;
import java.util.List;

public class SmartWarehouseManagementSystem {

    public static void main(String[] args) {

        Storage<Electronics> electronicsStorage = new Storage<>();
        electronicsStorage.addItem(new Electronics("Laptop"));
        electronicsStorage.addItem(new Electronics("Mobile"));

        Storage<Groceries> groceryStorage = new Storage<>();
        groceryStorage.addItem(new Groceries("Rice"));
        groceryStorage.addItem(new Groceries("Sugar"));

        Storage<Furniture> furnitureStorage = new Storage<>();
        furnitureStorage.addItem(new Furniture("Chair"));
        furnitureStorage.addItem(new Furniture("Table"));

        displayItems(electronicsStorage.getItems());
        displayItems(groceryStorage.getItems());
        displayItems(furnitureStorage.getItems());
    }

    public static void displayItems(List<? extends WarehouseItem> items) {

        for (WarehouseItem item : items) {
            System.out.println(item);
        }

        System.out.println();
    }
}

abstract class WarehouseItem {

    String name;

    public WarehouseItem(String name) {
        this.name = name;
    }

    public String toString() {
        return getClass().getSimpleName() + " : " + name;
    }
}

class Electronics extends WarehouseItem {

    public Electronics(String name) {
        super(name);
    }
}

class Groceries extends WarehouseItem {

    public Groceries(String name) {
        super(name);
    }
}

class Furniture extends WarehouseItem {

    public Furniture(String name) {
        super(name);
    }
}

class Storage<T extends WarehouseItem> {

    private List<T> items = new ArrayList<>();

    public void addItem(T item) {
        items.add(item);
    }

    public List<T> getItems() {
        return items;
    }
}