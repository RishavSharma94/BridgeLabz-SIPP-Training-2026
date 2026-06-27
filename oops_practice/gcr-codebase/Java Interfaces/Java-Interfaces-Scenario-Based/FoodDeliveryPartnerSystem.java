public class FoodDeliveryPartnerSystem {

    public static void main(String[] args) {

        String[] customers = {
                "Rishav",
                "Aman",
                "Rahul",
                "Kunal"
        };

        DeliveryExecutive executive = new DeliveryExecutive();

        executive.trackOrder();

        System.out.println();

        for (String customer : customers) {

            String deliveryCode = FoodDelivery.generateDeliveryCode();

            System.out.println("Customer: " + customer);
            executive.deliverFood(customer);
            executive.deliverGroceries(customer);
            System.out.println("Delivery Code: " + deliveryCode);
            System.out.println();
        }
    }
}

interface FoodDelivery {

    void deliverFood(String customer);

    default void trackOrder() {
        System.out.println("Tracking Food Delivery...");
    }

    static String generateDeliveryCode() {
        return "FD" + (int)(Math.random() * 9000 + 1000);
    }
}

interface GroceryDelivery {

    void deliverGroceries(String customer);

    default void trackOrder() {
        System.out.println("Tracking Grocery Delivery...");
    }
}

class DeliveryExecutive implements FoodDelivery, GroceryDelivery {

    @Override
    public void deliverFood(String customer) {
        System.out.println("Food delivered to " + customer);
    }

    @Override
    public void deliverGroceries(String customer) {
        System.out.println("Groceries delivered to " + customer);
    }

    @Override
    public void trackOrder() {

        FoodDelivery.super.trackOrder();
        GroceryDelivery.super.trackOrder();

        System.out.println("All deliveries are being tracked.");
    }
}