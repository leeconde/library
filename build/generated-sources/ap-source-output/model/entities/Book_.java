package model.entities;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Book.class)
public abstract class Book_ {

	public static volatile SingularAttribute<Book, String> author;
	public static volatile SingularAttribute<Book, String> isbn;
	public static volatile SingularAttribute<Book, String> publisher;
	public static volatile SingularAttribute<Book, Integer> id;
	public static volatile SingularAttribute<Book, Tag> tag;
	public static volatile SingularAttribute<Book, String> title;
	public static volatile SingularAttribute<Book, Date> publicationDate;

	public static final String AUTHOR = "author";
	public static final String ISBN = "isbn";
	public static final String PUBLISHER = "publisher";
	public static final String ID = "id";
	public static final String TAG = "tag";
	public static final String TITLE = "title";
	public static final String PUBLICATION_DATE = "publicationDate";

}

