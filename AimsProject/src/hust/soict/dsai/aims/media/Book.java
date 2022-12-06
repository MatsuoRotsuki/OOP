package hust.soict.dsai.aims.media;

import java.util.*;

public class Book extends Media{
    private List<String> authors = new ArrayList<>();

    public Book(){
    }

    public Book(int id, String title, String category, float cost){
        super(id, title, category, cost);
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public void addAuthor(String authorName){
        if (this.authors.contains(authorName)){
            System.out.println("This author is already in");
            return;
        }
        this.authors.add(authorName);
        System.out.println("Added author successfully");
    }

    public void removeAuthor(String authorName){
        if (this.authors.contains(authorName)){
            System.out.println("Removed author successfully");
            this.authors.remove(authorName);
        } else {
            System.out.println("The author is not present");
        }
    }
}
