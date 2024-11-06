package flower.reboot.delivery;

import java.util.List;

import flower.reboot.model.Item;

public interface Delivery {
    boolean deliver(List<Item> items);
}