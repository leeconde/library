package model.dao;

import java.util.List;

/**
 * Interface genérica que declara os métodos padrões a serem implementados nas classes do tipo DAO.
 * @author Leticia Conde
 * @param <T>
 */

public interface BasicDao<T> {

  T findById(int id);

  List<T> findAll();

  void create(T obj);
}