package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.media.Media;

import java.util.ArrayList;
import java.util.List;

public class Store {
    private List<Media> itemsInStore = new ArrayList<>();

    public Store() {

    }
    
    public void addMedia(Media media) {
        if (this.itemsInStore.contains(media)){

        }else {
            this.itemsInStore.add(media);
            System.out.println("Added item into the store successfully");
        }
    }

    public void removeMedia(Media media) {
        if (this.itemsInStore.contains(media)){
            this.itemsInStore.remove(media);
            System.out.println("Removed item from the store successfully");
        } else {
            System.out.println("Item not found");
        }
    }

}
