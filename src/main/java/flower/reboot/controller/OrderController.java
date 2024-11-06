package flower.reboot.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import flower.reboot.delivery.DHLDeliveryStrategy;
import flower.reboot.model.Item;
import flower.reboot.model.Order;
import flower.reboot.payment.CreditCardPaymentStrategy;

import java.util.List;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {

    @PostMapping("/create")
    public String createOrder(@RequestBody List<Item> items) {
        Order order = new Order(items);
        order.setDeliveryStrategy(new DHLDeliveryStrategy());
        order.setPaymentStrategy(new CreditCardPaymentStrategy());

        return order.processOrder() ? "Order processed successfully" :
         "Order processing failed";
    }
}