package entity;

public class MyBook {
    int isbn;
    String title;
    String author;
    String publisher;
    int year;
    int totalPages;
    int currentPages = 0;
    boolean isArchived = false;

    public MyBook(int isbn, String title, String author, String publisher, int year, int totalPages1) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.year = year;
        this.totalPages = totalPages1;
    }
    
     public MyBook(int isbn, String title, boolean status) {
        this.isbn = isbn;
        this.title = title;
        isArchived = status;
    }
    
    public MyBook(){
        this.isbn = 1;
        this.title = "a";
        this.author = "b";
        this.publisher = "c";
        this.year = 2;
        this.totalPages = 3;
    }
    
    public int getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getYear() {
        return year;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public int getCurrentPages() {
        return currentPages;
    }

    public void setCurrentPages(int currentPages) {
        this.currentPages = currentPages;
    }

    public boolean isArchived() {
        return isArchived;
    }

    public void setArchived(boolean archived) {
        isArchived = archived;
    }
    
   
}
