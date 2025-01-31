package service;

import javax.swing.JTable;

public interface MyBookService {
        public void showMyBook(String keywords, String cbxStatus);
        public void addMyBook(int isbn, String title, String author, String publisher, int year, int totalPages);       
        void setTableMyBook (JTable tblMyBook);     
        void setTableArchive(JTable tblArcive);       
        void loadData(String keywords, String cbxStat);       
        void loadDataArchive(String keywords, String cbxStatus);       
        void tableHandling();
        void tableArchivedHandling();      
        void removeMyBook(int isbn);        
        void changeMyBook(int ISBN, String title, boolean status);
        public void showMyBookWithoutArchived();
        public void showArchive(String keywords, String cbxStatus);
   
}
