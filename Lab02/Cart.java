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

    public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList){
        if (itemsOrdered.size() + dvdList.length >= MAX_NUMBERS_ORDERED){
            System.out.println("Cannot add because there's no space");
        } else {
            for (DigitalVideoDisc disc : dvdList){
                this.addDigitalVideoDisc(disc);
            }
        }
    }

    public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        if (itemsOrdered.size() <= MAX_NUMBERS_ORDERED - 2) {
            System.out.println("Cannot add because there's no space");
        } else {
            this.addDigitalVideoDisc(dvd1);
            this.addDigitalVideoDisc(dvd2);
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

    public void printCart() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        for (DigitalVideoDisc disc : itemsOrdered) {
            System.out.println(disc.toString());
        }
        System.out.println("Total cost: " + this.totalCost());
        System.out.println("***************************************************");
    }

    public void searchCart(int id) {
        List<DigitalVideoDisc> result = new ArrayList<DigitalVideoDisc>();

        for (DigitalVideoDisc disc : this.itemsOrdered) {
            if (disc.isMatch(id)) {
                result.add(disc);
            }
        }
        if (result.size() > 0) {
            System.out.println("Search results:");
            for (DigitalVideoDisc disc: result) {
                System.out.println(disc.toString());
            }
            System.out.println();
        } else {
            System.out.println("Item not found.");
        }
    }

    public void searchCart(String title) {
        List<DigitalVideoDisc> result = new ArrayList<DigitalVideoDisc>();

        for (DigitalVideoDisc disc : this.itemsOrdered) {
            if (disc.isMatch(title)) {
                result.add(disc);
            }
        }
        if (result.size() > 0) {
            System.out.println("Search results:");
            for (DigitalVideoDisc disc: result) {
                System.out.println(disc.toString());
            }
            System.out.println();
        } else {
            System.out.println("Item not found.");
        }
    }
}
