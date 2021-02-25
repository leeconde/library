package views;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.dao.TagDao;
import model.entities.Tag;

/**
 * Editor da Tag que extende o BasicEditor
 * @author Leticia Conde
 */
public class TagEditor extends BasicEditor {

  public TagEditor(Frame parent, boolean modal) {
    super(parent, modal);
    super.buttonSave.addActionListener(new ActionListener() {

      /**
       * Sobrescreve o método de criar um registro.
       * Pega o nome da Tag e criar o registro no banco.
       * @param e
       */
      @Override
      public void actionPerformed(ActionEvent e) {
        String name = textFieldName.getText();
        Tag tag = new Tag(name);
        TagDao.getInstance().create(tag);
        dispose();
      }
    });

    super.buttonCancel.addActionListener(new ActionListener() {

      /**
       * Sobrescreve o método de fechar a tela.
       * @param e
       */
      @Override
      public void actionPerformed(ActionEvent e) {
        dispose();
      }
    });
  }
}