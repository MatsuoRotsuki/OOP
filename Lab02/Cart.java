package Lab02;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private List<DigitalVideoDisc> itemsOrdered = new ArrayList<>();
    public void addDigitalVideoDisc(DigitalVideoDisc disc){
        if (this.itemsOrdered.size() >= MAX_NUMBERS_ORDERED){
            System.out.println("The cart is almost full");
        } else {
            System.out.println("Add disc into the cart successfully");
            this.itemsOrdered.add(disc);
        }
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc disc){
        int index = this.itemsOrdered.indexOf(disc);
        if (index >= 0){
            this.itemsOrdered.remove(disc);
            System.out.println("Item removed successfully");
        } else {
            System.out.println("Item not found");
        }
    }

    public float totalCost(){
        float sum = 0;
        for (DigitalVideoDisc disc : itemsOrdered){
            sum += disc.getCost();
        }
        return sum;
    }
}
