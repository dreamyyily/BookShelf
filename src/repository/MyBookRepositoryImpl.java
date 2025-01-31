package repository;

import java.util.ArrayList;
import entity.MyBook;
import java.sql.ResultSet;
import java.sql.SQLException;
import util.DB;

public class MyBookRepositoryImpl implements MyBookRepository {
    
    private final DB db;
    
    public MyBookRepositoryImpl() {
        db = new DB();
    }

    @Override
    public ArrayList<MyBook> getAll(String keywords, String status) {
        String query = "SELECT * FROM myBook";
        ResultSet resultSet = db.getAllData(query, keywords);
        ArrayList<MyBook> model = new ArrayList<>();
        
        if(resultSet != null) {
            try {
                while(resultSet.next()) {
                    int myBookISBN = resultSet.getInt("ISBN");
                    String title = resultSet.getString("title");
                    String author = resultSet.getString("author");
                    String publisher = resultSet.getString("publisher");
                    int year = resultSet.getInt("year");
                    int totalPages = resultSet.getInt("totalPages");
                    String infoStatus = resultSet.getString("STATUS");
                    boolean stat = false;
                    if (infoStatus.equalsIgnoreCase("Archive")) {
                        stat = true;
                    }

                    MyBook myBook = new MyBook(myBookISBN, title, author, publisher, year, totalPages);
                    myBook.setArchived(stat);
                    if (status.equalsIgnoreCase("") || status.equalsIgnoreCase("Semua")) {
                        model.add(myBook);
                    } else if (infoStatus.equalsIgnoreCase(status)) {
                        model.add(myBook);
                    }   
                }
            } catch (SQLException ex) {
                // Terjadi kesalahan pada JDBC
            }
        }
        return model;
    }
            
    @Override
    public MyBook getMyBookbyISBN(int ISBN) {
        MyBook myBook = null;
        String query = "SELECT * FROM myBook WHERE ISBN = ?";
        String[] values = new String[]{String.valueOf(ISBN)};
        ResultSet resultSet = db.get(query, values);
         if(resultSet != null) {
            try {
                while (resultSet.next()) {
                    
                    myBook = new MyBook(resultSet.getInt("ISBN"), resultSet.getString("author"), resultSet.getString("title"), resultSet.getString("publisher"), resultSet.getInt("year"), resultSet.getInt("currentPages"));

                    break;
                }
            } catch (Exception e) {
                //Terjadi kesalahan pada JDBC
            }
        }
        return myBook;
    }

    @Override
    public boolean add(MyBook myBook) {
        String query = "INSERT INTO myBook (isbn, title, author, publisher, year, totalPages, STATUS) VALUES (?,?, ?, ?, ?, ?, ?)";
        String[] values = new String[]{String.valueOf(myBook.getIsbn()), myBook.getTitle(), myBook.getAuthor(),myBook.getPublisher(), String.valueOf(myBook.getYear()), String.valueOf(myBook.getTotalPages()), String.valueOf(myBook.isArchived())};
        return db.update(query, values);
    }

    @Override
    public boolean remove(int isbn) {
        String query = "DELETE FROM myBook WHERE ISBN = ?";
        String[] values = new String[] {String.valueOf(isbn)};
        return db.update(query, values);
        
    }
    
    @Override
    public boolean change(int myBookISBN, MyBook myBook) {
        String query = "UPDATE myBook SET title = ?, status = ? WHERE isbn= ?";
        String archiveStatus = "Not Archive";
      if (myBook.isArchived()) {
            archiveStatus = "Archive";
        }
        String[] values = new String[]{myBook.getTitle(), archiveStatus, String.valueOf(myBookISBN)};
            return db.update(query, values);
    }

    @Override
    public ArrayList<MyBook> getWithoutArchived() {
        ArrayList<MyBook> save = new ArrayList<>();
        return save;
    }

    @Override
    public ArrayList<MyBook> getOnlyArchived() {
        ArrayList<MyBook> save = new ArrayList<>();
        return save;
    }
    
    @Override
    public boolean updateArchived(int isbn, boolean isArchived) {

        return false;
    }

}
