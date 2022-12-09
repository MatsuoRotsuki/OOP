package hust.soict.dsai.aims;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;

import java.util.Scanner;

public class Aims {

    public static Scanner input = new Scanner(System.in);

    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
        int command = input.nextInt();
        if (command == 0){
            return;
        } else if(command == 1){

        } else if(command == 2){

        } else if(command == 3){

        } else if(command == 4){

        }
    }


    public static void storeMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media’s details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");
        int command = input.nextInt();
        if (command == 0){
            return;
        } else if(command == 1){

        } else if(command == 2){

        } else if(command == 3){

        } else if(command == 4){

        }
    }

    public static void mediaDetailsMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
        int command = input.nextInt();
        if (command == 0){
            return;
        } else if(command == 1){

        } else if(command == 2) {

        }
    }

    public static void cartMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");
        int command = input.nextInt();
        if (command == 0){
            return;
        } else if(command == 1){

        } else if(command == 2){

        } else if(command == 3){

        } else if(command == 4){

        } else if(command == 5){

        }
    }
    public static void main(String[] args) {
        Cart anOrder = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc(
                "The Lion King",
                "Animation",
                "Roger Alllers",
                87,
                19.95f
        );
        anOrder.addMedia(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc(
                "Star Wars",
                "Science Fiction",
                "George Lucas",
                87,
                24.95f
        );
        anOrder.addMedia(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc(
                "Aladin",
                "Animation",
                18.99f
        );
        anOrder.addMedia(dvd3);

        Book book = new Book(
                "Sun Tzu: Art of War",
                "Strategy",
                14.95f
        );

        CompactDisc cd = new CompactDisc(
                50,
                "Loc",
                "Loc"
        );

        anOrder.addMedia(book);
        anOrder.addMedia(cd);
        anOrder.sortByCostTitle();

        System.out.println("Total Cost is: ");
        System.out.println(anOrder.totalCost());

        anOrder.printCart();
    }
}
