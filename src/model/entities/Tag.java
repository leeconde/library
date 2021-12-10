package model.entities;

import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Classe da entidade Tag usando o mapeamento do Hibernate.
 * @author Leticia Conde
 */
@Entity
public class Tag {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(name = "name")
  private String name;

  /**
   * Construtores com e sem argumentos.
   */
  public Tag() {
  }

  public Tag(int id, String name) {
    this.id = id;
    this.name = name;
  }

  public Tag(String name) {
    this.name = name;
  }

  /**
   * Métodos Getters e Setters
   */
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  /**
   * Método ToString
   */
  @Override
  public String toString() {
    return getName();
  }

  /*
   * Métodos hashCode e equals
   */
  @Override
  public int hashCode() {
    int hash = 7;
    hash = 31 * hash + Objects.hashCode(this.name);
    return hash;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    final Tag other = (Tag) obj;
    if (!Objects.equals(this.name, other.name)) {
      return false;
    }
    return true;
  }
}