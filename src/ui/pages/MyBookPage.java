/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package ui.pages;

import javax.swing.JTable;
import service.MyBookService;
import ui.AddMyBook;
import ui.AppFrame;
import ui.DetailMyBook;

public class MyBookPage extends javax.swing.JPanel {
    
    private MyBookService myBookService;
    private DetailMyBook detailMyBook = new DetailMyBook();
    private MyBookService service;
    
    
    public JTable returnTbl() {
        return tblMyBook;
    }

    public void setService(MyBookService service) {
        this.service = service;
    }

    
    public MyBookPage() {
        initComponents();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblMyBook = new javax.swing.JTable();
        btnAdd = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();

        setBackground(new java.awt.Color(32, 44, 51));

        jLabel1.setFont(new java.awt.Font("Roboto", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(222, 222, 222));
        jLabel1.setText("M Y  B O O K");

        tblMyBook.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ISBN", "Title", "Author", "Publisher", "Year", "Total Pages", "Status", "Aksi"
            }
        ));
        tblMyBook.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                tblMyBookMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tblMyBook);

        btnAdd.setBackground(new java.awt.Color(225, 225, 225));
        btnAdd.setFont(new java.awt.Font("Roboto", 0, 14)); // NOI18N
        btnAdd.setText("Add");
        btnAdd.setBorderPainted(false);
        btnAdd.setFocusable(false);
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/search.png"))); // NOI18N
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 693, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAdd))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(txtSearch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(279, 279, 279))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSearch))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAdd)
                .addContainerGap(58, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed

        // buat dan buka frame Simple Calculator
        AddMyBook addMyBook = new AddMyBook();
        service.setTableMyBook(tblMyBook);
        addMyBook.setService(service);
        addMyBook.setVisible(true);
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        String keyword = txtSearch.getText();
        myBookService.showMyBook(keyword, "");
    }//GEN-LAST:event_btnSearchActionPerformed

    private void tblMyBookMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMyBookMouseReleased
        int row = tblMyBook.rowAtPoint(evt.getPoint());
                int col = tblMyBook.columnAtPoint(evt.getPoint());

                if (row >= 0 && col == 0) {
                    int selectedISBN = (int) tblMyBook.getValueAt(row, 0);
                    String selectedTitle = tblMyBook.getValueAt(row, 1).toString(); 
                    boolean selectedStatus = tblMyBook.getValueAt(row, 2).toString().equals("Selesai");   
                    
                    DetailMyBook detailFrame = new DetailMyBook(selectedISBN, selectedTitle, selectedStatus);
                    if (detailFrame.isVisible() == true) {
                        detailFrame.dispose();
                    }
                    else                 
                        detailFrame.setVisible(true);   
                }
    }//GEN-LAST:event_tblMyBookMouseReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblMyBook;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
