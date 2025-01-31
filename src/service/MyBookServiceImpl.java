package service;

import entity.MyBook;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import repository.MyBookRepository;
import java.util.ArrayList;
import java.util.EventObject;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import util.ButtonEditor;

public class MyBookServiceImpl implements MyBookService {

    private MyBookRepository myBookRepository;
    private JTable tblMyBook;
    private JTable tblArchive;

    public MyBookServiceImpl(MyBookRepository myBookRepository) {
        this.myBookRepository = myBookRepository;
    }

    @Override
    public void setTableMyBook(JTable tblMyBook) {
        this.tblMyBook = tblMyBook;
        showMyBook("", "");
    }

    @Override
    public void setTableArchive(JTable tblArchive) {
        this.tblArchive = tblArchive;
        showArchive("", "Archive");
    }

    @Override
    public void tableHandling() {

        try {
            JTable tblTodo = this.tblMyBook;
            tblTodo.getColumnModel().getColumn(0).setCellEditor(new DefaultCellEditor(new JTextField()) {
                @Override
                public boolean isCellEditable(EventObject anEvent) {
                    return false;
                }
            });

            tblTodo.getColumnModel().getColumn(2).setCellEditor(new DefaultCellEditor(new JTextField()) {
                @Override
                public boolean isCellEditable(EventObject anEvent) {
                    return false;
                }
            });

            {
                // Membuat JComboBox untuk memilih antara Archive dan Not Archive
                JComboBox<String> cbxStatus = new JComboBox<>();
                cbxStatus.addItem("Archive");
                cbxStatus.addItem("Not Archive");

                // Menambahkan JComboBox ke kolom " " di posisi ke-6
                tblTodo.getColumnModel().getColumn(6).setCellEditor(new DefaultCellEditor(cbxStatus));

                cbxStatus.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int row = tblTodo.getSelectedRow();
                        int column = tblTodo.getSelectedColumn();
                        if (row >= 0 && column == 6) {
                            JComboBox<String> combo = (JComboBox<String>) e.getSource();
                            String selectedValue = (String) combo.getSelectedItem();
                            tblTodo.setValueAt(selectedValue, row, column);
                            changeMyBook((Integer) tblTodo.getValueAt(row, 0), tblTodo.getValueAt(row, 1).toString(), selectedValue.equals("Archive"));
                            showMyBook("", "");
                        }
                    }
                });

