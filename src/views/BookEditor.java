package views;

import controller.APIConsumer;
import model.entities.Book;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.dao.BookDao;
import model.dao.TagDao;
import model.entities.Tag;

/**
 * Editor de Livro
 * @author Leticia Conde
 */
public class BookEditor extends JDialog {

  SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

  private Book book;

  private boolean findByIsbnAction;

  private boolean registerEdit;

  private boolean registerRemove;

  private boolean createMode;

  private boolean removeMode;

  public BookEditor(java.awt.Frame parent, boolean modal) {
    super(parent, modal);
    initComponents();
    setTitle("Book Register");
    setLocationRelativeTo(null);
    setResizable(false);
  }

  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jPanelGeneral = new javax.swing.JPanel();
    jLabelTitle = new javax.swing.JLabel();
    jLabelPublicationDate = new javax.swing.JLabel();
    jLabelIsbn = new javax.swing.JLabel();
    jLabelAuthor = new javax.swing.JLabel();
    jLabelTag = new javax.swing.JLabel();
    textFieldTitle = new javax.swing.JTextField();
    textFieldAuthor = new javax.swing.JTextField();
    comboBoxTag = new javax.swing.JComboBox<>();
    dataChooserPublicationDate = new com.toedter.calendar.JDateChooser();
    jLabel1 = new javax.swing.JLabel();
    textFieldPublisher = new javax.swing.JTextField();
    textFieldIsbn = new javax.swing.JFormattedTextField();
    jPanelButtons = new javax.swing.JPanel();
    buttonOk = new javax.swing.JButton();
    buttonCancel = new javax.swing.JButton();
    buttonFindByISBN = new javax.swing.JButton();

    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

    jLabelTitle.setText("Title");

    jLabelPublicationDate.setText("Publication Date");

    jLabelIsbn.setText("ISBN");

    jLabelAuthor.setText("Author");

    jLabelTag.setText("Tag");

