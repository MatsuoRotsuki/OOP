package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.store.Store;
import javafx.collections.ListChangeListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class StoreScreen extends AimsScreen {

    @Override
    JPanel createCenter(){
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3,3,2,2));

        List<Media> mediaInStore = store.getItemsInStore();
        for(int i = 0; i < store.getItemsInStore().size(); i++){
            MediaStore cell = new MediaStore(mediaInStore.get(i), this.cart);
            center.add(cell);
        }

        return center;
    }

    public StoreScreen(Store store, Cart cart){
        super(store, cart);
        setCurrentScreen(this);
        setStoreScreen(this);
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setVisible(true);
        setTitle("Store");
        setSize(1024, 768);

        store.getItemsInStore().addListener(
                new ListChangeListener<Media>() {
                    @Override
                    public void onChanged(Change<? extends Media> change) {
                        BorderLayout layout = (BorderLayout)cp.getLayout();
                        cp.remove(layout.getLayoutComponent(BorderLayout.CENTER));
                        cp.add(createCenter(),BorderLayout.CENTER);
                        cp.repaint();
                        cp.revalidate();
                    }
                }
        );
    }
}