                // Membuat Button untuk kolom di JTable
                {
                    // Membuat Button Editor untuk ditambahkan ke kolom JTabel
                    ButtonEditor btnDeleteEditor = new ButtonEditor(new JCheckBox());
                    // Menambahkan ActionListener ke Button yang ada di Button Editor
                    btnDeleteEditor.button.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            int row = tblTodo.getSelectedRow();
                            int column = tblTodo.getSelectedColumn();
                            DefaultTableModel model = (DefaultTableModel) tblTodo.getModel();

                            if (row >= 0 && column == 7) {
                                int myBookISBN = (int) model.getValueAt(row, 0);
                                removeMyBook(myBookISBN);
                                model.removeRow(row);
                            }
                        }
                    });
                    // Menambahkan Button Editor ke JTable
                    tblTodo.getColumnModel().getColumn(7).setCellRenderer(new util.ButtonRenderer());
                    tblTodo.getColumnModel().getColumn(7).setCellEditor(btnDeleteEditor);
                }

                // Menambahkan CellEditorListener untuk menangkap perubahan pada kolom di JTable
                tblTodo.getDefaultEditor(String.class).addCellEditorListener(new CellEditorListener() {
                    @Override
                    public void editingStopped(ChangeEvent e) {
                        int row = tblTodo.getSelectedRow();
                        int column = tblTodo.getSelectedColumn();
                        String selectedValue = tblTodo.getValueAt(row, column).toString();
                        System.out.println("Cell di baris " + row + ", kolom " + column + " diubah menjadi: " + selectedValue);
                        changeMyBook((Integer) tblTodo.getValueAt(row, 0), tblTodo.getValueAt(row, 1).toString(), selectedValue.equals("Archive"));
                        showMyBook("", "");
                    }

                    @Override
                    public void editingCanceled(ChangeEvent e) {

                    }
                });
            }
        } catch (Error | Exception e) {

        }
    }

    @Override
    public void tableArchivedHandling() {
        try {
            JTable tblTodo = this.tblArchive;
            tblArchive.getColumnModel().getColumn(0).setCellEditor(new DefaultCellEditor(new JTextField()) {
                @Override
                public boolean isCellEditable(EventObject anEvent) {
                    return false;
                }
            });

            JComboBox<String> cbxStatus = new JComboBox<>();
            cbxStatus.addItem("Archive");
            cbxStatus.addItem("Not Archive");

            tblArchive.getColumnModel().getColumn(6).setCellEditor(new DefaultCellEditor(cbxStatus));

            cbxStatus.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int row = tblTodo.getSelectedRow();
                    int column = tblTodo.getSelectedColumn();
                    if (row >= 0 && column == 6) {
                        JComboBox<String> combo = (JComboBox<String>) e.getSource();
                        String selectedValue = (String) combo.getSelectedItem();
                        tblTodo.setValueAt(selectedValue, row, column);

                        changeMyBook((Integer) tblTodo.getValueAt(row, 0), tblTodo.getValueAt(row, 1).toString(), selectedValue.equals("Not Archive"));
                        System.out.println("" + selectedValue);

                    }
                }
            });

            // Button untuk menghapus buku
            ButtonEditor btnDeleteEditor = new ButtonEditor(new JCheckBox());
            btnDeleteEditor.button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int row = tblTodo.getSelectedRow();
                    int column = tblTodo.getSelectedColumn();
                    DefaultTableModel model = (DefaultTableModel) tblTodo.getModel();

                    if (row >= 0 && column == 3) {
                        int isbn = (int) model.getValueAt(row, 0);
                        removeMyBook(isbn);
                        showArchive("", "");
                    }
                }
            });

            // Set render dan editor untuk kolom penghapusan
            tblArchive.getColumnModel().getColumn(7).setCellRenderer(new util.ButtonRenderer());
            tblArchive.getColumnModel().getColumn(7).setCellEditor(btnDeleteEditor);

            // Menambahkan CellEditorListener untuk menangkap perubahan pada kolom di JTable
            tblTodo.getDefaultEditor(String.class).addCellEditorListener(new CellEditorListener() {
                @Override
                public void editingStopped(ChangeEvent e) {
                    int row = tblTodo.getSelectedRow();
                    int column = tblTodo.getSelectedColumn();
                    String selectedValue = tblTodo.getValueAt(row, column).toString();
                    System.out.println("Cell di baris " + row + ", kolom " + column + " diubah menjadi: " + selectedValue);
                    changeMyBook((Integer) tblArchive.getValueAt(row, 0), String.valueOf(tblTodo.getValueAt(row, 1)), selectedValue.equals("Not Archive"));
                    showArchive("", "");
                }

                @Override
                public void editingCanceled(ChangeEvent e) {
                    // aksi jika pengiditan dibatalkan
                }
            });
        } catch (Error | Exception e) {
            // Tangani kesalahan sesuai kebutuhan
            e.printStackTrace(); // Ini akan mencetak trace ke konsol (dapat diubah sesuai kebutuhan)
        }
    }

    @Override
    public void loadData(String keywords, String cbxStat) {
        JTable tblTodo = this.tblMyBook;
        ArrayList<MyBook> model = myBookRepository.getAll(keywords, cbxStat);
        DefaultTableModel tableModel = new DefaultTableModel(null, new Object[]{"ISBN", "title", "author", "publisher", "year", "totalPages", "Status", "Aksi"}) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return true;
            }
        };

        if (!model.isEmpty()) {
            for (var i = 0; i < model.size(); i++) {
                var myBook = model.get(i);
                var status = "Not Archive";

                if (myBook != null) {
                    if (myBook.isArchived()) {
                        status = "Archive";
                    }
                    tableModel.addRow(new Object[]{myBook.getIsbn(), myBook.getTitle(), myBook.getAuthor(), myBook.getPublisher(), myBook.getYear(), myBook.getTotalPages(), status, "Hapus"});
                }
            }
        }

        tblTodo.setModel(tableModel);
        tblTodo.setCellSelectionEnabled(false);
        tblTodo.setRowSelectionAllowed(true);
        tblTodo.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tblTodo.setRowHeight(40);

        TableColumnModel columnModel = tblTodo.getColumnModel();

        TableColumn columnID = columnModel.getColumn(0);
        columnID.setPreferredWidth(150);

        TableColumn columnTodo = columnModel.getColumn(1);
        columnTodo.setPreferredWidth(150);

        TableColumn columnStatus = columnModel.getColumn(2);
        columnStatus.setPreferredWidth(150);

        TableColumn columnAksi = columnModel.getColumn(3);
        columnAksi.setPreferredWidth(150);

    }
    
    @Override
    public void loadDataArchive(String keywords, String cbxStat) {
         JTable tblTodo = this.tblArchive;
        ArrayList<MyBook> model = myBookRepository.getAll(keywords, cbxStat);
        DefaultTableModel tableModel = new DefaultTableModel(null, new Object[]{"ISBN", "title", "author", "publisher", "year", "totalPages", "Status", "Aksi"}) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return true;
            }
        };

        if (!model.isEmpty()) {
            for (var i = 0; i < model.size(); i++) {
                var myBook = model.get(i);
                var status = "Not Archive";

                if (myBook != null) {
                    if (myBook.isArchived()) {
                        status = "Archive";
                    }
                    tableModel.addRow(new Object[]{myBook.getIsbn(), myBook.getTitle(), myBook.getAuthor(), myBook.getPublisher(), myBook.getYear(), myBook.getTotalPages(), status, "Hapus"});
                }
            }
        }

        tblTodo.setModel(tableModel);
        tblTodo.setCellSelectionEnabled(false);
        tblTodo.setRowSelectionAllowed(true);
        tblTodo.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tblTodo.setRowHeight(40);

        TableColumnModel columnModel = tblTodo.getColumnModel();

        TableColumn columnID = columnModel.getColumn(0);
        columnID.setPreferredWidth(150);

        TableColumn columnTodo = columnModel.getColumn(1);
        columnTodo.setPreferredWidth(150);

        TableColumn columnStatus = columnModel.getColumn(2);
        columnStatus.setPreferredWidth(150);

        TableColumn columnAksi = columnModel.getColumn(3);
        columnAksi.setPreferredWidth(150);
    }

    @Override
    public void showMyBook(String keywords, String cbxStatus) {
        loadData(keywords, cbxStatus);
        tableHandling();
    }

    @Override
    public void showArchive(String keywords, String cbxStatus) {
        loadDataArchive(keywords, cbxStatus);
        tableHandling();
    }

    @Override
    public void addMyBook(int isbn, String title, String author, String publisher, int year, int totalPages) {
        MyBook myBook = new MyBook(isbn, title, author, publisher, year, totalPages);
        if (myBookRepository.add(myBook)) {
            System.out.println("Berhasil menambahkan data my book!");
        } else {
            System.out.println("Gagal menambahkan data my book!");
        }
        showMyBook("", "");
    }

    @Override
    public void removeMyBook(int isbn) {
        boolean succes = myBookRepository.remove(isbn);
        System.out.println();
        if (succes) {
            System.out.println("SUKSES MENGHAPUS MY BOOK : " + isbn);
        } else {
            System.out.println("GAGAL MENGHAPUS MY BOOK : " + isbn);
        }
    }

    @Override
    public void changeMyBook(int ISBN, String title, boolean status) {
        System.out.println("isbn: " + ISBN);
        MyBook myBook = new MyBook(ISBN, title, status);
        boolean result = myBookRepository.change(ISBN, myBook);
        System.out.println("Status: " + myBook.isArchived());

        if (result) {
            System.out.println("SUKSES MENGUBAH MYBOOK  ISBN " + ISBN + ".");
        } else {
            System.out.println("GAGAL MENGUBAH MYBOOK dengan ISBN " + ISBN + ".");
        }

    }

    @Override
    public void showMyBookWithoutArchived() {
        ArrayList<MyBook> NotArchive = myBookRepository.getWithoutArchived();
        System.out.println("My Book :");
        if (!NotArchive.isEmpty()) {
            for (int i = 0; i < NotArchive.size(); i++) {
                var mybook = NotArchive.get(i);
                System.out.println(mybook.getIsbn() + ". " + mybook.getTitle() + " [" + mybook.getCurrentPages() + "/" + mybook.getTotalPages() + "]");
            }
        } else {
            System.out.println("Belum ada daftar buku yang tersedia");
        }
        System.out.println();

    }

    

}
