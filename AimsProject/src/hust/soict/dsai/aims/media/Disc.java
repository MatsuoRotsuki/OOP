package hust.soict.dsai.aims.media;

public class Disc extends Media {
    protected int length;
    protected String director;

    public int getLength() {
        return length;
    }

    public String getDirector() {
        return director;
    }

    public Disc(){
    }

    public Disc(int length, String director) {
        this.length = length;
        this.director = director;
    }
}
