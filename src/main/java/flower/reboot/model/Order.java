package flower.reboot.model;

import java.util.List;

import flower.reboot.delivery.Delivery;
import flower.reboot.payment.Payment;

public class Order {
    private List<Item> items;
    private Payment paymentStrategy;
    private Delivery deliveryStrategy;

    public Order(List<Item> items) {
        this.items = items;
    }

    public double calculateTotalPrice() {
        return items.stream().mapToDouble(Item::getPrice).sum();
    }

    public void setPaymentStrategy(Payment payment) {
        this.paymentStrategy = payment;
    }
    
    public void setDeliveryStrategy(Delivery delivery) {
        this.deliveryStrategy = delivery;
    }    

    public boolean processOrder() {
        if (deliveryStrategy.deliver(items) 
        && paymentStrategy.pay(calculateTotalPrice())) {
            return true;
        }
        return false;
    }
}