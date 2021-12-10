package model.dao;

import model.entities.Book;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 * Classe que implementa o BasicDao, realiza a instância de acesso ao banco e realiza todo o
 * gerenciamento do livro na base de dados.
 * @author Leticia Conde
 */
public class BookDao implements BasicDao<Book> {

  private static BookDao instance;

  private Book book;

  protected EntityManager entityManager;

  /**
   * Método que verifica se já existe uma instancia, caso não, ele cria uma nova.
   * @return uma instancia de BookDao
   */
  public static BookDao getInstance() {
    if (instance == null) {
      instance = new BookDao();
    }
    return instance;
  }

  private BookDao() {
    entityManager = getEntityManager();
  }

  private EntityManager getEntityManager() {
    EntityManagerFactory factory = Persistence.createEntityManagerFactory("library");
    if (entityManager == null) {
      entityManager = factory.createEntityManager();
    }
    return entityManager;
  }

  /**
   * Método que encontra o livro através do ID, mapeado pela classe Book.
   * @param id do livro a ser encontrado.
   * @return o livro encontrado.
   */
  @Override
  public Book findById(int id) {
    return entityManager.find(Book.class, id);
  }

  /**
   * Método que encontra todos os livros cadastrados no banco de dados.
   * @return uma lista com todos os livros.
   */
  @Override
  @SuppressWarnings("unchecked")
  public List<Book> findAll() {
    return entityManager.createQuery("FROM " + Book.class.getName()).getResultList();
  }

  /**
   * Método que realiza a criação do livro no banco de dados.
   * @param book pede um livro com os dados preenchidos.
   */
  @Override
  public void create(Book book) {
    try {
      entityManager.getTransaction().begin();
      entityManager.persist(book);
      entityManager.getTransaction().commit();
    }
    catch (Exception ex) {
      ex.printStackTrace();
      entityManager.getTransaction().rollback();
    }
  }

  /**
   * Método que realiza a edição do livro no banco de dados.
   * @param book pede um livro com os novos dados a serem inseridos.
   */
  public void merge(Book book) {
    try {
      entityManager.getTransaction().begin();
      entityManager.merge(book);
      entityManager.getTransaction().commit();
    }
    catch (Exception ex) {
      ex.printStackTrace();
      entityManager.getTransaction().rollback();
    }
  }

  public void remove(Book book) {
    try {
      entityManager.getTransaction().begin();
      book = entityManager.find(Book.class, book.getId());
      entityManager.remove(book);
      entityManager.getTransaction().commit();
    }
    catch (Exception ex) {
      ex.printStackTrace();
      entityManager.getTransaction().rollback();
    }
  }

  /**
   * Método para a remoção do livro no banco de dados.
   * É armazenado em um livro o resultado da busca através do ID e depois é realizada remoção.
   * @param id pede o id do livro a ser excluido.
   */
  public void removeById(int id) {
    try {
      entityManager.getTransaction().begin();
      Book book = entityManager.find(Book.class, id);
      entityManager.remove(book);
      entityManager.getTransaction().commit();
    }
    catch (Exception ex) {
      ex.printStackTrace();
      entityManager.getTransaction().rollback();
    }
  }

  /**
   * Método que encontra todos os livros que contém a mesma Tag.
   * @param id_tag id da tag a ser localizada.
   * @return a lista de livros que contém a Tag passada no parametro.
   */
  public List<Book> findByTag(int id_tag) {
    try {
      entityManager.getTransaction().begin();
      Query query = entityManager.createQuery("from Book where id_tag = :id_tag");
      query.setParameter("id_tag", id_tag);
      List<Book> list = query.getResultList();
      entityManager.getTransaction().commit();
      return list;
    }
    catch (Exception e) {
      e.printStackTrace();
      entityManager.getTransaction().rollback();
    }
    return null;
  }

  /**
   * Método que encontra todos os livros que contém a mesma Tag e nome do Autor.
   * @param id_tag id da tag a ser localizada.
   * @param author nome do autor a ser localizado.
   * @return lista de livros que contém a Tag e o nome do Autor passados no parametro.
   */
  public List<Book> findByTagAndAuthor(int id_tag, String author) {
    try {
      entityManager.getTransaction().begin();
      Query query = entityManager.createQuery("from Book where id_tag = :id_tag and author = :author");
      query.setParameter("id_tag", id_tag).setParameter("author", author);
      List<Book> list = query.getResultList();
      entityManager.getTransaction().commit();
      return list;
    }
    catch (Exception e) {
      e.printStackTrace();
      entityManager.getTransaction().rollback();
    }
    return null;
  }

  /**
   * Método que encontra todos os livros que contém o mesmo nome de Autor.
   * @param author nome do autor a ser localizado.
   * @return lista de livros que contém o nome do autor passado no parametro.
   */
  public List<Book> findByAuthorName(String author) {
    try {
      entityManager.getTransaction().begin();
      Query query = entityManager.createQuery("from Book where author = :author");
      query.setParameter("author", author);
      List<Book> list = query.getResultList();
      entityManager.getTransaction().commit();
      return list;
    }
    catch (Exception e) {
      e.printStackTrace();
      entityManager.getTransaction().rollback();
    }
    return null;
  }
}