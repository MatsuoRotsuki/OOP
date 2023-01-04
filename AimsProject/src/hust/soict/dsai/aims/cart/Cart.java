package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;

import javax.naming.LimitExceededException;
import java.util.*;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();
    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();

    public ObservableList<Media> getItemsOrdered() {
        return itemsOrdered;
    }

    public void addMedia(Media media) throws LimitExceededException {
        if (this.itemsOrdered.size() >= MAX_NUMBERS_ORDERED){
            throw new LimitExceededException("ERROR: The number of media has reached its limit");
        } else {
            System.out.println("Add disc into the cart successfully");
            this.itemsOrdered.add(media);
        }
    }

    public void addMedia(Media ...mediaList) throws LimitExceededException{
        if (itemsOrdered.size() + mediaList.length >= MAX_NUMBERS_ORDERED){
            throw new LimitExceededException("ERROR: Cannot add because there's no space");
        } else {
            try {
                for (Media media : mediaList){
                    this.addMedia(media);
                }
            } catch(LimitExceededException e){
                throw e;
            }
        }
    }

    public void addMedia(Media media1, Media media2) throws LimitExceededException {
        if (itemsOrdered.size() >= MAX_NUMBERS_ORDERED - 2) {
            throw new LimitExceededException("ERROR: Cannot add because there's no space");
        } else {
            try{
                this.addMedia(media1);
                this.addMedia(media2);
            } catch (LimitExceededException e){
                throw e;
            }
        }
    }

    public void removeMedia(Media media){
        if (this.itemsOrdered.contains(media)){
            this.itemsOrdered.remove(media);
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

    public FilteredList<Media> searchCart(int id) {

        FilteredList<Media> result = new FilteredList<>(this.itemsOrdered, media -> {return media.isMatch(id);});
//        for (Media media : this.itemsOrdered) {
//            if (media.isMatch(id)) {
//                result.add(media);
//            }
//        }
        return result;
    }

    public FilteredList<Media> searchCart(String title) {
        FilteredList<Media> result = new FilteredList<>(this.itemsOrdered, media -> {return media.isMatch(title);});

//        for (Media media : this.itemsOrdered) {
//            if (media.isMatch(title)) {
//                result.add(media);
//            }
//        }
        return result;
    }

    public void sortByTitleCost() {
        Collections.sort(this.itemsOrdered, COMPARE_BY_TITLE_COST);
    }

    public void sortByCostTitle() {
        Collections.sort(this.itemsOrdered, COMPARE_BY_COST_TITLE);
    }

    public int getNumberOfItemsOrder(){
        return this.itemsOrdered.size();
    }

    public Media getMedia(String title){
        for (Media media : this.itemsOrdered){
            if (media.isMatch(title)){
                return media;
            }
        }
        return null;
    }

    public Media getMedia(int id){
        for (Media media : this.itemsOrdered){
            if (media.isMatch(id)){
                return media;
            }
        }
        return null;
    }

    public void emptyCart(){
        this.itemsOrdered.clear();
    }
}
