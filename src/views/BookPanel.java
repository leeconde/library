package views;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import model.dao.BookDao;
import model.entities.Book;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import controller.FileHandler;
import javax.swing.JDialog;

/**
 * Painel de Livro.
 * @author Leticia Conde
 */
public class BookPanel extends JDialog {

  private BookEditor bookEditor;

  private Book book;

  private FileHandler fileHandler;

  SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

  public BookPanel(java.awt.Frame parent, boolean modal) {
    super(parent, modal);
    initComponents();
    setLocationRelativeTo(null);
    setTitle("Books");
    updateTable();
    setResizable(false);
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jScrollPane1 = new javax.swing.JScrollPane();
    jTable1 = new javax.swing.JTable();
    jPanelButtonTop = new javax.swing.JPanel();
    buttonUpdateTable = new javax.swing.JButton();
    jPanel2 = new javax.swing.JPanel();
    jScrollPane2 = new javax.swing.JScrollPane();
    tableBooks = new javax.swing.JTable();
    jPanelButtonBottom = new javax.swing.JPanel();
    buttonCreate = new javax.swing.JButton();
    buttonEdit = new javax.swing.JButton();
    buttonDelete = new javax.swing.JButton();
    buttonImportFile = new javax.swing.JButton();
    buttonClose = new javax.swing.JButton();
    jSeparator1 = new javax.swing.JSeparator();
    jSeparator2 = new javax.swing.JSeparator();

    jTable1.setModel(new javax.swing.table.DefaultTableModel(
      new Object [][] {
        {null, null, null, null},
        {null, null, null, null},
        {null, null, null, null},
        {null, null, null, null}
      },
      new String [] {
        "Title 1", "Title 2", "Title 3", "Title 4"
      }
    ));
    jScrollPane1.setViewportView(jTable1);

    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

    buttonUpdateTable.setMnemonic('U');
    buttonUpdateTable.setText("Update Table");
    buttonUpdateTable.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        buttonUpdateTableActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout jPanelButtonTopLayout = new javax.swing.GroupLayout(jPanelButtonTop);
    jPanelButtonTop.setLayout(jPanelButtonTopLayout);
    jPanelButtonTopLayout.setHorizontalGroup(
      jPanelButtonTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelButtonTopLayout.createSequentialGroup()
        .addContainerGap(769, Short.MAX_VALUE)
        .addComponent(buttonUpdateTable)
        .addContainerGap())
    );
    jPanelButtonTopLayout.setVerticalGroup(
      jPanelButtonTopLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelButtonTopLayout.createSequentialGroup()
        .addContainerGap(53, Short.MAX_VALUE)
        .addComponent(buttonUpdateTable)
        .addGap(16, 16, 16))
    );

    tableBooks.setModel(new javax.swing.table.DefaultTableModel(
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
    jScrollPane2.setViewportView(tableBooks);

    javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel2Layout.createSequentialGroup()
        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 888, Short.MAX_VALUE)
        .addContainerGap())
    );
    jPanel2Layout.setVerticalGroup(
      jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel2Layout.createSequentialGroup()
        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 433, Short.MAX_VALUE)
        .addContainerGap())
    );

    buttonCreate.setMnemonic('C');
    buttonCreate.setText("Create");
    buttonCreate.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        buttonCreateActionPerformed(evt);
      }
    });

    buttonEdit.setMnemonic('E');
    buttonEdit.setText("Edit");
    buttonEdit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        buttonEditActionPerformed(evt);
      }
    });

    buttonDelete.setMnemonic('D');
    buttonDelete.setText("Delete");
    buttonDelete.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        buttonDeleteActionPerformed(evt);
      }
    });

    buttonImportFile.setMnemonic('I');
    buttonImportFile.setText("Import File");
    buttonImportFile.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        buttonImportFileActionPerformed(evt);
      }
    });

    buttonClose.setMnemonic('F');
    buttonClose.setText("Close");
    buttonClose.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        buttonCloseActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout jPanelButtonBottomLayout = new javax.swing.GroupLayout(jPanelButtonBottom);
    jPanelButtonBottom.setLayout(jPanelButtonBottomLayout);
    jPanelButtonBottomLayout.setHorizontalGroup(
      jPanelButtonBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanelButtonBottomLayout.createSequentialGroup()
        .addContainerGap()
        .addComponent(buttonCreate, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(buttonEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(buttonDelete)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(buttonImportFile)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(buttonClose)
        .addContainerGap())
    );
    jPanelButtonBottomLayout.setVerticalGroup(
      jPanelButtonBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanelButtonBottomLayout.createSequentialGroup()
        .addGap(25, 25, 25)
        .addGroup(jPanelButtonBottomLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(buttonCreate)
          .addComponent(buttonEdit)
          .addComponent(buttonDelete)
          .addComponent(buttonImportFile)
          .addComponent(buttonClose))
        .addContainerGap(24, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jPanelButtonTop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
      .addComponent(jPanelButtonBottom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
      .addGroup(layout.createSequentialGroup()
        .addContainerGap()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addComponent(jSeparator2)
            .addContainerGap())
          .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
          .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addComponent(jPanelButtonTop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jPanelButtonBottom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap())
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  /**
   * Ação para o botão Update Table que chama o método updateTable().
   * @param evt
   */
  private void buttonUpdateTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUpdateTableActionPerformed
    updateTable();
  }//GEN-LAST:event_buttonUpdateTableActionPerformed

  /**
   * Ação para o botão Create que instancia o BookEditor, define a operação como inclusão, seta a
   * visibilidade e atualiza a tabela após o processamento.
   * @param evt
   */
  private void buttonCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCreateActionPerformed
    bookEditor = new BookEditor(null, true);
    bookEditor.operationEditCreateMode(true);
    bookEditor.setVisible(true);
    updateTable();
  }//GEN-LAST:event_buttonCreateActionPerformed

  /**
   * Ação do botão Edit que instancia o BookEditor, define a operação como edição.
   * Verifica se a linha foi selecionada, caso sim, pega o valor do id passando o indice da coluna 0.
   * Chama o método edit da classe BookEditor passando o id da linha selecionada como parametro.
   * @param evt
   */
  private void buttonEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEditActionPerformed
    bookEditor = new BookEditor(null, true);
    bookEditor.operationEditCreateMode(false);
    int selectedLine = tableBooks.getSelectedRow();
    if (selectedLine != -1) {
      try {
        Object idObj = tableBooks.getModel().getValueAt(selectedLine, 0);
        int id = Integer.parseInt(idObj.toString());
        if (bookEditor.edit(id)) {
          updateTable();
        }
      }
      catch (Exception ex) {
        ex.printStackTrace();
      }
    }
    else {
      validationSelectedRegister();
    }
  }//GEN-LAST:event_buttonEditActionPerformed

  /**
   * Ação do botão Delete. Pega a linha selecionada, questiona se realmente o usuário deseja excluir.
   * Caso sim, pega o valor do id passando o indice da coluna 0. Remove o livro passando o id pego.
   * Remove a linha da tabela.
   * @param evt
   */
  private void buttonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeleteActionPerformed
    bookEditor = new BookEditor(null, true);
    bookEditor.operationRemoveMode(true);

    int selectedLine = tableBooks.getSelectedRow();
    if (selectedLine != -1) {
      try {
        Object idObj = tableBooks.getModel().getValueAt(selectedLine, 0);
        int id = Integer.parseInt(idObj.toString());
        if (bookEditor.removeBook(id)) {
          updateTable();
        }
      }
      catch (Exception ex) {
        ex.printStackTrace();
      }
    }
    else {
      validationSelectedRegister();
    }
  }//GEN-LAST:event_buttonDeleteActionPerformed

  /**
   * Ação do botão Import File. Utilizo o JFileChooser para buscar o arquivo. Defino que só aceita
   * a seleção de arquivos. Defino o filtro para extensão de arquivos de texto. Pego o arquivo
   * selecionado e faço a leitura dele através do método read da classe FileHandler.
   * @param evt
   */
  private void buttonImportFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonImportFileActionPerformed
    JFileChooser fileChooser = new JFileChooser();
    fileChooser.setDialogTitle("Search File");
    fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

    FileNameExtensionFilter filter = new FileNameExtensionFilter("Text", "txt");

    fileChooser.setFileFilter(filter);
    int retur = fileChooser.showOpenDialog(this);
    if (retur == JFileChooser.APPROVE_OPTION) {
      File file = fileChooser.getSelectedFile();
      try {
        fileHandler.read(file);
      }
      catch (ParseException ex) {
        Logger.getLogger(BookPanel.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
    updateTable();
  }//GEN-LAST:event_buttonImportFileActionPerformed

  /**
   * Ação do botão Close.
   * @param evt
   */
  private void buttonCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCloseActionPerformed
    this.dispose();
  }//GEN-LAST:event_buttonCloseActionPerformed

  /**
   * Método que popula a tabela com os livros encontrados no banco de dados.
   */
  public void updateTable() {
    DefaultTableModel model = (DefaultTableModel) tableBooks.getModel();
    model.setNumRows(0);

    for (Book b : BookDao.getInstance().findAll()) {
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
      java.util.logging.Logger.getLogger(BookPanel.class
          .getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(BookPanel.class
          .getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(BookPanel.class
          .getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(BookPanel.class
          .getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    /* Create and display the dialog */
    java.awt.EventQueue.invokeLater(new Runnable() {

      public void run() {
        BookPanel dialog = new BookPanel(new javax.swing.JFrame(), true);
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

  // Variables declaration - do not modify//GEN-BEGIN:variables
  protected javax.swing.JButton buttonClose;
  protected javax.swing.JButton buttonCreate;
  protected javax.swing.JButton buttonDelete;
  protected javax.swing.JButton buttonEdit;
  protected javax.swing.JButton buttonImportFile;
  protected javax.swing.JButton buttonUpdateTable;
  protected javax.swing.JPanel jPanel2;
  protected javax.swing.JPanel jPanelButtonBottom;
  protected javax.swing.JPanel jPanelButtonTop;
  protected javax.swing.JScrollPane jScrollPane1;
  protected javax.swing.JScrollPane jScrollPane2;
  protected javax.swing.JSeparator jSeparator1;
  protected javax.swing.JSeparator jSeparator2;
  protected javax.swing.JTable jTable1;
  protected javax.swing.JTable tableBooks;
  // End of variables declaration//GEN-END:variables

  /**
   * Método que retorna uma mensagem caso um registro não seja selecionado.
   */
  private void validationSelectedRegister() {
    JOptionPane.showMessageDialog(null, "Select a register", "Register was not selected",
        JOptionPane.OK_OPTION);
  }
}