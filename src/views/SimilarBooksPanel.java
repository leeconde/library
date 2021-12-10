package views;

import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.dao.BookDao;
import model.dao.TagDao;
import model.entities.Book;
import model.entities.Tag;

/**
 * Tela de livros similares.
 * @author alpha7
 */
public class SimilarBooksPanel extends JDialog {

  SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

  public SimilarBooksPanel(java.awt.Frame parent, boolean modal) {
    super(parent, modal);
    initComponents();
    setLocationRelativeTo(null);
    setTitle("Similar Books");
    setEnabledAuthor();
    setEnabledTag();
    setResizable(false);
  }

  /**
   * Método que defino o componente do Autor como desabilitado caso o checkBox não esteja selecionado.
   */
  public void setEnabledAuthor() {
    if (!checkBoxAuthor.isSelected()) {
      textFieldAuthor.setEnabled(false);
    }
  }

  /**
   * Método que defino o comboBox da Tag como desabilitado caso o checkBox não esteja selecionado.
   */
  public void setEnabledTag() {
    if (!checkBoxTag.isSelected()) {
      comboBoxTag.setEnabled(false);
    }
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jPanelConfiguration = new javax.swing.JPanel();
    jLabel1 = new javax.swing.JLabel();
    checkBoxTag = new javax.swing.JCheckBox();
    checkBoxAuthor = new javax.swing.JCheckBox();
    buttonClose = new javax.swing.JButton();
    buttonApply = new javax.swing.JButton();
    textFieldAuthor = new javax.swing.JTextField();
    comboBoxTag = new javax.swing.JComboBox<>();
    jPanelSimilarBooks = new javax.swing.JPanel();
    jScrollPane1 = new javax.swing.JScrollPane();
    tableSimilarBooks = new javax.swing.JTable();

    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

    jLabel1.setText("Configuration");

    checkBoxTag.setText("Tag");
    checkBoxTag.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        checkBoxTagActionPerformed(evt);
      }
    });

    checkBoxAuthor.setText("Author");
    checkBoxAuthor.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        checkBoxAuthorActionPerformed(evt);
      }
    });

    buttonClose.setMnemonic('F');
    buttonClose.setText("Close");
    buttonClose.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        buttonCloseActionPerformed(evt);
      }
    });

    buttonApply.setMnemonic('A');
    buttonApply.setText("Apply");
    buttonApply.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        buttonApplyMouseClicked(evt);
      }
    });

    comboBoxTag.addAncestorListener(new javax.swing.event.AncestorListener() {
      public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
      }
      public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
        comboBoxTagAncestorAdded(evt);
      }
      public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
      }
    });

    javax.swing.GroupLayout jPanelConfigurationLayout = new javax.swing.GroupLayout(jPanelConfiguration);
    jPanelConfiguration.setLayout(jPanelConfigurationLayout);
    jPanelConfigurationLayout.setHorizontalGroup(
      jPanelConfigurationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanelConfigurationLayout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanelConfigurationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanelConfigurationLayout.createSequentialGroup()
            .addComponent(jLabel1)
            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
          .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelConfigurationLayout.createSequentialGroup()
            .addGroup(jPanelConfigurationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(checkBoxTag)
              .addComponent(comboBoxTag, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(42, 42, 42)
            .addGroup(jPanelConfigurationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(checkBoxAuthor)
              .addComponent(textFieldAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(339, 339, 339)
            .addComponent(buttonApply, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addComponent(buttonClose, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addContainerGap())))
    );
    jPanelConfigurationLayout.setVerticalGroup(
      jPanelConfigurationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanelConfigurationLayout.createSequentialGroup()
        .addComponent(jLabel1)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(jPanelConfigurationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(checkBoxTag)
          .addComponent(checkBoxAuthor)
          .addComponent(buttonClose)
          .addComponent(buttonApply))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(jPanelConfigurationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(textFieldAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(comboBoxTag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addContainerGap(59, Short.MAX_VALUE))
    );

    tableSimilarBooks.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {

      },
      new String [] {
        "Code", "Title", "Publication Date", "ISBN", "Author", "Publisher", "Tag"
      }
    ) {
      boolean[] canEdit = new boolean [] {
        false, false, false, false, false, false, false
      };

      public boolean isCellEditable(int rowIndex, int columnIndex) {
        return canEdit [columnIndex];
      }
    });
    jScrollPane1.setViewportView(tableSimilarBooks);

    javax.swing.GroupLayout jPanelSimilarBooksLayout = new javax.swing.GroupLayout(jPanelSimilarBooks);
    jPanelSimilarBooks.setLayout(jPanelSimilarBooksLayout);
    jPanelSimilarBooksLayout.setHorizontalGroup(
      jPanelSimilarBooksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanelSimilarBooksLayout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jScrollPane1)
        .addContainerGap())
    );
    jPanelSimilarBooksLayout.setVerticalGroup(
      jPanelSimilarBooksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanelSimilarBooksLayout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE)
        .addContainerGap())
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jPanelConfiguration, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
      .addComponent(jPanelSimilarBooks, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
        .addComponent(jPanelSimilarBooks, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jPanelConfiguration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  /**
   * Método do botão Close.
   * @param evt
   */
  private void buttonCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCloseActionPerformed
    this.dispose();
  }//GEN-LAST:event_buttonCloseActionPerformed

  /**
   * Ação do checkBox da Tag.
   * Caso o checkBox está selecionado, o combo é habilitado, caso não, ele é desabilitado.
   * @param evt
   */
  private void checkBoxTagActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxTagActionPerformed
    if (checkBoxTag.isSelected()) {
      comboBoxTag.setEnabled(true);
    }
    else if (!checkBoxTag.isSelected()) {
      comboBoxTag.setEnabled(false);
    }
  }//GEN-LAST:event_checkBoxTagActionPerformed

  /**
   * Ação do checkBox do Autor.
   * Caso o checkBox está selecionado, o textField é habilitado, caso não, ele é desabilitado.
   * @param evt
   */
  private void checkBoxAuthorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkBoxAuthorActionPerformed
    if (checkBoxAuthor.isSelected()) {
      textFieldAuthor.setEnabled(true);
    }
    else if (!checkBoxAuthor.isSelected()) {
      textFieldAuthor.setEnabled(false);
    }
  }//GEN-LAST:event_checkBoxAuthorActionPerformed

  /**
   * Ação do comboBox. Onde ele é populado com todas as Tag's do banco de dados.
   * @param evt
   */
  private void comboBoxTagAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_comboBoxTagAncestorAdded
    List<Tag> listTag = TagDao.getInstance().findAll();

    comboBoxTag.removeAll();

    for (Tag t : listTag) {
      comboBoxTag.addItem(t);
    }
  }//GEN-LAST:event_comboBoxTagAncestorAdded

  /**
   * Ação do botão Apply.
   * Se o checkBox da Tag e do Autor estão selecionados, salvo o item selecionado do combo e texto
   * inserido no textField e atualizo a tabela com a consulta encontrada.
   * Se o checkBox da Tag está selecionado e o do Autor não, salvo o item selecionado do combo e
   * atualizo a tabela com a consulta encontrada.
   * Se o checkBox da Tag não estiver selecionado e o do Autor estiver, salvo o texto inserido no
   * textField e atualizo a tabela com a consulta encontrada.
   * Caso nenhum checkBox tenha sido selecionado é dispirado uma mensagem pedindo para configurar
   * os parametros de busca.
   * @param evt
   */
  private void buttonApplyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_buttonApplyMouseClicked
    if (checkBoxTag.isSelected() && checkBoxAuthor.isSelected()) {
      Tag tag = (Tag) comboBoxTag.getSelectedItem();
      int id_tag = tag.getId();
      String author = textFieldAuthor.getText();
      updateTableTagAndAuthor(id_tag, author);
    }
    else if (checkBoxTag.isSelected() && !checkBoxAuthor.isSelected()) {
      Tag tag = (Tag) comboBoxTag.getSelectedItem();
      int id_tag = tag.getId();
      updateTableTag(id_tag);
    }
    else if (!checkBoxTag.isSelected() && checkBoxAuthor.isSelected()) {
      String author = textFieldAuthor.getText();
      updateTableAuthor(author);
    }
    else {
      JOptionPane.showMessageDialog(null, "It's necessary to set up a configuration",
          "Configuration", JOptionPane.OK_OPTION);
    }
  }//GEN-LAST:event_buttonApplyMouseClicked

  /**
   * Atualiza a tabela com os livros que contém a Tag passada no parametro.
   * @param id que será utilizado na busca do livro pela tag.
   */
  public void updateTableTag(int id) {
    DefaultTableModel model = (DefaultTableModel) tableSimilarBooks.getModel();
    model.setNumRows(0);

    List<Book> list = BookDao.getInstance().findByTag(id);

    for (Book b : BookDao.getInstance().findByTag(id)) {
      model.addRow(new Object[]{
        b.getId(),
        b.getTitle(),
        sdf.format(b.getPublicationDate()),
        b.getIsbn(),
        b.getAuthor(),
        b.getPublisher(),
        b.getTag()
      });
    }
    if (list.size() == 0) {
      noDataFound();
    }
  }

  /**
   * Atualiza a tabela com os livros que contém o nome do autor passado no parametro.
   * @param author que será utilizado na busca do livro pelo autor.
   */
  public void updateTableAuthor(String author) {
    DefaultTableModel model = (DefaultTableModel) tableSimilarBooks.getModel();
    model.setNumRows(0);

    List<Book> list = BookDao.getInstance().findByAuthorName(author);

    for (Book b : BookDao.getInstance().findByAuthorName(author)) {
      model.addRow(new Object[]{
        b.getId(),
        b.getTitle(),
        sdf.format(b.getPublicationDate()),
        b.getIsbn(),
        b.getAuthor(),
        b.getPublisher(),
        b.getTag()
      });
    }
    if (list.size() == 0) {
      noDataFound();
    }
  }

  /**
   * Atualiza a tabela com os livros que contém a Tag e o nome do autor passados no parametro.
   * @param id que será utilizado na busca do livro pela Tag.
   * @param author que será utilizado na busca do livro pelo autor.
   */
  public void updateTableTagAndAuthor(int id, String author) {
    DefaultTableModel model = (DefaultTableModel) tableSimilarBooks.getModel();
    model.setNumRows(0);

    List<Book> list = BookDao.getInstance().findByTagAndAuthor(id, author);

    for (Book b : BookDao.getInstance().findByTagAndAuthor(id, author)) {
      model.addRow(new Object[]{
        b.getId(),
        b.getTitle(),
        sdf.format(b.getPublicationDate()),
        b.getIsbn(),
        b.getAuthor(),
        b.getPublisher(),
        b.getTag()
      });
    }
    if (list.size() == 0) {
      noDataFound();
    }
  }

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
      java.util.logging.Logger.getLogger(SimilarBooksPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(SimilarBooksPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(SimilarBooksPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(SimilarBooksPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    /* Create and display the dialog */
    java.awt.EventQueue.invokeLater(new Runnable() {

      public void run() {
        SimilarBooksPanel dialog = new SimilarBooksPanel(new javax.swing.JFrame(), true);
        dialog.addWindowListener(new java.awt.event.WindowAdapter() {

          @Override
          public void windowClosing(java.awt.event.WindowEvent e) {
            System.exit(0);
          }
        });
        dialog.setVisible(true);
      }
    });
  }

  public void noDataFound() {
    JOptionPane.showMessageDialog(null, "Check the fields",
        "No data found", JOptionPane.OK_OPTION);
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  protected javax.swing.JButton buttonApply;
  protected javax.swing.JButton buttonClose;
  protected javax.swing.JCheckBox checkBoxAuthor;
  protected javax.swing.JCheckBox checkBoxTag;
  protected javax.swing.JComboBox<Tag> comboBoxTag;
  protected javax.swing.JLabel jLabel1;
  protected javax.swing.JPanel jPanelConfiguration;
  protected javax.swing.JPanel jPanelSimilarBooks;
  protected javax.swing.JScrollPane jScrollPane1;
  protected javax.swing.JTable tableSimilarBooks;
  protected javax.swing.JTextField textFieldAuthor;
  // End of variables declaration//GEN-END:variables
}