/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ui;

import java.awt.Color;
import java.awt.Image;
import javax.swing.JTable;
import service.MyBookService;
import ui.pages.PagesController;

/**
 *
 * @author dwila
 */
public class AppFrame extends javax.swing.JFrame {

    private MyBookService myBookService;
    private JTable table;

    public AppFrame() {
        initComponents();
        //awal

    }

    public void setMyBookService(MyBookService myBookService) {
        this.myBookService = myBookService;

        pnlPages.removeAll();
        pnlPages.add(PagesController.homePage);
        btnHome.setForeground(new Color(29, 155, 240));
        btnHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/home-on.png")));

        Image icon = getToolkit().getDefaultToolkit().getImage("src/assets/book3.png");
        setIconImage(icon);

        repaint();
        revalidate();

    }

    void resetAllMenu() {
        //reset warna menjadi text muted
        btnHome.setForeground(new Color(222, 222, 222));
        btnMyBook.setForeground(new Color(222, 222, 222));
        btnMyArchive.setForeground(new Color(222, 222, 222));
        btnAbout.setForeground(new Color(222, 222, 222));

        // reset icon menjadi disable
        btnHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/home-off.png")));
        btnMyBook.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/myBook-off.png")));
        btnMyArchive.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/myArchive-off.png")));
        btnAbout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/about-off.png")));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnMyArchive = new javax.swing.JButton();
        btnHome = new javax.swing.JButton();
        btnMyBook = new javax.swing.JButton();
        btnAbout = new javax.swing.JButton();
        pnlPages = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(897, 541));

        jPanel1.setBackground(new java.awt.Color(32, 44, 51));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        btnMyArchive.setBackground(new java.awt.Color(32, 44, 51));
        btnMyArchive.setFont(new java.awt.Font("Roboto", 1, 15)); // NOI18N
        btnMyArchive.setForeground(new java.awt.Color(222, 222, 222));
        btnMyArchive.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/myArchive-off.png"))); // NOI18N
        btnMyArchive.setText("My Archive");
        btnMyArchive.setBorderPainted(false);
        btnMyArchive.setFocusable(false);
        btnMyArchive.setIconTextGap(20);
        btnMyArchive.setOpaque(true);
        btnMyArchive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMyArchiveActionPerformed(evt);
            }
        });

        btnHome.setBackground(new java.awt.Color(32, 44, 51));
        btnHome.setFont(new java.awt.Font("Roboto", 1, 15)); // NOI18N
        btnHome.setForeground(new java.awt.Color(222, 222, 222));
        btnHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/home-on.png"))); // NOI18N
        btnHome.setText("Home");
        btnHome.setBorderPainted(false);
        btnHome.setFocusable(false);
        btnHome.setIconTextGap(20);
        btnHome.setOpaque(true);
        btnHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeActionPerformed(evt);
            }
        });

        btnMyBook.setBackground(new java.awt.Color(32, 44, 51));
        btnMyBook.setFont(new java.awt.Font("Roboto", 1, 15)); // NOI18N
        btnMyBook.setForeground(new java.awt.Color(222, 222, 222));
        btnMyBook.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/myBook-off.png"))); // NOI18N
        btnMyBook.setText("My Book");
        btnMyBook.setBorderPainted(false);
        btnMyBook.setFocusable(false);
        btnMyBook.setIconTextGap(20);
        btnMyBook.setOpaque(true);
        btnMyBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMyBookActionPerformed(evt);
            }
        });

        btnAbout.setBackground(new java.awt.Color(32, 44, 51));
        btnAbout.setFont(new java.awt.Font("Roboto", 1, 15)); // NOI18N
        btnAbout.setForeground(new java.awt.Color(222, 222, 222));
        btnAbout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/about-off.png"))); // NOI18N
        btnAbout.setText("About");
        btnAbout.setBorderPainted(false);
        btnAbout.setFocusable(false);
        btnAbout.setIconTextGap(20);
        btnAbout.setOpaque(true);
        btnAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAboutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnMyArchive)
                    .addComponent(btnHome)
                    .addComponent(btnMyBook)
                    .addComponent(btnAbout))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(166, 166, 166)
                .addComponent(btnHome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnMyBook)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnMyArchive)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAbout)
                .addContainerGap(215, Short.MAX_VALUE))
        );

        pnlPages.setBackground(new java.awt.Color(220, 220, 220));
        pnlPages.setLayout(new javax.swing.BoxLayout(pnlPages, javax.swing.BoxLayout.LINE_AXIS));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pnlPages, javax.swing.GroupLayout.DEFAULT_SIZE, 668, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlPages, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeActionPerformed
        pnlPages.removeAll();
        pnlPages.add(PagesController.homePage);

        resetAllMenu();
        btnHome.setForeground(new Color(29, 155, 240));
        btnHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/home-on.png")));

        repaint();
        revalidate();
    }//GEN-LAST:event_btnHomeActionPerformed

    private void btnMyBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMyBookActionPerformed
        pnlPages.removeAll();
        PagesController.myBookPage.setService(myBookService);
        pnlPages.add(PagesController.myBookPage);
        myBookService.setTableMyBook(PagesController.myBookPage.returnTbl());

        resetAllMenu();
        btnMyBook.setForeground(new Color(29, 155, 240));
        btnMyBook.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/myBook-on.png")));

        repaint();
        revalidate();
    }//GEN-LAST:event_btnMyBookActionPerformed

    private void btnMyArchiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMyArchiveActionPerformed
        pnlPages.removeAll();
        PagesController.myBookArchievePage.setMyBookService(myBookService);
        pnlPages.add(PagesController.myBookArchievePage);
        myBookService.setTableArchive(PagesController.myBookArchievePage.getTableArchive());


        resetAllMenu();
        btnMyArchive.setForeground(new Color(29, 155, 240));
        btnMyArchive.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/myArchive-on.png")));

        repaint();
        revalidate();
    }//GEN-LAST:event_btnMyArchiveActionPerformed

    private void btnAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAboutActionPerformed
        pnlPages.removeAll();
        pnlPages.add(PagesController.aboutPage);

        resetAllMenu();
        btnAbout.setForeground(new Color(29, 155, 240));
        btnAbout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/about-on.png")));

        repaint();
        revalidate();
    }//GEN-LAST:event_btnAboutActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AppFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AppFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AppFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AppFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AppFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbout;
    private javax.swing.JButton btnHome;
    private javax.swing.JButton btnMyArchive;
    private javax.swing.JButton btnMyBook;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel pnlPages;
    // End of variables declaration//GEN-END:variables
}
