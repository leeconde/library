package controller;

import model.entities.Book;
import model.entities.Tag;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import model.dao.BookDao;
import model.dao.TagDao;

/**
 * Classe responsável pela leitura de arquivo .txt e criação do livro lido no banco.
 * @author Leticia Conde
 */
public class FileHandler {

  /**
   * O método realiza a leitura de cada linha do arquivo .txt, separa por virgula e armazena no
   * objeto livro, a cada livro lido, é criado um registro no banco de dados.
   * @param file arquivo a ser lido
   * @throws ParseException
   */
  public static void read(File file) throws ParseException {

    List<Book> list = new ArrayList<>();

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
      String line = bufferedReader.readLine();
      line = bufferedReader.readLine();

      if (line == null) {
        JOptionPane.showMessageDialog(null, "Error to import", "Error", JOptionPane.OK_OPTION);
      }

      while (line != null) {
        String[] arrayString = new String[6];
        arrayString = line.split(",");
        String title = arrayString[0];
        Date publicationDate = sdf.parse(arrayString[1]);
        String isbn = arrayString[2];
        String author = arrayString[3];
        String publisher = arrayString[4];
        String tagCatched = arrayString[5];

        Tag tag = TagDao.getInstance().findAll().stream()
            .filter(t -> t.getName().equalsIgnoreCase(tagCatched))
            .findFirst()
            .orElse(new Tag(tagCatched));

        Book book = new Book(title, publicationDate, isbn, author, publisher, tag);
        list.add(book);
        line = bufferedReader.readLine();
      }
      for (Book book : list) {
        BookDao.getInstance().merge(book);
      }
    }
    catch (IOException e) {
      System.out.println(e.getMessage());
    }
  }
}