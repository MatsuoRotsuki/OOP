package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

import java.util.ArrayList;
import java.util.List;

public class Store {
    private List<Media> itemsInStore = new ArrayList<>();

    public Store() {

    }
    
    public void addMedia(Media media) {
        this.itemsInStore.add(media);
        System.out.println("Added item into the store successfully");
    }

    public void removeMedia(Media media) {
        this.itemsInStore.remove(media);
        System.out.println("Removed item from the store successfully");
    }
}
