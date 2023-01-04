package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;

import java.util.*;

public class CompactDisc extends Disc implements Playable {

    private static int nbCompactDiscs = 0;
    private String artist;
    private List<Track> tracks = new ArrayList<>();

    @Override
    public int getLength(){
       int sumLength = 0;
       for (Track track : tracks){
           sumLength += track.getLength();
       }
       return sumLength;
    }

    public String getArtist() {
        return artist;
    }

    public void addTrack(Track track){
        if (tracks.contains(track)){
            System.out.println("This track is already in");
        } else {
            tracks.add(track);
            System.out.println("Track added successfully");
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

    public void play() throws PlayerException {
        if(this.getLength() > 0){
            java.util.Iterator iter = tracks.iterator();
            Track nextTrack;
            while(iter.hasNext()){
                nextTrack = (Track) iter.next();
                try {
                    nextTrack.play();
                } catch (PlayerException e){
                    throw e;
                }
            }
        } else {
            throw new PlayerException("ERROR: CD length is non-positive!");
        }
    }

    public CompactDisc(){
        this.id = ++nbCompactDiscs;
    }

    public CompactDisc(String title){
        super();
        this.id = ++nbCompactDiscs;
        this.title = title;
    }

    public CompactDisc(String title, String director, String artist) {
        super(director);
        this.id = ++nbCompactDiscs;
        this.title = title;
        this.artist = artist;
    }

    public CompactDisc(String title, String category, float cost, String director, String artist)
    {
        super(title, category,cost, director);
        this.artist = artist;
    }

    @Override
    public String toString() {
        return "CompactDisc{" +
                "artist='" + artist + '\'' +
                ", tracks=" + tracks +
                ", length=" + length +
                ", director='" + director + '\'' +
                ", title='" + title + '\'' +
                ", category='" + category + '\'' +
                ", cost=" + cost +
                '}';
    }
}
