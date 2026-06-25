class Order {
    int orderId;
    String orderDate;

    Order(int orderId, String orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
    }

    String getOrderStatus() {
        return "Order Placed";
    }
}

class ShippedOrder extends Order {
    String trackingNumber;

    ShippedOrder(int orderId,
                 String orderDate,
                 String trackingNumber) {

        super(orderId, orderDate);
        this.trackingNumber = trackingNumber;
    }

    String getOrderStatus() {
        return "Order Shipped";
    }
}

class DeliveredOrder extends ShippedOrder {
    String deliveryDate;

    DeliveredOrder(int orderId,
                   String orderDate,
                   String trackingNumber,
                   String deliveryDate) {

        super(orderId, orderDate, trackingNumber);
        this.deliveryDate = deliveryDate;
    }

    String getOrderStatus() {
        return "Order Delivered";
    }
}

public class OnlineRetailOrderManagement {
    public static void main(String[] args) {

        DeliveredOrder order =
                new DeliveredOrder(
                        1001,
                        "25-06-2026",
                        "TRK123",
                        "28-06-2026");

        System.out.println(order.getOrderStatus());
    }
}