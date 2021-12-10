package model.entities;

import java.util.Date;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Classe da entidade Livro usando o mapeamento do Hibernate.
 * @author Leticia Conde
 */
@Entity
public class Book {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private String title;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "publication_date")
  private Date publicationDate;

  private String isbn;

  private String author;

  private String publisher;

  @OneToOne(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY, targetEntity = Tag.class)
  @JoinColumn(name = "id_tag", referencedColumnName = "id")
  private Tag tag;

  /**
   * Construtores com e sem argumentos.
   */
  public Book() {
  }

  public Book(int id, String title, Date publicationDate, String isbn, String author, String publisher,
      Tag tag) {
    this.id = id;
    this.title = title;
    this.publicationDate = publicationDate;
    this.isbn = isbn;
    this.author = author;
    this.publisher = publisher;
    this.tag = tag;
  }

  public Book(String title, Date publicationDate, String isbn, String author, String publisher,
      Tag tag) {
    this.title = title;
    this.publicationDate = publicationDate;
    this.isbn = isbn;
    this.author = author;
    this.publisher = publisher;
    this.tag = tag;
  }

  public Book(String title, Date publicationDate, String isbn, String publisher, String author) {
    this.title = title;
    this.publicationDate = publicationDate;
    this.isbn = isbn;
    this.publisher = publisher;
    this.author = author;
  }

  public Book(String title, String isbn, String author, String publisher) {
    this.title = title;
    this.isbn = isbn;
    this.author = author;
    this.publisher = publisher;
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

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Date getPublicationDate() {
    return publicationDate;
  }

  public void setPublicationDate(Date publicationDate) {
    this.publicationDate = publicationDate;
  }

  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public Tag getTag() {
    return tag;
  }

  public void setTag(Tag tag) {
    this.tag = tag;
  }

  public String getPublisher() {
    return publisher;
  }

  public void setPublisher(String publisher) {
    this.publisher = publisher;
  }

  /**
   * Método ToString
   */
  @Override
  public String toString() {
    return "Book{" + "id=" + id + ", title=" + title + ", publicationDate=" + publicationDate
        + ", isbn=" + isbn + ", author=" + author + ", publisher=" + publisher + ", tag=" + tag + '}';
  }

  /*
   * Métodos hashCode e equals
   */
  @Override
  public int hashCode() {
    int hash = 7;
    hash = 29 * hash + this.id;
    hash = 29 * hash + Objects.hashCode(this.title);
    hash = 29 * hash + Objects.hashCode(this.publicationDate);
    hash = 29 * hash + Objects.hashCode(this.isbn);
    hash = 29 * hash + Objects.hashCode(this.author);
    hash = 29 * hash + Objects.hashCode(this.publisher);
    hash = 29 * hash + Objects.hashCode(this.tag);
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
    final Book other = (Book) obj;
    if (this.id != other.id) {
      return false;
    }
    if (!Objects.equals(this.title, other.title)) {
      return false;
    }
    if (!Objects.equals(this.isbn, other.isbn)) {
      return false;
    }
    if (!Objects.equals(this.author, other.author)) {
      return false;
    }
    if (!Objects.equals(this.publisher, other.publisher)) {
      return false;
    }
    if (!Objects.equals(this.publicationDate, other.publicationDate)) {
      return false;
    }
    if (!Objects.equals(this.tag, other.tag)) {
      return false;
    }
    return true;
  }
}
