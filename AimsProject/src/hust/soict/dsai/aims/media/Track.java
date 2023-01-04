package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

import javax.swing.*;
import java.awt.*;

public class Track implements Playable {
    private String title;
    private int length;

    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    public Track(String title, int length){
        this.title = title;
        this.length = length;
    }

    public Track(){
    }

    @Override
    public void play() throws PlayerException {
        if(this.getLength() > 0){
            System.out.println("Playing DVD: " + this.getTitle());
            System.out.println("DVD length: " + this.getLength());
            Frame f = new Frame();
            f.setSize(400, 200);
            JDialog d = new JDialog(f, "Playing disc...");
            d.setLayout(new FlowLayout());
            d.add(new JLabel("<html>Playing DVD: " + this.getTitle()+"<br/>DVD Length: " + this.getLength() + "<html>"));
            d.setSize(400, 200);
            d.setVisible(true);
        }
        else {
            throw new PlayerException("ERROR: DVD length is non-positive!");
        }
    }

    @Override
    public boolean equals(Object obj) {
        return this.title.equals(((Track)obj).getTitle()) && this.length == ((Track)obj).getLength();
    }
}
