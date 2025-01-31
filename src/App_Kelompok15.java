
import com.formdev.flatlaf.FlatIntelliJLaf;
import javax.swing.UIManager;
import repository.MyBookRepository;
import repository.MyBookRepositoryImpl;
import service.MyBookService;
import service.MyBookServiceImpl;
import ui.AddMyBook;
import ui.AppFrame;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

public class App_Kelompok15 {

     public static void main(String[] args) {
        MyBookRepository myBookRepository = new MyBookRepositoryImpl();
        MyBookService myBookService = new MyBookServiceImpl(myBookRepository);
        AddMyBook addMyBook = new AddMyBook();

        try {
            UIManager.setLookAndFeel(new FlatIntelliJLaf());
        } catch (Exception ex) {
            System.out.println("Gagal mengubah desain tampilan");
        }
        AppFrame app = new AppFrame();
        app.setMyBookService(myBookService);
        app.setVisible(true);        
    }   
}
