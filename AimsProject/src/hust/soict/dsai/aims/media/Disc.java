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

    public Disc(String title, String category, float cost, int length, String director){
        super(title, category, cost);
        this.director = director;
        this.length = length;
    }

    public Disc(String title, String category, float cost, String director){
        super(title, category, cost);
        this.director = director;
    }

    public Disc(String director) {
        this.director = director;
    }
}
