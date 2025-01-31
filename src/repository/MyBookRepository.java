package repository;

import entity.MyBook;

import java.util.ArrayList;

public interface MyBookRepository {
    
    public ArrayList<MyBook> getAll(String keywords, String status);
    public ArrayList<MyBook> getWithoutArchived();
    public ArrayList<MyBook> getOnlyArchived();
    boolean add(MyBook myBook);
    boolean remove(int isbn);
    boolean change(int myBookISBN, MyBook myBook);
    boolean updateArchived(int isbn, boolean isArchived);
    MyBook getMyBookbyISBN(int ISBN);
}