package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private List<Media> itemsOrdered = new ArrayList<>();
    public void addMedia(Media media){
        if (this.itemsOrdered.size() >= MAX_NUMBERS_ORDERED){
            System.out.println("The cart is almost full");
        } else {
            System.out.println("Add disc into the cart successfully");
            this.itemsOrdered.add(media);
        }
    }

    public void addMedia(Media[] mediaList){
        if (itemsOrdered.size() + mediaList.length >= MAX_NUMBERS_ORDERED){
            System.out.println("Cannot add because there's no space");
        } else {
            for (Media media : mediaList){
                this.addMedia(media);
            }
        }
    }

    public void addDigitalVideoDisc(Media media1, Media media2) {
        if (itemsOrdered.size() <= MAX_NUMBERS_ORDERED - 2) {
            System.out.println("Cannot add because there's no space");
        } else {
            this.addMedia(media1);
            this.addMedia(media2);
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
        for (Media media : itemsOrdered){
            sum += media.getCost();
        }
        return sum;
    }

    public void printCart() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        for (Media media : itemsOrdered) {
            System.out.println(media.toString());
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
