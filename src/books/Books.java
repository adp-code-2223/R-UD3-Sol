package books;
// Generated 11 jun 2023 11:01:03 by Hibernate Tools 4.3.6.Final

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Books generated by hbm2java
 */
@Entity
@Table(name = "books")
@Inheritance(strategy = InheritanceType.JOINED)

public class Books implements java.io.Serializable {

	private Integer bookId;
	private Publishers publishers;
	private String title;
	private String isbn;
	private Date publishedDate;
	private Set<Authors> authorses = new HashSet<Authors>(0);

	public Books() {
	}

	public Books(String title) {
		this.title = title;
	}

	public Books(Publishers publishers, String title, String isbn, Date publishedDate, Set<Authors> authorses) {
		this.publishers = publishers;
		this.title = title;
		this.isbn = isbn;
		this.publishedDate = publishedDate;
		this.authorses = authorses;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "book_id", unique = true, nullable = false)
	public Integer getBookId() {
		return this.bookId;
	}

	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "publisher_id")
	public Publishers getPublishers() {
		return this.publishers;
	}

	public void setPublishers(Publishers publishers) {
		this.publishers = publishers;
	}

	@Column(name = "title", nullable = false)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "isbn", length = 20)
	public String getIsbn() {
		return this.isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "published_date", length = 10)
	public Date getPublishedDate() {
		return this.publishedDate;
	}

	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "bookses")
	public Set<Authors> getAuthorses() {
		return this.authorses;
	}

	public void setAuthorses(Set<Authors> authorses) {
		this.authorses = authorses;
	}

	@Override
	public String toString() {
		return "Books [bookId=" + bookId + ", publishers=" + publishers.getPublisherId() + ", title=" + title + ", isbn=" + isbn
				+ ", publishedDate=" + publishedDate +  "]";
	}
	
	

}
