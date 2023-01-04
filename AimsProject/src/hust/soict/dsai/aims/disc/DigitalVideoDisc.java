package hust.soict.dsai.aims.disc;

import hust.soict.dsai.aims.exception.PlayerException;
import hust.soict.dsai.aims.media.Disc;
import hust.soict.dsai.aims.media.Playable;

import javax.swing.*;
import java.awt.*;

public class DigitalVideoDisc extends Disc implements Playable {
    private static int nbDigitalVideoDiscs = 0;

    public DigitalVideoDisc(String title) {
        super();
        nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs;
        this.title = title;
    }

    public DigitalVideoDisc(String title, String category, float cost) {
        nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    public DigitalVideoDisc(String title, String category, float cost, String director) {
        super(director);
        nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(director);
        nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs;
        this.length = length;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "DigitalVideoDisc{" +
                "length=" + length +
                ", director='" + director + '\'' +
                ", title='" + title + '\'' +
                ", category='" + category + '\'' +
                ", cost=" + cost +
                '}';
    }

    public void play() throws PlayerException{
        if(this.getLength() > 0){
            System.out.println("Playing DVD: " + this.getTitle());
            System.out.println("DVD length: " + this.getLength());
            Frame f = new Frame();
            f.setSize(400,200);
            JDialog d = new JDialog(f, "Playing disc...");
            d.setLayout(new FlowLayout());
            d.add(new JLabel("<html>Playing DVD: " + this.getTitle()+"<br/>DVD Length: " + this.getLength() + "<html>"));
            d.setSize(400,200);
            d.setVisible(true);
        }
        else {
            throw new PlayerException("ERROR: DVD length is non-positive!");
        }
    }
}
