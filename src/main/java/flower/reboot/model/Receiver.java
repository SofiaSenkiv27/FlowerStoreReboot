package flower.reboot.model;

public class Receiver implements User {
    @Override
    public void update(String status) {
        System.out.println("Receiver received update: " + status);
    }
}