    comboBoxTag.addAncestorListener(new javax.swing.event.AncestorListener() {
      public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
      }
      public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
        comboBoxTagAncestorAdded(evt);
      }
      public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
      }
    });

    jLabel1.setText("Publisher");

    javax.swing.GroupLayout jPanelGeneralLayout = new javax.swing.GroupLayout(jPanelGeneral);
    jPanelGeneral.setLayout(jPanelGeneralLayout);
    jPanelGeneralLayout.setHorizontalGroup(
      jPanelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanelGeneralLayout.createSequentialGroup()
        .addGap(26, 26, 26)
        .addGroup(jPanelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanelGeneralLayout.createSequentialGroup()
            .addGroup(jPanelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(jLabelAuthor)
              .addComponent(jLabelTag)
              .addComponent(jLabelTitle)
              .addComponent(jLabel1))
            .addGap(18, 18, 18)
            .addGroup(jPanelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
              .addComponent(textFieldTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE)
              .addGroup(jPanelGeneralLayout.createSequentialGroup()
                .addComponent(comboBoxTag, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelIsbn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textFieldIsbn))
              .addComponent(textFieldAuthor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE)
              .addComponent(textFieldPublisher)))
          .addGroup(jPanelGeneralLayout.createSequentialGroup()
            .addComponent(jLabelPublicationDate)
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
            .addComponent(dataChooserPublicationDate, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addContainerGap(23, Short.MAX_VALUE))
    );
    jPanelGeneralLayout.setVerticalGroup(
      jPanelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanelGeneralLayout.createSequentialGroup()
        .addGap(28, 28, 28)
        .addGroup(jPanelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabelTitle)
          .addComponent(textFieldTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(18, 18, 18)
        .addGroup(jPanelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addComponent(textFieldIsbn, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addGroup(jPanelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
            .addComponent(jLabelTag)
            .addComponent(comboBoxTag, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jLabelIsbn)))
        .addGap(16, 16, 16)
        .addGroup(jPanelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabelAuthor)
          .addComponent(textFieldAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGap(18, 18, 18)
        .addGroup(jPanelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(jLabel1)
          .addComponent(textFieldPublisher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        .addGroup(jPanelGeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(jPanelGeneralLayout.createSequentialGroup()
            .addGap(26, 26, 26)
            .addComponent(jLabelPublicationDate))
          .addGroup(jPanelGeneralLayout.createSequentialGroup()
            .addGap(18, 18, 18)
            .addComponent(dataChooserPublicationDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addContainerGap(64, Short.MAX_VALUE))
    );

    buttonOk.setText("OK");
    buttonOk.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        buttonOkActionPerformed(evt);
      }
    });

    buttonCancel.setText("Cancel");
    buttonCancel.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        buttonCancelActionPerformed(evt);
      }
    });

    buttonFindByISBN.setText("Find By ISBN");
    buttonFindByISBN.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        buttonFindByISBNActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout jPanelButtonsLayout = new javax.swing.GroupLayout(jPanelButtons);
    jPanelButtons.setLayout(jPanelButtonsLayout);
    jPanelButtonsLayout.setHorizontalGroup(
      jPanelButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelButtonsLayout.createSequentialGroup()
        .addContainerGap(118, Short.MAX_VALUE)
        .addComponent(buttonOk, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(buttonCancel)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(buttonFindByISBN)
        .addGap(79, 79, 79))
    );
    jPanelButtonsLayout.setVerticalGroup(
      jPanelButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanelButtonsLayout.createSequentialGroup()
        .addContainerGap()
        .addGroup(jPanelButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(buttonOk)
          .addComponent(buttonCancel)
          .addComponent(buttonFindByISBN))
        .addContainerGap(18, Short.MAX_VALUE))
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addComponent(jPanelButtons, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
      .addComponent(jPanelGeneral, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addComponent(jPanelGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jPanelButtons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );

    pack();
  }// </editor-fold>//GEN-END:initComponents

  /**
   * Ação do botão cancelar.
   * @param evt
   */
  private void buttonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelActionPerformed
    this.dispose();
  }//GEN-LAST:event_buttonCancelActionPerformed

  /**
   * Ação que popula o Combo Box com as Tag's recebidas do banco de dados.
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
   * É realizada uma verificação onde se createMode for igual a verdadeiro, então é uma operação de
   * inclusão, caso seja falso é uma operação de edição.
   * Para o modo de inclusão, caso ocorra a validação dos campos sem problemas, é armazenado em
   * variavéis os dados inseridos nos componentes e passado para o construtor da entidade livro,
   * depois é criado um livro no banco de dados.
   * Para o modo de edição, caso ocorra a validação dos campos sem problemas, é setado os dados da
   * entidade livro com os valores recebido nos componentes e é realizada a edição do livro na base
   * de dados.
   * Foi criada uma variavel chamada registerEdit que recebe o valor verdadeiro informando que o
   * registro foi editado.
   * Para o modo de encontrar o livro pelo código ISBN, ele verifica se a variavel findByIsbnAction
   * foi setada como verdadeira, ou seja, foi realizada a ação do botão, caso sim, ele cria um
   * registro no banco.
   * @param evt
   */
  private void buttonOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonOkActionPerformed
    if (createMode == true) {
      Date publicationDate = dataChooserPublicationDate.getDate();
      String title = textFieldTitle.getText().trim();
      String isbn = textFieldIsbn.getText().trim();
      String author = textFieldAuthor.getText().trim();
      String publisher = textFieldPublisher.getText().trim();
      Tag catchTag = (Tag) comboBoxTag.getSelectedItem();
      if (validationFields()) {
        Book book = new Book(title, publicationDate, isbn, author, publisher, catchTag);
        BookDao.getInstance().merge(book);
        this.dispose();
      }
    }
    else if (createMode == false && removeMode == false) {
      if (validationFields()) {
        book.setTitle(textFieldTitle.getText());
        book.setAuthor(textFieldAuthor.getText());
        book.setIsbn(textFieldIsbn.getText());
        book.setPublicationDate(dataChooserPublicationDate.getDate());
        book.setPublisher(textFieldPublisher.getText());
        Tag tag = (Tag) comboBoxTag.getSelectedItem();
        book.setTag(tag);
        BookDao.getInstance().merge(book);
        registerEdit = true;
        this.dispose();
      }
    }
    else if (removeMode == true) {
      BookDao.getInstance().remove(book);
      removeMode = true;
      this.dispose();
    }
    else if (findByIsbnAction == true) {
      BookDao.getInstance().create(book);
    }
  }//GEN-LAST:event_buttonOkActionPerformed

  /**
   * Método de ação do botão Find By ISBN, onde inicialmente seta a variavel findByIsbnAction como
   * verdadeira. Verifica se o componente de ISBN está preenchido. Realiza a chamada do método de
   * registerBook da classe APIConsumer que realiza toda a leitura do arquivo json e converte no
   * objeto Book. Preenche os dados recebidos do objeto livro nos componentes do editor.
   * @param evt
   */
  private void buttonFindByISBNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonFindByISBNActionPerformed
    findByIsbnAction = true;
    String isbn = textFieldIsbn.getText();
    if (textFieldIsbn.getText().isEmpty()) {
      JOptionPane.showMessageDialog(null, "Enter with the ISBN");
    }
    try {
      Book book = APIConsumer.registerBook(isbn);
      if (book == null) {
        JOptionPane.showMessageDialog(null, "Can't found your book", "Book not found", JOptionPane.OK_OPTION);
      }
      else {
        textFieldTitle.setText(book.getTitle());
        textFieldAuthor.setText(book.getAuthor());
        textFieldPublisher.setText(book.getPublisher());
      }
    }
    catch (Exception ex) {
      Logger.getLogger(BookEditor.class.getName()).log(Level.SEVERE, null, ex);
      System.out.println(ex.getMessage());
    }
  }//GEN-LAST:event_buttonFindByISBNActionPerformed

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
      java.util.logging.Logger.getLogger(BookEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(BookEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(BookEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(BookEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    /* Create and display the dialog */
    java.awt.EventQueue.invokeLater(new Runnable() {

      public void run() {
        BookEditor dialog = new BookEditor(new javax.swing.JFrame(), true);
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
  protected javax.swing.JButton buttonCancel;
  protected javax.swing.JButton buttonFindByISBN;
  protected javax.swing.JButton buttonOk;
  protected javax.swing.JComboBox<Object> comboBoxTag;
  protected com.toedter.calendar.JDateChooser dataChooserPublicationDate;
  protected javax.swing.JLabel jLabel1;
  protected javax.swing.JLabel jLabelAuthor;
  protected javax.swing.JLabel jLabelIsbn;
  protected javax.swing.JLabel jLabelPublicationDate;
  protected javax.swing.JLabel jLabelTag;
  protected javax.swing.JLabel jLabelTitle;
  protected javax.swing.JPanel jPanelButtons;
  protected javax.swing.JPanel jPanelGeneral;
  protected javax.swing.JTextField textFieldAuthor;
  protected javax.swing.JFormattedTextField textFieldIsbn;
  protected javax.swing.JTextField textFieldPublisher;
  protected javax.swing.JTextField textFieldTitle;
  // End of variables declaration//GEN-END:variables

  /**
   * Método que valida todos os componentes do Editor.
   * Caso os campos estejam vazios é lançada uma mensagem pedindo para que sejam preenchidos.
   * É realizada uma validação para o campo de ISBN para que seja aceito apenas números.
   * @return false caso não passe na validação, true caso todos os campos passem na validação.
   */
  public boolean validationFields() {
    if (textFieldTitle.getText().trim().isEmpty()) {
      JOptionPane.showMessageDialog(null, "The field Title is empty", "The field can't be empty",
          JOptionPane.OK_OPTION);
      return false;
    }
    else if (textFieldAuthor.getText().trim().isEmpty()) {
      JOptionPane.showMessageDialog(null, "The field Author is empty", "The field can't be empty",
          JOptionPane.OK_OPTION);
      return false;
    }
    else if (textFieldPublisher.getText().trim().isEmpty()) {
      JOptionPane.showMessageDialog(null, "The field Publisher is empty", "The field can't be empty",
          JOptionPane.OK_OPTION);
      return false;
    }
    else if (textFieldIsbn.getText().trim().isEmpty()) {
      JOptionPane.showMessageDialog(null, "The field ISBN is empty", "The field can't be empty",
          JOptionPane.OK_OPTION);
      return false;
    }
    else if (!textFieldIsbn.getText().matches("[0-9]*")) {
      JOptionPane.showMessageDialog(null, "The field ISBN only aceppt numbers",
          "Only numbers", JOptionPane.OK_OPTION);
      return false;
    }
    else if (((JTextField) dataChooserPublicationDate.getDateEditor().getUiComponent()).getText()
        .trim().isEmpty()) {
      JOptionPane.showMessageDialog(null, "The field Publication Date is empty",
          "The field can't be empty", JOptionPane.OK_OPTION);
      return false;
    }
    else if (comboBoxTag.getSelectedItem() == null) {
      JOptionPane.showMessageDialog(null, "Register a Tag to be continue",
          "The Tag can't be empty", JOptionPane.OK_OPTION);
      return false;
    }
    return true;
  }

  /**
   * Método para desabilitar os campos para processos como Excluir registro.
   */
  public void disableFields() {
    textFieldAuthor.setEnabled(false);
    textFieldIsbn.setEnabled(false);
    textFieldPublisher.setEnabled(false);
    textFieldTitle.setEnabled(false);
    comboBoxTag.setEnabled(false);
    dataChooserPublicationDate.setEnabled(false);
    buttonFindByISBN.setEnabled(false);
  }

  /**
   * Método que pega como parametro o id passado na edição e utiliza para encontrar o livro.
   * Com o livro encontrado, é setado os componentes com os dados do livro.
   * Seta a visibilidade da tela.
   * @param id do livro a ser editado.
   * @return a variavel registerEdit como verdadeira.
   */
  public boolean edit(int id) {
    book = BookDao.getInstance().findById(id);
    textFieldTitle.setText(book.getTitle());
    textFieldAuthor.setText(book.getAuthor());
    textFieldIsbn.setText(book.getIsbn());
    textFieldPublisher.setText(book.getPublisher());
    dataChooserPublicationDate.setDate(book.getPublicationDate());
    comboBoxTag.setEditable(true);
    comboBoxTag.setSelectedItem(book.getTag());
    comboBoxTag.setEditable(false);
    setVisible(true);
    return registerEdit;
  }

  /**
   * Método que pega como parametro o id passado na exclusão do registro e utiliza para encontrar
   * o livro. Com o livro encontrado, é setado os componentes com os dados do livro e chama o
   * método para desabilitar os campos, impossibilitando a edição. Seta a visibilidade da tela.
   * @param id
   * @return a variavel de registerRemove como verdadeira.
   */
  public boolean removeBook(int id) {
    book = BookDao.getInstance().findById(id);
    textFieldTitle.setText(book.getTitle());
    textFieldAuthor.setText(book.getAuthor());
    textFieldIsbn.setText(book.getIsbn());
    textFieldPublisher.setText(book.getPublisher());
    dataChooserPublicationDate.setDate(book.getPublicationDate());
    comboBoxTag.setEditable(true);
    comboBoxTag.setSelectedItem(book.getTag());
    comboBoxTag.setEditable(false);
    disableFields();
    setVisible(true);
    return registerRemove = true;
  }

  /**
   * Método para verificar se a operação é inclusão ou edição.
   * Caso seja edição, o botão Find By ISBN é desabilitado.
   * @param createMode variavel booleana que será setada na ação dos botões incluir e editar.
   */
  public void operationEditCreateMode(boolean createMode) {
    if (createMode == true) {
      this.createMode = true;
    }
    else if (createMode == false) {
      this.createMode = false;
      buttonFindByISBN.setEnabled(false);
    }
  }

  /**
   * Método para verificar se a operação é remoção.
   * Caso seja, ele seta o valor da váriavel como true.
   * @param removeMode variavel que será setada na ação do botão excluir.
   */
  public void operationRemoveMode(boolean removeMode) {
    if (removeMode == true) {
      this.removeMode = true;
    }
  }
}