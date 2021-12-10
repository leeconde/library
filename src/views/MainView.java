package views;

import javax.swing.JFrame;

/**
 * Tela Principal do sistema.
 * @author Leticia Conde
 */
public class MainView extends JFrame {

  public MainView() {
    initComponents();
    setTitle("Main Menu");
    setLocationRelativeTo(null);
    setResizable(false);
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    panelMainView = new javax.swing.JPanel();
    jMenuBar1 = new javax.swing.JMenuBar();
    jMenuRegister = new javax.swing.JMenu();
    jMenuItemBook = new javax.swing.JMenuItem();
    jMenuItemTag = new javax.swing.JMenuItem();
    jMenuBooks = new javax.swing.JMenu();
    jMenuItemBooks = new javax.swing.JMenuItem();
    jMenuItemSimilarBooks = new javax.swing.JMenuItem();
    jMenuAbout = new javax.swing.JMenu();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    javax.swing.GroupLayout panelMainViewLayout = new javax.swing.GroupLayout(panelMainView);
    panelMainView.setLayout(panelMainViewLayout);
    panelMainViewLayout.setHorizontalGroup(
      panelMainViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 900, Short.MAX_VALUE)
    );
    panelMainViewLayout.setVerticalGroup(
      panelMainViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGap(0, 583, Short.MAX_VALUE)
    );

    jMenuRegister.setText("Register");

    jMenuItemBook.setText("Book");
    jMenuItemBook.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jMenuItemBookActionPerformed(evt);
      }
    });
    jMenuRegister.add(jMenuItemBook);

    jMenuItemTag.setText("Tag");
    jMenuItemTag.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jMenuItemTagActionPerformed(evt);
      }
    });
    jMenuRegister.add(jMenuItemTag);

    jMenuBar1.add(jMenuRegister);

    jMenuBooks.setText("Books");

    jMenuItemBooks.setText("Books");
    jMenuItemBooks.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jMenuItemBooksActionPerformed(evt);
      }
    });
    jMenuBooks.add(jMenuItemBooks);

    jMenuItemSimilarBooks.setText("Similar Books");
    jMenuItemSimilarBooks.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        jMenuItemSimilarBooksActionPerformed(evt);
      }
    });
    jMenuBooks.add(jMenuItemSimilarBooks);

    jMenuBar1.add(jMenuBooks);

    jMenuAbout.setText("About");
    jMenuAbout.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        jMenuAboutMouseClicked(evt);
      }
    });
    jMenuBar1.add(jMenuAbout);

    setJMenuBar(jMenuBar1);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(panelMainView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(panelMainView, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  private void jMenuItemBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemBookActionPerformed
    BookEditor bookEditor = new BookEditor(this, true);
    bookEditor.operationEditCreateMode(true);
    bookEditor.setVisible(true);
  }//GEN-LAST:event_jMenuItemBookActionPerformed

  private void jMenuItemTagActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemTagActionPerformed
    TagEditor tagEditor = new TagEditor(this, true);
    tagEditor.setVisible(true);
  }//GEN-LAST:event_jMenuItemTagActionPerformed

  private void jMenuAboutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuAboutMouseClicked
    AboutPanel aboutPanel = new AboutPanel(null, true);
    aboutPanel.setVisible(true);
  }//GEN-LAST:event_jMenuAboutMouseClicked

  private void jMenuItemBooksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemBooksActionPerformed
    BookPanel bookPanel = new BookPanel(this, true);
    bookPanel.setVisible(true);
  }//GEN-LAST:event_jMenuItemBooksActionPerformed

  private void jMenuItemSimilarBooksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemSimilarBooksActionPerformed
    SimilarBooksPanel similarBooksPanel = new SimilarBooksPanel(this, true);
    similarBooksPanel.setVisible(true);
  }//GEN-LAST:event_jMenuItemSimilarBooksActionPerformed

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
    }
    catch (ClassNotFoundException ex) {
      java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {

      public void run() {
        new MainView().setVisible(true);
      }
    });
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  protected javax.swing.JMenu jMenuAbout;
  protected javax.swing.JMenuBar jMenuBar1;
  protected javax.swing.JMenu jMenuBooks;
  protected javax.swing.JMenuItem jMenuItemBook;
  protected javax.swing.JMenuItem jMenuItemBooks;
  protected javax.swing.JMenuItem jMenuItemSimilarBooks;
  protected javax.swing.JMenuItem jMenuItemTag;
  protected javax.swing.JMenu jMenuRegister;
  protected javax.swing.JPanel panelMainView;
  // End of variables declaration//GEN-END:variables
}