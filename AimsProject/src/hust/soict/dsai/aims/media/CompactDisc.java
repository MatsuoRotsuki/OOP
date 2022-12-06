package hust.soict.dsai.aims.media;

import java.util.*;

public class CompactDisc extends Disc implements Playable{
    private String artist;
    List<Track> tracks = new ArrayList<>();

    public String getArtist() {
        return artist;
    }

    public void addTrack(Track track){
        if (tracks.contains(track)){
            System.out.println("This tracks is already in");
        } else {
            tracks.add(track);
            System.out.println("Added track successfully");
        }
    }

    public void removeTrack(Track track){
        if (tracks.contains(track)){
            tracks.remove(track);
            System.out.println("Removed track successfully");
        } else {
            System.out.println("Track not found");
        }
    }

    public void play(){
        tracks.forEach((track -> {track.play();}));
    }

    public int getLength(){
        int sum = 0;
        for (Track track: tracks){
            sum += track.getLength();
        }
        return sum;
    }
}
