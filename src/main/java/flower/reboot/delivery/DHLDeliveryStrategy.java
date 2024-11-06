package flower.reboot.delivery;

import java.util.List;

import flower.reboot.model.Item;

public class DHLDeliveryStrategy implements Delivery {
    @Override
    public boolean deliver(List<Item> items) {
        System.out.println("Delivering items by DHL.");
        return true;
    }
}