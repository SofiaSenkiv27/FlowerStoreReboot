package flower.reboot.delivery;

import java.util.List;

import flower.reboot.model.Item;

public class PostDeliveryStrategy implements Delivery {
    @Override
    public boolean deliver(List<Item> items) {
        System.out.println("Delivering items by Post.");
        return true;
    }
}