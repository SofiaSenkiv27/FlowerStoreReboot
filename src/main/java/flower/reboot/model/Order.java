package flower.reboot.model;

import java.util.ArrayList;
import java.util.List;

import flower.reboot.delivery.Delivery;
import flower.reboot.payment.Payment;

public class Order {
    private List<Item> items;
    private Payment paymentStrategy;
    private Delivery deliveryStrategy;
    private List<User> users = new ArrayList<>(); 

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

    public void addUser(User user) {
        users.add(user);
    }

    public void removeUser(User user) {
        users.remove(user);
    }

    private void notifyUsers(String status) {
        for (User user : users) {
            user.update(status);
        }
    }

    public boolean processOrder() {
        boolean delivered = deliveryStrategy.deliver(items);
        boolean paid = paymentStrategy.pay(calculateTotalPrice());
        
        if (delivered && paid) {
            notifyUsers("Order processed successfully.");
            return true;
        } else {
            notifyUsers("Order processing failed.");
            return false;
        }
    }
}
