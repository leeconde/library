package model.dao;

import model.entities.Tag;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Classe que implementa o BasicDao, realiza a instância de acesso ao banco e realiza todo o
 * gerenciamento da Tag na base de dados.
 * @author Leticia Conde
 */
public class TagDao implements BasicDao<Tag> {

  private static TagDao instance;

  protected EntityManager entityManager;

  /**
   * Método que verifica se já existe uma instancia, caso não, ele cria uma nova.
   * @return uma instancia de TagDao
   */
  public static TagDao getInstance() {
    if (instance == null) {
      instance = new TagDao();
    }
    return instance;
  }

  private TagDao() {
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
   * Método que encontra a Tag através do ID, mapeado pela classe Tag.
   * @param id da Tag a ser encontrada.
   * @return a Tag encontrada.
   */
  @Override
  public Tag findById(int id) {
    return entityManager.find(Tag.class, id);
  }

  /**
   * Método que encontra todas as Tag's cadastradas no banco de dados.
   * @return uma lista com todas as Tag's.
   */
  @Override
  public List<Tag> findAll() {
    return entityManager.createQuery("FROM " + Tag.class.getName()).getResultList();
  }

  /**
   * Método que realiza a criação da Tag no banco de dados.
   * @param tag pede uma Tag com os dados preenchidos.
   */
  @Override
  public void create(Tag tag) {
    try {
      entityManager.getTransaction().begin();
      entityManager.persist(tag);
      entityManager.getTransaction().commit();
    }
    catch (Exception ex) {
      ex.printStackTrace();
      entityManager.getTransaction().rollback();
    }
  }
}